
package form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.interface21.web.servlet.ModelAndView;
import com.interface21.web.servlet.mvc.FormController;
import com.wrox.expertj2ee.ticket.customer.RegisteredUser;

/**
 * Simple controller that both displays form data and
 * handles form submission.
 * 
 * @since Jan 7, 2003
 * @author Rod Johnson
 */
public class CustomerInput extends FormController {
	
	/** Data values to populate dropdown */
	private static final int[] BIRTH_YEARS = {
		1970, 1971, 1972, 1973, 1974 };
	
	public CustomerInput() {
		super(RegisteredUser.class);
	}
	


	/**
	 * Return the object behind the form
	 * @see com.interface21.web.servlet.mvc.FormController#formBackingObject(HttpServletRequest)
	 */
	protected Object formBackingObject(HttpServletRequest request) {
		RegisteredUser user = new RegisteredUser();
		user.setEmail("Enter your email");
		return user;
	}

	
	/**
	 * Handle form submission
	 * @see com.interface21.web.servlet.mvc.FormController#onSubmit(Object)
	 */
	protected ModelAndView onSubmit(Object command) {
		RegisteredUser user = (RegisteredUser) command;
		return new ModelAndView(getSuccessView(), "user", user);
	}
 

	/**
	 * @return the reference data for the input form
	 * @see FormController#formReferenceData()
	 */
	protected Map referenceData(HttpServletRequest request) {
		Map m = new HashMap();
		m.put("BIRTHYEARS", BIRTH_YEARS); 
		return m;
	}

}
