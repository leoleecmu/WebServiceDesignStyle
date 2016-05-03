/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haonanli.cmu.p2;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author haonan
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {

    static SpyList sl=new SpyList();
    /**
     * Web service operation
     * @param xml
     * @return 
     */
    @WebMethod(operationName = "spyOperation")
    public String spyOperation(@WebParam(name = "xml") String xml) {
        SpyMessage sm=new SpyMessage(xml);
        String[] info=sm.Parser();
        
        String op=info[0];
        String response = null;
       switch (op){
           case "addSpy":
               response=sl.addSpy(info[1], info[2],info[3], info[4]);
               break;
           case "updateSpy":
               response=sl.updateSpy(info[1], info[2],info[3], info[4]);
               break;
           case "getSpyAsXML":
               response=sl.getSpyAsXML(info[1]);
               break;
           case "deleteSpy":
               response=sl.deleteSpy(info[1]);
               break;
           case "getList":
               response=sl.getList();
               break;
           case "getListAsXML":
               response=sl.getListAsXML();
               break;
           case "getSpy":
               response=sl.getSpy(info[1]);
               break;
           default:
               break;
       }

        return response;
    }
    
}
