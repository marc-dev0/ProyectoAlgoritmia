package internalFrames.MenuMantenimiento;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import Frames.menu_Principal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarChocolate extends JInternalFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTextArea txtListado;
	private JButton btnCerrar;
	private JButton btnListar;

	private static ListarChocolate instance = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarChocolate frame = new ListarChocolate();
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
	private ListarChocolate() {
		setFrameIcon(new ImageIcon(ListarChocolate.class.getResource("/imagenes/list40.png")));
		setTitle("Listado de Chocolates");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 414, 179);
			getContentPane().add(scrollPane);
			{
				txtListado = new JTextArea();
				scrollPane.setViewportView(txtListado);
			}
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(251, 212, 89, 23);
			getContentPane().add(btnCerrar);
		}
		{
			btnListar = new JButton("Listar");
			btnListar.addActionListener(this);
			btnListar.setBounds(152, 212, 89, 23);
			getContentPane().add(btnListar);
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			do_btnListar_actionPerformed(e);
		}
		if (e.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(e);
		}
	}
	protected void do_btnCerrar_actionPerformed(ActionEvent e) {
		dispose();
	}
	
	public static ListarChocolate getInstance(){
		
		if (instance == null){
			instance = new ListarChocolate();
		}
		
		return instance;
		
	}
	
	// Region Método para dar formato con 2 decimales a un valor

	private String formatoDecimal(double Value){
		
		return String.format("%.2f", Value);
		
	}
	
	// EndRegion
	
	// Region Método que recibe el tipo, las unidades, precio y peso de los productos de la Tienda y los agrega al JTextArea
			
	private void imprimir(String tipo, double unidades, double precio, double peso){
		
		txtListado.append("\nTipo\t\t:\t" + tipo);
		txtListado.append("\nUnidades por caja\t:\t" + formatoDecimal(unidades));
		txtListado.append("\nPrecio por caja\t\t:\t" + "S/." + formatoDecimal(precio));
		txtListado.append("\nPeso por caja\t\t:\t" + formatoDecimal(peso));
		txtListado.append("\n");
	}
	
	//EndRegion
	
	protected void do_btnListar_actionPerformed(ActionEvent e) {
		
		txtListado.setText("LISTADO DE CHOCOLATES\n");
		
		imprimir(menu_Principal.tipo0,menu_Principal.unidades0,
				menu_Principal.precio0, menu_Principal.peso0);
		
		imprimir(menu_Principal.tipo1,menu_Principal.unidades1,
				menu_Principal.precio1, menu_Principal.peso1);
		
		imprimir(menu_Principal.tipo2,menu_Principal.unidades2,
				menu_Principal.precio2, menu_Principal.peso2);
		
		imprimir(menu_Principal.tipo3,menu_Principal.unidades3,
				menu_Principal.precio3, menu_Principal.peso3);
		
		imprimir(menu_Principal.tipo4,menu_Principal.unidades4,
				menu_Principal.precio4, menu_Principal.peso4);
		
	}
}
