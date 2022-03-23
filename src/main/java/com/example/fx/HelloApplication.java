package com.example.fx;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.*;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.*;
import java.util.Comparator;

public class HelloApplication  extends Application {
    public static void main(String[] args) {
        launch();


    }

    void deleteFiles(File dirPath) {
        File filesList[] = dirPath.listFiles();
        for(File file : filesList) {
            if(file.isFile()) {
                file.delete();
            } else {
                deleteFiles(file);
            }
        }
    }





    @Override
    public void start(Stage primaryStage) throws  Exception
    {


        Button btn = new Button("SUBMIT");
        TextField textField1 = new TextField();
        TextField textField2 = new TextField("Enter WebSite to LookUP");
        TextField textField3 = new TextField("https://i.pinimg.com/564x/e7/cd/95/e7cd9545ab2fce38bb5c8b49a529488a.jpg");
        TextField textField4 = new TextField("Enter Directory Location");
        Label lb = new Label();
        Button btn2 = new Button("CREATE  DIR");
        Button btn3 = new Button("DELETE  DIR");
        Button btn4 = new Button("DISPLAY IMG");
        Button btn5 = new Button("DOWNLD  IMG");




        //creating label email
        Text text1 = new Text("WebSite");
        text1.setFill(Color.WHITE);
        text1.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-font-size: 16px");


        //creating label password
        Text text2 = new Text("IPAddress");
        text2.setStyle("-fx-font-weight: bold; -fx-font-size: 16px");
        text2.setFill(Color.WHITE);

        Text text3 = new Text("URL");
        text3.setFill(Color.WHITE);
        text3.setStyle("-fx-font-weight: bold;-fx-font-size: 16px");

        Text text4 = new Text("DIR PATH");
        text4.setFill(Color.WHITE);
        text4.setStyle("-fx-font-weight: bold;-fx-font-size: 16px");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override

            public void handle(ActionEvent actionEvent) {

                InetAddress address = null;
                String IP1 = null;
                try {
                    address = Inet4Address.getByName(textField2.getText());
                    String temp = address.toString();
                    IP1 = temp.substring(temp.indexOf("/") + 1, temp.length());


                } catch (UnknownHostException ex) {
                    System.out.println(textField2.getText() + " not found");
                }
                primaryStage.setTitle("APP");
                textField1.setText(IP1);
//                lb.setText(address.toString());


            }
        });


        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                File f = new File(textField4.getText());
                if (f.mkdir() == true) {
                    System.out.println("Directory has been created successfully");
                }
                else {
                    System.out.println("Directory cannot be created");
                }
            }

        });

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                File file = new File(textField4.getText());
                //List of all files and directories
                deleteFiles(file);
                System.out.println("Files deleted........");

                Path path = FileSystems.getDefault().getPath(textField4.getText());
                try {
                    Files.deleteIfExists(path);
                } catch (NoSuchFileException x) {
                    System.err.format("%s: no such" + " file or directory%n", path);
                } catch (DirectoryNotEmptyException x) {
                    System.err.format("%s not empty%n", path);
                } catch (IOException x) {
                    System.err.println(x);
                }
            }



        });

        textField2.setMinWidth(280);

        Group g = new Group();
        Pane pane = new Pane();
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 500);

        //Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        gridPane.setVgap(5);
        gridPane.setHgap(5);

        //Setting the Grid alignment
        gridPane.setAlignment(Pos.CENTER);

        //Arranging all the nodes in the grid
        gridPane.add(text1, 0, 0);
        gridPane.add(textField2, 1, 0);
        gridPane.add(text2, 0, 1);
        gridPane.add(textField1, 1, 1);
        gridPane.add(text3, 0, 2);
        gridPane.add(textField3, 1, 2);
        gridPane.add(text4, 0, 3);
        gridPane.add(textField4, 1, 3);
        gridPane.add(btn, 1, 4);
        gridPane.add(btn2, 1, 5);
        gridPane.add(btn3, 1, 6);
        gridPane.add(btn4, 1, 7);
        gridPane.add(btn5, 1, 8);

        gridPane.setStyle("-fx-background-image: url('https://img1.goodfon.com/wallpaper/nbig/2/44/metal-grunge-metallic-steel-5838.jpg'); " +
                "-fx-background-repeat: no-repeat; " +
                "-fx-background-size: 500 500; " +
                "-fx-background-position: center center");

        Scene scene1 = new Scene(gridPane);


        primaryStage.setTitle("APP");
        primaryStage.setScene(scene1);
        Image icon = new Image("file:./src/main/java/img/NewBub.png");
        primaryStage.getIcons().add(icon);
        primaryStage.show();



        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent)  {

                Button btn1 = new Button("GO-BACK");
//              InputStream stream = new FileInputStream("C:\\Users\\bublikstudios\\Pictures\\falmingo.jpg");
                String path ="https://i.pinimg.com/564x/e7/cd/95/e7cd9545ab2fce38bb5c8b49a529488a.jpg";

                String path2 = textField3.getText();

                Image image = new Image(path2);
                //Creating the image view
                ImageView imageView = new ImageView();
                //Setting image to the image view
                imageView.setImage(image);
                //Setting the image view parameters
                imageView.setX(10);
                imageView.setY(10);
                imageView.setFitWidth(575);
                imageView.setPreserveRatio(true);
                //Setting the Scene object
                btn1.setAlignment(Pos.BOTTOM_CENTER);
                btn1.setLayoutY(750);
                btn1.setLayoutX(280);
                btn1.setOnAction(e -> primaryStage.setScene(scene1));

                btn1.setAlignment(Pos.BOTTOM_CENTER);

                Group gp = new Group(imageView,btn1);
                Scene scene = new Scene(gp, 600, 800);
                primaryStage.setTitle("Displaying Image");
                primaryStage.setScene(scene);
                primaryStage.show();

            }

        });


        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
        try {
            URL fetchWebsite = new URL(textField3.getText());
            ReadableByteChannel readableByteChannel = Channels.newChannel(fetchWebsite.openStream());

            try (FileOutputStream fos = new FileOutputStream(textField4.getText()+"//Image.jpg")) {
                fos.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
                System.out.println("Image has been Downloaded");

            }


        }catch (IOException e)
        {
            System.out.println("Cannot Download....");
            e.printStackTrace();}
            }

        });





    }


}

