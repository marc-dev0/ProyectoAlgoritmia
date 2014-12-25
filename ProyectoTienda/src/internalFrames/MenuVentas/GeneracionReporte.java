package internalFrames.MenuVentas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class GeneracionReporte extends JInternalFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTipoReporte;
	private JComboBox cboTipoReporte;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JTextArea txtReporte;

	private static GeneracionReporte instance = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneracionReporte frame = new GeneracionReporte();
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
	private GeneracionReporte() {
		setFrameIcon(new ImageIcon(GeneracionReporte.class.getResource("/imagenes/increasing5.png")));
		setTitle("Reportes");
		setBounds(100, 100, 573, 318);
		getContentPane().setLayout(null);
		{
			lblTipoReporte = new JLabel("Tipo de Reporte");
			lblTipoReporte.setFont(new Font("Arial", Font.PLAIN, 12));
			lblTipoReporte.setBounds(10, 15, 112, 14);
			getContentPane().add(lblTipoReporte);
		}
		{
			cboTipoReporte = new JComboBox();
			cboTipoReporte.setModel(new DefaultComboBoxModel(new String[] {"Ventas por chocolate", "Chocolates con venta \u00F3ptima", "Chocolates con precios inferiores al precio promedio", "Chocolates con precios superiores al precio promedio", "Precios promedio, menor y mayor"}));
			cboTipoReporte.setFont(new Font("Arial", Font.PLAIN, 12));
			cboTipoReporte.setBounds(112, 12, 333, 20);
			getContentPane().add(cboTipoReporte);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setFont(new Font("Arial", Font.PLAIN, 12));
			btnCerrar.setBounds(457, 11, 89, 23);
			getContentPane().add(btnCerrar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 54, 525, 223);
			getContentPane().add(scrollPane);
			{
				txtReporte = new JTextArea();
				scrollPane.setViewportView(txtReporte);
			}
		}

	}
	
	public static GeneracionReporte getInstance(){
		if(instance == null){
			instance = new GeneracionReporte();
		
		}
		return instance;
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(arg0);
		}
	}
	protected void do_btnCerrar_actionPerformed(ActionEvent arg0) {
		dispose();
	}
}
