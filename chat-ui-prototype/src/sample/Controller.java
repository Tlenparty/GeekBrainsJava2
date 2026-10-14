package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller  {
    @FXML
    TextField msgField;

    @FXML
    TextArea mainArea;

    public void sendMsAction() {
        String message = msgField.getText();
        msgField.clear();
        msgField.requestFocus();
        mainArea.setText(message);
    }
    @FXML
    public void initialize() {

    }
}
