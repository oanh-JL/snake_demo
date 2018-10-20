package game;

import base.*;
import base.player.Player;
import base.player.SnakePart;
import base.renderer.BoxColliderRenderer;
import base.snack.Snack;
import base.wall.Wall;


import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {
    public static Player player;
    public GameCanvas() {
        GameObject.recycle(Background.class);
        this.player = GameObject.recycle(Player.class);
        Snack snack = GameObject.recycle(Snack.class);
        //snack.position.set(190,450);
        Wall wall = GameObject.recycle(Wall.class);
       // wall.position.set(170,400);
    }

    public void run() {
        GameObject.runAll();
    }

    public void render() {
        GameObject.renderAllToBackBuffer();
    }

    @Override
    protected void paintComponent(Graphics g) {
        GameObject.renderBackBufferToGame(g);
    }
}
