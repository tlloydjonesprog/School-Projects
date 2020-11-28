import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.awt.*;

class Environment extends Pane {
    private static Rectangle endBlock = new Rectangle(1000,600, 50,50);

    public Group blocksTotal = new Group();
        public Environment(){
            super();
            setupEnvironment();
        }
        public Environment(int level){
        super();
        endBlock.setFill(       Color.BLUE);

        if(level<3) {

            this.getChildren().add(setupEnvironment(level));
        }
        else{

            this.getChildren().add( new Text( 250, 250,"CONGRATS, GAME COMPLETE!"));
        }
        }

    public static Node getEnd() {
            return endBlock;

    }
    public Pane end(){
            Pane ending = new Pane();
            ending.getChildren().add(endBlock);
            return ending;


    }

    private void setupEnvironment(){

            System.out.println("Environment added");
    }

         private Pane setupEnvironment(int level){

         System.out.println("Environment added");
             Pane levelPane = new Pane();
             if(level == 1) {
                 levelPane.getChildren().add(addKillerBlock());
             }
             if(level == 2){
                 levelPane.getChildren().clear();
                 levelPane.getChildren().add(addExtraKillerBlock());
             }

             return levelPane;
        }

    private Pane addExtraKillerBlock() {
            Pane  blockPane = new Pane();
            Group blocks = new Group(ExtraBlocks());
            blockPane.getChildren().addAll(ExtraBlocks());
            return blockPane;

    }

    private Node ExtraBlocks() {
        Rectangle blocks3 = new Rectangle(650,600,Math.random()*200,200);
        Rectangle blocks2 = new Rectangle(650,600,Math.random()*200,200);
        Rectangle blocks1 = new Rectangle(Math.random()*650+100,600,Math.random()*200,200);

        return new Group(blocks1,blocks2,blocks3);
    }


    private static Node addKillerBlock() {


        return new Rectangle(600, 601, 100, 200);
    }

    static Rectangle[] getBlocks(){

        Rectangle[] blocks = new Rectangle[2];
        blocks[0] = (Rectangle) addKillerBlock();
        blocks[1] = (Rectangle) addKillerBlock();


    return blocks;

    }


}
