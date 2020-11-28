import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/*
        Thomas Lloyd-Jones
                JumpGame
                12/19/2019
                V1.0.0

Rundown for future lookbacks:

Run JumpGame to play
Highscores reads and gets data from files for table
Environment creates floor ect. + endBlock
Enemy makes KillerBlocks
Sprites create Sprite image


*/
public class JumpGame extends Application {

    private static boolean isJumping = false;
    private static int totalScore;
    private final int framesPerSec = 32;
    private final float frameRate = 1.0f / framesPerSec;
    private final float g = 9.8f; //positive is down in graphics
    private final float jumpDx = 100.0f;
    private Pane graphics = new Pane();
    private int x = 0;
    private int y = 0;
    private double dx = 5;
    private int hp = 100;
    private String totalHP = Integer.toString(hp);
    private boolean[] keysDown = new boolean[5];
    private Sprite download;
    private Sprite idle;
    private Sprite jump;
    private Sprite jumpLeft;
    private Sprite walk;
    private Sprite walkleft;
    private Sprite attack;
    private Sprite fire;
    private Boolean space = false;
    private int level = 1;
    PathTransition transition;
    Timeline animation;
    private Timeline jumpAnimation;
    private Rectangle hiddenBlock = new Rectangle(0, 0, 50, 60);
    private Rectangle floor = new Rectangle(0, 650, 5000, 650);
    private Circle fireCircle = new Circle();
    private Timeline jumpAnimationLeft;
    private Pane lvl = new Pane();
    private Pane mySpriteImage = new Pane();
    private PathTransition transition1 = new PathTransition();
    private int hightOfSprite = 80;
    private float BOTTOM = 620.0f - hightOfSprite;
    private double previousX;
    private int jumpFrame;
    private float dy = -10;
    private Text hpDisplay = new Text(60, 60, "");
    private Text escapeToQuit = new Text(200, 60, "Press Escape to Quit at any time.");
    private Text xDisplay = new Text(70, 80, "");
    private Text yDisplay = new Text(70, 90, "");
    private BorderPane entirePane = new BorderPane();
    private Stage primaryStageMAIN = new Stage();
    private Stage menu = new Stage();
    private Scene scene = new Scene(entirePane, 1600, 800);

    public static int getTotalScore() {
        return totalScore;
    }


    // get stage
    private Stage getPrimaryStageMAIN() {
        return primaryStageMAIN;
    }
// return other stage
    public void setPrimaryStageMAIN(Stage primaryStageMAIN) {
        this.primaryStageMAIN = primaryStageMAIN;
    }



    public static void main(String[] args) {

        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStageMAIN = primaryStage;

        BorderPane menuPane = new BorderPane();
        Scene sceneMenu = new Scene(menuPane, 200, 300);
        menu.setScene(sceneMenu);

        menuPane.setCenter(menu(primaryStageMAIN));
        menu.show();




    }

    private Pane menu(Stage primaryStage) {

        BorderPane borderMenu = new BorderPane();
        Pane menuNode = new Pane();
        borderMenu.setTop(menuNode);
        Button startButton = new Button("Start Game");
        Button quitButton = new Button("Quit");


        startButton.setOnMousePressed(e -> startGame(primaryStage, this.menu));
        quitButton.setOnMouseClicked( e -> System.exit(0));


        // create a button
        Button b = new Button("show");
        // create a tile pane
        TilePane r = new TilePane();
        // string array
        String st[] = { "Level 1", "Level 2", "Level 3", "Level 4" };
        // create a choiceBox
        ChoiceBox levelSelect = new ChoiceBox(FXCollections.observableArrayList(st));

        // add a listener
        // if the item of the list is changed
        levelSelect.getSelectionModel().selectedIndexProperty()
                .addListener((ov, value, new_value) -> {

                    // set the text for the label to the selected item

                      setLevel(  Integer.parseInt(st[new_value.intValue()].substring(6)));

                });
        HBox boxContainer = new HBox(startButton,quitButton,levelSelect);
        try {
            VBox box = new VBox(HighScore.menuAddScoreboard());
            borderMenu.setCenter(box);
        } catch (IOException e) {
            e.printStackTrace();
        }
        menuNode.getChildren().add(boxContainer);

        return borderMenu;
    }

    private void startGame(Stage primaryStage, Stage menu) {
        menu.hide();
        setUpSprites(); // get images for sprites and show idle state
        GetMenu(primaryStage, getLevel());
        jump();
    }

    private Stage GetMenu(Stage primaryStage, int level){

        if(graphics.getChildren().contains(escapeToQuit)){
            entirePane.getChildren().clear();
            graphics.getChildren().clear();
            mySpriteImage.setLayoutX(30);
            mySpriteImage.setTranslateY(620.0f - hightOfSprite);
            setUpSprites();
            this.y = 10;
            this.x = 10;


        }
        graphics.getChildren().add(escapeToQuit);
        hpDisplay.setText(totalHP);
        xDisplay.setText(String.valueOf(x));
        yDisplay.setText(String.valueOf(y));
        entirePane.setCenter(graphics);
        Circle fireCircle = new Circle(0,0,100);
        fireCircle.setCenterX(this.x+180);
        fireCircle.setCenterY(this.y+40);

        //action event hadlers ...
        scene.setOnKeyPressed(this::keyPressed);   // jump handling
        scene.setOnKeyReleased(this::keyReleased); // if not jumping and moving right, set back to idle
        lvl.getChildren().add(new Environment(getLevel())); // add blocks to level
        // disp current hp
        graphics.getChildren().add(hpDisplay);
        graphics.getChildren().add(xDisplay);
        graphics.getChildren().add(fireCircle);
        graphics.getChildren().add(yDisplay);
        graphics.getChildren().add(hiddenBlock);
        entirePane.getChildren().add(Environment.getEnd());
        entirePane.getChildren().add(lvl);

        fireCircle.setVisible(false);
        hiddenBlock.setX(this.x + 30);
        hiddenBlock.setY(this.y + 50);
        hiddenBlock.setVisible(false);
        mySpriteImage.setTranslateX(30);
        mySpriteImage.setTranslateY(620.0f - hightOfSprite);
        primaryStage.setScene(scene);
        primaryStage.show();
        System.out.println();
        entirePane.getChildren().add(floor);
        return primaryStage;
    }
    private int getLevel() {
        return level;
    }

    private void setLevel(int level) {
        this.level = level;
    }
    private void endGame() {
        System.exit(0);
    }

    public void firstLevel(){

    }

    private void setUpSprites() {
        attack = new Sprite(("file:sprites/attack.png"), 3, 3);
        download = new Sprite("file:sprites/download.png", 4, 2); // run
        idle = new Sprite("file:sprites/idle.png", 5, 3);
        jump = new Sprite("file:sprites/jump.png", 3, 3);
        walk = new Sprite("file:sprites/walk.png", 3, 2);
        walkleft = new Sprite("file:sprites/walkflip.png", 3, 2);
        fire = new Sprite("file:sprites/fire.png", 3, 3);
        jumpLeft = new Sprite("file:sprites/jumpflip.png", 3, 3);


        walk.setId("walk");
        idle.setId("idle");
        jump.setId("jump");
        mySpriteImage.getChildren().add(idle);
        if(!graphics.getChildren().contains(mySpriteImage)) {

            mySpriteImage.getChildren().removeAll();
            graphics.getChildren().addAll(mySpriteImage);
        }
    }

    private void keyReleased(KeyEvent e) {
        keyReleased(e.getCode());
        if (mySpriteImage.getChildren().contains(walkleft)) {
            hiddenBlock.setX(this.x + 65);
            hiddenBlock.setY(this.y + 50);
        } else {
            hiddenBlock.setX(this.x + 30);
            hiddenBlock.setY(this.y + 50);

        }
        if (!isJumping && e.getCode() == KeyCode.RIGHT) {

            mySpriteImage.getChildren().clear();
            mySpriteImage.getChildren().add(idle);

        }
    }
    private void keyPressed(KeyEvent e) {
        if (mySpriteImage.getChildren().contains(walkleft)) {
            hiddenBlock.setX(this.x + 65);
            hiddenBlock.setY(this.y + 50);
        } else {
            hiddenBlock.setX(this.x + 30);
            hiddenBlock.setY(this.y + 50);
        }

        checkCollisionsEnvironment();
        levelComplete(getPrimaryStageMAIN());
        Rectangle[] a = Enemy.getBlocks();
        for (Rectangle rectangle : a) {
            checkCollisionsEnemy(rectangle);
        } // enemy stuffs

        keyPressed(e.getCode());// {Left, RIGHT, UP, DOWN, SPACE}

        if (this.keysDown[4] && this.keysDown[1]) { // right + space
            jump();

        }
        if (this.keysDown[0] && this.keysDown[4]) { // left + space
            runJumpActionLeft();
        }

        if (!isJumping && this.keysDown[3]) { //if(!isJumping && keysDown[3]){ // ATTACK WHILE NOT JUMPING
            attackRight();
        }
        //if not jumping ... process input

        if (!space)//move right while not in air
            if (!isJumping && this.keysDown[1]) { // {Left, RIGHT, UP, DOWN, SPACE}
                right();
            }
        if (!isJumping && this.keysDown[0]) { // LEFT WHILE NOT JUMPING
            left();
        }

    }

    private void right() {
        x += dx;
        mySpriteImage.setTranslateX(x);

        if (!mySpriteImage.getChildren().contains(walk)) {
            mySpriteImage.getChildren().clear();
            mySpriteImage.getChildren().add(walk);
        }
    }
    private void left() {

        x -= dx;
        mySpriteImage.setTranslateX(x);

        if (!mySpriteImage.getChildren().contains(walkleft) || !mySpriteImage.getChildren().contains(walk)) {
            mySpriteImage.getChildren().clear();
            mySpriteImage.getChildren().add(walkleft);
        }
    }

    private void runJumpActionLeft() {


        if (!isJumping) { // JUMP WHILE NOT JUMPING
            isJumping = true;
            if (mySpriteImage.getChildren().contains(jumpLeft) || mySpriteImage.getChildren().contains(jump)) {

            } else {
                mySpriteImage.getChildren().clear();
                mySpriteImage.getChildren().add(jumpLeft);
            }
            dy = -10; //Negative is up in graphics
        }
        EventHandler<ActionEvent> jumpLeftHandler = e -> {

            if (mySpriteImage.getTranslateY() >= BOTTOM) {
                y = (int) (BOTTOM - 1); //move off of BOTTOM
                mySpriteImage.setTranslateY(y);
                jumpAnimationLeft.stop();
                mySpriteImage.getChildren().clear();
                mySpriteImage.getChildren().add(idle);
                isJumping = false;
            } else {

                //System.out.println("jumping");
                x -= (jumpDx * frameRate);
                dy += (g * frameRate);
                y += dy;

                mySpriteImage.setTranslateX(x);
                mySpriteImage.setTranslateY(y);
            }

        };

        // Create the jumping cycle
        this.jumpFrame = 0;

        //creating the animaiton ...
        if (jumpAnimationLeft == null) {
            jumpAnimationLeft = new Timeline(
                    new KeyFrame(Duration.millis(frameRate * 1000), jumpLeftHandler));
            jumpAnimationLeft.setCycleCount(Timeline.INDEFINITE); //INDEFINITE
            jumpAnimationLeft.play(); // Start animation
        } else if (jumpAnimationLeft.getStatus() == Animation.Status.STOPPED) {
            jumpAnimationLeft.play(); // Start animation
        } else {
            System.out.println("Cannot jump left while jumping (in the air).");
        }


    }
    private void runJumpActionRight() {



        EventHandler<ActionEvent> jumpEventHandler = e -> {
            if (mySpriteImage.getTranslateY() >= BOTTOM) {
                y = (int) (BOTTOM - 1); //move off of BOTTOM
                mySpriteImage.setTranslateY(y);
                jumpAnimation.stop();
                mySpriteImage.getChildren().clear();
                mySpriteImage.getChildren().add(idle);
                isJumping = false;
            } else {
                x += (jumpDx * frameRate);
                dy += (g * frameRate);
                y += dy;

                mySpriteImage.setTranslateX(x);
                mySpriteImage.setTranslateY(y);
            }

        };

        // Create the jumping cycle
        this.jumpFrame = 0;

        //creating the animaiton ...
        if (jumpAnimation == null) {
            jumpAnimation = new Timeline(
                    new KeyFrame(Duration.millis(frameRate * 1000), jumpEventHandler));
            jumpAnimation.setCycleCount(Timeline.INDEFINITE); //INDEFINITE
            jumpAnimation.play(); // Start animation
        } else if (jumpAnimation.getStatus() == Animation.Status.STOPPED) {
            jumpAnimation.play(); // Start animation
        } else {
            System.out.println("Cannot jump while jumping (in the air).");
        }
    }

    private void attackRight() {
        if (mySpriteImage.getChildren().contains(attack)) {

        } else {
            mySpriteImage.getChildren().clear();
            mySpriteImage.getChildren().add(attack);
            mySpriteImage.getChildren().add(fire);
            transition1.setNode(fire);
            transition1.setPath(new Line(70, hightOfSprite, 250, hightOfSprite));

            transition1.setDuration(Duration.seconds(1));
            transition1.play();

            fireCircle.setVisible(true);
        }
    }
    private void jump() {

        //jump - space hit
        if (!isJumping) { // JUMP WHILE NOT JUMPING
            isJumping = true;
            if (mySpriteImage.getChildren().contains(jump)) {
            } else {
                mySpriteImage.getChildren().clear();
                mySpriteImage.getChildren().add(jump);
            }
            dy = -10; //Negative is up in graphics
            runJumpActionRight();

        }
    }
    private void checkCollisionsEnvironment() {
        if(!this.keysDown[2]){
        Rectangle[] blocks = Environment.getBlocks();

        for (int i = 0; i < blocks.length - 1; i++) {
            Shape intersect = Shape.intersect(hiddenBlock, blocks[i]);    // THIS INTERSECT WORKS
            Shape intersect2 = Shape.intersect(fireCircle, blocks[i]);    // THIS INTERSECT WORKS
            if (intersect.getBoundsInParent().getWidth() > 0) {

                if(this.hp>=5){
                    this.hp -= 5;
                }
                checkIfDead();
            }
        }
    }}

    private boolean isDead() {
        boolean isdead = false;
        if(this.hp <= 0){
            isdead = true;
        }
        return isdead;
    }
    private void checkIfDead() {

        xDisplay.setText(String.valueOf(x));
        yDisplay.setText(String.valueOf(y));
        this.hpDisplay.setText(String.valueOf(this.hp));

        if (isDead()) {
            System.out.println("You died!");
            try {
                start(primaryStageMAIN);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void levelComplete(Stage primaryStage){
        Rectangle endBlock = (Rectangle) Environment.getEnd();

        Shape intersect = Shape.intersect(hiddenBlock,  endBlock);    // THIS INTERSECT WORKS
        if(intersect.getBoundsInParent().getWidth()>0 && this.hp >0){
            System.out.println("THE END!");
            setLevel(getLevel()+1);
            System.out.println("COMPLETED LEVEL");
            this.totalScore = (int) (this.hp + 500);
            HighScore.checkHighScore();
            try {
                primaryStage.setScene(null);
                start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }

    private boolean[] keyPressed(KeyCode keycode) {


        if (keycode == KeyCode.LEFT) {
            this.keysDown[0] = true;

        }
        if (keycode == KeyCode.RIGHT) {
            this.keysDown[1] = true;

        }
        if (keycode == KeyCode.UP) {
            this.keysDown[2] = true;
        }
        if (keycode == KeyCode.DOWN) {
            this.keysDown[3] = true;
        }
        if (keycode == KeyCode.SPACE) {
            this.keysDown[4] = true;
        }
        if (keycode == KeyCode.ESCAPE){
            System.exit(0);
        }
        return keysDown;
    }
    private boolean[] keyReleased(KeyCode keycode) {

        if (keycode == KeyCode.LEFT) {
            this.keysDown[0] = false;
        }
        if (keycode == KeyCode.RIGHT) {
            this.keysDown[1] = false;

        }
        if (keycode == KeyCode.UP) {
            this.keysDown[2] = false;
        }
        if (keycode == KeyCode.DOWN) {
            this.keysDown[3] = false;
        }
        if (keycode == KeyCode.SPACE) {
            this.keysDown[4] = false;
        }
        return this.keysDown;
    }
    // keep as extra in case needed
    private void checkCollisionsEnemy(Rectangle block) {

        if ((mySpriteImage.getBoundsInParent()).intersects(block.getBoundsInParent())) {
            this.hp -= 2;
        }

    }

}
