package entities;

import components.AddVelocity;
import components.CircleCollider;
import components.DeleteOnScreenExit;
import components.Position;
import components.TimeWarp;
import core.Entity;

public class Meteor extends Entity {
	public Meteor(float x, float y) {
		this.AddComponent(new Position(x, y));
		this.AddComponent(new AddVelocity((float) (-10 + Math.random() * 20), (float) (-100 + Math.random() * -100)));
		this.AddComponent(new TimeWarp());
		this.AddComponent(new CircleCollider(10f));
		this.AddComponent(new DeleteOnScreenExit());
	}
}
