
package app.creditapp.inf.client.zf;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.4.9
 * 2016-09-09T14:44:57.792+08:00
 * Generated source version: 2.4.9
 */

@WebFault(name = "Exception", targetNamespace = "http://service.webservice.cheetah.com/")
public class Exception_Exception extends java.lang.Exception {
    
    private app.creditapp.inf.client.zf.Exception exception;

    public Exception_Exception() {
        super();
    }
    
    public Exception_Exception(String message) {
        super(message);
    }
    
    public Exception_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public Exception_Exception(String message, app.creditapp.inf.client.zf.Exception exception) {
        super(message);
        this.exception = exception;
    }

    public Exception_Exception(String message, app.creditapp.inf.client.zf.Exception exception, Throwable cause) {
        super(message, cause);
        this.exception = exception;
    }

    public app.creditapp.inf.client.zf.Exception getFaultInfo() {
        return this.exception;
    }
}
