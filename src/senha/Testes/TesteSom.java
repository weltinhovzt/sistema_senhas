/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senha.Testes;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import senha.control.MediaHelper;

/**
 *
 * @author gustavosmc
 */
public class TesteSom {
    public static void main(String...args){
        System.out.println(TesteSom.class.getResource("/senha/audio/alerta.wav").toString());
        MediaHelper.initSom(TesteSom.class.getResource("/senha/audio/alerta.wav").toString());
    }
}
