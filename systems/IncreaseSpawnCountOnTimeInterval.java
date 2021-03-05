package systems;

import core.ComponentSystem;

public class IncreaseSpawnCountOnTimeInterval implements ComponentSystem {
	public static int SPAWNCOUNT = 20;

	private float delayFromLastDecrease;
	private float decreaseDelay;

	public IncreaseSpawnCountOnTimeInterval(float decreaseDelay) {
		this.decreaseDelay = decreaseDelay;
	}

	@Override
	public void update(float deltaTime) {
		delayFromLastDecrease += deltaTime;

		if (delayFromLastDecrease < decreaseDelay)
			return;

		delayFromLastDecrease = 0f;
		SpawnMeteorOnTimeInterval.SPAWNCOUNT *= 1.05f;
	}
}
