package systems;

import core.ComponentSystem;
import core.EntityManager;
import entities.Meteor;

public class SpawnMeteorOnTimeInterval implements ComponentSystem {
	public static int SPAWNCOUNT = 20;

	private float delayFromLastSpawn;
	private float spawnDelay;

	public SpawnMeteorOnTimeInterval(float spawnDelay) {
		this.spawnDelay = spawnDelay;
	}

	@Override
	public void update(float deltaTime) {
		if (input.EventInput.isWarping)
			return;
		delayFromLastSpawn += deltaTime;

		if (delayFromLastSpawn < spawnDelay)
			return;

		delayFromLastSpawn = 0f;
		for (int i = 0; i < SPAWNCOUNT; i++) {
			float xPos = (float) (Math.random() * 800f);
			float yPos = -DeleteOnScreenExitSystem.LENIENCY;

			EntityManager.addEntity(new Meteor(xPos, yPos));
		}
	}
}
