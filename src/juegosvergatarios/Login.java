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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class Login extends JPanel {
    
    private JFrame framePrincipal;
    
    Color fondo1 = new Color(41,43,107);
    Color fondo = new Color(17,19,56);
    Color botonIngresar = new Color(255,255,255,255);
    Color textField = new Color(61,66,84,255);
    Font fondoTitulo = new Font("Montserrat",Font.BOLD,30);
    Font texto = new Font("SansSerif",Font.BOLD,12);
       
   public Login(JFrame frame){
         
       this.framePrincipal = frame;
       this.setSize(1024, 1024);
       this.setBackground(fondo1);
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
       
       JLabel usuario = new JLabel("USUARIO");
       usuario.setBounds(380, 200, 80, 15);
       usuario.setForeground(Color.WHITE);
       usuario.setFont(texto);
       usuario.setOpaque(false);
       
       JLabel contraseña = new JLabel("CONTRASEÑA");
       contraseña.setBounds(380, 285, 80, 15);
       contraseña.setForeground(Color.WHITE);
       contraseña.setFont(texto);
       contraseña.setOpaque(false);
       
       JTextField campoUsuario = new JTextField("");
       campoUsuario.setBounds(375, 220, 285, 40);
       campoUsuario.setBorder(null);
       campoUsuario.setFont(texto);
       campoUsuario.setForeground(Color.WHITE);
       campoUsuario.setOpaque(false);
            
       JTextField campoContraseña = new JTextField("");
       campoContraseña.setBounds(375, 305, 285, 40);
       campoContraseña.setBorder(null);
       campoContraseña.setFont(texto);
       campoContraseña.setForeground(Color.WHITE);
       campoContraseña.setOpaque(false);
       
       JLabel lblErrorUsuario = new JLabel(" ");
       lblErrorUsuario.setBounds(375, 265, 300, 15); // justo debajo del campoUsuario
       lblErrorUsuario.setForeground(new Color(255, 85, 85)); // rojo suave
       lblErrorUsuario.setFont(texto);

        JLabel lblErrorContraseña = new JLabel(" ");
        lblErrorContraseña.setBounds(375, 350, 300, 15); // justo debajo del campoContraseña
        lblErrorContraseña.setForeground(new Color(255, 85, 85)); // rojo suave
        lblErrorContraseña.setFont(texto);
        

       
       JButton ingresar = new JButton("ENTRAR");
       ingresar.setBounds(380, 380 , 265, 40);
       ingresar.setBackground(botonIngresar);
       ingresar.setBorder(null);
       ingresar.setOpaque(false);
       ingresar.setFocusPainted(false);
       
       JButton olvContraseña = new JButton("RESTAURAR CONTRASEÑA");
       olvContraseña.setBounds(350, 460 , 160  , 20);
       olvContraseña.setBackground(botonIngresar);
       olvContraseña.setForeground(Color.white);
       olvContraseña.setFont(texto);
       olvContraseña.setBorder(null);
       olvContraseña.setOpaque(false);
       olvContraseña.setFocusPainted(false);
         
       JButton creUsuario = new JButton("CREAR USUARIO");
       creUsuario.setBounds(530, 460 , 160  , 20);
       creUsuario.setBackground(botonIngresar);
       creUsuario.setForeground(Color.white);
       creUsuario.setFont(texto);
       creUsuario.setBorder(null);
       creUsuario.setOpaque(false);
       creUsuario.setFocusPainted(false);
       
        JButton salir = new JButton("SALIR");
        salir.setBounds(450, 500, 120, 40); // Ajusta la posición a tu gusto
        salir.setBackground(botonIngresar);
        salir.setBorder(null);
        salir.setOpaque(false);
        salir.setFocusPainted(false);
        salir.setForeground(Color.WHITE);
        salir.setFont(texto);
       
       ingresar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean valido = true;

        // Limpiar mensajes anteriores
        lblErrorUsuario.setText(" ");
        lblErrorContraseña.setText(" ");

        // Validar campos vacíos
        if(campoUsuario.getText().trim().isEmpty()){
            lblErrorUsuario.setText("El usuario no puede estar vacío");
            valido = false;
        }
        if(campoContraseña.getText().trim().isEmpty()){
            lblErrorContraseña.setText("La contraseña no puede estar vacía");
            valido = false;
        }

        if(!valido) return; // Si hay errores, no cambiar de panel

        // Limpiar campos por seguridad
        campoUsuario.setText("");
        campoContraseña.setText("");

        // Cambiar al panel Menu
        framePrincipal.getContentPane().removeAll();
        Menu menuPanel = new Menu(framePrincipal);

        framePrincipal.add(menuPanel);
        framePrincipal.revalidate();
        framePrincipal.repaint();
    }
});

       
       creUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                                // Antes de cambiar de panel
                campoUsuario.setText("");
                campoContraseña.setText("");

               

                // 1. Eliminar el panel actual (Login) del JFrame
                framePrincipal.getContentPane().removeAll();
                
                // 2. Crear una instancia del nuevo panel (Menu)
                crearUsuario crearUser = new crearUsuario(framePrincipal); // ¡Asume que tienes una clase Menu!
                
                // 3. Añadir el nuevo panel al JFrame
                framePrincipal.add(crearUser);
                
                // 4. Repintar y revalidar el JFrame para mostrar los cambios
                framePrincipal.revalidate();
                framePrincipal.repaint();
                
                // Nota: No es necesario cerrar el frame, solo reemplazamos el contenido.
            }
        });
       
       olvContraseña.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // Antes de cambiar de panel
                campoUsuario.setText("");
                campoContraseña.setText("");


                // 1. Eliminar el panel actual (Login) del JFrame
                framePrincipal.getContentPane().removeAll();
                
                // 2. Crear una instancia del nuevo panel (Menu)
                restaurarContraseña crearUser = new restaurarContraseña(framePrincipal); // ¡Asume que tienes una clase Menu!
                
                // 3. Añadir el nuevo panel al JFrame
                framePrincipal.add(crearUser);
                
                // 4. Repintar y revalidar el JFrame para mostrar los cambios
                framePrincipal.revalidate();
                framePrincipal.repaint();
                
                // Nota: No es necesario cerrar el frame, solo reemplazamos el contenido.
            }
        });
       
       // Acción para cerrar la aplicación
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
       
       // Añadir al panel
       this.add(ingresar);
       this.add(campoUsuario);
       this.add(usuario);
       this.add(campoContraseña);
       this.add(contraseña);
       this.add(titulo);
       this.add(titulo2);
       this.add(titulo3);
       this.add(titulo4);
       this.add(olvContraseña);
       this.add(creUsuario);
       this.add(lblErrorUsuario);
       this.add(lblErrorContraseña);
       this.add(salir);
   } 
   
   
   
   @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g); 
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
          
        final int RADIUS = 20; 
        final int RADIUSB = 40;
        final int SHADOW_OFFSET = 5; 
        
        //crear fondo con gradiente
        Rectangle cuadrado = new Rectangle(0, 0, 1024, 700);
        g2.fillRect(0, 0, 1024, 700);        
        GradientPaint gp = new GradientPaint(0, 0, new Color(14,19,32), 0, 0 + 700, new Color(0,40,66));
        g2.setPaint(gp);
        g2.fill(cuadrado);
    
        //crear panel contenedor
        g2.setColor(new Color(0, 0, 0, 100)); 
        g2.fillRoundRect(310 + SHADOW_OFFSET, 190 + SHADOW_OFFSET, 400, 250, RADIUS, RADIUS);       
        g.setColor(fondo); 
        g2.fillRoundRect(310, 190, 400, 250, RADIUS, RADIUS);
         
        //crear contenedor del usuario
        g.setColor(new Color(61,66,84,100));
        g2.fillRoundRect(365 + SHADOW_OFFSET, 220 + SHADOW_OFFSET, 300, 40, RADIUS, RADIUS);
        g.setColor(textField);
        g2.fillRoundRect(365, 220, 300, 40,RADIUS,RADIUS);
        //crear contenedor de contraseña
        g.setColor(new Color(61,66,84,100));
        g2.fillRoundRect(365 + SHADOW_OFFSET, 305 + SHADOW_OFFSET, 300, 40, RADIUS, RADIUS);
        g.setColor(textField);
        g2.fillRoundRect(365, 305, 300, 40,RADIUS,RADIUS);
        //crear contenedor del boton entrar
        g.setColor(new Color(255,255,255,100));
        g2.fillRoundRect(382 + SHADOW_OFFSET, 380 + SHADOW_OFFSET, 265, 40, RADIUSB, RADIUSB);
        g.setColor(Color.WHITE);
        g2.fillRoundRect(382, 380 , 265, 40,RADIUSB,RADIUSB);
        
        g2.drawLine(560, 481, 660, 481);
        g2.drawLine(350, 481, 510, 481);
    }    
}
