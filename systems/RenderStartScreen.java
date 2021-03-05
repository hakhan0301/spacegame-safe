package systems;

import core.ComponentSystem;
import input.EventInput;
import processing.core.PApplet;

public class RenderStartScreen implements ComponentSystem {

	private PApplet p;

	public RenderStartScreen(PApplet p) {
		this.p = p;
	}

	@Override
	public void update(float deltaTime) {
		if (EventInput.gameStarted)
			return;
		p.background(256);
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				p.fill(50, 50, 100f + (float) Math.random() * 100);
				p.circle((float) (Math.random() * p.width), (float) (Math.random() * p.height),
						4 + (float) Math.sin(p.millis() / 1000) * 2);
			}
		}
		p.fill(100f + (float) Math.random() * 100, 50, 50);
		p.text("Press E to Start Game", p.width / 2 - 40, p.height / 2 - 4);
	}
}
