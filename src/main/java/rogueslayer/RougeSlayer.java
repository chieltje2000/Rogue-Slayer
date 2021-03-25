package rogueslayer;

import java.util.ArrayList;

import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.view.View;

public class RougeSlayer extends GameEngine {
	ArrayList<Screen> kindOfScreens = new ArrayList<Screen>();
	Screen currentScreen;
	int difficulty;
	
	public static String MEDIA_URL = "src/main/java/rogueslayer/media/";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RougeSlayer rs = new RougeSlayer();
		rs.runSketch();
	}

	@Override
	public void setupGame() {
        int worldWidth = 800;
        int worldHeight = 600;
        difficulty = 1;
        
        kindOfScreens.add(new MainMenu(this));
        kindOfScreens.add(new Game(this));
        currentScreen = kindOfScreens.get(0);
        View view = new View(worldWidth, worldHeight);
        
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
	public void mouseClicked() {
		currentScreen.MouseClickedScreen();
	}

}
