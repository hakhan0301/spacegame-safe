package systems;

import java.util.ArrayList;

import components.Health;
import core.ComponentSystem;
import core.Entity;
import core.EntityManager;

public class DeleteEntityOnZeroHealth implements ComponentSystem {

	@Override
	public void update(float deltaTime) {
		ArrayList<Health> healths = EntityManager.getComponentsOfType(Health.class);
		ArrayList<Entity> entitiesToDelete = new ArrayList<Entity>();

		for (Health health : healths) {
			if (health.currentHealth <= 0) {
				entitiesToDelete.add(health.Entity);
			}
		}

		for (Entity entity : entitiesToDelete) {
			EntityManager.deleteEntity(entity);
		}

	}

}
