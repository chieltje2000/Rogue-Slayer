package rogueslayer;

import java.awt.event.MouseEvent;

public abstract class Screen {
	protected RogueSlayer rs;

	public Screen(RogueSlayer rs) {
		this.rs = rs;
	}

	protected abstract void updateScreen();

    public abstract void mouseClickedScreen(MouseEvent e);

    public abstract void mouseMovedScreen(MouseEvent e);

	public abstract void addAllGameObjects();
}
