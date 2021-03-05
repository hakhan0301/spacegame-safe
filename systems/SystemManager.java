package systems;

import java.util.HashMap;
import java.util.Map;

import core.ComponentSystem;

public class SystemManager {
	private static Map<Class<? extends ComponentSystem>, ComponentSystem> systems;

	static {
		systems = new HashMap<Class<? extends ComponentSystem>, ComponentSystem>();
	}

	public static void addSystem(ComponentSystem system) {
		systems.put(system.getClass(), system);
	}

	public static void update(float deltaTime) {
		for (ComponentSystem system : systems.values()) {
			system.update(deltaTime);
		}
	}
}
