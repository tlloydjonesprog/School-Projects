class ExcessCode {
//    public int getX() {
//        return x;
//    }
//
//    public void setX(int x) {
//        this.x = x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
    // System.out.println(""+blocks[i].getX()+blocks[i].getY()+blocks[i].getY()+blocks[i].getHeight()+ blocks[i].getX()+blocks[i].getWidth());
    //System.out.println(blocks[i].getBoundsInLocal());
    //System.out.println(hiddenBlock.getBoundsInLocal());
    //  if ((hiddenBlock.getBoundsInParent()).intersects(blocks[i].getX(),blocks[i].getY(),blocks[i].getY()+blocks[i].getHeight(), blocks[i].getX()+blocks[i].getWidth())) {
    //     this.hp -= 2;

                /*BorderPane menuPane = new BorderPane();
            Scene sceneMenu = new Scene(menuPane, 200, 300);
            menu.setScene(sceneMenu);

            menuPane.setCenter(menu(primaryStageMAIN));
            menu.show();*//*
             primaryStageMAIN.close();
             primaryStageMAIN.n*/
    //startGame(primaryStage, this.menu);   -- best yet



//    public void setY(int y) {
//        this.y = y;
//    }
//    private void setUpJumpMonitoring(PathTransition transition) {
//
//        EventHandler<ActionEvent> eventHandler = e -> {
//
//            //System.out.println(transition.getNode().getTranslateX() );
//
//            if (isJumping) {
//                if (previousX == transition.getNode().getTranslateX()) { //same spot ...
//                    //done jumping:
//                    isJumping = false;
//                    System.out.println("jumping: " + this.x);
//                    this.x += transition.getNode().getTranslateX();
//                    animation.stop();
//                } else {
//                    previousX = transition.getNode().getTranslateX();
//                    System.out.println("jumping: " + this.x);
//                }
//            }
//
//        };
//
/*
        HighScore.nameList[counter] = readerName;
        HighScore.scoreList[counter] = readerScore;*/
//        // Create the observer
//        animation = new Timeline(
//                new KeyFrame(Duration.millis(10), eventHandler));
//        animation.setCycleCount(2000);
//        animation.play(); // Start animation
//
//    }
//    private void setUpTransition() {
//        // create arc for jump
//        float jumpDistance = 100.0f;
//        Arc arc = new Arc();
//        System.out.println("Players X: " + this.x);
//        arc.setCenterX(this.x + jumpDistance);
//        arc.setCenterY(this.y + hightOfSprite);
//        arc.setRadiusX(jumpDistance);
//        arc.setRadiusY(jumpDistance);
//        arc.setStartAngle(180.0f);
//        arc.setLength(-180.0f);
//        arc.setType(ArcType.OPEN);  //changed to open
//
//
//        transition = new PathTransition();
//        transition.setNode(jump);
//        transition.setPath(arc);
//        transition.setDuration(Duration.seconds(1));
//
//        //				Pane p = new Pane();
//        //				p.getChildren().add(arc);
//        //				Stage temp = new Stage();
//        //				temp.setScene(new Scene( p, 400,400) );
//        //				temp.show();
//    }
//    private Button getPauseButton() {
//        Button pause = new Button("walk");
//
//        return pause;
//    }
//    private Button getTwiceSpeedButton() {
//        Button doubleSpeed = new Button("2x Speed");
//
//
//		/*        doubleSpeed.setOnKeyPressed( e -> {
//            if(e.getCode() == KeyCode.RIGHT){
//                graphics.getChildren().removeAll(idle);
//                graphics.getChildren().add(walk);
//            }
//        });
//        doubleSpeed.setOnKeyReleased( e -> {
//            if (e.getCode() == KeyCode.RIGHT) {
//                graphics.getChildren().removeAll(walk);
//                graphics.getChildren().add(idle);
//            }});*/
//        doubleSpeed.setOnAction(e -> doubleSpeed());
//        return doubleSpeed;
//    }
//    private void walkAnimation() {
//
//        if (graphics.getChildren().contains(idle)) {
//            graphics.getChildren().remove("idlee");
//
//            graphics.getChildren().add(walk);
//        } else
//            graphics.getChildren().remove(walk);
//        graphics.getChildren().add(idle);
//
//    }
    // private Pane getUI() {
    //
    //        HBox controlPanel = new HBox();
    //
    //        return controlPanel;
    //    }
}
