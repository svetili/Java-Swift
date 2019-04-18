package trollgame;
import java.util.ArrayDeque;
import java.util.Queue;

public class Trolls{
int count;
Queue<Warrior> trolls;

public Trolls(int count) {
	this.count = count;
	trolls = new ArrayDeque<Warrior>();
	for(int i = 0; i < count; i++) {
		Warrior troll = new Warrior(30, 6);
		trolls.add(troll);
	}
}

protected int getCount() {
	return count;
}

protected Queue<Warrior> getTrolls() {
	return trolls;
}

}
