import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;


class Enemy extends Pane {

    public int lvlNum = 0;

    public Enemy(){
        super();
        setupEnemy();
    }
    public Enemy(int level){
        super();
        this.getChildren().add(setupEnemy(level));
    }
    private void setupEnemy(){
        System.out.println("Enemy added");
    }

    private Pane setupEnemy(int level){

        System.out.println("Enemy added");
        Pane levelPane = new Pane();
        if(level == 1) {
            levelPane.getChildren().add(addKillerBlock());
        }

        return levelPane;
    }

    private static Node addKillerBlock() {
        return new Rectangle(540, 1000, 600, 2000);
    }

    public static Rectangle[] getBlocks(){

        Rectangle[] node = new Rectangle[2];
        node[0] = (Rectangle) addKillerBlock();
        node[1] = (Rectangle) addKillerBlock();

        return node;

    }


}
