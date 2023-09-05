
package form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.interface21.web.servlet.ModelAndView;
import com.interface21.web.servlet.mvc.SessionFormController;
import com.wrox.expertj2ee.ticket.customer.RegisteredUser;

public class CustomerInputInSession extends SessionFormController {
	
	private static final int[] BIRTH_YEARS = {
		1970, 1971, 1972, 1973, 1974 };
	
	public CustomerInputInSession() {
		super(RegisteredUser.class);
		// Get as bean property 
		//setValidator(new DefaultUserValidator());
	}


	protected Object formBackingObjectInternal(HttpServletRequest request) {
		RegisteredUser user = new RegisteredUser();
		user.setEmail("sessioncontroller");
		user.setNonbound("Nonbound at " + new java.util.Date());
		return user;
	}

	
	protected ModelAndView onSubmit(Object command) throws ServletException {
		//RegisteredUser user = (RegisteredUser) command;
		//return new ModelAndView(getSuccessView(), "email", user.getEmail());
		
		// Do something with object
		
		return super.onSubmit(command);
	}
 

	/**
	 * @see FormController#formReferenceData()
	 */
	protected Map referenceData(HttpServletRequest request) {
		Map m = new HashMap();
		m.put("BIRTHYEARS", BIRTH_YEARS); 
		return m;
	}

}
