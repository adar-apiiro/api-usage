
package org.apache.sayhi;

import javax.jws.WebParam.Mode;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * 
 */

@WebService(targetNamespace = "http://apache.org/sayHi", name = "SayHi")
@XmlSeeAlso({ObjectFactory.class})

public interface SayHi {

    @ResponseWrapper(targetNamespace = "http://apache.org/sayHi", className = "org.apache.sayhi.SayHiResponse", localName = "sayHiResponse")
    @RequestWrapper(targetNamespace = "http://apache.org/sayHi", className = "org.apache.sayhi.SayHi_Type", localName = "sayHi")
    @WebResult(targetNamespace = "http://apache.org/sayHi", name = "return")
    @WebMethod
    public java.lang.String sayHi(
        @WebParam(targetNamespace = "http://apache.org/sayHi", name = "arg0")
        java.lang.String arg0
    );

    @ResponseWrapper(targetNamespace = "http://apache.org/sayHi", className = "org.apache.sayhi.SayHiArrayResponse", localName = "sayHiArrayResponse")
    @RequestWrapper(targetNamespace = "http://apache.org/sayHi", className = "org.apache.sayhi.SayHiArray", localName = "sayHiArray")
    @WebResult(targetNamespace = "", name = "return")
    @WebMethod
    public java.util.List<java.lang.String> sayHiArray(
        @WebParam(targetNamespace = "", name = "arg0")
        java.util.List<java.lang.String> arg0
    );
}
