package aplicativo.application.form.other;

import Hospital.Dao.CPacienteDAO;
import Hospital.Dao.CUsuarioDAO;
import Hospital.Modelo.ModelPaciente;
import Hospital.Modelo.ModelUsuario;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 *
 * @author Wilson
 */
public class FormPaciente extends javax.swing.JPanel {
    String filename;
    byte[] Paciente_image;

    public FormPaciente() {
        initComponents();
        CPacienteDAO enfer=new CPacienteDAO();
        CUsuarioDAO user=new CUsuarioDAO();
        enfer.MostrarTablaPaciente(JTablaMostrarPaciente);
    }
    public void limpiarcampos(){
        txtCodPaciente.setText("");
        txtNomPaciente.setText("");
        txtApellidosPaciente.setText("");
        txtDNIPaciente.setText("");          
        jFechaNa.setDate(null);
        txtTelefonoPaciente.setText("");
        txtDireccionPaciente.setText("");
        txtCorreoPaciente.setText("");
        ImageIcon icono=new ImageIcon("src/aplicativo/icon/jpg/foto_fondo.jpg");
        lblMostrarFoto.setIcon(icono);
        txtCodigoUsuarioLogin.setText("");
        txtContraseñaLogin.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header1 = new Hospital.Vista.componentes.Header();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTablaMostrarPaciente = new javax.swing.JTable();
        panelTransparent1 = new aplicativo.swing.PanelTransparent();
        jLabel5 = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtCodPaciente = new javax.swing.JTextField();
        lblNombres = new javax.swing.JLabel();
        txtNomPaciente = new javax.swing.JTextField();
        lblFechaNa = new javax.swing.JLabel();
        btnAgregarPaciente = new javax.swing.JButton();
        btnEditarPaciente = new javax.swing.JButton();
        btnEliminarPaciente = new javax.swing.JButton();
        jFechaNa = new com.toedter.calendar.JDateChooser();
        lblTele = new javax.swing.JLabel();
        txtDNIPaciente = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        txtDireccionPaciente = new javax.swing.JTextField();
        lblFoto = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        txtCorreoPaciente = new javax.swing.JTextField();
        lblMostrarFoto = new javax.swing.JLabel();
        btnBuscarFoto = new javax.swing.JButton();
        lblCodigoUsuarioLogin = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        txtApellidosPaciente = new javax.swing.JTextField();
        lblDNI = new javax.swing.JLabel();
        txtTelefonoPaciente = new javax.swing.JTextField();
        scrollBarCustom1 = new aplicativo.swing.scrollbar.ScrollBarCustom();
        lblContraseñaLogin = new javax.swing.JLabel();
        txtCodigoUsuarioLogin = new javax.swing.JTextField();
        txtContraseñaLogin = new javax.swing.JTextField();
        txtRuta = new javax.swing.JTextField();

        JTablaMostrarPaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTablaMostrarPaciente.setOpaque(false);
        JTablaMostrarPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTablaMostrarPacienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTablaMostrarPaciente);

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel5.setText("CRUD PACIENTE");

        lblCodigo.setText("Codigo:");

        txtCodPaciente.setEnabled(false);

        lblNombres.setText("Nombres:");

        lblFechaNa.setText("Fecha Nacimiento:");

        btnAgregarPaciente.setText("Añadir");
        btnAgregarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPacienteActionPerformed(evt);
            }
        });

        btnEditarPaciente.setText("Editar");
        btnEditarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPacienteActionPerformed(evt);
            }
        });

        btnEliminarPaciente.setText("Eliminar");
        btnEliminarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPacienteActionPerformed(evt);
            }
        });

        lblTele.setText("Telefono:");

        lblDireccion.setText("Direccion:");

        lblFoto.setText("Foto:");

        lblCorreo.setText("Correo:");

        lblMostrarFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMostrarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplicativo/icon/jpg/foto_fondo.jpg"))); // NOI18N
        lblMostrarFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblMostrarFoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblMostrarFoto.setMaximumSize(new java.awt.Dimension(120, 149));
        lblMostrarFoto.setMinimumSize(new java.awt.Dimension(120, 149));
        lblMostrarFoto.setPreferredSize(new java.awt.Dimension(120, 149));

        btnBuscarFoto.setText("Buscar");
        btnBuscarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFotoActionPerformed(evt);
            }
        });

        lblCodigoUsuarioLogin.setText("Codigo Usuario:");

        lblApellidos.setText("Apellidos:");

        lblDNI.setText("DNI:");

        lblContraseñaLogin.setText("Contraseña:");

        txtCodigoUsuarioLogin.setEnabled(false);

        txtRuta.setEnabled(false);

        javax.swing.GroupLayout panelTransparent1Layout = new javax.swing.GroupLayout(panelTransparent1);
        panelTransparent1.setLayout(panelTransparent1Layout);
        panelTransparent1Layout.setHorizontalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addComponent(lblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTransparent1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTransparent1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(txtCorreoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addComponent(lblContraseñaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtContraseñaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(btnAgregarPaciente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditarPaciente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarPaciente))
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtApellidosPaciente, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCodPaciente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNomPaciente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDNIPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaNa)
                            .addComponent(lblTele, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefonoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFechaNa, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(txtDireccionPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTransparent1Layout.createSequentialGroup()
                                .addComponent(lblMostrarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarFoto))
                            .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addComponent(lblCodigoUsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodigoUsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panelTransparent1Layout.setVerticalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCodigo)
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addComponent(txtCodPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombres))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellidosPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApellidos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDNIPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDNI))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaNa)
                    .addComponent(jFechaNa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTele)
                    .addComponent(txtTelefonoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDireccion)
                    .addComponent(txtDireccionPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCorreoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCorreo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFoto)
                    .addComponent(lblMostrarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarFoto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoUsuarioLogin)
                    .addComponent(txtCodigoUsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContraseñaLogin)
                    .addComponent(txtContraseñaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarPaciente)
                    .addComponent(btnEditarPaciente)
                    .addComponent(btnEliminarPaciente))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, 1337, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTransparent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JTablaMostrarPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTablaMostrarPacienteMouseClicked
        CPacienteDAO objenfer=new CPacienteDAO();
        objenfer.SeleccionarPaciente(JTablaMostrarPaciente, txtCodPaciente, txtNomPaciente, txtApellidosPaciente, txtDNIPaciente, jFechaNa,
            txtTelefonoPaciente,txtDireccionPaciente, txtCorreoPaciente, lblMostrarFoto, txtCodigoUsuarioLogin,txtContraseñaLogin);
    }//GEN-LAST:event_JTablaMostrarPacienteMouseClicked

    private void btnAgregarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPacienteActionPerformed
        if (txtNomPaciente.getText().isEmpty() || txtApellidosPaciente.getText().isEmpty() || jFechaNa.getDateFormatString().isEmpty() || txtDNIPaciente.getText().isEmpty() ||
            txtDireccionPaciente.getText().isEmpty() || txtTelefonoPaciente.getText().isEmpty() || txtCorreoPaciente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
        }else{
            ModelPaciente Paciente=new ModelPaciente();
            Paciente.setNombre(txtNomPaciente.getText());
            Paciente.setApellido(txtApellidosPaciente.getText());
            String dni = txtDNIPaciente.getText().trim();
            if (dni.length() == 8 && dni.matches("\\d+")) {
                Paciente.setDni(dni);
            } else {
                JOptionPane.showMessageDialog(null, "El DNI debe contener exactamente 8 dígitos numéricos.");
                return;
            }
            Paciente.setFecha_Nacimiento(jFechaNa.getDate());
            Paciente.setTelefono(txtTelefonoPaciente.getText());
            Paciente.setDireccion(txtDireccionPaciente.getText());
            String email = txtCorreoPaciente.getText().trim();
            if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un correo electrónico válido.");
                return;
            }
            Paciente.setEmail(email);
            Paciente.setEmail(txtCorreoPaciente.getText());

            try {
                File ruta=new File(txtRuta.getText());
                byte[] icono=new byte[(int)ruta.length()];
                InputStream input= new FileInputStream(ruta);
                input.read(icono);
                Paciente.setFoto(icono);
            } catch (Exception e) {
                Paciente.setFoto(null);
            }

            // Crear objeto Usuario
            ModelUsuario usuario = new ModelUsuario();
            usuario.setCodigo_Usuario(txtCodigoUsuarioLogin.getText());
            usuario.setContraseña(new String(txtContraseñaLogin.getText()));
            usuario.setRolID(2);
            usuario.setFoto(Paciente.getFoto()); // Usar la misma foto que el Paciente

            // Llamar al método de inserción
            CPacienteDAO objenfer = new CPacienteDAO();
            boolean resultado = objenfer.InsertarPacienteYUsuario(Paciente, usuario);

            if (resultado) {
                JOptionPane.showMessageDialog(null, "Paciente y Usuario agregados exitosamente.");
                objenfer.MostrarTablaPaciente(JTablaMostrarPaciente);
                limpiarcampos();
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar Paciente y Usuario.");
            }
        }
    }//GEN-LAST:event_btnAgregarPacienteActionPerformed

    private void btnEditarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPacienteActionPerformed
        CPacienteDAO objenfer= new CPacienteDAO();
        objenfer.ModificarPaciente(txtCodPaciente, txtNomPaciente, txtApellidosPaciente, txtDNIPaciente, jFechaNa, txtTelefonoPaciente, txtDireccionPaciente,
            txtCorreoPaciente,lblMostrarFoto,txtRuta,txtCodigoUsuarioLogin,txtContraseñaLogin);
        objenfer.MostrarTablaPaciente(JTablaMostrarPaciente);
        limpiarcampos();
    }//GEN-LAST:event_btnEditarPacienteActionPerformed

    private void btnEliminarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPacienteActionPerformed
        int filaSeleccionada = JTablaMostrarPaciente.getSelectedRow();

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
                CPacienteDAO objenfer = new CPacienteDAO();
                objenfer.EliminarPaciente(txtCodigoUsuarioLogin,txtCodPaciente);
                objenfer.MostrarTablaPaciente(JTablaMostrarPaciente);
                System.out.println("Registro eliminado.");
            } else {
                System.out.println("Operación cancelada.");
                JOptionPane.showMessageDialog(this, "Operación cancelada.");
            }
        }
        limpiarcampos();
    }//GEN-LAST:event_btnEliminarPacienteActionPerformed

    private void btnBuscarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFotoActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        filename = file.getAbsolutePath();
        txtRuta.setText(filename);

        // Mostrar imagen en el lblMostrarFoto
        ImageIcon icon = new ImageIcon(filename);
        Image image = icon.getImage().getScaledInstance(lblMostrarFoto.getWidth(), lblMostrarFoto.getHeight(), Image.SCALE_SMOOTH);
        lblMostrarFoto.setIcon(new ImageIcon(image));

        // Guardar la imagen como bytes
        try {
            File imageFile = new File(filename);
            FileInputStream fis = new FileInputStream(imageFile);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            for (int readNum; (readNum = fis.read(buffer)) != -1;) {
                bos.write(buffer, 0, readNum);
            }
            Paciente_image = bos.toByteArray();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar la imagen: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscarFotoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTablaMostrarPaciente;
    private javax.swing.JButton btnAgregarPaciente;
    private javax.swing.JButton btnBuscarFoto;
    private javax.swing.JButton btnEditarPaciente;
    private javax.swing.JButton btnEliminarPaciente;
    private Hospital.Vista.componentes.Header header1;
    private com.toedter.calendar.JDateChooser jFechaNa;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigoUsuarioLogin;
    private javax.swing.JLabel lblContraseñaLogin;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFechaNa;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblMostrarFoto;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblTele;
    private aplicativo.swing.PanelTransparent panelTransparent1;
    private aplicativo.swing.scrollbar.ScrollBarCustom scrollBarCustom1;
    private javax.swing.JTextField txtApellidosPaciente;
    private javax.swing.JTextField txtCodPaciente;
    private javax.swing.JTextField txtCodigoUsuarioLogin;
    private javax.swing.JTextField txtContraseñaLogin;
    private javax.swing.JTextField txtCorreoPaciente;
    private javax.swing.JTextField txtDNIPaciente;
    private javax.swing.JTextField txtDireccionPaciente;
    private javax.swing.JTextField txtNomPaciente;
    private javax.swing.JTextField txtRuta;
    private javax.swing.JTextField txtTelefonoPaciente;
    // End of variables declaration//GEN-END:variables
}
