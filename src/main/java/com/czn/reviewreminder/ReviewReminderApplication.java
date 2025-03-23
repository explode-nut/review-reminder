package com.czn.reviewreminder;

import com.czn.reviewreminder.ui.MainUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.czn.reviewreminder.mvc.mapper")
public class ReviewReminderApplication extends Application {
    private ConfigurableApplicationContext springContext;

    @Override
    public void init() {
        springContext = SpringApplication.run(ReviewReminderApplication.class);
    }

    @Override
    public void start(Stage primaryStage) {
        MainUI mainUI = new MainUI();
        mainUI.show(primaryStage);
    }

    @Override
    public void stop() {
        springContext.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
