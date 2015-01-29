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

public class Precio extends JInternalFrame implements ActionListener,
        KeyListener {
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private JLabel lblTentacion;
    private JLabel lblDelicia;
    private JLabel lblExplosin;
    private JLabel lblChokoloko;
    private JLabel lblChocoboom;
    private JLabel lblS;
    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel label_3;
    private JTextField txtTentacion;
    private JTextField txtDelicia;
    private JTextField txtExplosion;
    private JTextField txtChokoloko;
    private JTextField txtChocoBoom;
    private JButton btnAceptar;
    private JButton btnCancelar;

    private static Precio instance = null;

    public static Precio getInstance() {
        if (instance == null)
            instance = new Precio();

        return instance;
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Precio frame = new Precio();
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
    private Precio() {
        setFrameIcon(new ImageIcon(
                Precio.class.getResource("/imagenes/dollar1.png")));
        setTitle("Configuraci\u00F3n de Precios");
        setBounds(100, 100, 382, 173);
        getContentPane().setLayout(null);
        {
            lblTentacion = new JLabel("Tentaci\u00F3n");
            lblTentacion.setBounds(10, 11, 96, 14);
            getContentPane().add(lblTentacion);
        }
        {
            lblDelicia = new JLabel("Delicia");
            lblDelicia.setBounds(10, 36, 96, 14);
            getContentPane().add(lblDelicia);
        }
        {
            lblExplosin = new JLabel("Explosi\u00F3n");
            lblExplosin.setBounds(10, 61, 96, 14);
            getContentPane().add(lblExplosin);
        }
        {
            lblChokoloko = new JLabel("Chokoloko");
            lblChokoloko.setBounds(10, 86, 96, 14);
            getContentPane().add(lblChokoloko);
        }
        {
            lblChocoboom = new JLabel("ChocoBoom");
            lblChocoboom.setBounds(10, 111, 96, 14);
            getContentPane().add(lblChocoboom);
        }
        {
            lblS = new JLabel("S/.");
            lblS.setBounds(116, 11, 30, 14);
            getContentPane().add(lblS);
        }
        {
            label = new JLabel("S/.");
            label.setBounds(116, 36, 30, 14);
            getContentPane().add(label);
        }
        {
            label_1 = new JLabel("S/.");
            label_1.setBounds(116, 61, 30, 14);
            getContentPane().add(label_1);
        }
        {
            label_2 = new JLabel("S/.");
            label_2.setBounds(116, 86, 30, 14);
            getContentPane().add(label_2);
        }
        {
            label_3 = new JLabel("S/.");
            label_3.setBounds(116, 111, 30, 14);
            getContentPane().add(label_3);
        }
        {
            txtTentacion = new JTextField();
            txtTentacion.addKeyListener(this);
            txtTentacion.setBounds(156, 8, 64, 20);
            getContentPane().add(txtTentacion);
            txtTentacion.setColumns(10);
        }
        {
            txtDelicia = new JTextField();
            txtDelicia.addKeyListener(this);
            txtDelicia.setColumns(10);
            txtDelicia.setBounds(156, 33, 64, 20);
            getContentPane().add(txtDelicia);
        }
        {
            txtExplosion = new JTextField();
            txtExplosion.addKeyListener(this);
            txtExplosion.setColumns(10);
            txtExplosion.setBounds(156, 58, 64, 20);
            getContentPane().add(txtExplosion);
        }
        {
            txtChokoloko = new JTextField();
            txtChokoloko.addKeyListener(this);
            txtChokoloko.setColumns(10);
            txtChokoloko.setBounds(156, 83, 64, 20);
            getContentPane().add(txtChokoloko);
        }
        {
            txtChocoBoom = new JTextField();
            txtChocoBoom.addKeyListener(this);
            txtChocoBoom.setColumns(10);
            txtChocoBoom.setBounds(156, 108, 64, 20);
            getContentPane().add(txtChocoBoom);
        }
        {
            btnAceptar = new JButton("Aceptar");
            btnAceptar.addActionListener(this);
            btnAceptar.setBounds(246, 7, 89, 23);
            getContentPane().add(btnAceptar);
        }
        {
            btnCancelar = new JButton("Cancelar");
            btnCancelar.addActionListener(this);
            btnCancelar.setBounds(246, 52, 89, 23);
            getContentPane().add(btnCancelar);
        }
        {
            // cargar precios a los jtextfield
            txtTentacion.setText("" + menu_Principal.getPrecioTentacion());
            txtDelicia.setText("" + menu_Principal.getPrecioDelicia());
            txtExplosion.setText("" + menu_Principal.getPrecioExplosion());
            txtChokoloko.setText("" + menu_Principal.getPrecioChokoLoko());
            txtChocoBoom.setText("" + menu_Principal.getPrecioChokoBoom());
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnAceptar) {
            do_btnAceptar_actionPerformed(e);
        }
        if (e.getSource() == btnCancelar) {
            do_btnCancelar_actionPerformed(e);
        }

    }

    protected void do_btnCancelar_actionPerformed(ActionEvent e) {
        dispose();
    }

    protected void do_btnAceptar_actionPerformed(ActionEvent e) {

        menu_Principal.precio0 = Double.parseDouble(txtTentacion.getText());
        menu_Principal.precio1 = Double.parseDouble(txtDelicia.getText());
        menu_Principal.precio2 = Double.parseDouble(txtExplosion.getText());
        menu_Principal.precio3 = Double.parseDouble(txtChokoloko.getText());
        menu_Principal.precio4 = Double.parseDouble(txtChocoBoom.getText());
        JOptionPane.showMessageDialog(null,
                "Los cambios han sido registrado correctamente", "Aviso",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void keyPressed(KeyEvent arg0) {
    }

    public void keyReleased(KeyEvent arg0) {
    }

    public void keyTyped(KeyEvent arg0) {
        if (arg0.getSource() == txtChocoBoom) {
            do_txtChocoBoom_keyTyped(arg0);
        }
        if (arg0.getSource() == txtChokoloko) {
            do_txtChokoloko_keyTyped(arg0);
        }
        if (arg0.getSource() == txtExplosion) {
            do_txtExplosion_keyTyped(arg0);
        }
        if (arg0.getSource() == txtDelicia) {
            do_txtDelicia_keyTyped(arg0);
        }
        if (arg0.getSource() == txtTentacion) {
            do_txtTentacion_keyTyped(arg0);
        }
    }

    protected void do_txtTentacion_keyTyped(KeyEvent arg0) {
        menu_Principal mnu = new menu_Principal();
        mnu.validarCampoNumerico(arg0, txtTentacion);
    }

    protected void do_txtDelicia_keyTyped(KeyEvent arg0) {
        menu_Principal mnu = new menu_Principal();
        mnu.validarCampoNumerico(arg0, txtDelicia);
    }

    protected void do_txtExplosion_keyTyped(KeyEvent arg0) {
        menu_Principal mnu = new menu_Principal();
        mnu.validarCampoNumerico(arg0, txtExplosion);
    }

    protected void do_txtChokoloko_keyTyped(KeyEvent arg0) {
        menu_Principal mnu = new menu_Principal();
        mnu.validarCampoNumerico(arg0, txtChokoloko);
    }

    protected void do_txtChocoBoom_keyTyped(KeyEvent arg0) {
        menu_Principal mnu = new menu_Principal();
        mnu.validarCampoNumerico(arg0, txtChocoBoom);
    }
}
