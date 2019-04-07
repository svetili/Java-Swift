package snake;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class SnakeGame {
	Point[][] board;
	Queue<Point> snake;
	Point snakeHead;
	Point apple;

	public SnakeGame() {
		this.board = new Point[20][60];
		this.snake = new ArrayDeque<Point>();
		this.initBoard();
		this.initBorder();
		this.initSnake();
		this.initApple();
	}

	public void initBoard() {
		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board[0].length; j++) {
				this.board[i][j] = new Point(i, j);
			}
		}
	}

	void initBorder() {
		for (int i = 0; i < this.board.length; i++) {
			this.board[i][0].setCh('#');
			this.board[i][this.board[0].length - 1].setCh('#');
		}
		for (int j = 1; j < this.board[0].length - 1; j++) {
			this.board[0][j].setCh('#');
			this.board[this.board.length - 1][j].setCh('#');
		}
	}

	public void initSnake() {
		for (int j = 1; j < 6; j++) {
			Point p = new Point(1, j, 'o');
			this.snake.add(p);
			this.board[1][j].setCh('o');
			if (j == 5) {
				snakeHead = p;
			}
		}
	}

	public void initApple() {
		Random rand = new Random();
		int i = rand.nextInt(this.board.length);
		int j = rand.nextInt(this.board[0].length);
		Point temp = new Point(i, j);
		while (this.isBorder(temp) || this.isSnake(temp)) {
			i = rand.nextInt(this.board.length);
			j = rand.nextInt(this.board[0].length);
			temp = new Point(i, j);
		}
		this.apple = new Point(i, j, '*');
		this.board[i][j].setCh('*');
	}

	public boolean isBorder(Point p) {
		int x = p.getX();
		int y = p.getY();
		if (x == 0 || y == 0 || x == board[0].length - 1 || y == board.length - 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isSnake(Point p) {
		boolean b = false;
		for (int i = 0; i < snake.size(); i++) {
			Point checkPoint = snake.poll();
			if (checkPoint.equals(p)) {
				b = true;
				break;
			}
			snake.add(checkPoint);
		}
		return b;
	}

	public void printState() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j].getCh());
			}
			System.out.println();
		}

	}

	public boolean moveSnake(String move) {
		int x = snakeHead.getX();
		int y = snakeHead.getY();
		int xNew = 0, yNew = 0;
		switch (move) {
		case "UP":
			xNew = x;
			yNew = y - 1;
			break;
		case "DOWN":
			xNew = x;
			yNew = y + 1;
			break;
		case "LEFT":
			xNew = x - 1;
			yNew = y;
			break;
		case "RIGHT":
			xNew = x + 1;
			yNew = y;
			break;
		}
		Point newPoint = new Point(yNew, xNew, 'o');
		if (this.isBorder(newPoint) || this.isSnake(newPoint)) {
			return false;
		}
		if (this.apple.equals(newPoint)) {
			initApple();
		} else {
			Point oldPoint = snake.poll();
			board[oldPoint.getY()][oldPoint.getX()].setCh(' ');
		}
		snake.add(newPoint);
		snakeHead = newPoint;
		board[newPoint.getY()][newPoint.getX()].setCh('o');
		return true;
	}

	public static void main(String[] args) {
		SnakeGame game = new SnakeGame();
		game.printState();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter action <UP, DOWN, LEFT, RIGHT, END>:");
		String str = sc.nextLine();
		boolean b = true;
		while (!"END".equals(str) && b) {
			b = game.moveSnake(str);
			if (!b) {
				System.out.println("You fail!");
			} else {
				game.printState();
				str = sc.nextLine();
			}
		}

		sc.close();
	}

}
