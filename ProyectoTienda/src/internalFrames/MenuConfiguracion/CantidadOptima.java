package internalFrames.MenuConfiguracion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CantidadOptima extends JInternalFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCantidadptimaDe;
	private JTextField txtCantidad;
	private JButton btnAceptar;
	private JButton btnCancelar;

	private static CantidadOptima instance = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CantidadOptima frame = new CantidadOptima();
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
	private CantidadOptima() {
		setFrameIcon(new ImageIcon(CantidadOptima.class.getResource("/imagenes/stack18.png")));
		
		setTitle("Configuraci\u00F3n de la cantidad \u00F3ptima de ventas");
		setBounds(100, 100, 326, 134);
		
		getContentPane().setLayout(null);
		{
			lblCantidadptimaDe = new JLabel("Cantidad \u00F3ptima de ventas:");
			lblCantidadptimaDe.setBounds(10, 11, 165, 14);
			getContentPane().add(lblCantidadptimaDe);
		}
		{
			txtCantidad = new JTextField();
			txtCantidad.setBounds(201, 8, 86, 20);
			getContentPane().add(txtCantidad);
			txtCantidad.setColumns(10);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setBounds(10, 45, 89, 23);
			getContentPane().add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(198, 45, 89, 23);
			getContentPane().add(btnCancelar);
		}

	}
	
	public static CantidadOptima getInstance(){
		if (instance == null)
			instance = new CantidadOptima();
		
		
		return instance;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			do_btnCancelar_actionPerformed(e);
		}
	}
	protected void do_btnCancelar_actionPerformed(ActionEvent e) {
		dispose();
	}
}
