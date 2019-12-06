package lab8_gabrielvasquez;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
        cargarTabla();
    }

    public final void cargarTabla() {
        log.conectar();
        try {
            log.query.execute("SELECT Nombre,Edad,Teléfono,Correo,Dirección FROM Contactos");

            ResultSet rs = log.query.getResultSet();

            DefaultTableModel modelo = (DefaultTableModel) contact_table.getModel();

            while (rs.next()) {
                Object[] row = new Object[5];
                for (int i = 0; i < row.length; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                modelo.addRow(row);

                Contacto c = new Contacto(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
                contactos.add(c);
            }

            contact_table.setModel(modelo);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        log.desconectar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jd_newContact = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nc_name = new javax.swing.JTextField();
        nc_mail = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        nc_dir = new javax.swing.JTextArea();
        b_saveNew = new javax.swing.JButton();
        nc_phone = new javax.swing.JFormattedTextField();
        nc_edad = new javax.swing.JSpinner();
        jd_modContact = new javax.swing.JDialog();
        jScrollPane3 = new javax.swing.JScrollPane();
        mc_dir = new javax.swing.JTextArea();
        b_modifyC = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        mc_phone = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        mc_edad = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        mc_name = new javax.swing.JTextField();
        mc_mail = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        contact_table = new javax.swing.JTable();
        b_newContact = new javax.swing.JButton();
        b_modContact = new javax.swing.JButton();
        b_deleteContact = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nuevo Contacto");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel3.setText("Edad");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel4.setText("Número de Teléfono");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel5.setText("Correo Electrónico");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel6.setText("Dirección");

        nc_name.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        nc_mail.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        nc_dir.setColumns(20);
        nc_dir.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        nc_dir.setRows(5);
        jScrollPane2.setViewportView(nc_dir);

        b_saveNew.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        b_saveNew.setText("Guardar");
        b_saveNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_saveNewMouseClicked(evt);
            }
        });

        try {
            nc_phone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        nc_edad.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        nc_edad.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        javax.swing.GroupLayout jd_newContactLayout = new javax.swing.GroupLayout(jd_newContact.getContentPane());
        jd_newContact.getContentPane().setLayout(jd_newContactLayout);
        jd_newContactLayout.setHorizontalGroup(
            jd_newContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_newContactLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jd_newContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jd_newContactLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jd_newContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jd_newContactLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jd_newContactLayout.createSequentialGroup()
                                .addGroup(jd_newContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(79, 79, 79)
                                .addGroup(jd_newContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nc_mail)
                                    .addComponent(nc_name)
                                    .addComponent(nc_phone)
                                    .addGroup(jd_newContactLayout.createSequentialGroup()
                                        .addComponent(nc_edad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jd_newContactLayout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(b_saveNew)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jd_newContactLayout.setVerticalGroup(
            jd_newContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_newContactLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jd_newContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nc_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jd_newContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nc_edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jd_newContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nc_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jd_newContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nc_mail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jd_newContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(b_saveNew, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        mc_dir.setColumns(20);
        mc_dir.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        mc_dir.setRows(5);
        jScrollPane3.setViewportView(mc_dir);

        b_modifyC.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        b_modifyC.setText("Cambiar");
        b_modifyC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_modifyCMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Modificar Contacto");

        try {
            mc_phone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel8.setText("Nombre");

        mc_edad.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        mc_edad.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel9.setText("Edad");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel10.setText("Número de Teléfono");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel11.setText("Correo Electrónico");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel12.setText("Dirección");

        mc_name.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        mc_mail.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        javax.swing.GroupLayout jd_modContactLayout = new javax.swing.GroupLayout(jd_modContact.getContentPane());
        jd_modContact.getContentPane().setLayout(jd_modContactLayout);
        jd_modContactLayout.setHorizontalGroup(
            jd_modContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_modContactLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jd_modContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jd_modContactLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jd_modContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jd_modContactLayout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jd_modContactLayout.createSequentialGroup()
                                .addGroup(jd_modContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(79, 79, 79)
                                .addGroup(jd_modContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mc_mail)
                                    .addComponent(mc_name)
                                    .addComponent(mc_phone)
                                    .addGroup(jd_modContactLayout.createSequentialGroup()
                                        .addComponent(mc_edad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jd_modContactLayout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(b_modifyC)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jd_modContactLayout.setVerticalGroup(
            jd_modContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_modContactLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jd_modContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mc_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jd_modContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mc_edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jd_modContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mc_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jd_modContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mc_mail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jd_modContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(b_modifyC, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 986, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Personal", jPanel1);

        contact_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Edad", "Teléfono", "Correo", "Dirección"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(contact_table);
        if (contact_table.getColumnModel().getColumnCount() > 0) {
            contact_table.getColumnModel().getColumn(0).setResizable(false);
            contact_table.getColumnModel().getColumn(1).setResizable(false);
            contact_table.getColumnModel().getColumn(2).setResizable(false);
            contact_table.getColumnModel().getColumn(3).setResizable(false);
            contact_table.getColumnModel().getColumn(4).setResizable(false);
        }

        b_newContact.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        b_newContact.setText("Nuevo Contacto");
        b_newContact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_newContactMouseClicked(evt);
            }
        });

        b_modContact.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        b_modContact.setText("Modificar Contacto");
        b_modContact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_modContactMouseClicked(evt);
            }
        });

        b_deleteContact.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        b_deleteContact.setText("Eliminar Contacto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(b_newContact)
                        .addGap(108, 108, 108)
                        .addComponent(b_modContact)
                        .addGap(90, 90, 90)
                        .addComponent(b_deleteContact))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_newContact, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_modContact, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_deleteContact, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Contactos", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 986, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Historial", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_newContactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_newContactMouseClicked
        jd_newContact.setModal(true);
        jd_newContact.pack();
        jd_newContact.setLocationRelativeTo(this);
        jd_newContact.setVisible(true);
    }//GEN-LAST:event_b_newContactMouseClicked

    private void b_saveNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_saveNewMouseClicked
        String n = nc_name.getText();
        int e = (int) nc_edad.getValue();
        String t = nc_phone.getText();
        String c = nc_mail.getText();
        String d = nc_dir.getText();

        if (n.equals("") || t.equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar nombre y número de teléfono como mínimo");
        } else {
            DefaultTableModel modelo = (DefaultTableModel) contact_table.getModel();
            Object[] row = {
                n, e, t, c, d
            };
            modelo.addRow(row);
            contact_table.setModel(modelo);

            try {
                log.conectar();
                log.query.execute("INSERT INTO Contactos"
                        + " (Nombre,Edad,Teléfono,Correo,Dirección)"
                        + " VALUES ('" + n + "', '" + e + "', '" + t + "', '" + c + "', '" + d + "')");
                log.commit();
                JOptionPane.showMessageDialog(this, "Contacto Guardado");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            Contacto nuevo = new Contacto(n, e, t, c, d);
            contactos.add(nuevo);

            log.desconectar();

            nc_name.setText("");
            nc_edad.setValue(0);
            nc_phone.setText("");
            nc_mail.setText("");
            nc_dir.setText("");
        }
    }//GEN-LAST:event_b_saveNewMouseClicked

    private void b_modifyCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_modifyCMouseClicked
        String n = mc_name.getText();
        int e = (int) mc_edad.getValue();
        String t = mc_phone.getText();
        String c = mc_mail.getText();
        String d = mc_dir.getText();

        try {
            log.conectar();
            log.query.execute("UPDATE Contactos SET Nombre='" + n + "', Edad='" + e + "', Teléfono='" + t + "', Correo='" + c + "', Dirección='" + d + "' WHERE ID='" + pos+1 + "'");
            log.commit();
        
            chosen.setNombre(n);
            chosen.setEdad(e);
            chosen.setNumero(t);
            chosen.setCorreo(c);
            chosen.setDireccion(d);
            
        } catch (SQLException ex) {

        }
        log.desconectar();

    }//GEN-LAST:event_b_modifyCMouseClicked

    private void b_modContactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_modContactMouseClicked
        try {
            pos = contact_table.getSelectedRow();
            chosen = contactos.get(pos);

            mc_name.setText(chosen.getNombre());
            mc_edad.setValue(chosen.getEdad());
            mc_phone.setText(chosen.getNumero());
            mc_mail.setText(chosen.getCorreo());
            mc_dir.setText(chosen.getDireccion());

            jd_modContact.setModal(true);
            jd_modContact.pack();
            jd_modContact.setLocationRelativeTo(this);
            jd_modContact.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar uno de sus contactos");
        }
    }//GEN-LAST:event_b_modContactMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_deleteContact;
    private javax.swing.JButton b_modContact;
    private javax.swing.JButton b_modifyC;
    private javax.swing.JButton b_newContact;
    private javax.swing.JButton b_saveNew;
    private javax.swing.JTable contact_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JDialog jd_modContact;
    private javax.swing.JDialog jd_newContact;
    private javax.swing.JTextArea mc_dir;
    private javax.swing.JSpinner mc_edad;
    private javax.swing.JTextField mc_mail;
    private javax.swing.JTextField mc_name;
    private javax.swing.JFormattedTextField mc_phone;
    private javax.swing.JTextArea nc_dir;
    private javax.swing.JSpinner nc_edad;
    private javax.swing.JTextField nc_mail;
    private javax.swing.JTextField nc_name;
    private javax.swing.JFormattedTextField nc_phone;
    // End of variables declaration//GEN-END:variables
    DataBase log = new DataBase("./Datos.accdb");
    ArrayList<Contacto> contactos = new ArrayList();
    int pos;
    Contacto chosen;
}
