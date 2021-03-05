package core;

import java.util.HashMap;
import java.util.Map;

public class ComponentPack {
	private Map<Class<? extends Component>, Component> componentMap;

	public ComponentPack(Component[] components) {
		componentMap = new HashMap<Class<? extends Component>, Component>();

		for (Component component : components)
			componentMap.put(component.getClass(), component);
	}

	public <T extends Component> T get(Class<? extends Component> type) {
		if (!componentMap.containsKey(type))
			throw new IllegalArgumentException("invalid type");

		return (T) componentMap.get(type);
	}

}