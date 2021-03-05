package systems;

import components.AddVelocity;
import components.Position;
import core.ComponentPack;
import core.ComponentSystem;
import core.EntityManager;
import core.MultiComponentList;

public class AddVelocitySystem implements ComponentSystem {

	@Override
	public void update(float deltaTime) {
		MultiComponentList components = EntityManager
				.getMultipleComponents(Position.class, AddVelocity.class);

		for (ComponentPack pack : components) {
			Position position = pack.get(Position.class);
			AddVelocity velocity = pack.get(AddVelocity.class);

			position.x -= velocity.xVelocity * deltaTime;
			position.y -= velocity.yVelocity * deltaTime;
		}
	}
}
