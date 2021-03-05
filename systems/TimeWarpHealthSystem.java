package systems;

import components.Health;
import components.TimeWarpHealth;
import core.ComponentPack;
import core.ComponentSystem;
import core.EntityManager;
import core.MultiComponentList;
import input.EventInput;
import processing.core.PApplet;

public class TimeWarpHealthSystem implements ComponentSystem {

	public static int STORAGE_SIZE = 0;

	public TimeWarpHealthSystem(PApplet p, float timeBackInSeconds) {
		STORAGE_SIZE = (int) (p.frameRate * timeBackInSeconds);
	}

	@Override
	public void update(float deltaTime) {
		if (!EventInput.isWarping)
			return;

		MultiComponentList components = EntityManager
				.getMultipleComponents(Health.class, TimeWarpHealth.class);

		for (ComponentPack pack : components) {
			Health health = pack.get(Health.class);
			TimeWarpHealth previousHealth = pack.get(TimeWarpHealth.class);

			for (int f = 0; f < 2; f++)
				if (previousHealth.size() > 0) {
					health.currentHealth = previousHealth.pop();
				}
		}

	}

}
