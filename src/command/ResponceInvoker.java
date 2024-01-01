package command;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author w
 */
public class ResponceInvoker {
    private ResponceCommand command;

    public void setCommand(ResponceCommand command) {
        this.command = command;
    }

    public void executeCommand(ArrayList<String> responseData) {
        if (command != null) {
            command.execute();
        }
    }
}
