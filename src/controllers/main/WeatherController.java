package controllers.main;

import classes.main.Weather;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class WeatherController {

    private static Thread thread = new Thread(new Weather());
    private static Weather weather = new Weather();
    private static Label weatherLabel;
    private static Button refreshButton;

    public static void construct (Label label, Button button) {
        weatherLabel = label;
        refreshButton = button;

        refreshWeatherData();
        loadWeatherToScreen();
    }


    public static void outline () {
        refreshButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                refreshWeatherData();
                loadWeatherToScreen();
            }
        });
    }

    public static void refreshWeatherData () {
        thread.run();
        System.out.println("Weather refreshed.");
    }

    private static void loadWeatherToScreen () {
        weatherLabel.setText(weather.getDescription() + weather.getTemp());
        System.out.println("Weather displayed.");
    }

}
