/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Historial;


import Clases.Branch_Office;
import Clases.History;
import Negocio.Branch_OfficeP;
import Negocio.HistoryP;
import Presentacion.Bus.frmBus;
import Presentacion.Config.frmConfig;
import Presentacion.Driver.frmDriver;
import Presentacion.Historial.frmRegistry;
import Presentacion.Home.frmContact;
import Presentacion.Home.frmHome;
import Presentacion.Home.frmManual;
import Presentacion.Money.frmCourtesy;
import Presentacion.Route.frmRoute;
import Presentacion.Trip.frmTrip;
import Presentacion.Users.frmUsers;
import java.awt.Cursor;
import java.awt.Font;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author lalon
 */
public class frmHistory extends javax.swing.JFrame {
    DefaultTableModel modelT = new DefaultTableModel();
    JTable table = new JTable(modelT);

    /**
     * Creates new form frmHistory
     */
    public frmHistory() throws SQLException, ClassNotFoundException {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        llena_combo();
        ModelTableDiscount();        
    }
    private DefaultComboBoxModel modeloOrigen = new DefaultComboBoxModel();
    private List<Branch_Office> sucursales = new ArrayList<Branch_Office>();
    private void llena_combo() throws SQLException, ClassNotFoundException{
        try {
            Branch_OfficeP bop = new Branch_OfficeP();
            modeloOrigen.removeAllElements();              
            modeloOrigen.addElement("Seleccionar");         
            sucursales = bop.getAllBranch_Office();
            if (sucursales != null) {
                sucursales.forEach((viaje) -> {
                    modeloOrigen.addElement(viaje.getNombre()); 
                });
            }
            cbo_sucursal.setModel(modeloOrigen);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar el historial \n"+ e.getMessage(), "ERRPR", JOptionPane.ERROR_MESSAGE);
        }
    } 
    
    void ModelTableDiscount(){
        DefaultTableModel model = new DefaultTableModel();
        table=this.tblBus;
        table.setModel(model);
        
        
        model.setColumnIdentifiers(new Object[]{"Fecha", "Tabla", "Tipo", "Autor", "Sucursal"});
            if (table.getColumnModel().getColumnCount() > 0)
            {
                //Font headers
                table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD,20));
                table.getColumnModel().getColumn(0).setPreferredWidth(100);  
                table.getColumnModel().getColumn(1).setPreferredWidth(100);
                table.getColumnModel().getColumn(2).setPreferredWidth(100);
                table.getColumnModel().getColumn(3).setPreferredWidth(100);
                table.getColumnModel().getColumn(4).setPreferredWidth(100);                  
            }
            
            //database
            List<History> list = new ArrayList<History>();            
            HistoryP up = new HistoryP();            
            try{                
            //Get some users                
            DateFormat df_inicio = new SimpleDateFormat("yyyy-MM-dd");
            Date dt_fecha_inicio = dt_inicio.getDate();
            String inicio = "";
            if (dt_fecha_inicio != null)
                inicio = df_inicio.format(dt_fecha_inicio);
            DateFormat df_fin = new SimpleDateFormat("yyyy-MM-dd");
            Date dt_fecha_fin = dt_final.getDate();
            String fin = "";
            if (dt_fecha_fin != null)
                fin = df_fin.format(dt_fecha_fin);
            int idx_tabla = cbo_tabla.getSelectedIndex();
            String tabla = "";
            if (idx_tabla > 0)
                tabla = String.valueOf(cbo_tabla.getSelectedItem());
            int idx_accion = cbo_accion.getSelectedIndex();
            String accion = ""; 
            if (idx_accion > 0)
                accion = String.valueOf(cbo_accion.getSelectedItem());
            int idx_sucursal = cbo_sucursal.getSelectedIndex();
            int idSucursal = 0;
            if (idx_sucursal > 0){
                idSucursal = sucursales.get(idx_sucursal - 1).getId();
            }
            list = up.searchHistory(inicio, fin, tabla, accion, idSucursal);
            for(int i = 0; i<= list.size()-1; i++){
                 model.addRow(
                         new Object[]{list.get(i).getFecha(), list.get(i).getTabla(), 
                             list.get(i).getAccion(), list.get(i).getAutor(), list.get(i).getSucursal() });                        
            } 

                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error al mostrar el historial \n"+ e.getMessage(), "ERRPR", JOptionPane.ERROR_MESSAGE);
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        NavBar = new javax.swing.JPanel();
        lblBus = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblCortesiaDesc = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        MenuBar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ContentBar = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBus = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbo_tabla = new javax.swing.JComboBox<>();
        dt_inicio = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        dt_final = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        cbo_accion = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        cbo_sucursal = new javax.swing.JComboBox<>();
        IcconBar5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });

        NavBar.setBackground(new java.awt.Color(0, 102, 204));
        NavBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                NavBarMouseMoved(evt);
            }
        });

        lblBus.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblBus.setForeground(new java.awt.Color(255, 255, 255));
        lblBus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Bus.png"))); // NOI18N
        lblBus.setText("Camiones");
        lblBus.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblBusMouseMoved(evt);
            }
        });
        lblBus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBusMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/conductor.png"))); // NOI18N
        jLabel6.setText("Conductores");
        jLabel6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel6MouseMoved(evt);
            }
        });
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/carretera-con-linea-discontinua.png"))); // NOI18N
        jLabel5.setText("Rutas");
        jLabel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel5MouseMoved(evt);
            }
        });
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/chofer.png"))); // NOI18N
        jLabel10.setText("Viajes");
        jLabel10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel10MouseMoved(evt);
            }
        });
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/usuarios-multiples-en-silueta.png"))); // NOI18N
        jLabel7.setText("Usuarios");
        jLabel7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel7MouseMoved(evt);
            }
        });
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/portafolios-con-lapiz (2).png"))); // NOI18N
        jLabel9.setText("Registro e Historial");
        jLabel9.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel9MouseMoved(evt);
            }
        });
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        lblCortesiaDesc.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblCortesiaDesc.setForeground(new java.awt.Color(255, 255, 255));
        lblCortesiaDesc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/etiqueta.png"))); // NOI18N
        lblCortesiaDesc.setText("Cortesías/Descuentos/Dolar");
        lblCortesiaDesc.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblCortesiaDescMouseMoved(evt);
            }
        });
        lblCortesiaDesc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCortesiaDescMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ajustes.png"))); // NOI18N
        jLabel13.setText("Configuración");
        jLabel13.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel13MouseMoved(evt);
            }
        });
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout NavBarLayout = new javax.swing.GroupLayout(NavBar);
        NavBar.setLayout(NavBarLayout);
        NavBarLayout.setHorizontalGroup(
            NavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavBarLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(lblBus)
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addGap(26, 26, 26)
                .addComponent(jLabel5)
                .addGap(26, 26, 26)
                .addComponent(jLabel10)
                .addGap(26, 26, 26)
                .addComponent(jLabel7)
                .addGap(26, 26, 26)
                .addComponent(jLabel9)
                .addGap(26, 26, 26)
                .addComponent(lblCortesiaDesc)
                .addGap(26, 26, 26)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        NavBarLayout.setVerticalGroup(
            NavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavBarLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(NavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBus)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(lblCortesiaDesc)
                    .addComponent(jLabel13))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        MenuBar.setBackground(new java.awt.Color(0, 102, 204));
        MenuBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                MenuBarMouseMoved(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Registro/analisis.png"))); // NOI18N
        jLabel2.setText("REGISTROS");
        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel2MouseMoved(evt);
            }
        });
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Registro/nota.png"))); // NOI18N
        jLabel3.setText("HISTORIAL");
        jLabel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel3MouseMoved(evt);
            }
        });
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MenuBarLayout = new javax.swing.GroupLayout(MenuBar);
        MenuBar.setLayout(MenuBarLayout);
        MenuBarLayout.setHorizontalGroup(
            MenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(93, 93, 93))
            .addGroup(MenuBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MenuBarLayout.setVerticalGroup(
            MenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuBarLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ContentBar.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel8.setText("Historial");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblBus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblBus);

        jButton1.setBackground(new java.awt.Color(0, 102, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/CRUD/lupa-para-buscar.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Desde:");

        cbo_tabla.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbo_tabla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "Seleccionar", "Usuarios", "Viajes", "Rutas", "Conductores","Dolares", "Descuentos", "Cortesias", "Camiones", "Sucursales" }));

jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
jLabel12.setText("Hasta:");

jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
jLabel14.setText("Tabla");

jButton4.setBackground(new java.awt.Color(0, 102, 255));
jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
jButton4.setForeground(new java.awt.Color(255, 255, 255));
jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Registro/impresora.png"))); // NOI18N
jButton4.setText("Imprimir");

jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
jLabel15.setText("Acción");

cbo_accion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
cbo_accion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Crear", "Actualizar", "Eliminar" }));

jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
jLabel16.setText("Sucursal");

cbo_sucursal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
cbo_sucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matehuala", "Texas", "Fuera" }));

javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
jPanel2.setLayout(jPanel2Layout);
jPanel2Layout.setHorizontalGroup(
    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(25, 25, 25)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1157, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dt_final, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dt_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo_tabla, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo_sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbo_accion, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(73, 73, 73)))
        .addContainerGap(149, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
            .addGap(104, 104, 104)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dt_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(cbo_accion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(cbo_sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGap(33, 33, 33)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(dt_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(cbo_tabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addContainerGap(127, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout ContentBarLayout = new javax.swing.GroupLayout(ContentBar);
    ContentBar.setLayout(ContentBarLayout);
    ContentBarLayout.setHorizontalGroup(
        ContentBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(ContentBarLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel8)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(ContentBarLayout.createSequentialGroup()
            .addGap(113, 113, 113)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    ContentBarLayout.setVerticalGroup(
        ContentBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(ContentBarLayout.createSequentialGroup()
            .addGap(55, 55, 55)
            .addComponent(jLabel8)
            .addGap(18, 18, 18)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );

    IcconBar5.setBackground(new java.awt.Color(255, 255, 255));
    IcconBar5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
        public void mouseMoved(java.awt.event.MouseEvent evt) {
            IcconBar5MouseMoved(evt);
        }
    });

    jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Imagen1.png"))); // NOI18N
    jLabel21.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
        public void mouseMoved(java.awt.event.MouseEvent evt) {
            jLabel21MouseMoved(evt);
        }
    });
    jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel21MouseClicked(evt);
        }
    });

    javax.swing.GroupLayout IcconBar5Layout = new javax.swing.GroupLayout(IcconBar5);
    IcconBar5.setLayout(IcconBar5Layout);
    IcconBar5Layout.setHorizontalGroup(
        IcconBar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(IcconBar5Layout.createSequentialGroup()
            .addGap(54, 54, 54)
            .addComponent(jLabel21)
            .addContainerGap(76, Short.MAX_VALUE))
    );
    IcconBar5Layout.setVerticalGroup(
        IcconBar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IcconBar5Layout.createSequentialGroup()
            .addContainerGap(20, Short.MAX_VALUE)
            .addComponent(jLabel21)
            .addContainerGap())
    );

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(MenuBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(IcconBar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ContentBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NavBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(NavBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(IcconBar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ContentBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MenuBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
    );

    jScrollPane1.setViewportView(jPanel1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1479, Short.MAX_VALUE)
            .addGap(0, 0, 0))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
            .addGap(0, 0, 0))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblBusMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBusMouseMoved

        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblBusMouseMoved

    private void lblBusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBusMouseClicked
        frmBus frmB = new frmBus();
        frmB.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblBusMouseClicked

    private void jLabel6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseMoved
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel6MouseMoved

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        frmDriver frmD = new frmDriver();
        frmD.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseMoved
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel5MouseMoved

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        frmRoute frmR = new frmRoute();
        frmR.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel10MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseMoved
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel10MouseMoved

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        try {
            frmTrip frmT = new frmTrip();
            frmT.setVisible(true);
            this.dispose();
        } catch (ParseException ex) {
            Logger.getLogger(frmHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseMoved
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel7MouseMoved

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        frmUsers frmU = new frmUsers();
        frmU.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel9MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseMoved
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel9MouseMoved

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        try {
            frmRegistry frmH = new frmRegistry();
            frmH.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(frmHistory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel9MouseClicked

    private void lblCortesiaDescMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCortesiaDescMouseMoved
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblCortesiaDescMouseMoved

    private void lblCortesiaDescMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCortesiaDescMouseClicked
        frmCourtesy frmC = new frmCourtesy();
        frmC.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblCortesiaDescMouseClicked

    private void jLabel13MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseMoved
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel13MouseMoved

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        frmConfig frmC = new frmConfig();
        frmC.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void NavBarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NavBarMouseMoved
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_NavBarMouseMoved

    private void jLabel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseMoved

        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel2MouseMoved

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        try {
            frmRegistry frmM = new frmRegistry();
            frmM.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(frmHistory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseMoved

        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel3MouseMoved

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        try {
            frmHistory frmC = new frmHistory();
            frmC.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(frmHistory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void MenuBarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuBarMouseMoved
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));        // TODO add your handling code here:
    }//GEN-LAST:event_MenuBarMouseMoved

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jPanel1MouseMoved

    private void jLabel21MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseMoved
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel21MouseMoved

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        frmHome frmH = new frmHome();
        frmH.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void IcconBar5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IcconBar5MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_IcconBar5MouseMoved

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ModelTableDiscount();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContentBar;
    private javax.swing.JPanel IcconBar5;
    private javax.swing.JPanel MenuBar;
    private javax.swing.JPanel NavBar;
    private javax.swing.JComboBox<String> cbo_accion;
    private javax.swing.JComboBox<String> cbo_sucursal;
    private javax.swing.JComboBox<String> cbo_tabla;
    private com.toedter.calendar.JDateChooser dt_final;
    private com.toedter.calendar.JDateChooser dt_inicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBus;
    private javax.swing.JLabel lblCortesiaDesc;
    private javax.swing.JTable tblBus;
    // End of variables declaration//GEN-END:variables
}
