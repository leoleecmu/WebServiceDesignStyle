/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservicedesignstyles3projectclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author haonan
 */
public class WebServiceDesignStyles3ProjectClient {

    /**
     * @param args the command line arguments
     */
    
   
    public static void main(String[] args) throws Exception{
       //Clear the Spies List
//       doDelete("ALLCLEAR");
//       System.out.println("*******Begin main*********");
//       //Get empty List
//       System.out.println(doGetListAsXML()); 
//       System.out.println(doGetListAsText());
//       //add new spies
//       Spy spy1 = new Spy("mikem","spy", "Pittsburgh","sesame");
//       Spy spy2 = new Spy("joem","spy", "Philadelphia","obama");
//       Spy spy3 = new Spy("seanb","spy commander", "Adelaide","pirates");
//       Spy spy4 = new Spy("jamesb","007", "Boston","queen");
//
//       //Test doPut method
//       System.out.println(doPut(spy1)); // 201
//       System.out.println(doPut(spy2)); // 201
//       System.out.println(doPut(spy3)); // 201
//       System.out.println(doPut(spy4)); // 201
//
//       //Test doDelete
//       System.out.println(doDelete("joem")); // 200
//       spy1.setPassword("Doris");
//       //Test doPost(update)
//       System.out.println(doPost(spy1)); // 200
//
//       //Test Get spy as text and XML
//       System.out.println(doGetListAsXML()); // display xml
//       System.out.println(doGetListAsText()); // display text
//
//       //Test Get SpyList as text and XML
//       System.out.println(doGetSpyAsXML("mikem")); // display xml
//       System.out.println(doGetSpyAsText("joem")); // 404
         System.out.println(doGetSpyAsXML("teacher"));
       
    }   
    // Low level routine to make an HTTP POST request
    // Note, POST does not use the URL line for its message to the server
    public static int doPost(Spy spy) {
          
        int status = 0;      
        try {                   
		URL url = new URL("http://localhost:8080/WebServiceDesignStyles3ProjectServer/SpyListCollection/");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
                // set request method to POST and send name value pair
                conn.setRequestMethod("POST");
		conn.setDoOutput(true);
                // write to POST data area
                OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
                out.write(spy.toXML());
                out.close();
                
                // get HTTP response code sent by server
                status = conn.getResponseCode();          
                //close the connection
		conn.disconnect();
	    } 
            // handle exceptions
            catch (MalformedURLException e) {
		      e.printStackTrace();        
            } 
            catch (IOException e) {
		      e.printStackTrace();
	    }

            return status;
    }
    
     public static String doGetSpyAsText(String name) {
         // Make an HTTP GET passing the name on the URL line
        
         String response = "";
         HttpURLConnection conn;
         int status = 0;
         
         try {    
                // pass the name on the URL line
		URL url = new URL("http://localhost:8080/WebServiceDesignStyles3ProjectServer/SpyListCollection" + "//"+name);
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
                // tell the server what format we want back
		conn.setRequestProperty("Accept", "text/plain");	
                // wait for response
                status = conn.getResponseCode();              
                // If things went poorly, don't try to read any response, just return.
		if (status != 200) {
                    return String.valueOf(status);
                }
                String output = "";
                // things went well so let's read the response
                BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));
		while ((output = br.readLine()) != null) {
			response += output;
		}
                
		conn.disconnect();
                return response;
	    } 
                catch (MalformedURLException e) {
		   e.printStackTrace();
	    }   catch (IOException e) {
		   e.printStackTrace();
	    }
         return response;
    } 
     public static String doGetSpyAsXML(String name) {
         // Make an HTTP GET passing the name on the URL line
        
         String response = "";
         HttpURLConnection conn;
         int status = 0;
         
         try {    
                // pass the name on the URL line
		URL url = new URL("http://localhost:8080/TranslatorServer/Translator" + "//"+name);
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
                // tell the server what format we want back
		conn.setRequestProperty("Accept", "text/xml");	
                // wait for response
                status = conn.getResponseCode();              
                // If things went poorly, don't try to read any response, just return.
		if (status != 200) {
                    return String.valueOf(status);
                }
                String output = "";
                // things went well so let's read the response
                BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));
		while ((output = br.readLine()) != null) {
			response += output;
		}
               
		conn.disconnect();
                return response;
		
	    } 
                catch (MalformedURLException e) {
		   e.printStackTrace();
	    }   catch (IOException e) {
		   e.printStackTrace();
	    }
         return response;
    }
      public static String doGetListAsXML(){
         // Make an HTTP GET passing the name on the URL line
        
         String response = "";
         HttpURLConnection conn;
         int status = 0;
         
         try {    
                // pass the name on the URL line
		URL url = new URL("http://localhost:8080/WebServiceDesignStyles3ProjectServer/SpyListCollection/");
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
                // tell the server what format we want back
		conn.setRequestProperty("Accept", "text/xml");	
                // wait for response
                status = conn.getResponseCode();              
                // If things went poorly, don't try to read any response, just return.
		if (status != 200) {
                    return String.valueOf(status);
                }
                String output = "";
                // things went well so let's read the response
                BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));
		while ((output = br.readLine()) != null) {
			response += output;
		}
                String re="";
                if(!response.isEmpty()){
                    String[] spies=response.split(",");
                    for(String s:spies){
                        String[] spy=s.split("-");
                        Spy sp=new Spy(spy[0],spy[1],spy[2],spy[3]);
                        re=re+"\n"+sp.toXML2();
                    }
                }else{
                    re="<SpyList></SpyList>";
                }
                
		conn.disconnect();
                return re;
	    } 
                catch (MalformedURLException e) {
		   e.printStackTrace();
	    }   catch (IOException e) {
		   e.printStackTrace();
	    }
         return response;
    }
      /**
       * Get Text List
       * @return 
       */
      public static String doGetListAsText(){
         // Make an HTTP GET passing the name on the URL line
        
         String response = "";
         HttpURLConnection conn;
         int status = 0;
         
         try {    
                // pass the name on the URL line
		URL url = new URL("http://localhost:8080/WebServiceDesignStyles3ProjectServer/SpyListCollection/");
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
                // tell the server what format we want back
		conn.setRequestProperty("Accept", "text/plain");	
                // wait for response
                status = conn.getResponseCode();              
                // If things went poorly, don't try to read any response, just return.
		if (status != 200) {
                    return String.valueOf(status);
                }
                String output = "";
                // things went well so let's read the response
                BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));
		while ((output = br.readLine()) != null) {
			response += output;
		}
                
		conn.disconnect();
                return response;
	    } 
                catch (MalformedURLException e) {
		   e.printStackTrace();
	    }   catch (IOException e) {
		   e.printStackTrace();
	    }
         return response;
    }
    // Low level routine to make an HTTP PUT request
    // Note, PUT does not use the URL line for its message to the server
    public static int doPut(Spy spy) {       
        int status = 0;
        try {  
		URL url = new URL("http://localhost:8080/WebServiceDesignStyles3ProjectServer/SpyListCollection/");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("PUT");
		conn.setDoOutput(true);
                OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
                //String request with XML spy
                out.write(spy.toXML());
                out.close();
                //201 or 405
		status = conn.getResponseCode();               
                conn.disconnect();
	    } 
            catch (MalformedURLException e) {
		   e.printStackTrace();
	     } catch (IOException e) {
		   e.printStackTrace();
	     }
        return status;   
    }  
    
    // Send an HTTP DELETE to server along with name on the URL line
    // We need not read the response, we are only interested in the HTTP status
    // code.
    public static int doDelete(String name) {
        
        int status = 0;
        
         try {  
		URL url = new URL("http://localhost:8080/WebServiceDesignStyles3ProjectServer/SpyListCollection" + "//"+name);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("DELETE");
                status = conn.getResponseCode();
		conn.disconnect();  
	     } 
             catch (MalformedURLException e) {
		   e.printStackTrace();
	     } catch (IOException e) {
		   e.printStackTrace();
	     }
        return status;
    }

}
class Spy {
        private String name;
        private String title;
        private String location;
        private String password;

        public Spy(String name,String title,String location,String password){
            this.name=name;
            this.title=title;
            this.location = location;
            this.password = password;
        }

        public Spy(String name) {
            this.name=name;
            this.title="";
            this.location = "";
            this.password = "";
        }

        public Spy() {
            this.name="";
            this.title="";
            this.location = "";
            this.password = "";
        }
        
        public String getName(){
            return this.name;
        }
        public void setName(String namee){
            this.name = namee;
        }
        public String getTitle(){
            return this.title;
        }
        public void setTitle(String titlee){
            this.title = titlee;
        }
        public String getLocation(){
            return this.location;
        }
        public void setLocation(String locationn){
            this.location = locationn;
        }
        public String getPassword(){
            return this.password;
        }
        public void setPassword(String pw){
            this.password = pw;
        }
        //Put all spy information to a String    
        public String tostring(){
            String s="Name:"+name+"\nTitle:"+title
                     +"\nLocation:"+location+"\nPassword:"+password;
            return s;
        }
        public String toXML(){
            String result="<spy><name>"+name+"</name><spyTitle>"+title+"</spyTitle><location>"+
                    location+"</location><password>"+password+"</password></spy>";
            return result; 
        }
        public String toXML2(){
        String result="<spy>\n\t<name>"+
                name+"</name>\n\t<spyTitle>"+title+"</spyTitle>\n\t<location>"+
                location+"</location>\n\t<password>"+password+"</password>\n</spy>";
        return result; 
    }
 }
