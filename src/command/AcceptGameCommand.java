/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import client.ClientApp;
import com.google.gson.reflect.TypeToken;
import data.GameInfo;
import java.lang.reflect.Type;
import java.util.ArrayList;
import javafx.application.Platform;
import ui.OnlineGame;
import utils.JsonHandler;
import utils.Util;

/**
 *
 * @author w
 */
public class AcceptGameCommand implements ResponceCommand {
    private ArrayList<String> responseData;

    public AcceptGameCommand(ArrayList<String> responseData) {
        this.responseData = responseData;
    }

    @Override
    public void execute() {
        startGame();
    }
    
    private void startGame() {
        Type gameType = new TypeToken<GameInfo>() {
        }.getType();
        GameInfo info = JsonHandler.deserializeArray(responseData.get(1), gameType);

        boolean myTurn = Boolean.valueOf(responseData.get(2));
        int type = Integer.valueOf(responseData.get(3));
        OnlineGame onlineGame;
        switch (type) {
            case 1:
                onlineGame = new OnlineGame(info, myTurn);
                Util.displayScreen(onlineGame);
                break;
            case 2:
                onlineGame = (OnlineGame) ClientApp.curDisplayedScreen;
                Platform.runLater(() -> onlineGame.startGame());
                break;
            default:
                onlineGame = (OnlineGame) ClientApp.curDisplayedScreen;
                Platform.runLater(() -> onlineGame.exitGame());
                break;
        }
    }
}
