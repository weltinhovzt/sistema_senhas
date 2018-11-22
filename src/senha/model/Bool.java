/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senha.model;

/**
 *
 * @author gustavosmc
 */
public class Bool {
    private boolean bool;

    public Bool(boolean bool){
        this.bool = bool;
    }
    /**
     * @return the bool
     */
    public boolean getBool() {
        return bool;
    }
    
    public void setBool(boolean bool){
        this.bool = bool;
    }
    
    public void notBool(){
        this.bool = !bool;
    }
}
