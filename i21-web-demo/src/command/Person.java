
package command;

/**
 * Simple JavaBean populated from a
 * web request.
 * Contains both String and int properties.
 * 
 * @since Jan 7, 2003
 * @author Rod Johnson
 */
public class Person {
	
	private int age;
	
	private String name;

	/**
	 * Gets the age.
	 * @return Returns a int
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 * @param age The age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Gets the name.
	 * @return Returns a String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * @param name The name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "Person: name='" + name + "'; age=" + age;
	}

	
}
