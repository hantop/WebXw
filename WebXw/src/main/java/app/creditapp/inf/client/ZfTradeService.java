package app.creditapp.inf.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


import app.creditapp.inf.client.zf.Exception_Exception;
import app.creditapp.inf.client.zf.ObjectFactory;
/**
 * This class was generated by Apache CXF 2.4.9
 * 2016-09-09T14:44:57.872+08:00
 * Generated source version: 2.4.9
 * 
 */
@WebService(targetNamespace = "http://ws.inf.creditapp.app/", name = "TradeService")
@XmlSeeAlso({ObjectFactory.class})
public interface ZfTradeService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "doAction", targetNamespace = "http://ws.inf.creditapp.app/", className = "app.creditapp.inf.client.zf.DoAction")
    @WebMethod
    @ResponseWrapper(localName = "doActionResponse", targetNamespace = "http://ws.inf.creditapp.app/", className = "app.creditapp.inf.client.zf.DoActionResponse")
    public java.lang.String doAction(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    ) throws Exception_Exception;
    
}