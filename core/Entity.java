package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Entity {
	private ArrayList<Component> components;
	private Map<Class<?>, Component> componentReferences;

	public Entity() {
		componentReferences = new HashMap<Class<?>, Component>();
		components = new ArrayList<Component>();
	}

	public void AddComponent(Component component) {
		component.Entity = this;
		components.add(component);
	}

	public boolean HasComponent(Class<?> type) {
		if (componentReferences.containsKey(type))
			return true;

		for (Component component : components)
			if (type.isInstance(component))
				return true;

		return false;
	}

	public <ComponentType extends Component> ComponentType GetComponent(Class<ComponentType> componentTypeReference) {
		@SuppressWarnings("unchecked")
		ComponentType referencedComponent = (ComponentType) componentReferences.get(componentTypeReference);
		if (referencedComponent != null)
			return referencedComponent;

		for (Component component : components) {
			if (componentTypeReference.isInstance(component)) {
				componentReferences.put(componentTypeReference, component);
				return componentTypeReference.cast(component);
			}
		}

		throw new IllegalArgumentException("Component not found in Entity");
	}

	public ArrayList<Component> GetComponents() {
		return components;
	}
}
