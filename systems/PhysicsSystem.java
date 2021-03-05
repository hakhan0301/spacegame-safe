package systems;

import components.Position;
import components.RigidBody;
import core.ComponentPack;
import core.ComponentSystem;
import core.EntityManager;
import core.MultiComponentList;

public class PhysicsSystem implements ComponentSystem {

	@Override
	public void update(float deltaTime) {
		MultiComponentList components = EntityManager
				.getMultipleComponents(Position.class, RigidBody.class);

		for (ComponentPack pack : components) {
			Position position = pack.get(Position.class);
			RigidBody rigidBody = pack.get(RigidBody.class);

			updatePositionsWithVelocity(position, rigidBody);
		}
	}

	private static void updatePositionsWithVelocity(Position position,
			RigidBody rigidBody) {
		position.x += rigidBody.xVelocity;
		position.y += rigidBody.yVelocity;
	}

}
