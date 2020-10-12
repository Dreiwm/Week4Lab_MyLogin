/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Chris
 */
public class User {
    private String name;
    private String password;
    
    public User(){
        this.name = "";
        this.password = null;
    }
    
    public User(String name){
        this.name = name;
        this.password = null;
    }
    
    public String getUserName(){
        return this.name;
    }
}
