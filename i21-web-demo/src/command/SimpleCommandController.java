package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.interface21.validation.Errors;
import com.interface21.web.servlet.ModelAndView;
import com.interface21.web.servlet.mvc.AbstractCommandController;

/**
 * Controller illustrating how a 
 * JavaBean can automatically be populated from a request.
 * 
 * @since Jan 7, 2003
 * @author Rod Johnson
 */
public class SimpleCommandController extends AbstractCommandController {

	/**
	 * Define the bean class and the name of the command
	 * so that we can identify target fields when data binding.
	 * @see java.lang.Object#Object()
	 */
	public SimpleCommandController() {
		super(Person.class, "person");
	}

	/**
	 * @see AbstractCommandController#handle(HttpServletRequest, HttpServletResponse, Object, Errors)
	 */
	protected ModelAndView handle(
		HttpServletRequest request,
		HttpServletResponse response,
		Object command,
		Errors errors) {
		if (!errors.hasErrors()) {
			// The submission was valid and the command was populated
			// OK
			return new ModelAndView("personDisplay", "person", (Person) command);
		} 
		else {
			// Binding errors
			System.out.println("There were binding errors: redirecting to debug page");
			return new ModelAndView("debugView", "errors", errors);
		}
	}

}
