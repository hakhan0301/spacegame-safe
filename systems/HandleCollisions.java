package systems;

import java.util.ArrayList;

import components.CircleCollider;
import components.Position;
import components.Trigger;
import core.Component;
import core.ComponentPack;
import core.ComponentSystem;
import core.EntityManager;
import core.MultiComponentList;

public class HandleCollisions implements ComponentSystem {

	@Override
	public void update(float deltaTime) {
		MultiComponentList triggerables = EntityManager.getMultipleComponents(CircleCollider.class, Trigger.class, Position.class);
		MultiComponentList colliders = EntityManager.getMultipleComponents(CircleCollider.class, Position.class);

		for (ComponentPack triggerPack : triggerables) {
			CircleCollider triggerCollider = triggerPack.get(CircleCollider.class);
			Trigger trigger = triggerPack.get(Trigger.class);
			Position triggerPosition = triggerPack.get(Position.class);

			for (ComponentPack colliderPack : colliders) {
				CircleCollider collider = colliderPack.get(CircleCollider.class);
				Position colliderPosition = colliderPack.get(Position.class);

				if (triggerCollider == collider)
					continue;

				boolean hasCollided = CircleCollider.CheckCollision(triggerPosition, triggerCollider, colliderPosition,	collider);

				if (hasCollided) {
					trigger.isTriggered = true;
					break;
				} else {
					trigger.isTriggered = false;
				}
			}
		}
	}
}
