/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author w
 */

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author w
 */
public class JsonHandler {

    private static final Gson gson = new Gson();
    
    public static String serializeJson(int action, Object... requestArgs) {
        ArrayList<Object> jsonRequest = new ArrayList<>();
        jsonRequest.add(action);

        jsonRequest.addAll(Arrays.asList(requestArgs));

        return gson.toJson(jsonRequest);
    }

    public static ArrayList<Object> deserializeJson(String jsonResponse) {
        Type listType = new TypeToken<ArrayList<Object>>() {}.getType();
        return gson.fromJson(jsonResponse, listType);
    }

    public static void main(String[] args) {

        // Example of making JSON
        String jsonRequest = JsonHandler.serializeJson(1, "arg1", 42, true);
        System.out.println("JSON Request: " + jsonRequest);

        // Example of deserializing JSON
        ArrayList<Object> deserializedList = deserializeJson(jsonRequest);
        System.out.println("Deserialized List: " + deserializedList);
    }
}
