package Frames;

import internalFrames.MenuConfiguracion.CantidadOptima;
import internalFrames.MenuConfiguracion.Descuentos;
import internalFrames.MenuConfiguracion.Obsequio;
import internalFrames.MenuConfiguracion.Precio;
import internalFrames.MenuMantenimiento.ConsultaChocolate;
import internalFrames.MenuMantenimiento.ListarChocolate;
import internalFrames.MenuVentas.GeneracionReporte;
import internalFrames.MenuVentas.VentaChocolate;
import jDialogs.MenuAyuda.Acercade;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

public class menu_Principal extends JFrame implements ActionListener {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JMenuItem mnu_itemSalir;
    private JMenuItem mnu_itemConsultarChoco;
    private JSeparator separatorMante;
    private JSeparator separatorVentas;
    private JDesktopPane desktopPane;
    private JMenuItem mnu_itemListarChoco;
    private JMenuItem mnu_itemVenderChoco;
    private JMenuItem mnu_itemGenerarReporte;
    private JMenuItem mnu_itemDescuentos;
    private JMenuItem mnu_itemPrecios;
    private JMenuItem mnu_itemObsequio;
    private JMenuItem mnu_itemCantidadOptima;
    private JMenuItem mnu_itemAcerca;

    // Region Variables Globales

    // Region Primer tipo de Chocolate
    public static String tipo0 = "Tentación";
    public static int unidades0 = 24;
    public static double peso0 = 720.0;
    public static double precio0 = 50.2;
    // EndRegion
    // Region Segundo tipo de Chocolate
    public static String tipo1 = "Delicia";
    public static int unidades1 = 48;
    public static double peso1 = 2160.0;
    public static double precio1 = 78.5;
    // EndRegion
    // Region Tercer tipo de Chocolate
    public static String tipo2 = "Explosión";
    public static int unidades2 = 36;
    public static double peso2 = 1267.2;
    public static double precio2 = 64.8;
    // EndRegion
    // Region Cuarto tipo de Chocolate
    public static String tipo3 = "ChokoLoko";
    public static int unidades3 = 24;
    public static double peso3 = 1684.8;
    public static double precio3 = 52.8;
    // EndRegion
    // Region Quinto tipo de Chocolate
    public static String tipo4 = "ChokoBoom";
    public static int unidades4 = 24;
    public static double peso4 = 972.0;
    public static double precio4 = 40.8;
    // EndRegion
    // Region Porcentajes
    public static double porcDes1 = 3.0;
    public static double porcDes2 = 4.5;
    public static double porcDes3 = 6.5;
    public static double porcDes4 = 9.0;
    // EndRegion
    // Region Cantidad óptima de Ventas
    public static int COV = 50;
    // EndRegion
    // Region Importe a pagar mínimo para el Obsequio
    public static double IPAGMRO = 350;
    // EndRegion
    // Region Obsequio
    public static String obsequio = "Un lapicero";

    // EndRegion
    // EndRegion

    public static void main(String[] args) {
        new SplashScreen(6000);

        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {

                    menu_Principal frame = new menu_Principal();
                    frame.setVisible(true);
                    frame.setExtendedState(MAXIMIZED_BOTH);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public menu_Principal() {
        setTitle("Men\u00FA Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setForeground(new Color(255, 255, 255));
        menuBar.setBackground(new Color(248, 248, 255));
        setJMenuBar(menuBar);

        JMenu mnu_BarArchivo = new JMenu("Archivo");
        mnu_BarArchivo.setIcon(new ImageIcon(menu_Principal.class
                .getResource("/imagenes/archivo.png")));
        mnu_BarArchivo.setBackground(new Color(248, 248, 255));
        mnu_BarArchivo.setForeground(new Color(0, 0, 0));
        menuBar.add(mnu_BarArchivo);

        mnu_itemSalir = new JMenuItem("Salir", new ImageIcon(
                menu_Principal.class.getResource("/imagenes/door9.png")));
        mnu_itemSalir.setForeground(new Color(0, 0, 0));
        mnu_itemSalir.setBackground(new Color(248, 248, 255));

        mnu_itemSalir.addActionListener(this);
        mnu_BarArchivo.add(mnu_itemSalir);

        JMenu mnu_BarMantenimiento = new JMenu("Mantenimiento");
        mnu_BarMantenimiento.setIcon(new ImageIcon(menu_Principal.class
                .getResource("/imagenes/screwdriver3.png")));
        mnu_BarMantenimiento.setForeground(new Color(0, 0, 0));
        menuBar.add(mnu_BarMantenimiento);

        mnu_itemConsultarChoco = new JMenuItem("Consultar Chocolate");
        mnu_itemConsultarChoco.setIcon(new ImageIcon(menu_Principal.class
                .getResource("/imagenes/search10.png")));
        mnu_itemConsultarChoco.addActionListener(this);
        mnu_BarMantenimiento.add(mnu_itemConsultarChoco);
        {
            separatorMante = new JSeparator();
            mnu_BarMantenimiento.add(separatorMante);
        }

        mnu_itemListarChoco = new JMenuItem("Listar Chocolate");
        mnu_itemListarChoco.addActionListener(this);
        mnu_itemListarChoco.setIcon(new ImageIcon(menu_Principal.class
                .getResource("/imagenes/list40.png")));
        mnu_BarMantenimiento.add(mnu_itemListarChoco);

        JMenu mnu_BarVentas = new JMenu("Ventas");
        mnu_BarVentas.setIcon(new ImageIcon(menu_Principal.class
                .getResource("/imagenes/towels1.png")));
        mnu_BarVentas.setForeground(new Color(0, 0, 0));
        menuBar.add(mnu_BarVentas);

        mnu_itemVenderChoco = new JMenuItem("Vender Chocolates");
        mnu_itemVenderChoco.addActionListener(this);
        mnu_itemVenderChoco.setIcon(new ImageIcon(menu_Principal.class
                .getResource("/imagenes/shopping100.png")));
        mnu_BarVentas.add(mnu_itemVenderChoco);
        {
            separatorVentas = new JSeparator();
            mnu_BarVentas.add(separatorVentas);
        }

        mnu_itemGenerarReporte = new JMenuItem("Generar Reportes");
        mnu_itemGenerarReporte.addActionListener(this);
        mnu_itemGenerarReporte.setIcon(new ImageIcon(menu_Principal.class
                .getResource("/imagenes/increasing5.png")));
        mnu_BarVentas.add(mnu_itemGenerarReporte);

        JMenu mnu_BarConfiguracion = new JMenu("Configuraci\u00F3n");
        mnu_BarConfiguracion.setIcon(new ImageIcon(menu_Principal.class
                .getResource("/imagenes/settings38.png")));
        mnu_BarConfiguracion.setForeground(new Color(0, 0, 0));
        menuBar.add(mnu_BarConfiguracion);

        mnu_itemDescuentos = new JMenuItem("Configurar descuentos");
        mnu_itemDescuentos.addActionListener(this);
        mnu_itemDescuentos.setIcon(new ImageIcon(menu_Principal.class
                .getResource("/imagenes/reduction.png")));
        mnu_BarConfiguracion.add(mnu_itemDescuentos);

        JSeparator separatorConfig1 = new JSeparator();
        mnu_BarConfiguracion.add(separatorConfig1);

        mnu_itemPrecios = new JMenuItem("Configurar precios");
        mnu_itemPrecios.addActionListener(this);
        mnu_itemPrecios.setIcon(new ImageIcon(menu_Principal.class
                .getResource("/imagenes/dollar1.png")));
        mnu_BarConfiguracion.add(mnu_itemPrecios);

        JSeparator separatorConfig2 = new JSeparator();
        mnu_BarConfiguracion.add(separatorConfig2);

        mnu_itemObsequio = new JMenuItem("Configurar obsequio");
        mnu_itemObsequio.addActionListener(this);
        mnu_itemObsequio.setIcon(new ImageIcon(menu_Principal.class
                .getResource("/imagenes/gift41.png")));
        mnu_BarConfiguracion.add(mnu_itemObsequio);

        JSeparator separatorConfig3 = new JSeparator();
        mnu_BarConfiguracion.add(separatorConfig3);

        mnu_itemCantidadOptima = new JMenuItem(
                "Configurar cantidad \u00F3ptima de ventas");
        mnu_itemCantidadOptima.addActionListener(this);
        mnu_itemCantidadOptima.setIcon(new ImageIcon(menu_Principal.class
                .getResource("/imagenes/stack18.png")));
        mnu_BarConfiguracion.add(mnu_itemCantidadOptima);

        JMenu mnu_BarAyuda = new JMenu("Ayuda");
        mnu_BarAyuda.setIcon(new ImageIcon(menu_Principal.class
                .getResource("/imagenes/help.png")));
        mnu_BarAyuda.setForeground(new Color(0, 0, 0));
        menuBar.add(mnu_BarAyuda);

        mnu_itemAcerca = new JMenuItem("Acerca de Tienda");
        mnu_itemAcerca.addActionListener(this);
        mnu_itemAcerca.setIcon(new ImageIcon(menu_Principal.class
                .getResource("/imagenes/chocolate.png")));
        mnu_BarAyuda.add(mnu_itemAcerca);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        {
            desktopPane = new JDesktopPane();
            desktopPane.setBounds(0, 0, 0, 0);
            desktopPane.setBackground(Color.gray);
            contentPane.add(desktopPane);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mnu_itemAcerca) {
            do_mnu_itemAcerca_actionPerformed(e);
        }
        if (e.getSource() == mnu_itemCantidadOptima) {
            do_mnu_itemCantidadOptima_actionPerformed(e);
        }
        if (e.getSource() == mnu_itemObsequio) {
            do_mnu_itemObsequio_actionPerformed(e);
        }
        if (e.getSource() == mnu_itemPrecios) {
            do_mnu_itemPrecios_actionPerformed(e);
        }
        if (e.getSource() == mnu_itemDescuentos) {
            do_mnu_itemDescuentos_actionPerformed(e);
        }
        if (e.getSource() == mnu_itemGenerarReporte) {
            do_mnu_itemGenerarReporte_actionPerformed(e);
        }
        if (e.getSource() == mnu_itemVenderChoco) {
            do_mnu_itemVenderChoco_actionPerformed(e);
        }
        if (e.getSource() == mnu_itemListarChoco) {
            do_mnu_itemListarChoco_actionPerformed(e);
        }
        if (e.getSource() == mnu_itemConsultarChoco) {
            do_mntmConsultarChocolate_actionPerformed(e);
        }
        if (e.getSource() == mnu_itemSalir) {
            do_mntmNewMenuItem_actionPerformed(e);
        }
    }

    protected void do_mntmNewMenuItem_actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    protected void do_mntmConsultarChocolate_actionPerformed(ActionEvent e) {
        ConsultaChocolate frmConsulta = ConsultaChocolate.getInstance();
        AbrirFormulario(frmConsulta);
    }

    protected void do_mnu_itemListarChoco_actionPerformed(ActionEvent e) {
        ListarChocolate frmListarChoco = ListarChocolate.getInstance();
        AbrirFormulario(frmListarChoco);
    }

    private void AbrirFormulario(JInternalFrame IE) {
        boolean flag = false;
        for (JInternalFrame jInternalFrame : desktopPane.getAllFrames()) {
            if (IE.getTitle() == jInternalFrame.getTitle()) {
                flag = true;
                break;
            }
        }

        if (flag == false) {
            desktopPane.add(IE);
        }

        IE.setVisible(true);
        IE.setLocation(0, 0);
        IE.moveToFront();
    }

    protected void do_mnu_itemVenderChoco_actionPerformed(ActionEvent e) {

        VentaChocolate frmVentaChocolate = VentaChocolate.getInstance();
        AbrirFormulario(frmVentaChocolate);
    }

    protected void do_mnu_itemGenerarReporte_actionPerformed(ActionEvent e) {
        GeneracionReporte frmGeneraReporte = GeneracionReporte.getInstance();
        AbrirFormulario(frmGeneraReporte);
    }

    protected void do_mnu_itemDescuentos_actionPerformed(ActionEvent e) {
        Descuentos frmConfigurarDescuentos = Descuentos.getInstance();
        AbrirFormulario(frmConfigurarDescuentos);

    }

    protected void do_mnu_itemPrecios_actionPerformed(ActionEvent e) {
        Precio frmConfigurarPrecio = Precio.getInstance();
        AbrirFormulario(frmConfigurarPrecio);
    }

    protected void do_mnu_itemObsequio_actionPerformed(ActionEvent e) {
        Obsequio frmConfigurarObsequio = Obsequio.getInstance();
        AbrirFormulario(frmConfigurarObsequio);
    }

    protected void do_mnu_itemCantidadOptima_actionPerformed(ActionEvent e) {
        CantidadOptima frmConfigurarCanOptima = CantidadOptima.getInstance();
        AbrirFormulario(frmConfigurarCanOptima);
    }

    protected void do_mnu_itemAcerca_actionPerformed(ActionEvent e) {
        Acercade jdlg = new Acercade();

        jdlg.setLocationRelativeTo(this);

        jdlg.setVisible(true);

    }

    // Region Getters

    // Region Obtener Tipos de Chocolate

    // Region Datos Tentación

    public static String getTipoTentacion() {
        return menu_Principal.tipo0;
    }

    public static int getUnidadesTentacion() {
        return menu_Principal.unidades0;
    }

    public static double getPesoTentacion() {
        return menu_Principal.peso0;
    }

    public static double getPrecioTentacion() {
        return menu_Principal.precio0;
    }

    // EndRegion

    // Region Datos Delicia

    public static String getTipoDelicia() {
        return menu_Principal.tipo1;
    }

    public static int getUnidadesDelicia() {
        return menu_Principal.unidades1;
    }

    public static double getPesoDelicia() {
        return menu_Principal.peso1;
    }

    public static double getPrecioDelicia() {
        return menu_Principal.precio1;
    }

    // EndRegion

    // Region Datos Explosión

    public static String getTipoExplosion() {
        return menu_Principal.tipo2;
    }

    public static int getUnidadesExplosion() {
        return menu_Principal.unidades2;
    }

    public static double getPesoExplosion() {
        return menu_Principal.peso2;
    }

    public static double getPrecioExplosion() {
        return menu_Principal.precio2;
    }

    // EndRegion

    // Region Datos ChokoLoko

    public static String getTipoChokoLoko() {
        return menu_Principal.tipo3;
    }

    public static int getUnidadesChokoLoko() {
        return menu_Principal.unidades3;
    }

    public static double getPesoChokoLoko() {
        return menu_Principal.peso3;
    }

    public static double getPrecioChokoLoko() {
        return menu_Principal.precio3;
    }

    // EndRegion

    // Region Datos ChokoBoom

    public static String getTipoChokoBoom() {
        return menu_Principal.tipo4;
    }

    public static int getUnidadesChokoBoom() {
        return menu_Principal.unidades4;
    }

    public static double getPesoChokoBoom() {
        return menu_Principal.peso4;
    }

    public static double getPrecioChokoBoom() {
        return menu_Principal.precio4;
    }

    // EndRegion

    // EndRegion

    // Region Porcentajes de descuento

    public static double getDescuento1a5() {
        return porcDes1;
    }

    public static double getDescuento6a10() {
        return porcDes2;
    }

    public static double getDescuento11a15() {
        return porcDes3;
    }

    public static double getDescuento15aMas() {
        return porcDes4;
    }

    // EndRegion

    // Region Método para dar formato con 2 decimales a un valor

    public static String formatoDecimal(double Value) {

        return String.format("%.2f", Value);

    }

    // EndRegion

    // Region Método que devuelve el promedio de los precios de los chocolates

    public static double PromedioPrecioChocolate() {

        return (precio0 + precio1 + precio2 + precio3 + precio4) / 5;

    }

    // EndRegion

    // Region Método que devuelve el menor precio de los chocolates

    public static double MenorPrecioChocolate() {
        double menor = 0;

        if (menor < precio0)
            menor = precio0;

        if (menor > precio1)
            menor = precio1;

        if (menor > precio2)
            menor = precio2;

        if (menor > precio3)
            menor = precio3;

        if (menor > precio4)
            menor = precio4;

        return menor;
    }

    // EndRegion

    // Region Método que devuelve el mayor precio de lso chocolates

    public static double MayorPrecioChocolate() {

        double mayor = 0;

        if (mayor < precio0)
            mayor = precio0;

        if (mayor < precio1)
            mayor = precio1;

        if (mayor < precio2)
            mayor = precio2;

        if (mayor < precio3)
            mayor = precio3;

        if (mayor < precio4)
            mayor = precio4;

        return mayor;

    }

    // EndRegion

    // Region Validar que sólo se acepten ciertos caracteres definidos en el
    // método sin retorno

    public void validarCampoNumerico(KeyEvent arg0) {

        String c1 = String.valueOf(arg0.getKeyChar());
        if (!(c1.matches("[0-9.,]"))) {
            arg0.consume();
            getToolkit().beep();
        }
    }

    // EndRegion

}
