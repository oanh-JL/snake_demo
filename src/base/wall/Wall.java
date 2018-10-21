package base.wall;

import base.GameObject;
import base.Settings;
import base.Vector2D;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.player.Player;
import base.renderer.BoxColliderRenderer;

import java.awt.*;

public class Wall extends GameObject implements Physics {
    BoxCollider collider;
    public Wall(){
        super();
        this.collider = new BoxCollider(Settings.WAY_SIZE,(Settings.WAY_SIZE)*6);
        this.renderer = new BoxColliderRenderer(Color.red,true);
        this.position = new Vector2D(170,400);
    }


    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
