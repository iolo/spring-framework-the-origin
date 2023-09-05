
package simple;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.interface21.context.ApplicationContextException;
import com.interface21.web.servlet.ModelAndView;
import com.interface21.web.servlet.mvc.AbstractController;

/**
 * Simple controller with a JavaBean property.
 * See "Expert One-on-One J2EE", p. 482.
 * @author Rod Johnson
 */
public class HelloController 
	extends AbstractController {

	private String name;

	/**
	 * JavaBean property, set through XML configuration descriptor
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This is the main request handling method
	 * @see com.interface21.web.servlet.mvc.AbstractController#handleRequestInternal(HttpServletRequest, HttpServletResponse)
	 */
	protected ModelAndView handleRequestInternal(
		HttpServletRequest request, 
		HttpServletResponse response)
		throws ServletException, IOException {
		String pname = request.getParameter("name");
		if (pname == null) {
			return new ModelAndView("enterNameView");
		}
		else {
			return new ModelAndView("greetingView", "greeting", 
				"Hello " + pname + ", my name is " + this.name);
		}
	}

	/**
	 * Overridden method that is invoked after bean properties
	 * are set, but before we begin handling requests.
	 * @see com.interface21.web.context.support.WebApplicationObjectSupport#init()
	 */
	protected void init() throws ApplicationContextException {
		if (this.name ==  null)
			throw new ApplicationContextException(
			"name property must be set on beans of class " + getClass().getName());
	}
}

