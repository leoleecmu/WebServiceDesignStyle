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
public class Spy {
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
        public String getPW(){
            return this.password;
        }
        public void setPW(String pw){
            this.password = pw;
        }
        //Put all spy information to a String    
        public String tostring(){
            String s="Name:"+name+"\nTitle:"+title
                     +"\nLocation:"+location+"\nPassword:"+password;
            return s;
        }
 }