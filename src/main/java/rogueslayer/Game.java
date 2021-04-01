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
			enemy.onDeath(player);
			nextFloor();
		} else {
			enemy.atack(player);
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
		playerTurn = true;
		currentRound += 1;
	}

	public void nextFloor() {
		// do enemy on death
		// reset player deck
		playerTurn = true;
		System.out.println("hier");
		enemy.removeAllGameObjects();
		generateEnemy();
		currentRound = 1;
		currentFloor += 1;
		if (currentFloor == 10) {
			// do boss fight
		} else if (currentFloor == 11) {
			dl.gameWin();
		}
	}

	private void generateEnemy() {
		Random random = new Random();
		int randomNumber = random.nextInt(3);
		if (randomNumber == 0) {
<<<<<<< HEAD
			enemy = new Spider(rs, 23, 50, 350, 350, 0);
=======
			enemy = new Spider(rs,"spider",50,50);
>>>>>>> master
			System.out.println("spider");

		} else if (randomNumber == 1) {
<<<<<<< HEAD
			enemy = new Golem(rs, 48, 50, 350, 350, 0);
			System.out.println("golem");
		} else if (randomNumber == 2) {
			enemy = new InfectedMiner(rs, 11, 50, 350, 350, 0);
=======
			enemy = new Golem(rs,"spider",50,50);
			System.out.println("golem");
		} else if (randomNumber == 2) {
			enemy = new InfectedMiner(rs,"spider",50,50);
>>>>>>> master
			System.out.println("infected miner");
		}
		enemy.addAllGameObjects();
	}

	private void generatePlayer() {
		player = new Player(rs, 200, 350);
	}

	@Override
	public void mouseClickedScreen(MouseEvent e) {
		// player card klick hier
		// test code
//		nextRound();
//		if (currentFloor > 10) {
//			rs.setCurrentScreen(0);
//		}
		if (dl.isClicked) {
			enemy.takeDamage(10);
			playerTurn = false;
		} else {
			dl.onClick(e);
		}
<<<<<<< HEAD
		// rs.setCurrentScreen(0);
=======
		dl.onClick(e);
		pl.onClick(e);
		//rs.setCurrentScreen(0);
>>>>>>> master

	}

	@Override
	public void mouseMovedScreen(MouseEvent e) {
		// player card on hover hier doen
		pl.onHover(e);
	}

	@Override
	public void addAllGameObjects() {
		this.currentFloor = 1;
		generateEnemy();
		generatePlayer();
		rs.addGameObject(round, 0, 0);
		rs.addGameObject(floor, 100, 0);

<<<<<<< HEAD
		dl.gameIntro();
		player.addAllGameObjects();

=======
		pl.addAllGameObjects();
		dl.gameIntro();

		rs.addGameObject(pl,200,350);
		pl.drawHP();
		pl.drawDEF();
		pl.takeDamage(90);
>>>>>>> master
	}

}
