package com.czn.reviewreminder.ui;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainUI {
    private final BorderPane root;
    private final HBox navBar;
    private final ToggleGroup navGroup;
    private final HomePage homePage;
    private final CategoryPage categoryPage;
    private final HelpPage helpPage;
    private final SettingsPage settingsPage;

    public MainUI() {
        root = new BorderPane();
        navBar = new HBox();
        navGroup = new ToggleGroup();
        homePage = new HomePage();
        categoryPage = new CategoryPage();
        helpPage = new HelpPage();
        settingsPage = new SettingsPage();

        setupNavigation();
        setupUI();
    }

    private void setupNavigation() {
        String[] navItems = {"主页", "分类", "帮助", "设置"};

        for (String item : navItems) {
            ToggleButton button = new ToggleButton(item);
            button.setToggleGroup(navGroup);
            button.setStyle("-fx-background-color: #F0F0F0; -fx-padding: 5 15;");
            button.setOnAction(e -> switchPage(item));

            // 悬停效果
            button.hoverProperty().addListener((obs, oldVal, newVal) -> {
                if (!button.isSelected()) {
                    button.setStyle(newVal ?
                            "-fx-background-color: #E0E0E0; -fx-padding: 5 15;" :
                            "-fx-background-color: #F0F0F0; -fx-padding: 5 15;");
                }
            });

            navBar.getChildren().add(button);
        }

        // 设置默认选中
        ((ToggleButton)navBar.getChildren().get(0)).setSelected(true);
        navBar.setSpacing(10);
        navBar.setStyle("-fx-background-color: #F0F0F0; -fx-padding: 5;");
    }

    private void switchPage(String page) {
        switch (page) {
            case "主页":
                root.setCenter(homePage.getRoot());
                break;
            case "分类":
                root.setCenter(categoryPage.getRoot());
                break;
            case "帮助":
                root.setCenter(helpPage.getRoot());
                break;
            case "设置":
                root.setCenter(settingsPage.getRoot());
                break;
        }

        // 更新选中按钮样式
        navGroup.getToggles().forEach(toggle -> {
            ToggleButton btn = (ToggleButton) toggle;
            btn.setStyle(btn.isSelected() ?
                    "-fx-background-color: #D0D0D0; -fx-padding: 5 15;" :
                    "-fx-background-color: #F0F0F0; -fx-padding: 5 15;");
        });
    }

    private void setupUI() {
        root.setTop(navBar);
        root.setCenter(homePage.getRoot());
    }

    public void show(Stage primaryStage) {
        Scene scene = new Scene(root, 600, 450);

        // 设置窗口图标
        try {
            Image icon = new Image("file:img/peter.png"); // 相对路径
            primaryStage.getIcons().add(icon);
        } catch (Exception e) {
            System.out.println("图标加载失败: " + e.getMessage());
        }

        primaryStage.setTitle("错题小帮手");
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });
        primaryStage.show();
    }
}


