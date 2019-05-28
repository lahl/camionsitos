/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Driver;

import Clases.Bus;
import Clases.Driver;
import Negocio.DriverP;
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
import com.autobuses.clases.utils.Sesion;
import com.placeholder.PlaceHolder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lalon
 */
public final class frmDriverRUD extends javax.swing.JFrame {
    DefaultTableModel modelT = new DefaultTableModel();
    JTable table = new JTable(modelT);
    
    Driver d;

    /**
     * Creates new form frmDriverRUD
     */
    public frmDriverRUD() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ModelTableDiscount("null");

        
        //HolderData
        PlaceHolder holder = new PlaceHolder(txtBuscarDriver, Color.GRAY, Color.BLACK, "Nombre", rootPaneCheckingEnabled, Font.SERIF , 18);
        txtBuscarDriver.setFont(new java.awt.Font("Tahoma", 0, 18));
    }
    
    
    void ModelTableDiscount(String something){
        DriverP dp = new DriverP(); 
        DefaultTableModel model = new DefaultTableModel();
        table=this.tblDriver;
        table.setModel(model);
        
        //Disable drag columns
        table.getTableHeader().setReorderingAllowed(false);
        
        model.setColumnIdentifiers(new Object[]{"id","Nombre","Teléfono", "Licencia", "Correo", "Domicilio", "Fecha N.", "AP Inicio","AP Fin",
            "Contrato I.", "Contrato F."});
            if (table.getColumnModel().getColumnCount() > 0)
            {
                //Hide ID Column
                table.getColumnModel().getColumn(0).setMinWidth(0);
                table.getColumnModel().getColumn(0).setMaxWidth(0);
                //Font headers
                table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD,20));


                table.getColumnModel().getColumn(1).setPreferredWidth(200);
                table.getColumnModel().getColumn(2).setPreferredWidth(100);
                table.getColumnModel().getColumn(3).setPreferredWidth(150);
                table.getColumnModel().getColumn(4).setPreferredWidth(150);
                table.getColumnModel().getColumn(5).setPreferredWidth(100);
                table.getColumnModel().getColumn(6).setPreferredWidth(100);
                table.getColumnModel().getColumn(7).setPreferredWidth(100);
                table.getColumnModel().getColumn(8).setPreferredWidth(100);
                table.getColumnModel().getColumn(9).setPreferredWidth(120);
                
                
                
                
            
            }
            System.out.println(txtBuscarDriver.getText());
             //Data RES
        
        
        
        List<Driver> listB = new ArrayList<Driver>();
        List<Driver> listC = new ArrayList<Driver>();
        List<Driver> listD = new ArrayList<Driver>();
         try{

            
            
            
            
        if( something == "null"){
            listB =  dp.getAllDrivers();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
            for(int i = 0; i<=listB.size()-1;i++){
            model.addRow(new Object[]{listB.get(i).getId(), listB.get(i).getName(), listB.get(i).getCel(), listB.get(i).getLicense(), listB.get(i).getEmail(),
                listB.get(i).getAddres(),sdf.format(listB.get(i).getBirthDate()), sdf.format(listB.get(i).getApStart()), sdf.format(listB.get(i).getApEnd()),
                sdf.format(listB.get(i).getContractDateStart()), sdf.format(listB.get(i).getContractDateEnd())});
                System.out.println("Encontrado en B");
        }
            
        }

              if(something =="search"){
                  DriverP dp2 = new DriverP();
                  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                  
                  listC = dp2.searchDriver(txtBuscarDriver.getText());
                  System.out.println(txtBuscarDriver.getText());
            for(int i = 0; i<=listC.size()-1;i++){
                System.out.println("Encontrado en C");
                model.addRow(new Object[]{listC.get(i).getId(), listC.get(i).getName(), listC.get(i).getCel(), listC.get(i).getLicense(), listC.get(i).getEmail(),
                listC.get(i).getAddres(),sdf.format(listC.get(i).getBirthDate()), sdf.format(listC.get(i).getApStart()), sdf.format(listC.get(i).getApEnd()),
                sdf.format(listC.get(i).getContractDateStart()), sdf.format(listC.get(i).getContractDateEnd())});
        }
    
             if( "Nombre".equals(txtBuscarDriver.getText())){
                 
                 listD =  dp.getAllDrivers();
            for(int i = 0; i<=listD.size()-1;i++){
            model.addRow(new Object[]{listD.get(i).getId(), listD.get(i).getName(), listD.get(i).getCel(), listD.get(i).getLicense(), listD.get(i).getEmail(),
                listD.get(i).getAddres(),sdf.format(listD.get(i).getBirthDate()), sdf.format(listD.get(i).getApStart()), sdf.format(listD.get(i).getApEnd()),
                sdf.format(listD.get(i).getContractDateStart()), sdf.format(listD.get(i).getContractDateEnd())});
                System.out.println("Encontrado en D");
        }
            
        }
        }
         
         
         }
         catch(Exception e){
            System.out.println("Erro al cargar datos tabla (ModelTableBus): "+e.getMessage());
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDriver = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtBuscarDriver = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        IcconBar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

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
                .addContainerGap(52, Short.MAX_VALUE))
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
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/CRUD/boton-redondo-de-agregar.png"))); // NOI18N
        jLabel2.setText("AGREGAR");
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
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/CRUD/instrumentos.png"))); // NOI18N
        jLabel3.setText("BUS/ELI/ACT");
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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblDriver.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDriver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDriverMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDriver);

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
        jLabel4.setText("Buscar:");

        txtBuscarDriver.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jButton2.setBackground(new java.awt.Color(0, 102, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/CRUD/boton-actualizar.png"))); // NOI18N
        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 102, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/CRUD/cubo-de-basura.png"))); // NOI18N
        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel8.setText("Conductores");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(479, 479, 479)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(38, 38, 38)
                                .addComponent(jButton2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscarDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(560, 560, 560)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBuscarDriver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout ContentBarLayout = new javax.swing.GroupLayout(ContentBar);
        ContentBar.setLayout(ContentBarLayout);
        ContentBarLayout.setHorizontalGroup(
            ContentBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContentBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ContentBarLayout.setVerticalGroup(
            ContentBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContentBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        IcconBar.setBackground(new java.awt.Color(255, 255, 255));
        IcconBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                IcconBarMouseMoved(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Imagen1.png"))); // NOI18N
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel1MouseMoved(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout IcconBarLayout = new javax.swing.GroupLayout(IcconBar);
        IcconBar.setLayout(IcconBarLayout);
        IcconBarLayout.setHorizontalGroup(
            IcconBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IcconBarLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        IcconBarLayout.setVerticalGroup(
            IcconBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IcconBarLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IcconBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(IcconBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ContentBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
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
            Logger.getLogger(frmDriverRUD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(frmDriverRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmDriverRUD.class.getName()).log(Level.SEVERE, null, ex);
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
        frmDriver frmU = new frmDriver();
        frmU.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseMoved

        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel3MouseMoved

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        frmDriverRUD frmC = new frmDriverRUD();
        frmC.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void MenuBarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuBarMouseMoved
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));        // TODO add your handling code here:
    }//GEN-LAST:event_MenuBarMouseMoved

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jPanel1MouseMoved

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
        if(txtBuscarDriver.getText().equals("Nombre")){
            JOptionPane.showMessageDialog(null, "Por favor escribe un nombre a encontrar");
        }else{
            ModelTableDiscount("search");
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            DriverP dp = new DriverP();
            dp.updateDriver(d, Sesion.getId());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            
        }
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblDriverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDriverMouseClicked
        if(evt.getButton()==1){
            try{
                 int fila = tblDriver.getSelectedRow();
            
            if(fila > -1){
                
                String id = (String.valueOf(tblDriver.getValueAt(fila, 0)));
                String name= (String.valueOf(tblDriver.getValueAt(fila, 1)));
                String cel = (String.valueOf(tblDriver.getValueAt(fila, 2)));      
                  
                    String pattern = "yyyy-MM-dd";
                    SimpleDateFormat formatter = new SimpleDateFormat(pattern);

                    String birthDate = (String.valueOf(tblDriver.getValueAt(fila, 6)));         
                    Date dbd = formatter.parse(birthDate);

                    String license =(String.valueOf(tblDriver.getValueAt(fila, 3)));


                    String apStart = (String.valueOf(tblDriver.getValueAt(fila, 7)));
                    Date das= formatter.parse(apStart);

                    String apEnd = (String.valueOf(tblDriver.getValueAt(fila, 8)));
                    Date dae= formatter.parse(apEnd);

                    String email=(String.valueOf(tblDriver.getValueAt(fila, 4)));

                    String contractStart=(String.valueOf(tblDriver.getValueAt(fila, 9)));
                    Date dcs= formatter.parse(contractStart);

                    String contractEnd=(String.valueOf(tblDriver.getValueAt(fila, 10)));
                    Date dce= formatter.parse(contractEnd);

                    String addres =(String.valueOf(tblDriver.getValueAt(fila, 5)));

                    d  = new Driver();

                    d.setId(Integer.parseInt(id));
                    d.setAddres(addres);
                    d.setApEnd(dae);
                    d.setApStart(das);
                    d.setBirthDate(dbd);
                    d.setCel(cel);
                    d.setContractDateEnd(dce);
                    d.setContractDateStart(dcs);
                    d.setEmail(email);
                    d.setLicense(license);
                    d.setName(name);
                    

            }
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error al seleccionar: "+e, "ERROR", JOptionPane.ERROR_MESSAGE);
                
            }
           
        }
    }//GEN-LAST:event_tblDriverMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
            
            DriverP dp = new DriverP();
            int res=JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar ese dato?", "Confirmar Acción", JOptionPane.YES_NO_OPTION);
        
            if(res==0){

                dp.deleteDriver(d.getId());
                ModelTableDiscount("null");

            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseMoved
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel1MouseMoved

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        frmHome frmH = new frmHome();
        frmH.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void IcconBarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IcconBarMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_IcconBarMouseMoved
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContentBar;
    private javax.swing.JPanel IcconBar;
    private javax.swing.JPanel MenuBar;
    private javax.swing.JPanel NavBar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JTable tblDriver;
    private javax.swing.JTextField txtBuscarDriver;
    // End of variables declaration//GEN-END:variables
}
