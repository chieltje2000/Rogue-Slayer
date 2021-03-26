package rogueslayer;

import java.awt.event.MouseEvent;

public class Game extends Screen{

	public Game(RogueSlayer rs) {
		super(rs);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void updateScreen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClickedScreen(MouseEvent e) {
		rs.setCurrentScreen(0);
	}

	@Override
	public void mouseMovedScreen(MouseEvent e) {

	}

	@Override
	public void addAllGameObjects() {

	}


}
