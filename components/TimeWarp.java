package components;

import java.util.Stack;

import core.Component;
import systems.TimeWarpSystem;

public class TimeWarp extends Component {
	public static final int STORAGE_SIZE = TimeWarpSystem.STORAGE_SIZE;

	private Stack<Float> xPositions;
	private Stack<Float> yPositions;

	public boolean ToEmpty;

	public TimeWarp() {
		xPositions = new Stack<Float>();
		yPositions = new Stack<Float>();
	}

	public void AddPosition(float x, float y) {
		if (yPositions.size() > STORAGE_SIZE)
			xPositions.remove(0);
		if (yPositions.size() > STORAGE_SIZE)
			yPositions.remove(0);

		xPositions.push(x);
		yPositions.push(y);
	}

	public void Empty() {
		ToEmpty = false;
		xPositions.clear();
		yPositions.clear();
	}

	public int Size() {
		return Math.min(xPositions.size(), yPositions.size());
	}

	public float popX() {
		ToEmpty = true;
		return xPositions.pop();
	}

	public float popY() {
		ToEmpty = true;
		return yPositions.pop();
	}
}
