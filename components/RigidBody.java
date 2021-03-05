package components;

import core.Component;
import systems.GravitySystem;

public class RigidBody extends Component {
	public float Gravity;
	public float xVelocity;
	public float yVelocity;

	public RigidBody() {
		// Gravity = GravitySystem.GRAVITY;
		Gravity = 0f;
	}

	public RigidBody(float gravity) {
		Gravity = gravity;
	}

	public static RigidBody WithInitialVelocity(float xVelocity,
			float yVelocity) {
		RigidBody rb = new RigidBody(GravitySystem.GRAVITY);
		rb.xVelocity = xVelocity;
		rb.yVelocity = yVelocity;

		return rb;
	}
}
