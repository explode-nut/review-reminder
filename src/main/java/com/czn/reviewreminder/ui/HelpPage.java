package com.czn.reviewreminder.ui;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class HelpPage {
    private final VBox root;

    public HelpPage() {
        root = new VBox();
        Label helpLabel = new Label("帮助页面内容");
        root.getChildren().add(helpLabel);
    }

    public VBox getRoot() {
        return root;
    }
}
