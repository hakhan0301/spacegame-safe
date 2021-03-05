package systems;

import components.AddVelocity;
import components.MovementInputComponent;
import core.ComponentPack;
import core.ComponentSystem;
import core.EntityManager;
import core.MultiComponentList;

public class InputUpdatesVelocitySystem implements ComponentSystem {
	public static final float SPEED = 50f;

	@Override
	public void update(float deltaTime) {
		MultiComponentList components = EntityManager.getMultipleComponents(
				MovementInputComponent.class, AddVelocity.class);

		for (ComponentPack pack : components) {
			MovementInputComponent inputComponent = pack
					.get(MovementInputComponent.class);
			AddVelocity addVelocity = pack.get(AddVelocity.class);

			addVelocity.xVelocity = CalculateVelocity(addVelocity.xVelocity,
					inputComponent.x, inputComponent.maxSpeed, deltaTime);
			addVelocity.yVelocity = CalculateVelocity(addVelocity.yVelocity,
					inputComponent.y, inputComponent.maxSpeed, deltaTime);
		}
	}

	public static float CalculateVelocity(float velocity, float inputComponent,
			float maxSpeed, float deltaTime) {
		if (inputComponent == 0) {
			float sign = Math.signum(velocity);
			velocity = Math.abs(velocity);
			velocity -= 1500 * deltaTime;
			velocity = Math.max(0f, velocity);
			velocity *= sign;
		}

		if (Math.signum(velocity) == -Math.signum(inputComponent))
			velocity += inputComponent * SPEED * 8;
		velocity += inputComponent * SPEED;

		velocity = Math.signum(velocity)
				* Math.min(Math.abs(velocity), maxSpeed);

		return velocity;
	}
}
