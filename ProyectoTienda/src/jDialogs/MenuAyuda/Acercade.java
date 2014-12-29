package jDialogs.MenuAyuda;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Acercade extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	
	private JButton btnCerrar;
	private JLabel lblTienda;
	private JPanel panel;
	private JLabel lblHechoPor;
	private JLabel lblAutores;
	private JLabel lblLimaPer;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			
			Acercade dialog = new Acercade();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.getContentPane().setLayout(null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Acercade() {
	
		setTitle("Acerca de");
		setModal(true);
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(156, 207, 89, 23);
			contentPanel.add(btnCerrar);
			
		}
		{
			panel = new JPanel();
			panel.setBorder(null);
			panel.setBounds(31, 37, 377, 147);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				lblHechoPor = new JLabel("Hecho por: ");
				lblHechoPor.setBounds(10, 50, 72, 14);
				panel.add(lblHechoPor);
			}
			{
				lblAutores = new JLabel("<html>Miguel Ángel Rojas Coraje"
						+ "	<br>Oscar Zuñiga Leo"
						+ " <br>José Mamani Salas</html>");
				lblAutores.setFont(new Font("Times New Roman", Font.BOLD, 15));
				
				lblAutores.setBounds(105, 43, 245, 65);
				panel.add(lblAutores);
			}
			{
				lblLimaPer = new JLabel("Lima, Per\u00FA, 2015");
				lblLimaPer.setBounds(120, 119, 128, 14);
				panel.add(lblLimaPer);
			}
		}
		{
			lblTienda = new JLabel("Tienda v1.0");
			lblTienda.setBounds(144, 11, 128, 27);
			contentPanel.add(lblTienda);
			lblTienda.setFont(new Font("Tahoma", Font.BOLD, 22));
		}
		
		
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
