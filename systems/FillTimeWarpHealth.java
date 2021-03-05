package systems;

import components.Health;
import components.TimeWarpHealth;
import core.ComponentPack;
import core.ComponentSystem;
import core.EntityManager;
import core.MultiComponentList;
import input.EventInput;

public class FillTimeWarpHealth implements ComponentSystem {

	@Override
	public void update(float deltaTime) {
		if (EventInput.isWarping)
			return;

		MultiComponentList components = EntityManager
				.getMultipleComponents(Health.class, TimeWarpHealth.class);

		for (ComponentPack pack : components) {
			Health health = pack.get(Health.class);
			TimeWarpHealth previousHealth = pack.get(TimeWarpHealth.class);

			previousHealth.AddHealth(health.currentHealth);
		}
	}

}
