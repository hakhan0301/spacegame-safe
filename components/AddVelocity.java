package components;

import core.Component;

public class AddVelocity extends Component {
	public float xVelocity;
	public float yVelocity;

	public AddVelocity() {
	};

	public AddVelocity(float xVelocity, float yVelocity) {
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
	}
}
