package client;

import com.google.gson.reflect.TypeToken;
import exception.NotConnectedException;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Constants;
import utils.JsonHandler;
import command.*;

/**
 *
 * @author w
 */
public class Client {

    private static final String IP_ADDRESS = "127.0.0.1";
    private static final int PORT = 5005;

    private Thread thread;

    private Socket mySocket;
    private DataInputStream in;
    private PrintStream out;
    private ArrayList<String> responceData;
    private boolean isConnected;

    private static Client singletonClient;

    private Map<Integer, ResponceCommand> commands = new HashMap<>();
    
    private Client() {
        initializeCommands();
    }
    
    private void initializeCommands() {
        commands.put(Constants.REGISTER, new RegisterCommand(responceData));
        commands.put(Constants.LOGIN, new LoginCommand(responceData));
        commands.put(Constants.GET_AVAILIABLE_PLAYERS, new GetAvailableCommand(responceData));
        commands.put(Constants.SEND_MESSAGE, new SendMessageCommand(responceData));
        commands.put(Constants.BROADCAST_MESSAGE, new SendBroadcastCommand(responceData));
        commands.put(Constants.GET_DATA_OF_PLAYER, new GetDataCommand(responceData));
        commands.put(Constants.SEND_INVITE, new SendInviteCommand(responceData));
        commands.put(Constants.SEND_MOVE, new SendMoveCommand(responceData));
        commands.put(Constants.ADD_FRIEND, new AddFriendCommand(responceData));
        commands.put(Constants.REMOVE_FRIEND, new RemoveFriendCommand(responceData));
        commands.put(Constants.BLOCK_PLAYER, new BlockPlayerCommand(responceData));
        commands.put(Constants.UN_BLOCK_PLAYER, new UnblockPlayerCommand(responceData));
        commands.put(Constants.ACCEPTGAME, new AcceptGameCommand(responceData));
        commands.put(Constants.EXIT_GAME, new ExitGameCommand(responceData));
    }

    public static Client getClient() {

        if (singletonClient == null) {
            singletonClient = new Client();
            singletonClient.connect();
        }

        return singletonClient;
    }

    public void connect() {
        try {
            mySocket = new Socket(IP_ADDRESS, PORT);
            in = new DataInputStream(mySocket.getInputStream());
            out = new PrintStream(mySocket.getOutputStream());
            isConnected = true;
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        startListening();
    }

    public void closeConnection() {
        try {
            in.close();
            out.close();
            mySocket.close();
            isConnected = false;
            thread.stop();
            thread = null;
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendRequest(String gson) throws NotConnectedException {
        if (!isConnected) {
            throw new NotConnectedException("Client is not connected to the server");
        }
        out.println(gson);
    }

    private void startListening() {
        thread = new Thread(() -> {
            try {
                while (isConnected && mySocket != null && !(mySocket.isClosed())) {
                    String gsonResponse = in.readLine();
                    if (!gsonResponse.isEmpty()) {
                        handleResponse(gsonResponse);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        thread.start();
    }

    private void handleResponse(String gsonResponce) {
        Type listType = new TypeToken<ArrayList<Object>>() {
        }.getType();
        responceData = JsonHandler.deserializeArray(gsonResponce, listType);
        int action = Integer.valueOf(responceData.get(0));
        if (commands.containsKey(action))
            commands.get(action).execute();
        else
            System.out.println("Unknown response type: " + action);
    }
}
