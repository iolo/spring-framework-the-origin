
package form;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.interface21.web.servlet.ModelAndView;
import com.interface21.web.servlet.mvc.FormController;
import command.Person;

public class PersonInput extends FormController {
	
	public PersonInput() {
		super(Person.class, "person");
		// Get as bean property 
		setValidator(new PersonValidator());
		setFormView("personForm");
	}


	protected Object formBackingObject(HttpServletRequest request) throws ServletException {
		Person person = new Person();
		person.setName("AAAA");
		return person;
	}
	
	protected ModelAndView onSubmit(Object command)
		throws ServletException {
		Person person = (Person) command;
		return new ModelAndView("personDisplay", getBeanName(), person);
	}



}
