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
public class SpyMessage {
    Spy spy;
    String str;
    public SpyMessage(Spy spyy,String strr){
        this.spy=spyy;
        this.str=strr;
    }
    public String toXML(){
        String result="<spyMessage>\n\t<operation>"+str+"</operation>\n\t<spy>\n\t\t<name>"+
                spy.getName()+"</name>\n\t\t<spyTitle>"+spy.getTitle()+"</spyTitle>\n\t\t<location>"+
                spy.getLocation()+"</location>\n\t\t<password>"+spy.getPW()+"</password>\n\t</spy>\n</spyMessage>";
        return result; 
    }
}
