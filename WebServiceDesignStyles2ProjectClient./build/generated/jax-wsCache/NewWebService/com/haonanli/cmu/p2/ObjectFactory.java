
package com.haonanli.cmu.p2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.haonanli.cmu.p2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SpyOperation_QNAME = new QName("http://p2.cmu.haonanli.com/", "spyOperation");
    private final static QName _SpyOperationResponse_QNAME = new QName("http://p2.cmu.haonanli.com/", "spyOperationResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.haonanli.cmu.p2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SpyOperation }
     * 
     */
    public SpyOperation createSpyOperation() {
        return new SpyOperation();
    }

    /**
     * Create an instance of {@link SpyOperationResponse }
     * 
     */
    public SpyOperationResponse createSpyOperationResponse() {
        return new SpyOperationResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SpyOperation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p2.cmu.haonanli.com/", name = "spyOperation")
    public JAXBElement<SpyOperation> createSpyOperation(SpyOperation value) {
        return new JAXBElement<SpyOperation>(_SpyOperation_QNAME, SpyOperation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SpyOperationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://p2.cmu.haonanli.com/", name = "spyOperationResponse")
    public JAXBElement<SpyOperationResponse> createSpyOperationResponse(SpyOperationResponse value) {
        return new JAXBElement<SpyOperationResponse>(_SpyOperationResponse_QNAME, SpyOperationResponse.class, null, value);
    }

}
