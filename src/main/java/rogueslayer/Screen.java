package rogueslayer;

import java.awt.event.MouseEvent;

public abstract class Screen {
	protected RogueSlayer rs;

	public Screen(RogueSlayer rs) {
		this.rs = rs;
	}

	protected abstract void updateScreen();

    public abstract void MouseClickedScreen(MouseEvent e);
}
