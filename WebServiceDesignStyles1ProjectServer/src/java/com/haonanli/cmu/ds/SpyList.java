/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haonanli.cmu.ds;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author haonan
 */
public class SpyList {
    //store spies
    ArrayList list = new ArrayList();
    //store spies and their unique ids
    HashMap<String,Integer> map = new HashMap();
    
    //constructor
    public SpyList(){}
    public SpyList(HashMap mapp,ArrayList listt){
        this.map=mapp;
        this.list=listt;
    }
    //GET/SET
    public HashMap getMap(){
        return this.map;
    }
    public void setMap(HashMap mapp){
        this.map=mapp;
    }
     public ArrayList getList(){
        return this.list;
    }
    public void setList(ArrayList listt){
        this.list=listt;
    }
}



