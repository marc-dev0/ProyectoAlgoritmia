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

import org.omg.CORBA.Object;

import Frames.menu_Principal;

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
			cboTipoReporte.addActionListener(this);
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
		if (arg0.getSource() == cboTipoReporte) {
			do_cboTipoReporte_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(arg0);
		}
	}
	
	protected void do_btnCerrar_actionPerformed(ActionEvent arg0) {

		dispose();
	}
	
	protected void do_cboTipoReporte_actionPerformed(ActionEvent arg0) {
	
		double importeTotal = VentaChocolate.totalPagoChokoBoom + VentaChocolate.totalPagoChokoLoko + VentaChocolate.totalPagoDelicia + 
				  VentaChocolate.totalPagoExplosion + VentaChocolate.totalPagoTentacion;
		txtReporte.setText("VENTAS POR CHOCOLATE\n\n");
		
		switch(cboTipoReporte.getSelectedIndex()){
		
		case 0 : //Ventas por Chocolate
			imprimir(menu_Principal.getTipoTentacion(), VentaChocolate.canVentasTentacion, VentaChocolate.totalCajasTentacion, VentaChocolate.totalPagoTentacion);
			imprimir(menu_Principal.getTipoDelicia(), VentaChocolate.canVentasDelicia, VentaChocolate.totalCajasDelicia, VentaChocolate.totalPagoDelicia);
			imprimir(menu_Principal.getTipoExplosion(), VentaChocolate.canVentasExplosion, VentaChocolate.totalCajasExplosion, VentaChocolate.totalPagoExplosion);
			imprimir(menu_Principal.getTipoChokoLoko(), VentaChocolate.canVentasChokoLoko,VentaChocolate.totalCajasChokoLoko, VentaChocolate.totalPagoChokoLoko);
			imprimir(menu_Principal.getTipoChokoBoom(), VentaChocolate.canVentasChokoBoom, VentaChocolate.totalCajasChokoBoom, VentaChocolate.totalPagoChokoBoom);
			txtReporte.append("Importe total Acumulado General: \t"+ menu_Principal.formatoDecimal(importeTotal));
		case 1 : //Chocolates con Venta Óptima
			
		case 2 : //Explosion
			
		case 3 : //ChokoLoko
			
		default : //ChokoBoom
			
			
		}
		
	}
	
	private void imprimir(String tipo, int cantidadVentas, int cantidadCajas, double importeTotal){
		txtReporte.append("Tipo\t\t:\t" + tipo);
		txtReporte.append("\nCantidad de Ventas\t:\t" + menu_Principal.formatoDecimal(cantidadVentas));
		txtReporte.append("\nCantidad total de Cajas Vendidas:\t" + menu_Principal.formatoDecimal(cantidadCajas));
		txtReporte.append("\nImporte Total Acumulado\t:\t" + menu_Principal.formatoDecimal(importeTotal));
		txtReporte.append("\n\n");
	}
}
