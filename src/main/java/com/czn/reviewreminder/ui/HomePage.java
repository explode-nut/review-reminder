package com.czn.reviewreminder.ui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class HomePage {
    private final VBox root;

    public HomePage() {
        root = new VBox();
        Label todayReviewLabel = new Label("今日需要复习的错题");
        Button batchModifyButton = new Button("批量修改");
        Button submitButton = new Button("提交");

        root.getChildren().addAll(todayReviewLabel, batchModifyButton, submitButton);
    }

    public VBox getRoot() {
        return root;
    }
}
