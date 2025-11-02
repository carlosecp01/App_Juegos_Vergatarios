
package juegosvergatarios;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class codigoEnviado extends JPanel {
    
    private JFrame framePrincipall;
    
    Color fondo1 = new Color(41,43,107);
    Color fondo = new Color(17,19,56);
    Color botonIngresar = new Color(255,255,255,255);
    Color textField = new Color(61,66,84,255);
    
    Font fondoTitulo = new Font("Montserrat",Font.BOLD,30);
    
    Font texto = new Font("SansSerif",Font.BOLD,15);
    
    public codigoEnviado(JFrame framee){
        
        this.framePrincipall = framee;
    
    this.setSize(1024, 700);
    this.setBackground(Color.blue);
    this.setLayout(null);
          
        JLabel titulo = new JLabel("JUEGOS");
        titulo.setBounds(450, 100, 400, 50);
        titulo.setForeground(Color.white);
        titulo.setFont(fondoTitulo);

        JLabel titulo2 = new JLabel("JUEGOS");
        titulo2.setBounds(450+3, 100+3, 400, 50);
        titulo2.setForeground(new Color(255,255,255,100));
        titulo2.setFont(fondoTitulo);

        JLabel titulo3 = new JLabel("VERGATARIOS");
        titulo3.setBounds(400, 110, 400, 100);
        titulo3.setForeground(Color.white);
        titulo3.setFont(fondoTitulo);

        JLabel titulo4 = new JLabel("VERGATARIOS");
        titulo4.setBounds(400+3, 110+3, 400, 100);
        titulo4.setForeground(new Color(255,255,255,100));
        titulo4.setFont(fondoTitulo);
    
        JLabel correo = new JLabel("Ingresa el código");
        correo.setBounds(450, 240, 150, 15);
        correo.setForeground(Color.WHITE);
        correo.setFont(texto);
        correo.setOpaque(false);
       
        JLabel errorCampo = new JLabel("");
        errorCampo.setBounds(385, 305, 300, 20);
        errorCampo.setForeground(Color.RED);
        errorCampo.setFont(new Font("SansSerif", Font.PLAIN, 12));
                     
    JTextField campoNombre = new JTextField("");
       campoNombre.setBounds(380, 260, 300-25, 40);
       campoNombre.setBorder(null);
       campoNombre.setFont(texto);
       campoNombre.setForeground(Color.WHITE);
       campoNombre.setOpaque(false);   
                   
    JButton cambiarContraseña = new JButton("Cambiar Contraseña");
       cambiarContraseña.setBounds(382, 360 + 60 , 265, 40);
       cambiarContraseña.setBackground(botonIngresar);
       cambiarContraseña.setBorder(null);
       cambiarContraseña.setOpaque(false);
       cambiarContraseña.setFocusPainted(false);   
       
    JButton regresar = new JButton("Regresar");
       regresar.setBounds(382, 360 , 265, 40);
       regresar.setBackground(botonIngresar);
       regresar.setBorder(null);
       regresar.setOpaque(false);
       regresar.setFocusPainted(false);
       
       regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               

                // 1. Eliminar el panel actual (Login) del JFrame
                framePrincipall.getContentPane().removeAll();
                
                // 2. Crear una instancia del nuevo panel (Menu)
                restaurarContraseña login = new restaurarContraseña(framePrincipall); // ¡Asume que tienes una clase Menu!
                
                // 3. Añadir el nuevo panel al JFrame
                framePrincipall.add(login);
                
                // 4. Repintar y revalidar el JFrame para mostrar los cambios
                framePrincipall.revalidate();
                framePrincipall.repaint();
                
                // Nota: No es necesario cerrar el frame, solo reemplazamos el contenido.
            }
        });
       
       cambiarContraseña.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String nombreIngresado = campoNombre.getText().trim();
        
        // Limpiar mensaje previo
        errorCampo.setText("");

        if (nombreIngresado.isEmpty()) {
            errorCampo.setText("Por favor, completa este campo.");
            return;
        }

        // Si pasa la validación: mostrar etiqueta verde de éxito (sin JOptionPane)
        errorCampo.setForeground(new Color(0, 255, 100)); // verde
        errorCampo.setText("Cambio realizado con éxito.");

        // Cambiar al login después de unos segundos (opcional)
        javax.swing.Timer timer = new javax.swing.Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                framePrincipall.getContentPane().removeAll();
                Login login = new Login(framePrincipall);
                framePrincipall.add(login);
                framePrincipall.revalidate();
                framePrincipall.repaint();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
});
       
       this.add(correo);
       this.add(campoNombre);
       this.add(errorCampo);
       this.add(cambiarContraseña);
       this.add(regresar);
       this.add(titulo);
       this.add(titulo2);
       this.add(titulo3);
       this.add(titulo4);
       
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        
        final int RADIUS = 20; 
        final int RADIUSB = 40;
        final int SHADOW_OFFSET = 5; 
        
        super.paintComponent(g); 
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
          
        
        Rectangle cuadrado = new Rectangle(0, 0, 1024, 700);
        
        g2.fillRect(0, 0, 1024, 700);        
        GradientPaint gp = new GradientPaint(0, 0, new Color(14,19,32), 0, 0 + 700, new Color(0,40,66));
        g2.setPaint(gp);
        g2.fill(cuadrado);
        
        //crear panel contenedor y sombra de las etiquetas y textfield
        g2.setColor(new Color(0, 0, 0, 100)); 
        g2.fillRoundRect(310 + SHADOW_OFFSET, 190 + SHADOW_OFFSET, 400, 300, RADIUS, RADIUS);
           
        g.setColor(fondo); 
        g2.fillRoundRect(310, 190, 400, 300, RADIUS, RADIUS);
        
        // crear campos de text field
        
        g.setColor(new Color(61,66,84,100));
        g2.fillRoundRect(365 + SHADOW_OFFSET, 260 + SHADOW_OFFSET, 300, 40, RADIUS, RADIUS);
        g.setColor(textField);
        g2.fillRoundRect(365, 260, 300, 40,RADIUS,RADIUS);
        
        
        // crear botones
        g.setColor(new Color(255,255,255,100));
        g2.fillRoundRect(382 + SHADOW_OFFSET, 360 + SHADOW_OFFSET, 265, 40, RADIUSB, RADIUSB);
        g.setColor(Color.WHITE);
        g2.fillRoundRect(382, 360 , 265, 40,RADIUSB,RADIUSB);
        
                g.setColor(new Color(255,255,255,100));
        g2.fillRoundRect(382 + SHADOW_OFFSET, 360+60 + SHADOW_OFFSET, 265, 40, RADIUSB, RADIUSB);
        g.setColor(Color.WHITE);
        g2.fillRoundRect(382, 360+60 , 265, 40,RADIUSB,RADIUSB);
    }
    
    
}