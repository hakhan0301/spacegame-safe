package components;

import java.util.Stack;

import core.Component;
import systems.TimeWarpHealthSystem;

public class TimeWarpHealth extends Component {
	public static final int STORAGE_SIZE = TimeWarpHealthSystem.STORAGE_SIZE;

	private Stack<Integer> previousHealth;

	public TimeWarpHealth() {
		previousHealth = new Stack<Integer>();
	}

	public void AddHealth(int health) {
		if (previousHealth.size() > STORAGE_SIZE)
			previousHealth.remove(0);

		previousHealth.push(health);
	}

	public int size() {
		return previousHealth.size();
	}

	public int pop() {
		return previousHealth.pop();
	}
}
