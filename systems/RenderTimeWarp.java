package systems;

import components.Position;
import components.TimeWarp;
import components.TimeWarpHealth;
import core.ComponentPack;
import core.ComponentSystem;
import core.EntityManager;
import core.MultiComponentList;
import processing.core.PApplet;

public class RenderTimeWarp implements ComponentSystem {
	private PApplet p;

	public RenderTimeWarp(PApplet p) {
		this.p = p;
	}

	@Override
	public void update(float deltaTime) {
		MultiComponentList components = EntityManager
				.getMultipleComponents(Position.class, TimeWarpHealth.class);

		for (ComponentPack pack : components) {
			Position position = pack.get(Position.class);
			TimeWarpHealth timeWarp = pack.get(TimeWarpHealth.class);

			float maxWidth = 20f;

			p.fill(150, 150, 150);
			p.rect(position.x + 5, position.y + 5, maxWidth, 3);

			p.fill(256, 200, 200);
			p.rect(position.x + 5, position.y + 5,
					maxWidth * timeWarp.size() / TimeWarp.STORAGE_SIZE, 3);
		}

	}
}
