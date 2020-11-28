import javafx.scene.input.KeyCode;

import java.awt.event.KeyEvent;

class KeyCheck {
    private static final boolean[] keysDown = new boolean[5]; // {Left, RIGHT, UP, DOWN, SPACE}



public static boolean[] getKeysDown(){
        return keysDown;
}

    public static boolean[] keyReleased(KeyCode keycode) {

        if(keycode == KeyCode.LEFT){
            keysDown[0] = false;
        }
        if(keycode == KeyCode.RIGHT){
            keysDown[1] = false;

        }
         if(keycode == KeyCode.UP){
            keysDown[2] = false;
        }
         if(keycode == KeyCode.DOWN){
            keysDown[3] = false;
        }
         if(keycode == KeyCode.SPACE){
            keysDown[4] = false;
        }
        return keysDown;
    }

}
