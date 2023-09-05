
package cache;

import java.io.IOException;
import java14.java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.interface21.web.servlet.LastModified;
import com.interface21.web.servlet.ModelAndView;
import com.interface21.web.servlet.mvc.Controller;

/**
 * Simple controller showing how implementing the LastModified
 * method can automatically provide support for HTTP caching.
 * 
 * Whether or not any caching is achieved will
 * depend on your browser.
 * 
 * @see com.interface21.web.servlet.LastModified
 * 
 * @since Jan 6, 2003
 * @author Rod Johnson
 */
public class CacheController implements Controller, LastModified {
	
	//---------------------------------------------------------------------
	// Instance data
	//---------------------------------------------------------------------
	/**
	* Create a logging category that is available
	* to subclasses. 
	*/
	protected final Logger logger = Logger.getLogger(getClass().getName());
	
	/**
	 * Time the imaginary resource behind this controller was
	 * last modified
	 */
	private long lastmod = System.currentTimeMillis();
	
	/**
	 * @see AbstractController#handleRequestInternal(HttpServletRequest, HttpServletResponse)
	 */
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			
			 
		//logger.warning("request=" + request);
			  
		response.setHeader("Cache-Control", "maxAge=30, must-revalidate");
		
		logger.warning("*********** Generated");//: lastmod=" + new Date(getLastModified(request)));
		return new ModelAndView("debugView");
	}

	/**
	 * Allows the page to be 15 seconds old. After that
	 * pretends that the underlying resource has been modified.
	 * 
	 * @see LastModified#getLastModified(HttpServletRequest)
	 */
	public long getLastModified(HttpServletRequest request) {
		
		if (System.currentTimeMillis() - lastmod > 1000 * 15)
			lastmod = System.currentTimeMillis();
		
		logger.warning("getLastMod with return " + new java.util.Date(lastmod) );
		return lastmod;
	}

}
