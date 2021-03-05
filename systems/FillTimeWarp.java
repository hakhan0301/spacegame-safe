package systems;

import components.Position;
import components.TimeWarp;
import core.ComponentPack;
import core.ComponentSystem;
import core.EntityManager;
import core.MultiComponentList;
import input.EventInput;

public class FillTimeWarp implements ComponentSystem {

	@Override
	public void update(float deltaTime) {
		if (EventInput.isWarping)
			return;

		MultiComponentList components = EntityManager
				.getMultipleComponents(Position.class, TimeWarp.class);

		for (ComponentPack pack : components) {
			Position position = pack.get(Position.class);
			TimeWarp previousPosition = pack.get(TimeWarp.class);

			previousPosition.AddPosition(position.x, position.y);
		}
	}

}
