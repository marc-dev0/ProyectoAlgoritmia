package internalFrames.MenuVentas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
        setFrameIcon(new ImageIcon(
                GeneracionReporte.class
                        .getResource("/imagenes/increasing5.png")));
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
            cboTipoReporte.setModel(new DefaultComboBoxModel(new String[] {
                    "Ventas por chocolate", "Chocolates con venta \u00F3ptima",
                    "Chocolates con precios inferiores al precio promedio",
                    "Chocolates con precios superiores al precio promedio",
                    "Precios promedio, menor y mayor" }));
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

    public static GeneracionReporte getInstance() {
        if (instance == null) {
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

        double importeTotal = VentaChocolate.totalPagoChokoBoom
                + VentaChocolate.totalPagoChokoLoko
                + VentaChocolate.totalPagoDelicia
                + VentaChocolate.totalPagoExplosion
                + VentaChocolate.totalPagoTentacion;

        switch (cboTipoReporte.getSelectedIndex()) {

            case 0: // Ventas por Chocolate
                txtReporte.setText("");
                imprimirVentasPorChocolate(menu_Principal.getTipoTentacion(),
                        VentaChocolate.canVentasTentacion,
                        VentaChocolate.totalCajasTentacion,
                        VentaChocolate.totalPagoTentacion);
                imprimirVentasPorChocolate(menu_Principal.getTipoDelicia(),
                        VentaChocolate.canVentasDelicia,
                        VentaChocolate.totalCajasDelicia,
                        VentaChocolate.totalPagoDelicia);
                imprimirVentasPorChocolate(menu_Principal.getTipoExplosion(),
                        VentaChocolate.canVentasExplosion,
                        VentaChocolate.totalCajasExplosion,
                        VentaChocolate.totalPagoExplosion);
                imprimirVentasPorChocolate(menu_Principal.getTipoChokoLoko(),
                        VentaChocolate.canVentasChokoLoko,
                        VentaChocolate.totalCajasChokoLoko,
                        VentaChocolate.totalPagoChokoLoko);
                imprimirVentasPorChocolate(menu_Principal.getTipoChokoBoom(),
                        VentaChocolate.canVentasChokoBoom,
                        VentaChocolate.totalCajasChokoBoom,
                        VentaChocolate.totalPagoChokoBoom);
                txtReporte.append("Importe total Acumulado General: \t"
                        + menu_Principal.formatoDecimal(importeTotal));
                break;

            case 1: // Chocolates con Venta �ptima
                txtReporte.setText("");
                imprimirVentaOptima();
                break;

            case 2: // Chocolates con precios superiores al precio promedio
                txtReporte.setText("");
                imprimirChocolateSuperiorPromedio();
                break;
            case 3: // Chocolates con precios inferiores al precio promedio
                txtReporte.setText("");
                imprimirChocolateInferiorPromedio();
                break;

            default: // ChokoBoom
                txtReporte.setText("");
                imprimiPrecioProMenorMayor();

        }

    }

    // Region M�todos para Imprimir Reportes

    private void imprimirVentasPorChocolate(String tipo, int cantidadVentas,
            int cantidadCajas, double importeTotal) {

        txtReporte.append("VENTAS POR CHOCOLATE\n\n");
        txtReporte.append("Tipo\t\t:\t" + tipo);
        txtReporte.append("\nCantidad de Ventas\t:\t" + cantidadVentas);
        txtReporte.append("\nCantidad total de Cajas Vendidas:\t"
                + cantidadCajas);
        txtReporte.append("\nImporte Total Acumulado\t:\t"
                + menu_Principal.formatoDecimal(importeTotal));
        txtReporte.append("\n\n");

    }

    private void imprimirVentaOptima() {

        txtReporte.setText("CHOCOLATE CON VENTA �PTIMA\n\n");

        if (VentaChocolate.totalCajasTentacion >= menu_Principal.COV) {

            txtReporte
                    .append("Tipo\t\t:\t" + menu_Principal.getTipoTentacion());
            txtReporte.append("\nCantidad de Cajas Vendidas\t:\t"
                    + VentaChocolate.totalCajasTentacion);
            txtReporte.append("\n\n");

        } else {
            txtReporte
                    .append("\nTentaci�n: A�n no llega a la cantidad �ptima de venta");
            txtReporte.append("\n\n");

        }
        if (VentaChocolate.totalCajasDelicia >= menu_Principal.COV) {

            txtReporte.append("Tipo\t\t:\t" + menu_Principal.getTipoDelicia());
            txtReporte.append("\nCantidad de Cajas Vendidas\t:\t"
                    + VentaChocolate.totalCajasDelicia);
            txtReporte.append("\n\n");

        } else {
            txtReporte
                    .append("\nDelicia: A�n no llega a la cantidad �ptima de venta");
            txtReporte.append("\n\n");

        }

        if (VentaChocolate.totalCajasExplosion >= menu_Principal.COV) {

            txtReporte
                    .append("Tipo\t\t:\t" + menu_Principal.getTipoExplosion());
            txtReporte.append("\nCantidad de Cajas Vendidas\t:\t"
                    + VentaChocolate.totalCajasExplosion);
            txtReporte.append("\n\n");

        } else {
            txtReporte
                    .append("\nExplosi�n: A�n no llega a la cantidad �ptima de venta");
            txtReporte.append("\n\n");

        }

        if (VentaChocolate.totalCajasChokoLoko >= menu_Principal.COV) {

            txtReporte
                    .append("Tipo\t\t:\t" + menu_Principal.getTipoChokoLoko());
            txtReporte.append("\nCantidad de Cajas Vendidas\t:\t"
                    + VentaChocolate.totalCajasChokoLoko);
            txtReporte.append("\n\n");

        } else {
            txtReporte
                    .append("\nChokoLoko: A�n no llega a la cantidad �ptima de venta");
            txtReporte.append("\n\n");

        }

        if (VentaChocolate.totalCajasChokoBoom >= menu_Principal.COV) {

            txtReporte
                    .append("Tipo\t\t:\t" + menu_Principal.getTipoChokoBoom());
            txtReporte.append("\nCantidad de Cajas Vendidas\t:\t"
                    + VentaChocolate.totalCajasChokoBoom);
            txtReporte.append("\n\n");

        } else {
            txtReporte
                    .append("\nChokoboom: A�n no llega a la cantidad �ptima de venta");
            txtReporte.append("\n\n");

        }

    }

    private void imprimirChocolateSuperiorPromedio() {

        double promedio = menu_Principal.PromedioPrecioChocolate();

        txtReporte
                .setText("CHOCOLATES CON PRECIOS SUPERIORES AL PRECIO PROMEDIO\n");

        if (menu_Principal.precio0 > promedio) // Precio Tentaci�n
            txtReporte.append("\n" + menu_Principal.getTipoTentacion());

        if (menu_Principal.precio1 > promedio) // Precio Delicia
            txtReporte.append("\n" + menu_Principal.getTipoDelicia());

        if (menu_Principal.precio2 > promedio) // Precio Explosi�n
            txtReporte.append("\n" + menu_Principal.getTipoExplosion());

        if (menu_Principal.precio3 > promedio) // Precio ChokoLoko
            txtReporte.append("\n" + menu_Principal.getTipoChokoLoko());

        if (menu_Principal.precio4 > promedio) // Chokoboom
            txtReporte.append("\n" + menu_Principal.getTipoChokoBoom());

        txtReporte.append("\n\nPrecio Promedio:\t" + "S/. " + promedio);
    }

    private void imprimirChocolateInferiorPromedio() {

        double promedio = menu_Principal.PromedioPrecioChocolate();

        txtReporte
                .setText("CHOCOLATES CON PRECIOS SUPERIORES AL PRECIO PROMEDIO\n");

        if (menu_Principal.precio0 < promedio) // Precio Tentaci�n
            txtReporte.append("\n" + menu_Principal.getTipoTentacion());

        if (menu_Principal.precio1 < promedio) // Precio Delicia
            txtReporte.append("\n" + menu_Principal.getTipoDelicia());

        if (menu_Principal.precio2 < promedio) // Precio Explosi�n
            txtReporte.append("\n" + menu_Principal.getTipoExplosion());

        if (menu_Principal.precio3 < promedio) // Precio ChokoLoko
            txtReporte.append("\n" + menu_Principal.getTipoChokoLoko());

        if (menu_Principal.precio4 < promedio) // Chokoboom
            txtReporte.append("\n" + menu_Principal.getTipoChokoBoom());

        txtReporte.append("\n\nPrecio Promedio:\t" + "S/. " + promedio);
    }

    private void imprimiPrecioProMenorMayor() {

        txtReporte.setText("PRECIO PROMEDIO, MENOR Y MAYOR\n\n");
        txtReporte.append("Precio Promedio\t:\t"
                + menu_Principal.formatoDecimal(menu_Principal
                        .PromedioPrecioChocolate()));
        txtReporte.append("\nPrecio Menor\t\t:\t"
                + menu_Principal.formatoDecimal(menu_Principal
                        .MenorPrecioChocolate()));
        txtReporte.append("\nPrecio Mayor\t\t:\t"
                + menu_Principal.formatoDecimal(menu_Principal
                        .MayorPrecioChocolate()));
    }

    // EndRegion

}
