package entities;

import components.AddVelocity;
import components.CircleCollider;
import components.Health;
import components.MovementInputComponent;
import components.Position;
import components.RigidBody;
import components.TimeWarp;
import components.TimeWarpHealth;
import components.Trigger;
import core.Entity;

public class Player extends Entity {
	public Player() {
		this.AddComponent(new Position(800 / 2, 800 / 4));
		this.AddComponent(new MovementInputComponent(200));
		this.AddComponent(new AddVelocity());
		this.AddComponent(new TimeWarp());
		this.AddComponent(new CircleCollider(5f));
		this.AddComponent(new Trigger());
		this.AddComponent(new TimeWarp());
		this.AddComponent(new TimeWarpHealth());
		this.AddComponent(new Health(3));
		this.AddComponent(new RigidBody());
	}
}
