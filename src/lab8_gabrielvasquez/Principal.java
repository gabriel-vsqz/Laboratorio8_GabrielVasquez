package lab8_gabrielvasquez;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        setLocationRelativeTo(null);

        ImageIcon img = new ImageIcon("./Rigby.png");
        icon.setIcon(img);

        ImageIcon img2 = new ImageIcon("./phone.png");
        this.setIconImage(img2.getImage());
        jd_Call.setIconImage(img2.getImage());
        jd_modContact.setIconImage(img2.getImage());
        jd_newContact.setIconImage(img2.getImage());
        jd_newMessage.setIconImage(img2.getImage());

        Cargar();
    }

    public final void Cargar() {
        log.conectar();
        try {
            cleanTable();

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

            log.query.execute("SELECT Receptor,Fecha,Contenido FROM Mensajes");
            ResultSet sr = log.query.getResultSet();
            while (sr.next()) {
                buzon.append("Para: " + sr.getString(1) + "\nMensaje: " + sr.getString(3) + "\nEnviado " + sr.getString(2) + "\n\n");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        log.desconectar();
    }

    public void cleanTable() {
        contact_table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Nombre", "Edad", "Teléfono", "Correo", "Dirección"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
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
        jd_newMessage = new javax.swing.JDialog();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        recipiente = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        mensaje = new javax.swing.JTextArea();
        b_sendMessage = new javax.swing.JButton();
        jd_Call = new javax.swing.JDialog();
        calling = new javax.swing.JLabel();
        b_colgar = new javax.swing.JButton();
        duration = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        contact_table = new javax.swing.JTable();
        b_newContact = new javax.swing.JButton();
        b_modContact = new javax.swing.JButton();
        b_deleteContact = new javax.swing.JButton();
        b_showMD = new javax.swing.JButton();
        b_Call = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        buzon = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_calls = new javax.swing.JTable();

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

        jd_newMessage.setTitle("Nuevo Mensaje");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel13.setText("Receptor:");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Mensaje");

        recipiente.setEditable(false);
        recipiente.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        mensaje.setColumns(20);
        mensaje.setRows(5);
        jScrollPane4.setViewportView(mensaje);

        b_sendMessage.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        b_sendMessage.setText("Enviar");
        b_sendMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_sendMessageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jd_newMessageLayout = new javax.swing.GroupLayout(jd_newMessage.getContentPane());
        jd_newMessage.getContentPane().setLayout(jd_newMessageLayout);
        jd_newMessageLayout.setHorizontalGroup(
            jd_newMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_newMessageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jd_newMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jd_newMessageLayout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jd_newMessageLayout.createSequentialGroup()
                        .addGap(0, 32, Short.MAX_VALUE)
                        .addGroup(jd_newMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jd_newMessageLayout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(recipiente, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jd_newMessageLayout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))))))
            .addGroup(jd_newMessageLayout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(b_sendMessage)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jd_newMessageLayout.setVerticalGroup(
            jd_newMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_newMessageLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jd_newMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recipiente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(b_sendMessage)
                .addGap(22, 22, 22))
        );

        calling.setFont(new java.awt.Font("Dialog", 1, 50)); // NOI18N
        calling.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        b_colgar.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        b_colgar.setText("Colgar");
        b_colgar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_colgarMouseClicked(evt);
            }
        });

        duration.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        duration.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        duration.setText("00:00:00");

        javax.swing.GroupLayout jd_CallLayout = new javax.swing.GroupLayout(jd_Call.getContentPane());
        jd_Call.getContentPane().setLayout(jd_CallLayout);
        jd_CallLayout.setHorizontalGroup(
            jd_CallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_CallLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(calling, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jd_CallLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(jd_CallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(duration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_colgar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jd_CallLayout.setVerticalGroup(
            jd_CallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_CallLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(calling, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(duration, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(b_colgar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 50)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Rigby");

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Edad: 20");

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Número: 9123-1243");

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Correo: riggygamer@regular.show");

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Dirección: El Parque");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(108, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel19)
                        .addGap(69, 69, 69)
                        .addComponent(jLabel21))
                    .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(90, Short.MAX_VALUE))
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
        b_deleteContact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_deleteContactMouseClicked(evt);
            }
        });

        b_showMD.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        b_showMD.setText("Enviar Mensaje");
        b_showMD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_showMDMouseClicked(evt);
            }
        });

        b_Call.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        b_Call.setText("Llamar");
        b_Call.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_CallMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(b_newContact)
                        .addGap(108, 108, 108)
                        .addComponent(b_modContact)
                        .addGap(90, 90, 90)
                        .addComponent(b_deleteContact))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(b_showMD)
                        .addGap(135, 135, 135)
                        .addComponent(b_Call, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_showMD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_Call, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_newContact, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_modContact, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_deleteContact, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("Contactos", jPanel2);

        buzon.setEditable(false);
        buzon.setColumns(20);
        buzon.setRows(5);
        jScrollPane5.setViewportView(buzon);

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Buzón de Salida");

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Llamadas");

        table_calls.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Duración"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(table_calls);
        if (table_calls.getColumnModel().getColumnCount() > 0) {
            table_calls.getColumnModel().getColumn(0).setResizable(false);
            table_calls.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
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

        boolean tryout = true;

        for (Contacto ct : contactos) {
            if (ct.getNumero().equals(t)) {
                tryout = false;
            }
        }

        if (n.equals("") || t.equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar nombre y número de teléfono como mínimo");
        } else if (tryout == false) {
            JOptionPane.showMessageDialog(this, "El número ya está registrado");
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
        
        log.conectar();
        try {
            log.query.execute("UPDATE Contactos SET Nombre='" + n + "', Edad='" + e + "', Teléfono='" + t + "', Correo='" + c + "', Dirección='" + d + "' WHERE Teléfono='" + chosen.getNumero() + "'");
            log.commit();

            chosen.setNombre(n);
            chosen.setEdad(e);
            chosen.setNumero(t);
            chosen.setCorreo(c);
            chosen.setDireccion(d);

            JOptionPane.showMessageDialog(this, "Contacto Modificado");

            Cargar();

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

    private void b_deleteContactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_deleteContactMouseClicked
        try {
            pos = contact_table.getSelectedRow();
            chosen = contactos.get(pos);

            log.conectar();
            log.query.execute("DELETE FROM Contactos WHERE ID='" + (pos + 1) + "'");
            log.commit();

            DefaultTableModel modelo = (DefaultTableModel) contact_table.getModel();
            modelo.removeRow(pos);
            contact_table.setModel(modelo);

            contactos.remove(chosen);

            JOptionPane.showMessageDialog(this, "Contacto Eliminado");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar uno de sus contactos");
        }
        log.desconectar();
    }//GEN-LAST:event_b_deleteContactMouseClicked

    private void b_showMDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_showMDMouseClicked
        try {
            pos = contact_table.getSelectedRow();
            chosen = contactos.get(pos);

            recipiente.setText(chosen.getNombre());

            mensaje.setText("");

            jd_newMessage.setModal(true);
            jd_newMessage.pack();
            jd_newMessage.setLocationRelativeTo(this);
            jd_newMessage.setVisible(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar a uno de sus contactos");
        }


    }//GEN-LAST:event_b_showMDMouseClicked

    private void b_sendMessageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_sendMessageMouseClicked
        String m = mensaje.getText();
        String r = recipiente.getText();
        Date f = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("dd/MMM/yyyy");
        String d = sf.format(f);

        log.conectar();
        try {
            log.query.execute("INSERT INTO Mensajes"
                    + " (Emisor,Receptor,Fecha,Contenido)"
                    + " VALUES ('Rigby', '" + r + "', '" + d + "', '" + m + "')");
            log.commit();

            buzon.append("Para: " + r + "\nMensaje: " + m + "\nEnviado " + d + "\n\n");

            mensaje.setText("");
            JOptionPane.showMessageDialog(this, "Mensaje Enviado");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_b_sendMessageMouseClicked

    private void b_CallMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_CallMouseClicked
        try {
            pos = contact_table.getSelectedRow();
            chosen = contactos.get(pos);

            calling.setText(chosen.getNombre());

            call = new adminLlamada(duration);
            call.start();

            jd_Call.setModal(true);
            jd_Call.pack();
            jd_Call.setLocationRelativeTo(this);
            jd_Call.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar uno de sus contactos");
        }

    }//GEN-LAST:event_b_CallMouseClicked

    private void b_colgarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_colgarMouseClicked
        call.setOnCall(false);
        call.stop();

        DefaultTableModel modelo = (DefaultTableModel) table_calls.getModel();
        Object[] row = {
            calling.getText(), duration.getText()
        };
        modelo.addRow(row);
        table_calls.setModel(modelo);

        jd_Call.setVisible(false);
    }//GEN-LAST:event_b_colgarMouseClicked

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
    private javax.swing.JButton b_Call;
    private javax.swing.JButton b_colgar;
    private javax.swing.JButton b_deleteContact;
    private javax.swing.JButton b_modContact;
    private javax.swing.JButton b_modifyC;
    private javax.swing.JButton b_newContact;
    private javax.swing.JButton b_saveNew;
    private javax.swing.JButton b_sendMessage;
    private javax.swing.JButton b_showMD;
    private javax.swing.JTextArea buzon;
    private javax.swing.JLabel calling;
    private javax.swing.JTable contact_table;
    private javax.swing.JLabel duration;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JDialog jd_Call;
    private javax.swing.JDialog jd_modContact;
    private javax.swing.JDialog jd_newContact;
    private javax.swing.JDialog jd_newMessage;
    private javax.swing.JTextArea mc_dir;
    private javax.swing.JSpinner mc_edad;
    private javax.swing.JTextField mc_mail;
    private javax.swing.JTextField mc_name;
    private javax.swing.JFormattedTextField mc_phone;
    private javax.swing.JTextArea mensaje;
    private javax.swing.JTextArea nc_dir;
    private javax.swing.JSpinner nc_edad;
    private javax.swing.JTextField nc_mail;
    private javax.swing.JTextField nc_name;
    private javax.swing.JFormattedTextField nc_phone;
    private javax.swing.JTextField recipiente;
    private javax.swing.JTable table_calls;
    // End of variables declaration//GEN-END:variables
    DataBase log = new DataBase("./Datos.accdb");
    ArrayList<Contacto> contactos = new ArrayList();
    int pos;
    Contacto chosen;
    adminLlamada call;

}
