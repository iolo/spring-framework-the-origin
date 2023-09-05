package com.wrox.expertj2ee.ticket.customer;

import com.interface21.validation.Errors;
import com.interface21.validation.Validator;

/**
 * Simple validator example
 * 
 * @since Jan 7, 2003
 * @author Rod Johnson
 */
public class DefaultUserValidator implements Validator {

	/** Minimum length for email */
	public static final int DEFAULT_MIN_EMAIL = 6;

	/** Maximum length for email */
	public static final int DEFAULT_MAX_EMAIL = 64;

	private int minEmail = DEFAULT_MIN_EMAIL;
	private int maxEmail = DEFAULT_MAX_EMAIL;

	/** Bean parameters */
	public void setMinEmail(int minEmail) {
		this.minEmail = minEmail;
	}

	public void setMaxEmail(int maxEmail) {
		this.maxEmail = maxEmail;
	}
	
	public boolean supports(Class clazz) {
		return clazz.equals(RegisteredUser.class);
	}

	/** 
	 * This is the method that will be used to validate objects
	*/
	public void validate(Object o, Errors errs) {
		RegisteredUser u = (RegisteredUser) o;
		validateEmail(u.getEmail(), errs);
		checkPostCode(u.getBillingAddress().getPostcode(), errs);
	}

	private void validateEmail(String email, Errors errs) {
		if (email == null || "".equals(email)) {
			errs.rejectValue("email", "emailRequired", "E-mail Address is required");
			return;
		}

		int fioa = email.indexOf("@");
		int lioa = email.lastIndexOf("@");
		int liod = email.lastIndexOf(".");
		int len = email.length();
		if (len < minEmail
			|| len > maxEmail
			|| (fioa != lioa)
			|| (len - liod < 3)
			|| (lioa > liod)
			|| (fioa < 1)
			|| // not x@ - make sure there's at least 1 char before @ symbol
		 (email.charAt(fioa + 1) == '.')
			|| // not xx@.xxx - dot following straight after first @
		 (email.charAt(fioa - 1) == '.')
			|| // not x.@ - dot preceeding first @
		 (email.charAt(0) == '.') // first character isn't '.'
		) {
			errs.rejectValue("email", "emailInvalid", "E-mail Address is invalid");
			return;
		}

		//checkEmailIsUnique(email, ice);
	} // validateEmail

	private void checkPostCode(String postcode, Errors errs) {
		if (postcode == null || postcode.equals("")) {
			errs.rejectValue("billingAddress.postcode", "postcode.missing", "Postcode is required for billing address");
			return;
		}

		if (!postcode.startsWith("SE10"))
			errs.rejectValue("billingAddress.postcode", "postcode.notse", "Postcode must be in Greenwich!");

	}

}

