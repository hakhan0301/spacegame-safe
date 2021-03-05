package core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class MultiComponentList implements Iterable<ComponentPack> {
	private Map<Class<? extends Component>, ArrayList<Component>> listMap;

	private int uniqueComponents;
	private int componentsPerList;

	public MultiComponentList(
			Map<Class<? extends Component>, ArrayList<Component>> listMap) {
		this.listMap = listMap;

		uniqueComponents = listMap.size();

		ArrayList<?> firstList = listMap.values().iterator().next();
		componentsPerList = firstList.size();
	}

	@Override
	public Iterator<ComponentPack> iterator() {
		return new ComponentListIterator();
	}

	class ComponentListIterator implements Iterator<ComponentPack> {
		private int currrentPackIndex;

		@Override
		public boolean hasNext() {
			return currrentPackIndex < componentsPerList;
		}

		@Override
		public ComponentPack next() {
			Component[] components = new Component[uniqueComponents];

			int i = 0;
			for (ArrayList<Component> componentList : listMap.values()) {
				components[i] = componentList.get(currrentPackIndex);
				i++;
			}

			currrentPackIndex++;
			return new ComponentPack(components);
		}
	}
}
