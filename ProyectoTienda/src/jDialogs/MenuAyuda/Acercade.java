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
	private JLabel lblNewLabel;
	private JPanel panel;
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
			btnCerrar.setBounds(172, 183, 89, 23);
			contentPanel.add(btnCerrar);
			
		}
		{
			panel = new JPanel();
			panel.setBorder(null);
			panel.setBounds(127, 39, 190, 114);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				lblNewLabel = new JLabel("Tienda v1.0");
				lblNewLabel.setBounds(31, 5, 128, 27);
				panel.add(lblNewLabel);
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
			}
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
