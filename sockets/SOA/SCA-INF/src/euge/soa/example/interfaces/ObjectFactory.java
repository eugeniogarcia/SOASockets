
package euge.soa.example.interfaces;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the euge.soa.example.interfaces package. 
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

    private final static QName _Notifica_QNAME = new QName("http://interfaces.example.soa.euge/", "notifica");
    private final static QName _NotificaResponse_QNAME = new QName("http://interfaces.example.soa.euge/", "notificaResponse");
    private final static QName _CheckPersona_QNAME = new QName("http://interfaces.example.soa.euge/", "checkPersona");
    private final static QName _CheckPersonaResponse_QNAME = new QName("http://interfaces.example.soa.euge/", "checkPersonaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: euge.soa.example.interfaces
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Notifica }
     * 
     */
    public Notifica createNotifica() {
        return new Notifica();
    }

    /**
     * Create an instance of {@link NotificaResponse }
     * 
     */
    public NotificaResponse createNotificaResponse() {
        return new NotificaResponse();
    }

    /**
     * Create an instance of {@link CheckPersona }
     * 
     */
    public CheckPersona createCheckPersona() {
        return new CheckPersona();
    }

    /**
     * Create an instance of {@link CheckPersonaResponse }
     * 
     */
    public CheckPersonaResponse createCheckPersonaResponse() {
        return new CheckPersonaResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Notifica }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Notifica }{@code >}
     */
    @XmlElementDecl(namespace = "http://interfaces.example.soa.euge/", name = "notifica")
    public JAXBElement<Notifica> createNotifica(Notifica value) {
        return new JAXBElement<Notifica>(_Notifica_QNAME, Notifica.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotificaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NotificaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://interfaces.example.soa.euge/", name = "notificaResponse")
    public JAXBElement<NotificaResponse> createNotificaResponse(NotificaResponse value) {
        return new JAXBElement<NotificaResponse>(_NotificaResponse_QNAME, NotificaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckPersona }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CheckPersona }{@code >}
     */
    @XmlElementDecl(namespace = "http://interfaces.example.soa.euge/", name = "checkPersona")
    public JAXBElement<CheckPersona> createCheckPersona(CheckPersona value) {
        return new JAXBElement<CheckPersona>(_CheckPersona_QNAME, CheckPersona.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckPersonaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CheckPersonaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://interfaces.example.soa.euge/", name = "checkPersonaResponse")
    public JAXBElement<CheckPersonaResponse> createCheckPersonaResponse(CheckPersonaResponse value) {
        return new JAXBElement<CheckPersonaResponse>(_CheckPersonaResponse_QNAME, CheckPersonaResponse.class, null, value);
    }

}
