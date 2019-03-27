package javax.servlet;

import java.io.IOException;

/**
 * 
 * @author feivirus
 *
 */
public interface Servlet {
    
    public void init(ServletConfig config);
    
    public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException;
}
