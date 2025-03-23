package com.czn.reviewreminder.ui;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class CategoryPage {
    private final VBox root;
    private final GridPane categoryGrid;
    private final Button addCategoryButton;

    public CategoryPage() {
        root = new VBox();
        categoryGrid = new GridPane();
        addCategoryButton = new Button("添加错题分类");

        root.getChildren().addAll(categoryGrid, addCategoryButton);
    }

    public VBox getRoot() {
        return root;
    }
}
