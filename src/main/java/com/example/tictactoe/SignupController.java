package com.example.tictactoe;
//
import animatefx.animation.*;
//import animatefx.animation.BounceInUp;
import javafx.event.ActionEvent;
import javafx.animation.*;
//import javafx.animation.Duration;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class SignupController implements Initializable {
    @FXML
    TextField usrname;
    @FXML
    TextField password;
    @FXML
    TextField cpassword;
    @FXML
    Button Signup;
    @FXML
    Button switchToLogin;
    @FXML
    ImageView logo;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TranslateTransition translate=new TranslateTransition();
        translate.setNode(logo);
        translate.setDuration(Duration.millis(1000)); // do the translate in 1 sec
        translate.setByX(-90); // or 250
        translate.setCycleCount(2); // repeat the translate 2 times
        translate.setAutoReverse(true); // return to your  original position after translation
        translate.play();

        RotateTransition rotate=new RotateTransition();
        rotate.setNode(logo);
        rotate.setDuration(Duration.millis(1000)); // do the rotate in 1 sec
        rotate.setInterpolator(Interpolator.LINEAR); //smooth rotation
        rotate.setByAngle(360);
        rotate.play();

//        Duration sec = Duration.seconds(0.5);
//        new BounceInRight(logo).setCycleDuration(4);
//        Animation.setCycleDuration(Duration.millis(10));

    }

    public void SignupBtnAction(ActionEvent event) throws IOException {
        System.out.println("Pressed action button");
        System.out.println(usrname.getText());
        System.out.println(cpassword.getText());
        System.out.println(password.getText());
        // If the fields are NOT empty && the passwords are similar
        if (!getUserName().isEmpty() && !getPassword().isEmpty() && !getcPassword().isEmpty()) {
            if ((password.getText().equals(cpassword.getText()))) {
                // Call client-server handler static signup function with user-provided username
                // & password
                boolean result = ClientServerHandler.signUp(getUserName(), getPassword());
                if (result) {
                    Stage stage;
                    Scene scene;
                    Parent root;
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profile.fxml")));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    new BounceInRight(root).play();
                }
            }
        } else {
            ShowSignUpFailed();
        }
    }

    public void SwitchToLogin(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        new BounceInUp(root).play();

    }

    public void ShowSignUpFailed() {
        Alert alert = new Alert(Alert.AlertType.NONE, "Check your data and try again :)", ButtonType.OK);
        alert.getDialogPane().setMinHeight(100);
        alert.getDialogPane().setMinWidth(100);
        alert.setTitle("sign up Failed");
        alert.setResizable(false);
        alert.show();
//
    }

    public String getUserName() {
        return usrname.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    public String getcPassword() {
        return password.getText();
    }


}
