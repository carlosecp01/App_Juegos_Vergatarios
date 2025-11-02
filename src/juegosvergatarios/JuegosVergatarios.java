
package juegosvergatarios;

import javax.swing.JFrame;

public class JuegosVergatarios extends JFrame {
    
    
    public static void main(String[] args) {
       
        JFrame frame = new JFrame("Juegos Vergatarios");
        frame.setSize(1024, 700);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        
        Login login = new Login(frame);
        
        
        
        
        frame.add(login);
       
        frame.setVisible(true);
    }
    
}
