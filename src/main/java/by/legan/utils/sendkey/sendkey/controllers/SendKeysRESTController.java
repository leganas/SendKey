package by.legan.utils.sendkey.sendkey.controllers;

import javafx.application.Platform;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Map;

@RestController
@RequestMapping(value = "/rest/key/")
public class SendKeysRESTController {

    @RequestMapping(value = "/send/{enter}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<?> sendKey(@RequestParam Map<String,String> body, @PathVariable("enter") Boolean enter){
        Platform.runLater(() -> {
            Robot robot= null;
            try {
                robot = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }
            ClipboardContent content = new ClipboardContent();
                content.putString(body.get("str"));
                Clipboard.getSystemClipboard().setContent(content);

                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);

                if (enter) {
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);
                }
        });
        return  ResponseEntity
                .status(HttpStatus.OK).body("OK");
    }
}
