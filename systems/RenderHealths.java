package systems;

import components.Health;
import components.Position;
import core.ComponentPack;
import core.ComponentSystem;
import core.EntityManager;
import core.MultiComponentList;
import processing.core.PApplet;

public class RenderHealths implements ComponentSystem {
	private PApplet p;

	public RenderHealths(PApplet p) {
		this.p = p;
	}

	@Override
	public void update(float deltaTime) {
		MultiComponentList components = EntityManager.getMultipleComponents(Position.class, Health.class);

		for (ComponentPack pack : components) {
			Position position = pack.get(Position.class);
			Health health = pack.get(Health.class);

			p.fill(256, 100, 100);
			p.text(health.currentHealth, position.x + 5, position.y - 5);
		}

	}
}
