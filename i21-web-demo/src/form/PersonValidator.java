
package form;

import com.interface21.validation.Errors;
import com.interface21.validation.Validator;
import command.Person;

public class PersonValidator implements Validator {

	/**
	 * @see Validator#supports(Class)
	 */
	public boolean supports(Class clazz) {
		return clazz.equals(Person.class);
	}

	/**
	 * @see Validator#validate(Object, Errors)
	 */
	public void validate(Object obj, Errors errors) {
		Person person = (Person) obj;
		if (person.getAge() < 18)
			errors.rejectValue("age", "age.tooyoung", "Too young");
	}

}
