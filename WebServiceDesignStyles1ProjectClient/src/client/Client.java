/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author haonan
 */
public class Client {

    public static void main(String[] args){
        //INITIALIZE THE LIST
        initializeList();
        System.out.println(getList());
        System.out.println(getListAsXML());
        //my name
        addSpy("haonanli","spymaster","Pittsburgh","KFC");
        //my other colleges
        addSpy("mikem","spy","Pittsburgh","sesame");
        addSpy("joem","spy","North Hills","xyz");
        addSpy("seanb","spy commander","South Hills","abcdefg");
        addSpy("jamesb","spy","Adelaide","sydney");
        addSpy("adekunle","spy","Pittsburgh","secret");
        System.out.println(getList());
        System.out.println(getListAsXML());
        updateSpy("mikem", "super spy", "Pittsburgh","sesame");
        System.out.println(getListAsXML());
        String result = getSpy("jamesb");
        System.out.println(result);
        deleteSpy("jamesb");
        result = getSpy("jamesb");
        System.out.println(result);
        
        /**
         * Test edge cases
         */
        
        System.out.println("*******************TEST*******************");
        //add an existing spy
        System.out.println(addSpy("haonanli","spymaster","Pittsburgh","KFC"));
        //update a spy not exists
        System.out.println(updateSpy("haonanli2", "super spy", "Pittsburgh","sesame"));
        //get a spy not exists
        System.out.println(getSpy("haonanli2"));
        //delete a spy not exists
        System.out.println(deleteSpy("haonanli2"));
        //get empty list and xml list.This has been tested at the beginning
    }
    
    private static String addSpy(java.lang.String name, java.lang.String title, java.lang.String location, java.lang.String password) {
        com.haonanli.cmu.ds.NewWebService_Service service = new com.haonanli.cmu.ds.NewWebService_Service();
        com.haonanli.cmu.ds.NewWebService port = service.getNewWebServicePort();
        return port.addSpy(name, title, location, password);
    }

    private static String deleteSpy(java.lang.String name) {
        com.haonanli.cmu.ds.NewWebService_Service service = new com.haonanli.cmu.ds.NewWebService_Service();
        com.haonanli.cmu.ds.NewWebService port = service.getNewWebServicePort();
        return port.deleteSpy(name);
    }

    private static String getSpy(java.lang.String name) {
        com.haonanli.cmu.ds.NewWebService_Service service = new com.haonanli.cmu.ds.NewWebService_Service();
        com.haonanli.cmu.ds.NewWebService port = service.getNewWebServicePort();
        return port.getSpy(name);
    }

    private static String updateSpy(java.lang.String name, java.lang.String title, java.lang.String location, java.lang.String password) {
        com.haonanli.cmu.ds.NewWebService_Service service = new com.haonanli.cmu.ds.NewWebService_Service();
        com.haonanli.cmu.ds.NewWebService port = service.getNewWebServicePort();
        return port.updateSpy(name, title, location, password);
    }

    private static String getList() {
        com.haonanli.cmu.ds.NewWebService_Service service = new com.haonanli.cmu.ds.NewWebService_Service();
        com.haonanli.cmu.ds.NewWebService port = service.getNewWebServicePort();
        return port.getList();
    }

    private static String getListAsXML() {
        com.haonanli.cmu.ds.NewWebService_Service service = new com.haonanli.cmu.ds.NewWebService_Service();
        com.haonanli.cmu.ds.NewWebService port = service.getNewWebServicePort();
        return port.getListAsXML();
    }

    private static void initializeList() {
        com.haonanli.cmu.ds.NewWebService_Service service = new com.haonanli.cmu.ds.NewWebService_Service();
        com.haonanli.cmu.ds.NewWebService port = service.getNewWebServicePort();
        port.initializeList();
    }
    
}
