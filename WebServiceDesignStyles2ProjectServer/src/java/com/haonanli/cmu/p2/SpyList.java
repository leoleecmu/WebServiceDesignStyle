/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haonanli.cmu.p2;
import java.util.HashMap;
/**
 *
 * @author haonan
 */
public class SpyList {

    HashMap<String,Spy> map = new HashMap();
    
    //constructor
    public SpyList(){}
    public SpyList(HashMap mapp){
        this.map=mapp;
    }
    //GET/SET
    public HashMap getMap(){
        return this.map;
    }
    public void setMap(HashMap mapp){
        this.map=mapp;
    }

    /**
     * ADD new Spy
     * @param name
     * @param title
     * @param location
     * @param password
     * @return 
     */
    public String addSpy(String name, String title,String location,String password){
        String report;
        if(map.containsKey(name)){
            report="This spy already exists.No update was made.";
        }else{
            Spy newspy=new Spy(name,title,location,password);
            map.put(name, newspy);
            report=newspy.tostring();
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

    public String updateSpy(String name,String title,String location,String password){

        String report;
        if(map.containsKey(name)){
            map.get(name).setLocation(location);
            map.get(name).setPW(password);
            map.get(name).setTitle(title);
            report=map.get(name).tostring();
        }else{
            report="No such a spy.No update was made";
        }
            
        return report;
    }
    /**GET
     * 
     * @param name
     * @return 
     */
    public String getSpy(String name) {
        String report;
        if(map.containsKey(name)){
            report=map.get(name).tostring();
        }else{
            report="No such a spy.";
        }
        return report;
    }
     /**GET spy as XML
     * 
     * @param name
     * @return 
     */
    public String getSpyAsXML(String name) {
        String report;
        if(map.containsKey(name)){
            report="<spy>+\n\t<name>"+map.get(name).getName()+"</name>\n\t<spyTitle>"+
                    map.get(name).getTitle()+"</spyTitle>\n\t<location>"+
                    map.get(name).getLocation()+"</location>\n\t<password>"+
                    map.get(name).getLocation()+"</password>\n</spy>";
        }else{
            report="No such a spy.";
        }
        return report;
    }
    
    /**DELETE
     * 
     * @param name
     * @return 
     */

    public String deleteSpy(String name){
        String report;
        if(map.containsKey(name)){
            map.remove(name);
            report="Spy "+name+" has been deleted.";
        }else{
            report="No such a spy.No update was made";
        }
        return report;
    }
    /**
     * Get spy list
     * @return 
     */
    public String getList(){
        String result="";
        if(!map.isEmpty()){
            for (Spy value : map.values()) {
            result=result+"\n"+value.tostring();
            }   
        } 
        return result;
    }
    
    /**
     * Get XML spy list with all data
     * @return 
     */
    public String getListAsXML(){
        String result="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\n"+"<SpyList>";
        if(!map.isEmpty()){
            for(Spy test:map.values()){
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
   
    public void initialize(){
       map.clear();
    }
}





