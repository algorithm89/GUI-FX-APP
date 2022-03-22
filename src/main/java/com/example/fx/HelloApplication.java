package com.example.fx;


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


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.*;
import java.util.Comparator;

public class HelloApplication  extends Application {
    public static void main(String[] args) {
        launch(args);


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

    void deleteDir() throws IOException
    {




        Path path = FileSystems.getDefault().getPath("./src/main/Images");
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








    @Override
    public void start(Stage primaryStage) throws  Exception
    {


        Button btn = new Button("SUBMIT");
        TextField textField1 = new TextField();
        TextField textField2 = new TextField("Enter WebSite to LookUP");
        TextField textField3 = new TextField("https://i.pinimg.com/564x/e7/cd/95/e7cd9545ab2fce38bb5c8b49a529488a.jpg");
        Label lb = new Label();
        Button btn2 = new Button("CREATE  DIR");
        Button btn3 = new Button("DELETE  DIR");
        Button btn4 = new Button("DISPLAY IMG");

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
        text3.setStyle("-fx-font-weight: bold;");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override

            public void handle(ActionEvent actionEvent) {
                InetAddress address = null;
                try {
                    address = InetAddress.getByName(textField2.getText());

                } catch (UnknownHostException ex) {
                    System.out.println(textField2.getText() + " not found");
                }
                primaryStage.setTitle("APP");
                textField1.setText(address.toString());
                lb.setText(address.toString());


            }
        });


        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                File f = new File("./src/main/Images");
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

                File file = new File("./src/main/Images");
                //List of all files and directories
                deleteFiles(file);
                System.out.println("Files deleted........");

                try {
                    deleteDir();
                }catch (IOException e)
                {
                    e.printStackTrace();
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
        gridPane.add(btn, 1, 3);
        gridPane.add(btn2, 1, 4);
        gridPane.add(btn3, 1, 5);
        gridPane.add(btn4, 1, 6);

        gridPane.setStyle("-fx-background-image: url('https://wallpaperaccess.com/full/1808239.jpg'); " +
                "-fx-background-repeat: no-repeat; " +
                "-fx-background-size: 500 500; " +
                "-fx-background-position: center center");

        Scene scene1 = new Scene(gridPane);

        primaryStage.setTitle("APP");
        primaryStage.setScene(scene1);
        primaryStage.show();



        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent)  {

                Button btn1 = new Button("GO-BACK");
//                    InputStream stream = new FileInputStream("C:\\Users\\bublikstudios\\Pictures\\falmingo.jpg");
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
                btn1.setLayoutX(250);
                btn1.setOnAction(e -> primaryStage.setScene(scene1));

                btn1.setAlignment(Pos.BOTTOM_CENTER);

                Group gp = new Group(imageView,btn1);
                Scene scene = new Scene(gp, 600, 800);
                primaryStage.setTitle("Displaying Image");
                primaryStage.setScene(scene);
                primaryStage.show();

            }

        });







    }


}


//        btn.setLayoutY(110);
//        btn.setLayoutX(120);
//
//        textField2.setLayoutY(150);
//        textField2.setLayoutX(10);
//        textField2.setMinWidth(280);
//
//
//        textField.setLayoutY(250);
//        textField.setMinWidth(280);
//        textField.setLayoutX(10);
//
//        lb.setLayoutY(300);
//        lb.setLayoutX(60);