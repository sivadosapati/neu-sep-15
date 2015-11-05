package lecture8;

import base.BaseObject;

public class ChessPlayer extends BaseObject implements Runnable {
	private String name;
	private int moveCount = 0;
	private boolean turn = false;

	public ChessPlayer(String n) {
		this.name = n;
	}
	
	public void setTurn(boolean b){
		this.turn = b;
	}

	public void think() {
		for (int i = 0; i < 10; i++) {
			System.out.println(name + " is thinking -> " + i);
			sleep(2);
		}
	}

	public void move() {
		System.out.println(name + " is moving " + moveCount);
		moveCount++;
		turn = false;
	}

	@Override
	public void run() {
		think();
	}

	public boolean isMyTurn() {
		return turn;
	}
}
