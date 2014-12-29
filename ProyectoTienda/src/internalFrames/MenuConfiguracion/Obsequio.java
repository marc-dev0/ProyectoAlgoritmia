package internalFrames.MenuConfiguracion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import Frames.menu_Principal;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Obsequio extends JInternalFrame implements ActionListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblImporteMinimo;
	private JLabel lblObsequio;
	private JTextField txtImporte;
	private JTextField txtObsequio;
	private JButton btnAceptar;
	private JButton btnCancelar;

	private static Obsequio instance = null;
	
	public static Obsequio getInstance(){
		if (instance == null)
			instance = new Obsequio();
		
		return instance;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Obsequio frame = new Obsequio();
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
	private Obsequio() {
		setFrameIcon(new ImageIcon(Obsequio.class.getResource("/imagenes/gift41.png")));
		setTitle("Configuraci\u00F3n del Obsequio");
		setBounds(100, 100, 481, 126);
		getContentPane().setLayout(null);
		{
			lblImporteMinimo = new JLabel("Importe a pagar m\u00EDnimo requerido   (S/.)");
			lblImporteMinimo.setBounds(10, 21, 238, 14);
			getContentPane().add(lblImporteMinimo);
		}
		{
			lblObsequio = new JLabel("Obsequio:");
			lblObsequio.setBounds(10, 57, 83, 14);
			getContentPane().add(lblObsequio);
		}
		{
			txtImporte = new JTextField();
			txtImporte.addKeyListener(this);
			txtImporte.setBounds(260, 18, 86, 20);
			getContentPane().add(txtImporte);
			txtImporte.setColumns(10);
		}
		{
			txtObsequio = new JTextField();
			txtObsequio.setColumns(10);
			txtObsequio.setBounds(260, 46, 86, 20);
			getContentPane().add(txtObsequio);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(370, 17, 89, 23);
			getContentPane().add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(370, 53, 89, 23);
			getContentPane().add(btnCancelar);
		}
		{
			//cargar precio y obsequio
			txtImporte.setText(""+menu_Principal.IPAGMRO);
			txtObsequio.setText(menu_Principal.obsequio);
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
		menu_Principal.IPAGMRO = Double.parseDouble(txtImporte.getText());
		menu_Principal.obsequio = txtObsequio.getText();
		JOptionPane.showMessageDialog(null, "Los cambios han sido registrado correctamente","Aviso", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtImporte) {
			do_txtImporte_keyTyped(arg0);
		}
	}
	
	protected void do_txtImporte_keyTyped(KeyEvent arg0) {
		menu_Principal mnu = new menu_Principal();
		mnu.validarCampoNumerico(arg0);
	}
}
