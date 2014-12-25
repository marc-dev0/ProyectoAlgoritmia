package internalFrames.MenuConfiguracion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Precio extends JInternalFrame implements ActionListener {
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
	
	public static Precio getInstance(){
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
		setFrameIcon(new ImageIcon(Precio.class.getResource("/imagenes/dollar1.png")));
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
			txtTentacion.setBounds(156, 8, 64, 20);
			getContentPane().add(txtTentacion);
			txtTentacion.setColumns(10);
		}
		{
			txtDelicia = new JTextField();
			txtDelicia.setColumns(10);
			txtDelicia.setBounds(156, 33, 64, 20);
			getContentPane().add(txtDelicia);
		}
		{
			txtExplosion = new JTextField();
			txtExplosion.setColumns(10);
			txtExplosion.setBounds(156, 58, 64, 20);
			getContentPane().add(txtExplosion);
		}
		{
			txtChokoloko = new JTextField();
			txtChokoloko.setColumns(10);
			txtChokoloko.setBounds(156, 83, 64, 20);
			getContentPane().add(txtChokoloko);
		}
		{
			txtChocoBoom = new JTextField();
			txtChocoBoom.setColumns(10);
			txtChocoBoom.setBounds(156, 108, 64, 20);
			getContentPane().add(txtChocoBoom);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setBounds(246, 7, 89, 23);
			getContentPane().add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(246, 52, 89, 23);
			getContentPane().add(btnCancelar);
		}

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
