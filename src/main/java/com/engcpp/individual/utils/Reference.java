/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engcpp.individual.utils;

/**
 *
 * @author engcpp
 */
public class Reference {
    private String name;
    
    private boolean jointAccount;
    private boolean guarantor;

    public Reference(String name){
        this.name = name;
    }    
    
    public String getName() {
        return name;
    }

    public Reference withName(String name) {
        this.name = name;
        return this;
    }

    public boolean isJointAccount() {
        return jointAccount;
    }

    public Reference withJointAccount(boolean jointAccount) {
        this.jointAccount = jointAccount;
        return this;
    }

    public boolean isGuarantor() {
        return guarantor;
    }

    public Reference withGuarantor(boolean guarantor) {
        this.guarantor = guarantor;
        return this;
    }        
}
