package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EntityManager {
	private static Map<Class<? extends Component>, ArrayList<Component>> components;
	private static ArrayList<Entity> entities;

	static {
		components = new HashMap<Class<? extends Component>, ArrayList<Component>>();
		entities = new ArrayList<Entity>();
	}

	public static void deleteEntity(Entity entity) {
		entities.remove(entity);
		for (Component component : entity.GetComponents()) {
			ArrayList<? extends Component> components = getComponentsOfType(
					component.getClass());
			components.remove(component);
		}

		entity = null;
	}

	public static <ComponentType extends Component> ArrayList<ComponentType> getComponentsOfType(
			Class<ComponentType> componentTypeReference) {
		ArrayList<? extends Component> componentList = components
				.get(componentTypeReference);
		ArrayList<ComponentType> outputList = (ArrayList<ComponentType>) componentList;
		if (outputList == null)
			return new ArrayList<ComponentType>();

		return outputList;
	}

	@SafeVarargs
	public static MultiComponentList getMultipleComponents(
			Class<? extends Component>... componentTypes) {

		Map<Class<? extends Component>, ArrayList<Component>> componentMap = new HashMap<Class<? extends Component>, ArrayList<Component>>();
		for (Class<? extends Component> componentType : componentTypes) {
			componentMap.put(componentType, new ArrayList<Component>());
		}

		EntityLoop: for (Entity entity : entities) {
			for (Class<? extends Component> componentType : componentTypes) {
				if (!entity.HasComponent(componentType))
					continue EntityLoop;
			}
			for (Class<? extends Component> componentType : componentTypes) {
				Component componentFromEntity = entity
						.GetComponent(componentType);
				componentMap.get(componentType).add(componentFromEntity);
			}
		}

		return new MultiComponentList(componentMap);
	}

	public static void addEntity(Entity entity) {
		entities.add(entity);

		for (Component component : entity.GetComponents()) {
			Class<? extends Component> componentType = component.getClass();

			if (components.get(componentType) == null) {
				ArrayList<Component> emptyList = new ArrayList<Component>();
				components.put(componentType, emptyList);
			}

			ArrayList<Component> listOfTypes = components.get(componentType);
			listOfTypes.add(component);
		}

	}

	public static int entityCount() {
		return entities.size();
	}
}
