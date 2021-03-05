package components;

import core.Component;

public class MovementInputComponent extends Component {
	public int x;
	public int y;
	public float maxSpeed;

	public MovementInputComponent(float speed) {
		this.maxSpeed = speed;
	}
}
