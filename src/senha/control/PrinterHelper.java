/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senha.control;

import senha.model.PrinterSenha;
import senha.model.Senha;
import senha.model.Util;

/**
 *
 * @author gustavosmc
 */
public class PrinterHelper {
     public static  void  imprimirHelper(Senha senha) {
      
        Thread print;
         print = new Thread(new Runnable() {
             PrinterSenha printer;
            {
                this.printer = new PrinterSenha(senha.getTipoAtendimento(), Util.formatarSenha(senha.getNumeroSenha())
                        , senha.getDataSenha(), senha.getHoraSenha(), senha.getSigla(), senha.getSetor());
            }
            
             
             @Override
             public void run() {
                 printer.printSenha();
              
             }
         });
        print.start();
    }
}
