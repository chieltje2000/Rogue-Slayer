package rogueslayer;

import java.awt.event.MouseEvent;
import java.util.Random;

import nl.han.ica.oopg.objects.TextObject;

public class Game extends Screen {

	int currentFloor = 1;
	int bossFloor = 10;
	int currentRound = 1;
	boolean playerTurn = true;
	Player player;
	Enemy enemy;
	TextObject round;
	TextObject floor;

	public Game(RogueSlayer rs) {
		super(rs);
		round = new TextObject("ronde: " + currentRound, 20);
		floor = new TextObject("floer: " + currentFloor, 20);

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
			nextRound();
		}
	}

	private void enemyTurn() {
		if (currentRound == 5) {
			// doe enemy special
		}
		// do enemy aanval
	}

	private void nextRound() {
		currentRound += 1;
		if (currentRound > 10) {
			nextFloor();
		}
	}

	public void nextFloor() {
		// do enemy on death
		// reset player deck
		generateEnemy();
		currentRound = 1;
		currentFloor += 1;
		if (currentFloor == 10) {
			// do boss fight
		}
	}

	private void generateEnemy() {
		Random random = new Random();
		int randomNumber = random.nextInt(3);
		if (randomNumber == 0) {
			enemy = new Spider();
			System.out.println("spider");
		} else if (randomNumber == 1) {
			enemy = new Golem();
			System.out.println("golem");
		} else if (randomNumber == 2) {
			enemy = new InfectedMiner();
			System.out.println("infected miner");
		}
	}

	@Override
	public void mouseClickedScreen(MouseEvent e) {
		// player card klick hier
		// test code
		nextRound();
		if (currentFloor > 10) {
			rs.setCurrentScreen(0);
		}
	}

	@Override
	public void mouseMovedScreen(MouseEvent e) {
		// player card on hover hier doen
	}

	@Override
	public void addAllGameObjects() {
		generateEnemy();
		rs.addGameObject(round, 0, 0);
		rs.addGameObject(floor, 100, 0);
	}

}
