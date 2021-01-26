package com.internshala.temperatureController;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();

        MenuBar menuBar= createMenu();
        rootNode.getChildren().add(0 ,menuBar);


        Scene scene = new Scene(rootNode);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter Tool");
        primaryStage.show();
    }

    private  MenuBar  createMenu(){
        // file menu
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        newMenuItem.setOnAction(event -> System.out.println("new Item Created"));
        MenuItem quitMenuItem = new MenuItem("Quit");
        quitMenuItem.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });
        SeparatorMenuItem separator= new SeparatorMenuItem();
        fileMenu.getItems().addAll(newMenuItem, separator,quitMenuItem);



        // help menu
        Menu helpMenu = new Menu("Help");
        MenuItem aboutApp = new MenuItem("About");
        helpMenu.getItems().addAll(aboutApp);

        aboutApp.setOnAction(event -> aboutApp());

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }
    public void aboutApp(){
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("Temperature Converter");
        alertDialog.setHeaderText("Java Fx");
        alertDialog.setContentText("This Application is created using JavaFX ");


        ButtonType yesBtn = new ButtonType("Yes");
        ButtonType noBtn = new ButtonType("No");
        alertDialog.getButtonTypes().setAll(yesBtn,noBtn);
        Optional<ButtonType> clickedBtn = alertDialog.showAndWait();

        if(clickedBtn.isPresent() && clickedBtn.get()==yesBtn){
            System.out.println("yes button clicked");
        }else {
            System.out.println("No button is clicked");
        }



    }


    public static void main(String[] args) {
        launch(args);
    }
}