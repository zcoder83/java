package com.example.clock;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    Time time = new Time (new CurrentTime().currentTime()); // set local time
    //Time time = new Time("12:13:45");

    @FXML
    private Text timer;

    @FXML
    private TextField alarmTime;

    @FXML
            private  Text alarm;

    // create Timeline object for methods to calculate time and set time every 1 second
    Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(1), e -> {
                if (time.getCurrentTime().equals(alarmTime.getText())) {
                    System.out.println("Alarm!!!");
                }
                time.oneSecondPassed();
                timer.setText(time.getCurrentTime());
            })
    );



    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        timer.setText(time.getCurrentTime());
        alarm.setText("Set alarm");
        timeline.setCycleCount(Timeline.INDEFINITE); // set infinite times
        timeline.play();
    }
}