package trollgame;
import java.util.ArrayDeque;
import java.util.Queue;

public class Humans{
int count;
Queue<Warrior> humans;

public Humans(int count) {
	this.count = count;
	humans = new ArrayDeque<Warrior>();
	for(int i = 0; i < count; i++) {
		Warrior human = new Warrior(20, 10);
		humans.add(human);
	}
}

protected int getCount() {
	return count;
}

protected Queue<Warrior> getHumans() {
	return humans;
}

}
