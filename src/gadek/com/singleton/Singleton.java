package gadek.com.singleton;

import java.io.Serializable;

/*
 * Singleton 
 * serialization and thread-safe guaranteed
 * by the enum implementation
 * but field  variables are not getting serialized
 */

public enum Singleton  {
	INSTANCE;
	int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	

}
