package lecture8;

import base.BaseObject;

public class ChessPlayer extends BaseObject implements Runnable {
	private String name;
	private int moveCount = 0;
	private boolean turn = false;

	private ChessPlayer competitor;

	public void setCompetitor(ChessPlayer cp) {
		this.competitor = cp;
	}

	public ChessPlayer(String n) {
		this.name = n;
	}

	public void setTurn(boolean b) {
		this.turn = b;
	}

	public void think() {
		for (int i = 0; i < 10; i++) {
			System.out.println(name + " is thinking -> " + i);
			sleep(2);
		}
	}

	public synchronized void move() {
		while (true) {
			if (!isMyTurn()) {
				waitForAWhile();
			}
			int x = getRandomNumber(2000);
			sleep(x);
			System.out.println(name + " is moving after thinking for -> " + x+" millis -> "+moveCount);
			moveCount++;
			this.setTurn(false);
			competitor.setTurn(true);
			synchronized(competitor){
				competitor.notify();
			}
			if (moveCount == 5) {
				break;
			}
		}
	}

	@Override
	public void run() {
		think();
	}

	public boolean isMyTurn() {
		return turn;
	}
}
