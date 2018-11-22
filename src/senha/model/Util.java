/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senha.model;

import java.text.DecimalFormat;

/**
 *
 * @author welti_000
 */
public final class Util {
    private Util(){
        
    }
    
    public static String formatarSenha(double senha){
        DecimalFormat df = new DecimalFormat("000");
        return df.format(senha);
    }
    
    public static String formatarGuiche(double senha){
        DecimalFormat df = new DecimalFormat("00");
        return df.format(senha);
    }
}
