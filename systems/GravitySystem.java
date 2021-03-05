package systems;

import java.util.ArrayList;

import components.RigidBody;
import core.ComponentSystem;
import core.EntityManager;

public class GravitySystem implements ComponentSystem {

	public static final float GRAVITY = 2.4f;

	@Override
	public void update(float deltaTime) {
		ArrayList<RigidBody> rigidBodies = EntityManager.getComponentsOfType(RigidBody.class);

		for (RigidBody rigidBody : rigidBodies) {
			rigidBody.yVelocity += rigidBody.Gravity * deltaTime;
		}
	}
}
