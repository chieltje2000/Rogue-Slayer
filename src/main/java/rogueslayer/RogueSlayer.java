package rogueslayer;

import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.objects.TextObject;
import nl.han.ica.oopg.view.View;
import sun.applet.Main;

import javax.swing.*;
import java.awt.*;

public class RogueSlayer extends GameEngine {

    private  MainMenu menu;
    private  Button button;
    private int worldWidth = 1280;
    private int worldHeight= 704;
    public  static String MEDIA_URL = "src/main/java/rogueslayer/media/";

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RogueSlayer rs = new RogueSlayer();
        rs.runSketch();
    }

    @Override
    public void setupGame() {
        // TODO Auto-generated method stub
        createViewWithoutViewport(getWorldWidth(), getWorldHeight());
    }

    private void createMainMenu() {
        menu = new MainMenu(this);
        menu.setupMainMenu();
    }

    public int getWorldWidth() {
        return worldWidth;
    }
    public int getWorldHeight() {
        return worldHeight;
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        createMainMenu();
    }


    /**
     * Creeërt de view zonder viewport
     *
     * @param screenWidth  Breedte van het scherm
     * @param screenHeight Hoogte van het scherm
     */
    private void createViewWithoutViewport(int screenWidth, int screenHeight) {
        View view = new View(screenWidth, screenHeight);
        view.setBackground(loadImage(RogueSlayer.MEDIA_URL.concat("background1.png")));

        setView(view);
        size(screenWidth, screenHeight);
    }
}
