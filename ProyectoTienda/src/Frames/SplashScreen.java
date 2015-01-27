package Frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class SplashScreen extends JWindow {

    private int duracion = 0;
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

    public SplashScreen(int duracion) {

        this.duracion = duracion;

        JPanel panel = (JPanel) getContentPane();
        ImageIcon img = new ImageIcon(
                SplashScreen.class.getResource("/imagenes/choco.jpg"));

        panel.add(new JLabel(img), BorderLayout.CENTER);
        setSize(img.getIconWidth(), img.getIconHeight());
        setVisible(true);
        setLocationRelativeTo(null);

        try {
            Thread.sleep(duracion);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(false);
        /*
         * menu_Principal menu = new menu_Principal(); menu.setSize(d.width,
         * d.height); menu.setLocation(0, 0); menu.setVisible(true);
         */

    }
    /*
     * public static void main(String[] args) { new SplashScreen(6000); }
     */

}
