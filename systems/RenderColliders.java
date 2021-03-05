package systems;

import components.CircleCollider;
import components.Position;
import core.ComponentPack;
import core.ComponentSystem;
import core.EntityManager;
import core.MultiComponentList;
import processing.core.PApplet;

public class RenderColliders implements ComponentSystem {

	private PApplet p;

	public RenderColliders(PApplet p) {
		this.p = p;
	}

	@Override
	public void update(float deltaTime) {
		MultiComponentList components = EntityManager
				.getMultipleComponents(CircleCollider.class, Position.class);

		for (ComponentPack pack : components) {
			CircleCollider collider = pack.get(CircleCollider.class);
			Position position = pack.get(Position.class);

			p.fill(230);
			p.circle(position.x, position.y, collider.radius);
		}
	}
}
