package components;

import core.Component;

public class Health extends Component {

	public int currentHealth;
	public long lastTimeReduced;

	public Health(int startingHealth) {
		this.currentHealth = startingHealth;
	}
}
