package client.controllers;


import client.NetworkClient;
import client.models.Network;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;


public class ChatController {

    @FXML
    private TextArea chatHistory;

    @FXML
    public ListView<String> userList;

    @FXML
    private Label usernameTitle;

    @FXML
    private TextField textField;

    @FXML
    private Button sendButton;

   // private final ObservableList<String> wordList = FXCollections.observableArrayList("Hi","how are you");

    private Network network;

    // Нетворкчат (эко клиент) знает нетворк.

    public void setNetwork(Network network) {
        this.network = network;
    }

    public void setLabel(String usernameTitle) {
        this.usernameTitle.setText(usernameTitle);
    }

    @FXML
    public void initialize(){
        userList.setItems(FXCollections.observableArrayList(NetworkClient.USERS_TEST_DATA));
        sendButton.setOnAction(event -> ChatController.this.sendMessage());
        textField.setOnAction(event -> ChatController.this.sendMessage());
    }


    // Отвечает за отправку на экран. Принмиет текст из поля
    private void sendMessage(){  // Отправка сообщения на нетворк + вывод на экран
        String message = textField.getText();
        appendMessage("Я: " + message); // добавляет текст.
        textField.clear();

        // Получим класс Network
        try {
            // Отправляем сообщение на сервер
            network.sendMessage(message); // get.Out().writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
            NetworkClient.showErrorMessage("Ошибка подключения","Ошибка при отправке сообщения",e.getMessage());
        }

    }


    public void appendMessage(String message) { // вывод на экран

        chatHistory.appendText(message);
        chatHistory.appendText(System.lineSeparator());

    }


    public void setUsernameTitle(String username) {


    }
}
