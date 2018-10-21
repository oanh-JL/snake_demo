package base.player;

import base.GameObject;
import base.Settings;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.BoxColliderRenderer;
import base.wall.Wall;

import java.awt.*;

public class SnakePart extends GameObject implements Physics {
    BoxCollider collider;
    SnakeHead head;
    public SnakePart(){
        super();
        this.collider = new BoxCollider(Settings.WAY_SIZE-6,Settings.WAY_SIZE-6);
        this.renderer = new BoxColliderRenderer(Color.white);
    }

    @Override
    public void run() {
        this.checkIntersects();
    }

    private void checkIntersects() {
        Wall wall = GameObject.intersect(Wall.class,this);
        if (wall!=null){
            this.destroy();
        }

        Player player=GameObject.intersect(Player.class,this);
        if(player!=null){
            player.destroy();
        }

    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
