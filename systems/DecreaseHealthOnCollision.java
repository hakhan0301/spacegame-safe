package systems;

import components.Health;
import components.Trigger;
import core.ComponentPack;
import core.ComponentSystem;
import core.EntityManager;
import core.MultiComponentList;
import input.EventInput;

public class DecreaseHealthOnCollision implements ComponentSystem {

	public static final long INVINCIBILITY_MILLIS = 1000;

	@Override
	public void update(float deltaTime) {
		if (EventInput.isWarping)
			return;

		MultiComponentList components = EntityManager
				.getMultipleComponents(Health.class, Trigger.class);

		for (ComponentPack pack : components) {
			Health health = (Health) pack.get(Health.class);
			Trigger trigger = (Trigger) pack.get(Trigger.class);

			long timeSinceDamage = System.currentTimeMillis()
					- health.lastTimeReduced;
			if (trigger.isTriggered && timeSinceDamage > INVINCIBILITY_MILLIS) {
				health.currentHealth -= 1;
				health.lastTimeReduced = System.currentTimeMillis();
			}
		}

	}

}
