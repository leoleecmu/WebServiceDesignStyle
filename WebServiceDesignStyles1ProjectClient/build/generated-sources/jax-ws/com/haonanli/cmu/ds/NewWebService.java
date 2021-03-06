
package com.haonanli.cmu.ds;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "NewWebService", targetNamespace = "http://ds.cmu.haonanli.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface NewWebService {


    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "initializeList", targetNamespace = "http://ds.cmu.haonanli.com/", className = "com.haonanli.cmu.ds.InitializeList")
    @ResponseWrapper(localName = "initializeListResponse", targetNamespace = "http://ds.cmu.haonanli.com/", className = "com.haonanli.cmu.ds.InitializeListResponse")
    @Action(input = "http://ds.cmu.haonanli.com/NewWebService/initializeListRequest", output = "http://ds.cmu.haonanli.com/NewWebService/initializeListResponse")
    public void initializeList();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getList", targetNamespace = "http://ds.cmu.haonanli.com/", className = "com.haonanli.cmu.ds.GetList")
    @ResponseWrapper(localName = "getListResponse", targetNamespace = "http://ds.cmu.haonanli.com/", className = "com.haonanli.cmu.ds.GetListResponse")
    @Action(input = "http://ds.cmu.haonanli.com/NewWebService/getListRequest", output = "http://ds.cmu.haonanli.com/NewWebService/getListResponse")
    public String getList();

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getSpy", targetNamespace = "http://ds.cmu.haonanli.com/", className = "com.haonanli.cmu.ds.GetSpy")
    @ResponseWrapper(localName = "getSpyResponse", targetNamespace = "http://ds.cmu.haonanli.com/", className = "com.haonanli.cmu.ds.GetSpyResponse")
    @Action(input = "http://ds.cmu.haonanli.com/NewWebService/getSpyRequest", output = "http://ds.cmu.haonanli.com/NewWebService/getSpyResponse")
    public String getSpy(
        @WebParam(name = "name", targetNamespace = "")
        String name);

    /**
     * 
     * @param password
     * @param name
     * @param location
     * @param title
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addSpy", targetNamespace = "http://ds.cmu.haonanli.com/", className = "com.haonanli.cmu.ds.AddSpy")
    @ResponseWrapper(localName = "addSpyResponse", targetNamespace = "http://ds.cmu.haonanli.com/", className = "com.haonanli.cmu.ds.AddSpyResponse")
    @Action(input = "http://ds.cmu.haonanli.com/NewWebService/addSpyRequest", output = "http://ds.cmu.haonanli.com/NewWebService/addSpyResponse")
    public String addSpy(
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "title", targetNamespace = "")
        String title,
        @WebParam(name = "location", targetNamespace = "")
        String location,
        @WebParam(name = "password", targetNamespace = "")
        String password);

    /**
     * 
     * @param password
     * @param name
     * @param location
     * @param title
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateSpy", targetNamespace = "http://ds.cmu.haonanli.com/", className = "com.haonanli.cmu.ds.UpdateSpy")
    @ResponseWrapper(localName = "updateSpyResponse", targetNamespace = "http://ds.cmu.haonanli.com/", className = "com.haonanli.cmu.ds.UpdateSpyResponse")
    @Action(input = "http://ds.cmu.haonanli.com/NewWebService/updateSpyRequest", output = "http://ds.cmu.haonanli.com/NewWebService/updateSpyResponse")
    public String updateSpy(
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "title", targetNamespace = "")
        String title,
        @WebParam(name = "location", targetNamespace = "")
        String location,
        @WebParam(name = "password", targetNamespace = "")
        String password);

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteSpy", targetNamespace = "http://ds.cmu.haonanli.com/", className = "com.haonanli.cmu.ds.DeleteSpy")
    @ResponseWrapper(localName = "deleteSpyResponse", targetNamespace = "http://ds.cmu.haonanli.com/", className = "com.haonanli.cmu.ds.DeleteSpyResponse")
    @Action(input = "http://ds.cmu.haonanli.com/NewWebService/deleteSpyRequest", output = "http://ds.cmu.haonanli.com/NewWebService/deleteSpyResponse")
    public String deleteSpy(
        @WebParam(name = "name", targetNamespace = "")
        String name);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getListAsXML", targetNamespace = "http://ds.cmu.haonanli.com/", className = "com.haonanli.cmu.ds.GetListAsXML")
    @ResponseWrapper(localName = "getListAsXMLResponse", targetNamespace = "http://ds.cmu.haonanli.com/", className = "com.haonanli.cmu.ds.GetListAsXMLResponse")
    @Action(input = "http://ds.cmu.haonanli.com/NewWebService/getListAsXMLRequest", output = "http://ds.cmu.haonanli.com/NewWebService/getListAsXMLResponse")
    public String getListAsXML();

}
