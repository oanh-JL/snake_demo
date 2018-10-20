package base.snack;

import base.GameObject;
import base.Settings;
import base.Vector2D;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.BoxColliderRenderer;

import java.awt.*;

public class Snack extends GameObject implements Physics {
    BoxCollider collider;
    public Snack(){
        super();
        this.collider = new BoxCollider(Settings.WAY_SIZE-6,Settings.WAY_SIZE-6);
        this.renderer = new BoxColliderRenderer(Color.yellow,true);
        this.position = new Vector2D(110,230);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
