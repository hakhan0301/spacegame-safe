package components;

import core.Component;

public class CircleCollider extends Component {
	public float radius;

	public CircleCollider(float radius) {
		this.radius = radius;
	}

	public static boolean CheckCollision(Position aPos, CircleCollider aCollider, Position bPos,
			CircleCollider bCollider) {
		float distance = (float) Math
				.sqrt((bPos.y - aPos.y) * (bPos.y - aPos.y) + (bPos.x - aPos.x) * (bPos.x - aPos.x));
		float totalRadius = Math.max(aCollider.radius, bCollider.radius)
				- Math.min(aCollider.radius, bCollider.radius) / 2;
		return distance < totalRadius;
	}
}
