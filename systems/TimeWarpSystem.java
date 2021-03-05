package systems;

import components.Position;
import components.TimeWarp;
import core.ComponentPack;
import core.ComponentSystem;
import core.EntityManager;
import core.MultiComponentList;
import input.EventInput;
import processing.core.PApplet;

public class TimeWarpSystem implements ComponentSystem {

	public static int STORAGE_SIZE = 0;

	public TimeWarpSystem(PApplet p, float timeBackInSeconds) {
		STORAGE_SIZE = (int) (p.frameRate * timeBackInSeconds);
	}

	@Override
	public void update(float deltaTime) {
		if (!EventInput.isWarping)
			return;

		MultiComponentList components = EntityManager
				.getMultipleComponents(Position.class, TimeWarp.class);

		for (ComponentPack pack : components) {
			Position position = pack.get(Position.class);
			TimeWarp previousPosition = pack.get(TimeWarp.class);

			for (int f = 0; f < 2; f++)
				if (previousPosition.Size() > 0) {
					position.x = previousPosition.popX();
					position.y = previousPosition.popY();
				}
		}

	}

}
