package sample;//package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.*;



public class TicTacToeApp extends Application {


    //Tracks the turn, if it is not X's turn then it is O's turn
    private boolean isXturn = true;
    //Checks if we are able to play or not
    private boolean ableToPlay = true;

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(600, 600);

        //Creates a 3x3 grid
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                //Creates the tile and each time changes the x and y axis
                Tile tile = new Tile();
                tile.setTranslateX(j * 200);
                tile.setTranslateY(i * 200);

                root.getChildren().add(tile);

            }
        }

        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();


    }

    private void checkState(){

            //need to check the 3 horizontal, 3 vertivle, and 3 diagnals

    }
    private class Combo{
        private Tile[] tiles;
        public Combo(Tile...tiles){
            this.tiles = tiles;
        }

        public boolean isComplete(){

        }
    }

    //Each of the squares on the grid
    private class Tile extends StackPane {
        //TODO find out how to replace that with an image
        private Text text = new Text();
        private Image ximage = new Image("x.jpg");
        private Image oimage = new Image("o.jpg");

        private ImageView imageView = new ImageView();


        public Tile() {
            Rectangle border = new Rectangle(200, 200);
            //By default the squares are black, need to set the fill to none
            border.setFill(null);
            //Gives us a black border
            border.setStroke(Color.BLACK);
            //Aligns everything to the center of the page
            setAlignment(Pos.CENTER);
            //TODO will need to figure out how to replace that with an image
//            getChildren().addAll(border, text);
            getChildren().addAll(border, imageView);

            setOnMouseClicked(event -> {
                //On left mouse click. TODO Will need to change that for alternating turns.
                if (event.getButton() == MouseButton.PRIMARY) {

                    //If we are not able to play then stop
                    if (ableToPlay == false){
                        return;
                    }
                    if (isXturn == true) {

                        drawX();
                        checkState();
                        isXturn = false;
                        return;
                    }
                    if (isXturn == false) {

                        drawO();
                        checkState();
                        isXturn = true;
                        return;
                    }
                }
            });

        }

        public String getValue(){
            return text.getText();

        }

        //TODO change it so that it overlays the X image needed for the project instead
        private void drawX() {
//                text.setText("X");
            imageView.setImage(ximage);
            imageView.setFitWidth(200);
            imageView.setFitHeight(200);
        }

        //TODO change it so that it overlays the Y image needed for the project instead
        private void drawO() {
//                text.setText("O");
            imageView.setImage(oimage);
            imageView.setFitWidth(200);
            imageView.setFitHeight(200);

        }
    }

        public static void main(String[] args) {

            launch(args);


        }
    }
