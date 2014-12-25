package internalFrames.MenuVentas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

public class VentaChocolate extends JInternalFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTipoChocolate;
	
	private JComboBox cboTipoChoco;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JButton btnVender;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JTextArea txtDetalle;

	private static VentaChocolate instance = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentaChocolate frame = new VentaChocolate();
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
	private VentaChocolate() {
		setFrameIcon(new ImageIcon(VentaChocolate.class.getResource("/imagenes/shopping100.png")));
		setTitle("Venta de Chocolates");
		setBounds(100, 100, 458, 300);
		getContentPane().setLayout(null);
		{
			lblTipoChocolate = new JLabel("Tipo de Chocolate");
			lblTipoChocolate.setFont(new Font("Arial", Font.PLAIN, 12));
			lblTipoChocolate.setBounds(10, 15, 108, 14);
			getContentPane().add(lblTipoChocolate);
		}
		{
			cboTipoChoco = new JComboBox();
			cboTipoChoco.setModel(new DefaultComboBoxModel(new String[] {"Tentaci\u00F3n", "Delicia", "Explosi\u00F3n", "ChokoLoko", "ChokoBoom"}));
			cboTipoChoco.setToolTipText("");
			cboTipoChoco.setFont(new Font("Arial", Font.PLAIN, 12));
			cboTipoChoco.setBounds(124, 12, 122, 20);
			getContentPane().add(cboTipoChoco);
		}
		{
			lblCantidad = new JLabel("Cantidad de Cajas");
			lblCantidad.setFont(new Font("Arial", Font.PLAIN, 12));
			lblCantidad.setBounds(10, 48, 108, 14);
			getContentPane().add(lblCantidad);
		}
		{
			txtCantidad = new JTextField();
			txtCantidad.setColumns(10);
			txtCantidad.setBounds(124, 43, 122, 20);
			getContentPane().add(txtCantidad);
		}
		{
			btnVender = new JButton("Vender");
			btnVender.setFont(new Font("Arial", Font.PLAIN, 12));
			btnVender.setBounds(343, 11, 89, 23);
			getContentPane().add(btnVender);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setFont(new Font("Arial", Font.PLAIN, 12));
			btnCerrar.setBounds(343, 44, 89, 23);
			getContentPane().add(btnCerrar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 73, 424, 186);
			getContentPane().add(scrollPane);
			{
				txtDetalle = new JTextArea();
				scrollPane.setViewportView(txtDetalle);
			}
		}

	}

	public static VentaChocolate getInstance(){
		if(instance == null){
			instance = new VentaChocolate();
		}
		
		return instance;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(e);
		}
	}
	protected void do_btnCerrar_actionPerformed(ActionEvent e) {
		dispose();
	}
}
