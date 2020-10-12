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
public class AccountService {
    private String betty;
    private String adam;
    private String password;
    
    public AccountService(){
        this.betty = "betty";
        this.adam = "adam";
        this.password = "password";
    }
    
    public User login(String username, String password){
       
        if(username.matches(this.adam) || username.matches(this.betty)){
            if(password.matches(this.password))
                return new User(username);
        }
        
        return null;
    }
}
