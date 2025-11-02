package juegosvergatarios;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;
import javax.swing.*;

public class crearUsuario extends JPanel {

    private JFrame framePrincipal;
    
    // Colores y fuentes
    Color fondo1 = new Color(41, 43, 107);
    Color fondo = new Color(17, 19, 56);
    Color botonIngresar = new Color(255, 255, 255, 255);
    Color textField = new Color(61, 66, 84, 255);
    Color colorError = new Color(255, 85, 85); // rojo suave para errores
    Font fondoTitulo = new Font("Montserrat", Font.BOLD, 30);
    Font texto = new Font("SansSerif", Font.BOLD, 15);

    // Campos de texto
    private JTextField campoNombre, campoApellido, campoCorreo;
    private JPasswordField campoContraseña, campoConfirContraseña;

    // Etiquetas de error
    private JLabel errorNombre, errorApellido, errorCorreo, errorContraseña, errorConfirmacion;

    public crearUsuario(JFrame frame) {

        this.framePrincipal = frame;
        this.setSize(1024, 700);
        this.setBackground(Color.blue);
        this.setLayout(null);

        // Etiquetas principales
        JLabel nombre = new JLabel("Nombre");
        nombre.setBounds(490, 72, 80, 15);
        nombre.setForeground(Color.WHITE);
        nombre.setFont(texto);

        JLabel apellido = new JLabel("Apellido");
        apellido.setBounds(490, 155, 80, 15);
        apellido.setForeground(Color.WHITE);
        apellido.setFont(texto);

        JLabel correo = new JLabel("Correo Electrónico");
        correo.setBounds(460, 240, 150, 15);
        correo.setForeground(Color.WHITE);
        correo.setFont(texto);

        JLabel contraseña = new JLabel("Contraseña");
        contraseña.setBounds(480, 325, 110, 15);
        contraseña.setForeground(Color.WHITE);
        contraseña.setFont(texto);

        JLabel confirContraseña = new JLabel("Confirmar Contraseña");
        confirContraseña.setBounds(440, 410, 160, 15);
        confirContraseña.setForeground(Color.WHITE);
        confirContraseña.setFont(texto);

        // Campos de texto
        campoNombre = new JTextField();
        campoNombre.setBounds(375, 92, 285, 40);
        campoNombre.setBorder(null);
        campoNombre.setFont(texto);
        campoNombre.setForeground(Color.WHITE);
        campoNombre.setOpaque(false);

        campoApellido = new JTextField();
        campoApellido.setBounds(375, 175, 285, 40);
        campoApellido.setBorder(null);
        campoApellido.setFont(texto);
        campoApellido.setForeground(Color.WHITE);
        campoApellido.setOpaque(false);

        campoCorreo = new JTextField();
        campoCorreo.setBounds(375, 260, 285, 40);
        campoCorreo.setBorder(null);
        campoCorreo.setFont(texto);
        campoCorreo.setForeground(Color.WHITE);
        campoCorreo.setOpaque(false);

        campoContraseña = new JPasswordField();
        campoContraseña.setBounds(375, 360, 285, 40);
        campoContraseña.setBorder(null);
        campoContraseña.setFont(texto);
        campoContraseña.setForeground(Color.WHITE);
        campoContraseña.setOpaque(false);

        campoConfirContraseña = new JPasswordField();
        campoConfirContraseña.setBounds(375, 430, 285, 40);
        campoConfirContraseña.setBorder(null);
        campoConfirContraseña.setFont(texto);
        campoConfirContraseña.setForeground(Color.WHITE);
        campoConfirContraseña.setOpaque(false);

        // Etiquetas de error
        errorNombre = crearEtiquetaError(375, 136);
        errorApellido = crearEtiquetaError(375, 220);
        errorCorreo = crearEtiquetaError(375, 305);
        errorContraseña = crearEtiquetaError(375, 390);
        errorConfirmacion = crearEtiquetaError(375, 475);

        // Botones
        JButton crear = new JButton("Crear");
        crear.setBounds(525, 500, 165, 40);
        crear.setBackground(botonIngresar);
        crear.setBorder(null);
        crear.setOpaque(false);
        crear.setFocusPainted(false);

        JButton regresar = new JButton("Regresar");
        regresar.setBounds(340, 500, 165, 40);
        regresar.setBackground(botonIngresar);
        regresar.setBorder(null);
        regresar.setOpaque(false);
        regresar.setFocusPainted(false);

        // Validación en tiempo real de contraseña
        campoConfirContraseña.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String pass = new String(campoContraseña.getPassword());
                String confirm = new String(campoConfirContraseña.getPassword());
                if (!confirm.equals(pass)) {
                    errorConfirmacion.setText("Las contraseñas no coinciden");
                } else {
                    errorConfirmacion.setText("");
                }
            }
        });

        // Botón crear usuario
        crear.addActionListener(e -> {
            limpiarErrores();
            if (validarCampos()) {
                JOptionPane.showMessageDialog(null, "Usuario creado correctamente ✅");
                limpiarCampos();
            }
        });

        // Botón regresar al login
        regresar.addActionListener(e -> {
            framePrincipal.getContentPane().removeAll();
            Login login = new Login(framePrincipal);
            framePrincipal.add(login);
            framePrincipal.revalidate();
            framePrincipal.repaint();
            limpiarCampos();
        });

        // Añadir todo al panel
        this.add(nombre);
        this.add(apellido);
        this.add(correo);
        this.add(contraseña);
        this.add(confirContraseña);
        this.add(campoNombre);
        this.add(campoApellido);
        this.add(campoCorreo);
        this.add(campoContraseña);
        this.add(campoConfirContraseña);
        this.add(crear);
        this.add(regresar);

        // Añadir etiquetas de error
        this.add(errorNombre);
        this.add(errorApellido);
        this.add(errorCorreo);
        this.add(errorContraseña);
        this.add(errorConfirmacion);
    }

    // Crear etiqueta de error
    private JLabel crearEtiquetaError(int x, int y) {
        JLabel label = new JLabel("");
        label.setBounds(x, y, 300, 15);
        label.setForeground(colorError);
        label.setFont(new Font("SansSerif", Font.PLAIN, 12));
        return label;
    }

    // Limpiar etiquetas de error
    private void limpiarErrores() {
        errorNombre.setText("");
        errorApellido.setText("");
        errorCorreo.setText("");
        errorContraseña.setText("");
        errorConfirmacion.setText("");
    }

    // Validar campos
    private boolean validarCampos() {
        boolean valido = true;
        String nombre = campoNombre.getText().trim();
        String apellido = campoApellido.getText().trim();
        String correo = campoCorreo.getText().trim();
        String pass = new String(campoContraseña.getPassword());
        String confirm = new String(campoConfirContraseña.getPassword());

        if (nombre.isEmpty()) {
            errorNombre.setText("El nombre no puede estar vacío");
            valido = false;
        }
        if (apellido.isEmpty()) {
            errorApellido.setText("El apellido no puede estar vacío");
            valido = false;
        }
        if (correo.isEmpty()) {
            errorCorreo.setText("El correo no puede estar vacío");
            valido = false;
        } else if (!Pattern.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", correo)) {
            errorCorreo.setText("Correo inválido");
            valido = false;
        }
        if (pass.isEmpty()) {
            errorContraseña.setText("La contraseña no puede estar vacía");
            valido = false;
        }
        if (!confirm.equals(pass)) {
            errorConfirmacion.setText("Las contraseñas no coinciden");
            valido = false;
        }
        return valido;
    }

    // Limpiar campos
    private void limpiarCampos() {
        campoNombre.setText("");
        campoApellido.setText("");
        campoCorreo.setText("");
        campoContraseña.setText("");
        campoConfirContraseña.setText("");
        limpiarErrores();
    }

    // Fondo personalizado
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
        GradientPaint gp = new GradientPaint(0, 0, new Color(14, 19, 32), 0, 700, new Color(0, 40, 66));
        g2.setPaint(gp);
        g2.fill(cuadrado);

        // Panel contenedor
        g2.setColor(new Color(0, 0, 0, 100));
        g2.fillRoundRect(310 + SHADOW_OFFSET, 60 + SHADOW_OFFSET, 400, 500, RADIUS, RADIUS);
        g.setColor(fondo);
        g2.fillRoundRect(310, 60, 400, 500, RADIUS, RADIUS);

        // Campos
        dibujarCampo(g2, 365, 92, RADIUS);
        dibujarCampo(g2, 365, 175, RADIUS);
        dibujarCampo(g2, 365, 260, RADIUS);
        dibujarCampo(g2, 365, 345, RADIUS);
        dibujarCampo(g2, 365, 430, RADIUS);

        // Botones
        dibujarBoton(g2, 525, 500, RADIUSB);
        dibujarBoton(g2, 340, 500, RADIUSB);
    }

    private void dibujarCampo(Graphics2D g2, int x, int y, int radius) {
        final int SHADOW_OFFSET = 5;
        g2.setColor(new Color(61, 66, 84, 100));
        g2.fillRoundRect(x + SHADOW_OFFSET, y + SHADOW_OFFSET, 300, 40, radius, radius);
        g2.setColor(textField);
        g2.fillRoundRect(x, y, 300, 40, radius, radius);
    }

    private void dibujarBoton(Graphics2D g2, int x, int y, int radius) {
        final int SHADOW_OFFSET = 5;
        g2.setColor(new Color(255, 255, 255, 100));
        g2.fillRoundRect(x, y + SHADOW_OFFSET, 165, 40, radius, radius);
        g2.setColor(Color.WHITE);
        g2.fillRoundRect(x, y, 165, 40, radius, radius);
    }
}
