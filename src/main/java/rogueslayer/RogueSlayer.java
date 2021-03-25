package rogueslayer;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.view.View;

public class RogueSlayer extends GameEngine {
	ArrayList<Screen> kindOfScreens = new ArrayList<Screen>();
	Screen currentScreen;
	int difficulty;

	public static String MEDIA_URL = "src/main/java/rogueslayer/media/";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RogueSlayer rs = new RogueSlayer();
		rs.runSketch();
	}

	@Override
	public void setupGame() {
        int worldWidth = 1280;
        int worldHeight = 704;
        difficulty = 1;
        
        kindOfScreens.add(new MainMenu(this));
        kindOfScreens.add(new Game(this));
        currentScreen = kindOfScreens.get(0);
        View view = new View(worldWidth, worldHeight);
        view.setBackground(loadImage(RogueSlayer.MEDIA_URL.concat("background.png")));
        setView(view);
        size(worldWidth, worldHeight);	
        System.out.println(getWidth());

	}
	
	public void setCurrentScreen(int indexOfScreen) {
		this.currentScreen = this.kindOfScreens.get(indexOfScreen);
	}

	@Override
	public void update() {
		currentScreen.updateScreen();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {currentScreen.MouseClickedScreen(e);
	}

}
