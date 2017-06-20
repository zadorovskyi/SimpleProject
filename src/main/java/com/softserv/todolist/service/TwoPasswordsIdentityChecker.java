package com.softserv.todolist.service;


public class TwoPasswordsIdentityChecker {
    public static boolean passChecker(String password, String repeatedPassword){
        if(password.equals(repeatedPassword)){
            return true;
        }
        return false;
    }
}