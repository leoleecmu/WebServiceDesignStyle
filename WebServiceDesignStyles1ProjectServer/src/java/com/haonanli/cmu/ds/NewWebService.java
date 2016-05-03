/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haonanli.cmu.ds;

import java.util.ArrayList;
import java.util.HashMap;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author haonan
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {
    //List storing spies' information
    SpyList spyList=new SpyList(new HashMap(),new ArrayList()); 
    int i=0;
    ArrayList<Spy> SpyList= spyList.getList();
    /**
     * Class Spy
    */
   
    /**
     * 
     * @param name
     * @param title
     * @param location
     * @param password
     * @return 
     */
    @WebMethod(operationName = "addSpy")
    public String addSpy(@WebParam(name = "name") String name,
                            @WebParam(name = "title") String title,
                            @WebParam(name = "location") String location,
                            @WebParam(name = "password") String password){
        String report;
        Spy t=new Spy();
        //If the list is not empty,check that whether the spy exist or not
        if(!SpyList.isEmpty()){
            for(Spy test:SpyList){
                if(test.getName().equals(name) && test.getLocation().equals(location) &&
                        test.getPW().equals(password) && test.getTitle().equals(title)){
                    t=test;                 
                }
            }
        }
        //if this spy not exist
        if(t.getName() == null){
            Spy newspy=new Spy(name,title,location,password);
            //give the unique id to each spy
            spyList.getMap().put(newspy.getName(),i);
            i++;
            SpyList.add(newspy);
            report=newspy.tostring();          
        }else{
            report="This spy already exists.No update was made.";
        }
        return report;
    }
   /**UODATE
    * 
    * @param name
    * @param title
    * @param location
    * @param password
    * @return 
    */
    @WebMethod(operationName = "updateSpy")
    public String updateSpy(@WebParam(name = "name") String name,
                            @WebParam(name = "title") String title,
                            @WebParam(name = "location") String location,
                            @WebParam(name = "password") String password){

        String report="No update is made.";
        for (Spy test : SpyList) {
            if(test.getName().equals(name)){
                test.setLocation(location);
                test.setPW(password);
                test.setTitle(title);
                report=test.tostring();
                break;
            }
        }     
        return report;
    }
    /**GET
     * 
     * @param name
     * @return 
     */
    @WebMethod(operationName = "getSpy")
    public String getSpy(@WebParam(name = "name") String name) {
        String report = "No such spy";
        for(Spy test : SpyList){
            if (test.getName().equals(name)){
                report=test.tostring();
            }
        }
        return report;
    }
    
    /**DELETE
     * s
     * @param name
     * @return 
     */
    @WebMethod(operationName = "deleteSpy")
    public String deleteSpy(@WebParam(name = "name") String name){
        String report="No such spy";
        for(Spy test:SpyList){
            if (test.getName().equals(name)){
                SpyList.remove(test);
                spyList.getMap().remove(name);
                report="Spy "+name+" was deleted from the list.";
            }
        }
        return report;
    }
    /**
     * Get spy list
     * @return 
     */
    @WebMethod(operationName = "getList")
    public String getList(){
        String result="";
        if(!SpyList.isEmpty()){
            for(Spy test:SpyList){
                result=result+test.tostring()+"\n";
            }
        }
        return result;
    }
    
    /**
     * Get XML spy list with all data
     * @return 
     */
    @WebMethod(operationName = "getListAsXML")
    public String getListAsXML(){
        String result="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\n"+"<SpyList>";
        if(!SpyList.isEmpty()){
            for(Spy test:SpyList){
                result=result+"\n<Spy>"+
                        "\n\t<name>"+test.getName()+"</name>"+
                        "\n\t<title>"+test.getTitle()+"</title>"+
                        "\n\t<name>"+test.getName()+"</name>"+
                        "\n\t<password>"+test.getPW()+"</password>"+
                        "</Spy>";
            }
        }
        return result+"</SpyList>";
    }
    @WebMethod(operationName = "initializeList")
    public void initialize(){
        SpyList=new ArrayList();
    }
}
