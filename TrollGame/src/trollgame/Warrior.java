package trollgame;

public class Warrior {
int hp;
int power;

public Warrior(int hp, int power) {
	this.hp = hp;
	this.power = power;
}

public int getHp() {
	return hp;
}

protected void setHp(int hp) {
	this.hp = hp;
}

public int getPower() {
	return power;
}

protected void setPower(int power) {
	this.power = power;
}

protected boolean isAlive() {
	return hp != 0;
}
protected int attack(Warrior w) {
	int n = w.getHp() - this.getPower();
	if (n < 0) {
		w.setHp(0);
	} else {
		w.setHp(n);
	}
	return w.getHp();
}
}
