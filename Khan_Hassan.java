import core.EntityManager;
import entities.Player;
import input.EventInput;
import input.MovementInput;
import processing.core.PApplet;
import systems.AddVelocitySystem;
import systems.DecreaseHealthOnCollision;
import systems.DeleteEntityOnZeroHealth;
import systems.DeleteOnScreenExitSystem;
import systems.FillTimeWarp;
import systems.FillTimeWarpHealth;
import systems.HandleCollisions;
import systems.IncreaseSpawnCountOnTimeInterval;
import systems.InputSystem;
import systems.InputUpdatesVelocitySystem;
import systems.PhysicsSystem;
import systems.RenderColliders;
import systems.RenderHealths;
import systems.RenderStartScreen;
import systems.RenderTimeWarp;
import systems.SpawnMeteorOnTimeInterval;
import systems.SystemManager;
import systems.TimeWarpHealthSystem;
import systems.TimeWarpSystem;

public class Khan_Hassan extends PApplet {

	public static void main(String[] args) {
		PApplet.main("Khan_Hassan");
	}

	Player player;

	@Override
	public void settings() {
		size(800, 800);

		SystemManager.addSystem(new RenderStartScreen(this));
	}

	public void StartGame() {
		SystemManager.addSystem(new RenderColliders(this));
		SystemManager.addSystem(new RenderHealths(this));
		SystemManager.addSystem(new RenderTimeWarp(this));
		SystemManager.addSystem(new InputSystem());
		SystemManager.addSystem(new InputUpdatesVelocitySystem());
		SystemManager.addSystem(new AddVelocitySystem());
		SystemManager.addSystem(new PhysicsSystem());
		SystemManager.addSystem(new TimeWarpSystem(this, 3f));
		SystemManager.addSystem(new TimeWarpHealthSystem(this, 3f));
		SystemManager.addSystem(new FillTimeWarp());
		SystemManager.addSystem(new FillTimeWarpHealth());
		SystemManager.addSystem(new DecreaseHealthOnCollision());
		SystemManager.addSystem(new HandleCollisions());
		SystemManager.addSystem(new DeleteEntityOnZeroHealth());
		SystemManager.addSystem(new DeleteOnScreenExitSystem(width, height));
		SystemManager.addSystem(new SpawnMeteorOnTimeInterval(1f));
		SystemManager.addSystem(new IncreaseSpawnCountOnTimeInterval(2f));

		EntityManager.addEntity(player = new Player());
	}

	@Override
	public void setup() {
		frameRate(60);
	}

	int lastTime = 0;

	@Override
	public void draw() {
		background(0);

		float deltaTime = (millis() - lastTime) / 1000f;

		SystemManager.update(deltaTime);

		lastTime = millis();
	}

	@Override
	public void keyPressed() {
		if (key == 'w')
			MovementInput.W = true;
		if (key == 'a')
			MovementInput.A = true;
		if (key == 's')
			MovementInput.S = true;
		if (key == 'd')
			MovementInput.D = true;
		if (key == ' ')
			EventInput.isWarping = true;
		if (key == 'e') {
			if (EventInput.gameStarted != true)
				StartGame();
			EventInput.gameStarted = true;
		}
	}

	@Override
	public void keyReleased() {
		if (key == 'w')
			MovementInput.W = false;
		if (key == 'a')
			MovementInput.A = false;
		if (key == 's')
			MovementInput.S = false;
		if (key == 'd')
			MovementInput.D = false;
		if (key == ' ')
			EventInput.isWarping = false;
	}
}