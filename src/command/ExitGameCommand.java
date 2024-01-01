/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import client.ClientApp;
import java.util.ArrayList;
import javafx.application.Platform;
import ui.OnlineGame;

/**
 *
 * @author w
 */
public class ExitGameCommand implements ResponceCommand {
    private ArrayList<String> responseData;

    public ExitGameCommand(ArrayList<String> responseData) {
        this.responseData = responseData;
    }

    @Override
    public void execute() {
        handleExit();
    }
    
    private void handleExit() {
        OnlineGame game = (OnlineGame) ClientApp.curDisplayedScreen;
        Platform.runLater(() -> game.exitGame());
    }
}
