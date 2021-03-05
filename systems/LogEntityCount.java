package systems;

import core.ComponentSystem;
import core.EntityManager;

public class LogEntityCount implements ComponentSystem {

	@Override
	public void update(float deltaTime) {
		System.out.println(EntityManager.entityCount());
	}

}
