
package simple;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.interface21.web.servlet.ModelAndView;
import com.interface21.web.servlet.mvc.Controller;

public class SimpleControllerWithBeanProperty implements Controller {
	
	private String name;
	
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

	/**
	 * @see SimpleController#handleRequest(HttpServletRequest, HttpServletResponse)
	 */
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String name = request.getParameter("name");
		if (name == null || "".equals(name)) {
			return new ModelAndView("enterNameView");
		}
		else if (name.indexOf("-") != -1) {
			return new ModelAndView("invalidNameView", "name", name);
		}
		else {
			return new ModelAndView("validNameView", "name",  name);
		}
	}

}
