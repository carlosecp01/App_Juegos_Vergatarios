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
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Menu extends JPanel {

    private JFrame framePrincipal;

    public Menu(JFrame frame) {
        this.framePrincipal = frame;

        this.setSize(1024, 700);
        this.setBackground(Color.red);
        this.setLayout(null);

        // Botón regresar
        JButton regresar = new JButton("REGRESAR");
        regresar.setBounds(450, 300, 120, 40);
        regresar.setBackground(new Color(255, 255, 255, 255));
        regresar.setBorder(null);
        regresar.setOpaque(false);
        regresar.setFocusPainted(false);
        regresar.setForeground(Color.WHITE);
        regresar.setFont(new Font("SansSerif", Font.BOLD, 14));

        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Volver al Login
                framePrincipal.getContentPane().removeAll();
                Login loginPanel = new Login(framePrincipal);
                framePrincipal.add(loginPanel);
                framePrincipal.revalidate();
                framePrincipal.repaint();
            }
        });

        this.add(regresar);
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
        GradientPaint gp = new GradientPaint(0, 0, new Color(14, 19, 32), 0, 700, new Color(0, 40, 66));
        g2.setPaint(gp);
        g2.fill(cuadrado);
    }
}
