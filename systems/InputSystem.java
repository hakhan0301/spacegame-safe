package systems;

import java.util.ArrayList;

import components.MovementInputComponent;
import core.ComponentSystem;
import core.EntityManager;
import input.MovementInput;

public class InputSystem implements ComponentSystem {

	@Override
	public void update(float deltaTime) {
		int vertical = 0;
		if (MovementInput.W)
			vertical += 1;
		if (MovementInput.S)
			vertical -= 1;

		int horizontal = 0;
		if (MovementInput.A)
			horizontal += 1;
		if (MovementInput.D)
			horizontal -= 1;

		ArrayList<MovementInputComponent> inputComponents = EntityManager.getComponentsOfType(MovementInputComponent.class);
		for (MovementInputComponent inputComponent : inputComponents) {
			inputComponent.x = horizontal;
			inputComponent.y = vertical;
		}
	}

}
