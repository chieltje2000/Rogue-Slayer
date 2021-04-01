package rogueslayer;

import nl.han.ica.oopg.dashboard.Dashboard;
import nl.han.ica.oopg.objects.TextObject;

import java.awt.event.MouseEvent;

public class Game extends Screen{

	Player pl = new Player(rs);
	Dialog dl = new Dialog(rs);
	ATK atk = new ATK(rs);
	DEF def = new DEF(rs);
	HEAL heal = new HEAL(rs);
	private TextObject hpCount;
	private TextObject defCount;

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
		//rs.setCurrentScreen(0);
	}

	@Override
	public void mouseMovedScreen(MouseEvent e) {

	}

	@Override
	public void addAllGameObjects() {
		dl.gameIntro();
		rs.addGameObject(pl,200,350);
		pl.drawHP();
		pl.drawDEF();
		pl.takeDamage(90);
	}

/* word nog niet gebruikt voor iets
	private void createDashboard(int dashboardWith, int dashboardHeight) {
		Dashboard dashboard = new Dashboard(0, 300, dashboardWith, dashboardHeight);
		rs.addDashboard(dashboard);
	}*/
}
