package systems;

import java.util.ArrayList;

import components.DeleteOnScreenExit;
import components.Position;
import core.ComponentPack;
import core.ComponentSystem;
import core.Entity;
import core.EntityManager;
import core.MultiComponentList;

public class DeleteOnScreenExitSystem implements ComponentSystem {
	public static final int LENIENCY = 200;

	private int width;
	private int height;

	public DeleteOnScreenExitSystem(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public void update(float deltaTime) {
		MultiComponentList components = EntityManager.getMultipleComponents(
				Position.class, DeleteOnScreenExit.class);

		ArrayList<Entity> toDelete = new ArrayList<Entity>();
		for (ComponentPack pack : components) {
			Position position = pack.get(Position.class);
			DeleteOnScreenExit deleteCheck = pack.get(DeleteOnScreenExit.class);

			if (position.x < -LENIENCY || position.x > width + LENIENCY) {
				toDelete.add(deleteCheck.Entity);
			}
			if (position.y < -LENIENCY || position.y > height + LENIENCY) {
				toDelete.add(deleteCheck.Entity);
			}
		}

		for (Entity entity : toDelete)
			EntityManager.deleteEntity(entity);
	}

}
