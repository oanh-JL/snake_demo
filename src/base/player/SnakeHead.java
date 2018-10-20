package base.player;

import base.GameObject;
import base.physics.Physics;
import base.renderer.BoxColliderRenderer;
import base.snack.Snack;
import base.wall.Wall;
import game.GameCanvas;

import java.awt.*;

public class SnakeHead extends SnakePart implements Physics {
    SnakePart part;
    public SnakeHead(){
        super();
        this.renderer = new BoxColliderRenderer(Color.green,true);
    }
    @Override
    public void run() {
        Snack snack = GameObject.intersect(Snack.class,this);

        if (snack!=null){
            snack.destroy();
            GameCanvas.player.growUp();
        }
        Wall wall = GameObject.intersect(Wall.class,this);
        if (wall!=null){
            this.destroy();
            GameCanvas.player.destroy();

        }
    }
}
