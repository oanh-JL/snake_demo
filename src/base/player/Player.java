package base.player;

import base.GameObject;
import base.Settings;
import base.counter.FrameCounter;
import base.event.KeyEventPress;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.wall.Wall;
import game.GameCanvas;

import java.util.ArrayList;

public class Player extends GameObject {

    SnakeHead head;
    ArrayList<SnakePart> parts;
    FrameCounter moveCount;
    int direction;
    SnakePart newPart;
    BoxCollider collider;

    public Player() {
        super();
        this.moveCount = new FrameCounter(10);
        this.position.set(190, 290);
        this.initParts();
        this.direction = Settings.UP;
        this.newPart = GameObject.recycle(SnakePart.class);


    }

    private void initParts() {
        this.parts = new ArrayList<>();
        this.head = GameObject.recycle(SnakeHead.class);
        this.head.position.set(this.position);
        SnakePart tail = GameObject.recycle(SnakePart.class);
        tail.position.set(this.head.position.add(0, -Settings.WAY_SIZE));
        this.parts.add(this.head);
        this.parts.add(tail);

    }

    @Override
    public void run() {

        this.setDirection();
        if (this.moveCount.run()) {
            this.move();
            this.setPartsPosition();
            this.moveCount.reset();
        }
 }


    private void setPartsPosition() {
        if (this.newPart != null) {
            parts.add(1, GameObject.recycle(SnakePart.class));
            parts.add(2, GameObject.recycle(SnakePart.class));
            parts.add(3, GameObject.recycle(SnakePart.class));
            parts.add(4, GameObject.recycle(SnakePart.class));
            parts.add(5, GameObject.recycle(SnakePart.class));

            this.newPart = null;

        } else {
            for (int i = this.parts.size() - 1; i > 0; i--) {
                SnakePart part = this.parts.get(i);
                SnakePart prevPart = this.parts.get(i - 1);
                part.position.set(prevPart.position);
            }
        }
        this.head.position.set(this.position);
    }

    private void move() {

        switch (this.direction) {
            case Settings.UP: {
                this.position.addThis(0, -Settings.WAY_SIZE);
                break;
            }
            case Settings.DOWN: {
                this.position.addThis(0, Settings.WAY_SIZE);
                break;
            }
            case Settings.LEFT: {
                this.position.addThis(-Settings.WAY_SIZE, 0);
                break;
            }
            case Settings.RIGHT: {
                this.position.addThis(Settings.WAY_SIZE, 0);
                break;
            }
        }
    }

    private void setDirection() {
        if (KeyEventPress.isUpPress && this.direction != Settings.DOWN) {
            this.direction = Settings.UP;
        } else if ((KeyEventPress.isDownPress && this.direction != Settings.UP)) {
            this.direction = Settings.DOWN;
        } else if (KeyEventPress.isLeftPress && this.direction != Settings.RIGHT) {
            this.direction = Settings.LEFT;
        } else if (KeyEventPress.isRightPress && this.direction != Settings.LEFT) {
            this.direction = Settings.RIGHT;
        }
    }

    public void growUp() {
        this.newPart = GameObject.recycle(SnakePart.class);
    }

}
