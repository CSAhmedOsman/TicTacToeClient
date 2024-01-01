/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author w
 */
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class PlayerStorage {
    private static final String FILE_PATH = "user_data.bin";

    public static void saveUserId(int userId) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(String.valueOf(userId));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int loadUserId() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String userIdStr = reader.readLine();
            if (userIdStr != null && !userIdStr.isEmpty()) {
                return Integer.parseInt(userIdStr);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return -1; // Default value or error indicator
    }
}