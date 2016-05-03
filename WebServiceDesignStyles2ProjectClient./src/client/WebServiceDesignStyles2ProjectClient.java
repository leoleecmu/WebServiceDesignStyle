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
public class WebServiceDesignStyles2ProjectClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String result = "";
        System.out.println("Adding spy jamesb");
        // create a spy
        Spy bond = new Spy("jamesb", "spy", "London","james");
        // create a message
        SpyMessage sb = new SpyMessage(bond,"addSpy");
        // make a call on the web service
        result = spyOperation(sb.toXML());
        System.out.println(result);

        //Add myself
        System.out.println("Adding author haonanli");
        Spy leo = new Spy("haonanli", "master", "Pittsburgh","lynne");
        SpyMessage s0 = new SpyMessage(leo,"addSpy");
        result = spyOperation(s0.toXML());
        System.out.println(result);
        
        System.out.println("Adding spy seanb");
        Spy beggs = new Spy("seanb", "spy master", "Pittsburgh","sean");
        SpyMessage ss = new SpyMessage(beggs,"addSpy");
        result = spyOperation(ss.toXML());
        System.out.println(result);

        System.out.println("Adding spy joem");
        Spy mertz = new Spy("joem", "spy", "Los Angeles","joe");
        SpyMessage sj = new SpyMessage(mertz,"addSpy");
        result = spyOperation(sj.toXML());
        System.out.println(result);

        System.out.println("Adding spy mikem");
        Spy mccarthy = new Spy("mikem", "spy", "Ocean City Maryland","sesame");
        SpyMessage sm = new SpyMessage(mccarthy,"addSpy");
        result = spyOperation(sm.toXML());
        System.out.println(result);
        System.out.println("Displaying spy list");
        SpyMessage list = new SpyMessage(new Spy(),"getList");
        result = spyOperation(list.toXML());
        System.out.println(result);

        System.out.println("Displaying spy list as XML");
        SpyMessage listXML = new SpyMessage(new Spy(),"getListAsXML");
        result = spyOperation(listXML.toXML());
        System.out.println(result);

        System.out.println("Updating spy jamesb");
        Spy newJames = new Spy("jamesb","Cool Spy","New Jersey","sesame");
        SpyMessage um = new SpyMessage(newJames,"updateSpy");
        result = spyOperation(um.toXML());
        System.out.println(result);

        System.out.println("Displaying spy list");
        list = new SpyMessage(new Spy(),"getList");
        result = spyOperation(list.toXML());
        System.out.println(result);

        System.out.println("Deleting spy jamesb");
        Spy james = new Spy("jamesb");
        SpyMessage dm = new SpyMessage(james,"deleteSpy");
        result = spyOperation(dm.toXML());
        System.out.println(result);

        System.out.println("Displaying spy list");

        list = new SpyMessage(new Spy(),"getList");
        result = spyOperation(list.toXML());
        System.out.println(result);

        System.out.println("Displaying spy list as XML");
        listXML = new SpyMessage(new Spy(),"getListAsXML");
        result = spyOperation(listXML.toXML());
        System.out.println(result);


        System.out.println("Deleting spy Amos");
        Spy amos = new Spy("amos");
        SpyMessage am = new SpyMessage(amos,"deleteSpy");
        result = spyOperation(am.toXML());
        System.out.println(result);
    }

    private static String spyOperation(java.lang.String xml) {
        com.haonanli.cmu.p2.NewWebService_Service service = new com.haonanli.cmu.p2.NewWebService_Service();
        com.haonanli.cmu.p2.NewWebService port = service.getNewWebServicePort();
        return port.spyOperation(xml);
    }
    
}
