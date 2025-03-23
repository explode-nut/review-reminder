package com.czn.reviewreminder.ui;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SettingsPage {
    private final VBox root;

    public SettingsPage() {
        root = new VBox();
        Label settingsLabel = new Label("设置页面内容");
        root.getChildren().add(settingsLabel);
    }

    public VBox getRoot() {
        return root;
    }
}
