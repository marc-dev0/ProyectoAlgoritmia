package internalFrames.MenuConfiguracion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Frames.menu_Principal;

public class Descuentos extends JInternalFrame implements ActionListener,
        KeyListener {
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private JLabel lbl1a5;
    private JLabel lbl6a10;
    private JLabel lbl11a15;
    private JLabel lblMayora15;
    private JTextField txtRango1a5;
    private JTextField txtRango6a10;
    private JTextField txtRango11a15;
    private JTextField txtRangoMayora15;
    private JLabel lblNewLabel;
    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;
    private JButton btnAceptar;
    private JButton btnCancelar;

    private static Descuentos instance = null;

    public static Descuentos getInstance() {
        if (instance == null)
            instance = new Descuentos();

        return instance;
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Descuentos frame = new Descuentos();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    private Descuentos() {
        setFrameIcon(new ImageIcon(
                Descuentos.class.getResource("/imagenes/reduction.png")));
        setTitle("Configuraci\u00F3n de los porcentajes de descuento");
        setBounds(100, 100, 441, 143);
        getContentPane().setLayout(null);
        {
            lbl1a5 = new JLabel("1 a 5 unidades:");
            lbl1a5.setBounds(10, 11, 112, 14);
            getContentPane().add(lbl1a5);
        }
        {
            lbl6a10 = new JLabel("6 a 10 unidades:");
            lbl6a10.setBounds(10, 39, 112, 14);
            getContentPane().add(lbl6a10);
        }
        {
            lbl11a15 = new JLabel("11 a 15 unidades:");
            lbl11a15.setBounds(10, 64, 112, 14);
            getContentPane().add(lbl11a15);
        }
        {
            lblMayora15 = new JLabel("M\u00E1s de 15 unidades:");
            lblMayora15.setBounds(10, 89, 140, 14);
            getContentPane().add(lblMayora15);
        }
        {
            txtRango1a5 = new JTextField();
            txtRango1a5.addKeyListener(this);
            txtRango1a5.setBounds(200, 8, 86, 20);
            txtRango1a5.setTransferHandler(null);
            getContentPane().add(txtRango1a5);
            txtRango1a5.setColumns(10);

        }
        {
            txtRango6a10 = new JTextField();
            txtRango6a10.addKeyListener(this);
            txtRango6a10.setColumns(10);
            txtRango6a10.setBounds(200, 33, 86, 20);
            txtRango6a10.setTransferHandler(null);
            getContentPane().add(txtRango6a10);
        }
        {
            txtRango11a15 = new JTextField();
            txtRango11a15.addKeyListener(this);
            txtRango11a15.setColumns(10);
            txtRango11a15.setBounds(200, 58, 86, 20);
            txtRango11a15.setTransferHandler(null);
            getContentPane().add(txtRango11a15);

        }
        {
            txtRangoMayora15 = new JTextField();
            txtRangoMayora15.addKeyListener(this);
            txtRangoMayora15.setColumns(10);
            txtRangoMayora15.setBounds(200, 83, 86, 20);
            txtRangoMayora15.setTransferHandler(null);

            getContentPane().add(txtRangoMayora15);
        }
        {
            lblNewLabel = new JLabel("%");
            lblNewLabel.setBounds(290, 11, 22, 14);
            getContentPane().add(lblNewLabel);
        }
        {
            label = new JLabel("%");
            label.setBounds(290, 39, 22, 14);
            getContentPane().add(label);
        }
        {
            label_1 = new JLabel("%");
            label_1.setBounds(290, 64, 22, 14);
            getContentPane().add(label_1);
        }
        {
            label_2 = new JLabel("%");
            label_2.setBounds(290, 89, 22, 14);
            getContentPane().add(label_2);
        }
        {
            btnAceptar = new JButton("Aceptar");
            btnAceptar.addActionListener(this);
            btnAceptar.setBounds(330, 7, 89, 23);
            getContentPane().add(btnAceptar);
        }
        {
            btnCancelar = new JButton("Cancelar");
            btnCancelar.addActionListener(this);
            btnCancelar.setBounds(330, 39, 89, 23);
            getContentPane().add(btnCancelar);
        }

        { // Load descuentos a JTextField
            txtRango1a5.setText("" + menu_Principal.getDescuento1a5());
            txtRango6a10.setText("" + menu_Principal.getDescuento6a10());
            txtRango11a15.setText("" + menu_Principal.getDescuento11a15());
            txtRangoMayora15.setText("" + menu_Principal.getDescuento15aMas());
        }

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCancelar) {
            do_btnCancelar_actionPerformed(e);
        }

        if (e.getSource() == btnAceptar) {
            do_btnAceptar_actionPerformed(e);
        }
    }

    private void do_btnAceptar_actionPerformed(ActionEvent e) {

        menu_Principal.porcDes1 = Double.parseDouble(txtRango1a5.getText());
        menu_Principal.porcDes2 = Double.parseDouble(txtRango6a10.getText());
        menu_Principal.porcDes3 = Double.parseDouble(txtRango11a15.getText());
        menu_Principal.porcDes4 = Double
                .parseDouble(txtRangoMayora15.getText());
        JOptionPane.showMessageDialog(null, "Los cambios han sido registrados",
                "Aviso", JOptionPane.INFORMATION_MESSAGE);

    }

    protected void do_btnCancelar_actionPerformed(ActionEvent e) {
        dispose();
    }

    public void keyTyped(KeyEvent arg0) {

        if (arg0.getSource() == txtRango1a5) {
            do_txtRango1a5_keyTyped(arg0);
        }

        if (arg0.getSource() == txtRango6a10) {
            do_txtRango6a10_keyTyped(arg0);
        }

        if (arg0.getSource() == txtRango11a15) {
            do_txtRango11a15_keyTyped(arg0);
        }

        if (arg0.getSource() == txtRangoMayora15) {
            do_txtRangoMayora15_keyTyped(arg0);
        }

    }

    private void do_txtRango11a15_keyTyped(KeyEvent arg0) {
        menu_Principal mnu = new menu_Principal();
        mnu.validarCampoNumerico(arg0, txtRango11a15);

    }

    private void do_txtRango6a10_keyTyped(KeyEvent arg0) {
        menu_Principal mnu = new menu_Principal();
        mnu.validarCampoNumerico(arg0, txtRango6a10);

    }

    private void do_txtRango1a5_keyTyped(KeyEvent arg0) {
        menu_Principal mnu = new menu_Principal();
        mnu.validarCampoNumerico(arg0, txtRango1a5);

    }

    private void do_txtRangoMayora15_keyTyped(KeyEvent arg0) {
        menu_Principal mnu = new menu_Principal();
        mnu.validarCampoNumerico(arg0, txtRangoMayora15);

    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

}
