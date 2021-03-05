package systems;

import components.MovementInputComponent;
import components.Position;
import core.ComponentPack;
import core.ComponentSystem;
import core.EntityManager;
import core.MultiComponentList;

public class InputUpdatesPositionSystem implements ComponentSystem {

	@Override
	public void update(float deltaTime) {
		MultiComponentList components = EntityManager.getMultipleComponents(
				MovementInputComponent.class, Position.class);

		for (ComponentPack pack : components) {
			MovementInputComponent inputComponent = pack
					.get(MovementInputComponent.class);
			Position position = pack.get(Position.class);

			position.x -= inputComponent.x * inputComponent.maxSpeed / 75;
			position.y -= inputComponent.y * inputComponent.maxSpeed / 75;
		}
	}
}
