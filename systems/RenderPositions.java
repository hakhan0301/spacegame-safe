package systems;

import java.util.ArrayList;

import components.Position;
import core.ComponentSystem;
import core.EntityManager;
import processing.core.PApplet;

public class RenderPositions implements ComponentSystem {

	private PApplet p;

	public RenderPositions(PApplet p) {
		this.p = p;
	}

	@Override
	public void update(float deltaTime) {
		ArrayList<Position> positions = EntityManager.getComponentsOfType(Position.class);
		for (Position position : positions) {
			p.fill(256, 2343, 234);
			p.circle(position.x, position.y, 5);
		}
	}
}
