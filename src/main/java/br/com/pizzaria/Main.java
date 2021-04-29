package br.com.pizzaria;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import br.com.pizzaria.view.ViewPizzaria;

public class Main 
{
    public static void main( String[] args )
    {
        try {
            UIManager.setLookAndFeel( new NimbusLookAndFeel() );
         }
         catch ( Throwable ex ) {
            
         }
         
         ViewPizzaria frm = new ViewPizzaria();
         frm.setVisible( true );
    }
}
