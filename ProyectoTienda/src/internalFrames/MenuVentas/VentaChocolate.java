package internalFrames.MenuVentas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import Frames.menu_Principal;

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
	public static int canVentasTentacion = 0, canVentasDelicia = 0, canVentasExplosion = 0, canVentasChokoLoko = 0, canVentasChokoBoom = 0;
	public static int totalCajasTentacion = 0, totalCajasDelicia = 0, totalCajasExplosion = 0, totalCajasChokoLoko = 0, totalCajasChokoBoom = 0;
	public static double totalPagoTentacion = 0, totalPagoDelicia = 0, totalPagoExplosion = 0, totalPagoChokoLoko = 0, totalPagoChokoBoom = 0;
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
			cboTipoChoco.setModel(new DefaultComboBoxModel(new String[] {menu_Principal.tipo0,
					menu_Principal.tipo1, menu_Principal.tipo2, menu_Principal.tipo3,menu_Principal.tipo4}));
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
			btnVender.addActionListener(this);
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
	  private void do_txtCantidad_keyTyped(KeyEvent arg0) {
	        
		  menu_Principal mnu = new menu_Principal();
	        mnu.validarCampoNumerico(arg0, txtCantidad);
	    }
	  public void keyTyped(KeyEvent arg0) {

	        if (arg0.getSource() == txtCantidad) {
	            do_txtCantidad_keyTyped(arg0);
	        }


	    }
	public static VentaChocolate getInstance(){
		if(instance == null){
			instance = new VentaChocolate();
		}
		
		return instance;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVender) {
			do_btnVender_actionPerformed(e);
		}
		if (e.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(e);
		}
	}

	protected void do_btnCerrar_actionPerformed(ActionEvent e) {

		dispose();
		
	}
	
	protected void do_btnVender_actionPerformed(ActionEvent e) {
		
		if(txtCantidad.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Debe ingresar la cantidad","Aviso", JOptionPane.INFORMATION_MESSAGE);
			txtCantidad.requestFocus();
			return;
		}
		
		//declaraci�n de variables
		double importeCompra, descuento, importeTotal;
		String obsequio;
		//Variables entrada
		int cantidad = Integer.parseInt(txtCantidad.getText());
		
		importeCompra = getImporteCompra(cantidad);
		descuento = getDescuento(cantidad, importeCompra);
		importeTotal = getImporteTotal(importeCompra,descuento);
		obsequio = getObsequio(importeTotal);
		mostrarReporte(cantidad, importeCompra, descuento,importeTotal, obsequio);
	}
	
	private void mostrarReporte(int cantidad, double importeCompra, double descuento, double importeTotal, String obsequio)
	
	{
		txtDetalle.setText("DETALLE DE VENTA \n\nTipo del Chocolate\t:\t"+ cboTipoChoco.getSelectedItem());
		txtDetalle.append("\nUnidades por caja\t:\t"  + getUnidadPorCaja());
		txtDetalle.append("\nPrecio por caja\t\t:\t" + menu_Principal.formatoDecimal(getPrecioPorCaja()));
		txtDetalle.append("\nPeso por caja\t\t:\t" + getPesoporCaja());
		txtDetalle.append("\nCantidad de Cajas Vendidas\t:\t" + cantidad);
		txtDetalle.append("\nImporte de Compra\t:\t"+ menu_Principal.formatoDecimal(importeCompra));
		txtDetalle.append("\nDescuento\t\t:\t"+ menu_Principal.formatoDecimal(descuento));
		txtDetalle.append("\nImporte Total\t\t:\t" + menu_Principal.formatoDecimal(importeTotal));
		txtDetalle.append("\nObsequio\t\t:\t" + obsequio);
		
	}
	
	// Region Getters

	private double getPrecioPorCaja() {
		
		switch(cboTipoChoco.getSelectedIndex()){
		
		case 0 ://Tentaci�n
			
			return menu_Principal.getPrecioTentacion();
			
		case 1 ://Delicia
			
			return menu_Principal.getPrecioDelicia();
			
		case 2 ://Explosi�n
			
			return menu_Principal.getPrecioExplosion();
			
		case 3 ://ChokoLoko
			
			return menu_Principal.getPrecioChokoLoko();
			
		default : //ChokoBoom
			
			return menu_Principal.getPrecioChokoBoom();
	
		}
	}

	private int getUnidadPorCaja() {
		
		switch(cboTipoChoco.getSelectedIndex()){
		
		case 0 ://Tentaci�n
			
			return menu_Principal.getUnidadesTentacion();
			
		case 1 ://Delicia
			
			return menu_Principal.getUnidadesDelicia();
			
		case 2 ://Explosi�n
			
			return menu_Principal.getUnidadesExplosion();
			
		case 3 ://ChokoLoko
			
			return menu_Principal.getUnidadesChokoLoko();
			
		default : //ChokoBoom
			
			return menu_Principal.getUnidadesChokoBoom();
	
		}	
	}

	private double getPesoporCaja(){
		
		switch(cboTipoChoco.getSelectedIndex()){
		
		case 0 ://Tentaci�n
			
			return menu_Principal.getPesoTentacion();
			
		case 1 ://Delicia
			
			return menu_Principal.getPesoDelicia();
			
		case 2 ://Explosi�n
			
			return menu_Principal.getPesoExplosion();
			
		case 3 ://ChokoLoko
			
			return menu_Principal.getPesoChokoLoko();
			
		default : //ChokoBoom
			
			return menu_Principal.getPesoChokoBoom();
	
		}	
	
	}

	// EndRegion	
	
	// Region Calculos del proceso de Venta
	
	private double getImporteCompra(int cantidad){

		switch(cboTipoChoco.getSelectedIndex()){
		
		case 0 ://Tentaci�n
			canVentasTentacion++;
			totalCajasTentacion += cantidad;
			return cantidad * menu_Principal.getPrecioTentacion();
			
		case 1 ://Delicia
			canVentasDelicia++;
			totalCajasDelicia += cantidad;
			return cantidad * menu_Principal.getPrecioDelicia();
			
		case 2 ://Explosi�n
			canVentasExplosion++;
			totalCajasExplosion += cantidad;
			return cantidad * menu_Principal.getPrecioExplosion();
			
		case 3 ://ChokoLoko
			canVentasChokoLoko++;
			totalCajasChokoLoko += cantidad;
			return cantidad * menu_Principal.getPrecioChokoLoko();
			
		default : //ChokoBoom
			totalCajasChokoBoom += cantidad;
			canVentasChokoBoom++;
			return cantidad * menu_Principal.getPrecioChokoBoom();
			
		}	
		
	}
	
	private double getDescuento(int cantidad, double importeCompra){
		if (cantidad <= 5)
			return (importeCompra * menu_Principal.porcDes1)/100;
		else if(cantidad <= 10)
			return (importeCompra * menu_Principal.porcDes2)/100;
		else if(cantidad <= 15)
			return (importeCompra * menu_Principal.porcDes3)/100;
		else 
			return (importeCompra * menu_Principal.porcDes4)/100;
	}
		
	private double getImporteTotal(double importeCompra, double descuento){
	
		double impPago = importeCompra - descuento ;
		
		switch(cboTipoChoco.getSelectedIndex()){
		case 0 : //Tentacion
			totalPagoTentacion += impPago;
			return impPago;
		case 1 : //Delicia
			totalPagoDelicia += impPago;
			return impPago;
		case 2 : //Explosion
			totalPagoExplosion += impPago;
			return impPago;
		case 3 : //ChokoLoko
			totalPagoChokoLoko += impPago;
			return impPago;
		default : //ChokoBoom
			totalPagoChokoBoom += impPago;
			return impPago;
		}
	}
	
	private String getObsequio(double importeTotal){
		
		String obs;
		if(importeTotal>= menu_Principal.IPAGMRO)
			obs = menu_Principal.obsequio;
		else
			obs = " No tiene el Importe de Pago suficiente para obtener un regalo";
		return obs;
	
	}
	//EndRegion
}
