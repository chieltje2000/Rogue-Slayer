package rogueslayer;

public class MainMenu extends Screen {

	public MainMenu(RougeSlayer rs) {
		super(rs);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void updateScreen() {
		System.out.println("mainMenu");
	}

	@Override
	protected void MouseClickedScreen() {		
		rs.setCurrentScreen(1);
	}

}
