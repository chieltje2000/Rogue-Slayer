package rogueslayer;

import nl.han.ica.oopg.objects.TextObject;

import java.awt.event.MouseEvent;
import java.util.Random;

public class Game extends Screen {

	int currentFloor = 1;
	int bossFloor = 10;
	int currentRound = 1;
	boolean playerTurn = true;
	Player player;
	Enemy enemy;
	TextObject round;
	TextObject floor;

	Dialog dl = new Dialog(rs);

	public Game(RogueSlayer rs) {
		super(rs);
		round = new TextObject("round: " + currentRound, 20);
		floor = new TextObject("floor: " + currentFloor, 20);
	}

	@Override
	protected void updateScreen() {
		checkturn();
		round.setText("ronde: " + currentRound);
		floor.setText("floer: " + currentFloor);
	}

	private void checkturn() {
		if (!playerTurn) {
			enemyTurn();
		}
	}

	private void enemyTurn() {

		if (enemy.hp <= 0) {
			nextFloor();
		} else {
			enemy.doDamage(player);
			if (player.hp <= 0) {
				dl.gameLose();
			}
			nextRound();
			if (currentRound == 5) {
				enemy.special();
			}
		}
	}

	private void nextRound() {
//		player.refreshDEF();
//		player.refreshHP();
//		enemy.refreshDEF();
//		enemy.refreshHP();
//		player.drawCard();
		playerTurn = true;
		currentRound += 1;
	}

	public void nextFloor() {
		// do enemy on death
		// reset player deck
		playerTurn = true;
		System.out.println("hier");
		enemy.removeAllGameObjects();
		player.reward();
		player.resetDeck();
		generateEnemy();
		currentRound = 1;
		currentFloor += 1;
		if (currentFloor == 10) {
			enemy.bossMode();
		} else if (currentFloor == 11) {
			dl.gameWin();
		}
	}

	private void generateEnemy() {
		Random random = new Random();
		int randomNumber = random.nextInt(3);
		if (randomNumber == 0) {
			enemy = new Spider(rs, 23, 50, 350, 350, 10);


		} else if (randomNumber == 1) {
			enemy = new Golem(rs, 48, 50, 350, 350, 10);
		} else if (randomNumber == 2) {
			enemy = new InfectedMiner(rs, 11, 50, 350, 350, 10);
		}
		enemy.addAllGameObjects();
		player.enemyChanged(enemy);
	}

	private void generatePlayer() {
		player = new Player(rs, 200, 350);
		player.addAllGameObjects();
	}

	@Override
	public void mouseClickedScreen(MouseEvent e) {

		if (dl.isClicked) {
			player.onClick(e);
			playerTurn = false;
		} else {
			dl.onClick(e);
		}
	}

	@Override
	public void mouseMovedScreen(MouseEvent e) {
		// player card on hover hier doen
		player.onHover(e);
	}

	@Override
	public void addAllGameObjects() {
		this.currentFloor = 1;
		generatePlayer();
		generateEnemy();
		
		rs.addGameObject(round, 0, 0);
		rs.addGameObject(floor, 100, 0);
		dl.gameIntro();

	}

}
