package jpl.simle.domain;

import java.lang.Boolean;
import java.lang.String;
import jpl.simle.domain.SIMLEGroup;

privileged aspect SIMLEUser_Roo_JavaBean {
    
    public String SIMLEUser.getUsername() {    
        return this.username;        
    }    
    
    public void SIMLEUser.setUsername(String username) {    
        this.username = username;        
    }    
    
    public String SIMLEUser.getPassword() {    
        return this.password;        
    }    
    
    public void SIMLEUser.setPassword(String password) {    
        this.password = password;        
    }    
    
    public Boolean SIMLEUser.getEnabled() {    
        return this.enabled;        
    }    
    
    public void SIMLEUser.setEnabled(Boolean enabled) {    
        this.enabled = enabled;        
    }    
    
    public SIMLEGroup SIMLEUser.getGroup() {    
        return this.group;        
    }    
    
    public void SIMLEUser.setGroup(SIMLEGroup group) {    
        this.group = group;        
    }    
    
}
