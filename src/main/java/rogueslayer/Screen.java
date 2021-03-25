package rogueslayer;

public abstract class Screen {
	protected RougeSlayer rs;

	public Screen(RougeSlayer rs) {
		this.rs = rs;
	}

	protected abstract void updateScreen();

	protected abstract void MouseClickedScreen();

}
