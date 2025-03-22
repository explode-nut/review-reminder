package com.czn.reviewreminder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;


@SpringBootApplication
@MapperScan("com.czn.reviewreminder.mvc.mapper")
public class ReviewReminderApplication extends Application {
    private ConfigurableApplicationContext springContext;
    private VBox root;

    @Override
    public void init() {
        springContext = SpringApplication.run(ReviewReminderApplication.class);
    }

    @Override
    public void start(Stage primaryStage) {
        root = new VBox();
        Button button = new Button("Click me!");
        root.getChildren().add(button);

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("JavaFX Spring Boot App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() {
        springContext.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
