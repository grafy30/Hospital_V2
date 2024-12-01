package aplicativo.application.form.other;

import Hospital.Dao.CCitaDAO;
import Hospital.Dao.CDoctorDAO;
import Hospital.Dao.CUsuarioDAO;
import Hospital.Modelo.ModelCita;
import Hospital.Modelo.ModelDoctor;
import Hospital.Modelo.ModelPaciente;
import Hospital.Modelo.ModelUsuario;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author Wilson
 */
public class FormConsulasMedicas extends javax.swing.JPanel {
    public FormConsulasMedicas() {
        initComponents();
        CCitaDAO cita=new CCitaDAO();
        cita.MostrarTablaCita(JTablaMostrarCitas);
        CDoctorDAO docComb=new CDoctorDAO();
        docComb.MostrarDoctoresCombo(jComboBoxDoctor); 
    }

    public void limpiarcampos(){
        txtCodCita.setText("");
        txtCodPaciente.setText("");
        txtNomPaciente.setText("");
        txtApellidosPaciente.setText("");      
        jComboBoxDoctor.setSelectedIndex(0);
        jFechaCita.setDate(null);
        txtMotivoPaciente.setText("");
        ImageIcon icono=new ImageIcon("src/aplicativo/icon/jpg/foto_fondo.jpg");
        lblMostrarFoto.setIcon(icono);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        header1 = new Hospital.Vista.componentes.Header();
        panelTransparent1 = new aplicativo.swing.PanelTransparent();
        jLabel5 = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtCodCita = new javax.swing.JTextField();
        lblNombres = new javax.swing.JLabel();
        txtNomPaciente = new javax.swing.JTextField();
        txtMotivoPaciente = new javax.swing.JTextField();
        lblApellidos = new javax.swing.JLabel();
        txtApellidosPaciente = new javax.swing.JTextField();
        lblDNI = new javax.swing.JLabel();
        scrollBarCustom1 = new aplicativo.swing.scrollbar.ScrollBarCustom();
        jLabel6 = new javax.swing.JLabel();
        lblCodigo1 = new javax.swing.JLabel();
        txtCodPaciente = new javax.swing.JTextField();
        lblMostrarFoto = new javax.swing.JLabel();
        lblFechaNa = new javax.swing.JLabel();
        jFechaCita = new com.toedter.calendar.JDateChooser();
        lblDoctor = new javax.swing.JLabel();
        jComboBoxDoctor = new javax.swing.JComboBox<>();
        textAreaMedicacion = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTablaMostrarCitas = new javax.swing.JTable();
        btnCita = new javax.swing.JButton();
        btnEditarCita = new javax.swing.JButton();
        btnEliminarDoctor = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel5.setText("CONSULTAS MEDICAS");

        lblCodigo.setText("Codigo:");

        txtCodCita.setEnabled(false);

        lblNombres.setText("Nombres:");

        txtNomPaciente.setEnabled(false);

        lblApellidos.setText("Apellidos:");

        txtApellidosPaciente.setEnabled(false);

        lblDNI.setText("Motivo:");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel6.setText("DATOS DEL PACIENTE");

        lblCodigo1.setText("Codigo:");

        txtCodPaciente.setEnabled(false);

        lblMostrarFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMostrarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplicativo/icon/jpg/foto_fondo.jpg"))); // NOI18N
        lblMostrarFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblMostrarFoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblMostrarFoto.setMaximumSize(new java.awt.Dimension(120, 149));
        lblMostrarFoto.setMinimumSize(new java.awt.Dimension(120, 149));
        lblMostrarFoto.setPreferredSize(new java.awt.Dimension(120, 149));

        lblFechaNa.setText("Fecha Cita:");

        lblDoctor.setText("Doctor:");

        jComboBoxDoctor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        textAreaMedicacion.addTab("DIAGNOSTICO", jScrollPane1);

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jScrollPane6.setViewportView(jTextArea5);

        textAreaMedicacion.addTab("MEDICACION", jScrollPane6);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane4.setViewportView(jTextArea3);

        textAreaMedicacion.addTab("TRATAMIENTO", jScrollPane4);

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane5.setViewportView(jTextArea4);

        textAreaMedicacion.addTab("NOTAS", jScrollPane5);

        javax.swing.GroupLayout panelTransparent1Layout = new javax.swing.GroupLayout(panelTransparent1);
        panelTransparent1.setLayout(panelTransparent1Layout);
        panelTransparent1Layout.setHorizontalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addComponent(lblFechaNa, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtApellidosPaciente, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomPaciente)
                            .addGroup(panelTransparent1Layout.createSequentialGroup()
                                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTransparent1Layout.createSequentialGroup()
                                        .addComponent(txtCodPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39))
                                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                                        .addComponent(txtCodCita, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(lblMostrarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
                            .addComponent(jComboBoxDoctor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMotivoPaciente, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelTransparent1Layout.createSequentialGroup()
                                .addComponent(jFechaCita, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(textAreaMedicacion, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panelTransparent1Layout.setVerticalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCodigo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigo1)
                            .addComponent(txtCodPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblMostrarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombres))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidosPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellidos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDoctor)
                    .addComponent(jComboBoxDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFechaCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaNa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMotivoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDNI))
                .addGap(18, 18, 18)
                .addComponent(textAreaMedicacion))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel7.setText("Tabla de Citas");

        JTablaMostrarCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTablaMostrarCitas.setOpaque(false);
        JTablaMostrarCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTablaMostrarCitasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTablaMostrarCitas);

        btnCita.setText("Añadir");
        btnCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCitaActionPerformed(evt);
            }
        });

        btnEditarCita.setText("Editar");
        btnEditarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCitaActionPerformed(evt);
            }
        });

        btnEliminarDoctor.setText("Eliminar");
        btnEliminarDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDoctorActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel8.setText("Prescripcion");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Medicamento", "Dosis", "Indicaciones"
            }
        ));
        jScrollPane7.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(1, 1, 1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane7)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 373, Short.MAX_VALUE)
                        .addComponent(btnCita)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditarCita)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarDoctor)
                        .addGap(307, 307, 307))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTransparent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCita)
                            .addComponent(btnEditarCita)
                            .addComponent(btnEliminarDoctor))
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCitaActionPerformed
        if ( jFechaCita.getDateFormatString().isEmpty() || txtMotivoPaciente.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
        }else{
            ModelPaciente paciente=new ModelPaciente();
            paciente.setNombre(txtNomPaciente.getText());
            paciente.setApellido(txtApellidosPaciente.getText());

            ModelUsuario codUser= new ModelUsuario();
            codUser.setCodigo_Usuario(txtCodPaciente.getText());

            CUsuarioDAO user=new CUsuarioDAO();
            int idpaciente= user.obtenerIdPaciente(codUser);

            if (idpaciente != -1) {
                paciente.setId_Paciente(idpaciente);
                System.out.println("ID del doctor seleccionado: " + idpaciente);
            } else {
                System.out.println("No se encontró el ID del doctor.");
            }

            String doctorSeleccionado = jComboBoxDoctor.getSelectedItem().toString();
            CDoctorDAO doctorDAO = new CDoctorDAO();
            int idDoctor = doctorDAO.obtenerIdDoctorPorNombreCompleto(doctorSeleccionado);

            ModelDoctor doc=new ModelDoctor();
            if (idDoctor != -1) {
                doc.setId_doctor(idDoctor);
                System.out.println("ID del doctor seleccionado: " + idDoctor);
            } else {
                System.out.println("No se encontró el ID del doctor.");
            }

            ModelCita cita=new ModelCita();
            cita.setFecha_cita(jFechaCita.getDate());
            cita.setMotivo(txtMotivoPaciente.getText());
            cita.setFoto(paciente.getFoto());

            // Llamar al método de inserción
            CCitaDAO objCita = new CCitaDAO();
            boolean resultado = objCita.InsertarCita(paciente, cita, doc );

            if (resultado) {
                JOptionPane.showMessageDialog(null, "Cita agregada exitosamente.");
                objCita.MostrarTablaCita(JTablaMostrarCitas);
                limpiarcampos();
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar Cita.");
            }
        }
    }//GEN-LAST:event_btnCitaActionPerformed

    private void btnEditarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCitaActionPerformed
        CCitaDAO cita=new CCitaDAO();
        cita.ModificarCita(txtCodCita, jComboBoxDoctor, jFechaCita, txtMotivoPaciente);
        cita.MostrarTablaCita(JTablaMostrarCitas);
        limpiarcampos();
        btnCita.setEnabled(true);
    }//GEN-LAST:event_btnEditarCitaActionPerformed

    private void btnEliminarDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDoctorActionPerformed
        int filaSeleccionada = JTablaMostrarCitas.getSelectedRow();

        if (filaSeleccionada == -1) {
            // Si no hay fila seleccionada, mostrar mensaje de advertencia
            JOptionPane.showMessageDialog(
                this,
                "Por favor, seleccione un registro de la tabla para eliminar.",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE
            );
        } else {
            // Mostrar mensaje de confirmación
            int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro de que desea eliminar este registro?",
                "Confirmación de eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
            );

            if (confirmacion == JOptionPane.YES_OPTION) {
                CCitaDAO cita= new CCitaDAO();
                cita.EliminarCita(txtCodCita);
                cita.MostrarTablaCita(JTablaMostrarCitas);
                System.out.println("Registro eliminado.");
            } else {
                System.out.println("Operación cancelada.");
                JOptionPane.showMessageDialog(this, "Operación cancelada.");
            }
        }
        limpiarcampos();
    }//GEN-LAST:event_btnEliminarDoctorActionPerformed

    private void JTablaMostrarCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTablaMostrarCitasMouseClicked
        CCitaDAO cita=new CCitaDAO();
        cita.SeleccionarCitas(JTablaMostrarCitas, txtCodCita,txtCodPaciente,txtNomPaciente,txtApellidosPaciente,jComboBoxDoctor,
            jFechaCita,txtMotivoPaciente,lblMostrarFoto);
        btnCita.setEnabled(false);
    }//GEN-LAST:event_JTablaMostrarCitasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTablaMostrarCitas;
    private javax.swing.JButton btnCita;
    private javax.swing.JButton btnEditarCita;
    private javax.swing.JButton btnEliminarDoctor;
    private Hospital.Vista.componentes.Header header1;
    private javax.swing.JComboBox<String> jComboBoxDoctor;
    private com.toedter.calendar.JDateChooser jFechaCita;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigo1;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblDoctor;
    private javax.swing.JLabel lblFechaNa;
    private javax.swing.JLabel lblMostrarFoto;
    private javax.swing.JLabel lblNombres;
    private aplicativo.swing.PanelTransparent panelTransparent1;
    private aplicativo.swing.scrollbar.ScrollBarCustom scrollBarCustom1;
    private javax.swing.JTabbedPane textAreaMedicacion;
    private javax.swing.JTextField txtApellidosPaciente;
    private javax.swing.JTextField txtCodCita;
    private javax.swing.JTextField txtCodPaciente;
    private javax.swing.JTextField txtMotivoPaciente;
    private javax.swing.JTextField txtNomPaciente;
    // End of variables declaration//GEN-END:variables
}
