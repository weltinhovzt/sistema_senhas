/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senha.model;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSizeName;

/**
 *
 * @author gustavosmc
 */
public class PrinterSenha {
        private FrameModelo frame;
        private final PrinterJob printerJob;
        private final String senha;
        private final String data;
        private final String hora;
        private final String tipoAtendimento;
        public PrinterSenha(String tipoAtendimento, String senha,  String data, String hora, String prefixo, String setor){
            this.hora = hora;
            this.senha = prefixo + senha;
            this.data = data;
            this.tipoAtendimento = setor +" "+ tipoAtendimento;
            printerJob = PrinterJob.getPrinterJob();
            
        }
        
        public void printSenha(){
            frame = new FrameModelo(tipoAtendimento, senha, data, hora);
             printerJob.setPrintable(frame);
              PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
              pras.add(MediaSizeName.NA_8X10);
              
             
            try {
                printerJob.print(pras);
                System.out.println("Impresso com sucesso");
                
            } catch (PrinterException ex) {
                System.out.println("Não foi possivel imprimir");
                Logger.getLogger(PrinterSenha.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    
}
