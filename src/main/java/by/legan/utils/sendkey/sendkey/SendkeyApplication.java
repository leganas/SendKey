package by.legan.utils.sendkey.sendkey;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class SendkeyApplication extends AbstractJavaFxApplicationSupport {

    @Value("${ui.title:JavaFX приложение}")//
    private String windowTitle;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle(windowTitle);
        stage.setScene(null);
        stage.setResizable(true);
        stage.centerOnScreen();
        Platform.setImplicitExit(false);
        stage.show();
        stage.hide();
    }

    public static void main(String[] args) {
        launchApp(SendkeyApplication.class, args);
    }


}
