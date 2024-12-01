package aplicativo.application.form.other;

import Hospital.Dao.CDoctorDAO;
import Hospital.Dao.CUsuarioDAO;
import Hospital.Modelo.ModelDoctor;
import Hospital.Modelo.ModelUsuario;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * @author Wilson
 */

public class FormDoctor extends javax.swing.JPanel {
    String filename;
    byte[] Doctor_image;

    public FormDoctor() {
        initComponents();
        CDoctorDAO doc=new CDoctorDAO();
        CUsuarioDAO user=new CUsuarioDAO();
        doc.MostrarTablaDoctor(JTablaMostrarDoctor);
    }
    public void limpiarcampos(){
        txtCodDoctor.setText("");
        txtNomDoctor.setText("");
        txtApellidosDoctor.setText("");
        txtDNIDoctor.setText("");          
        jFechaNa.setDate(null);
        txtTelefonoDoctor.setText("");
        txtDireccionDoctor.setText("");
        txtCorreoDoctor.setText("");
        txtEspecialidadDoctor.setText("");
        ImageIcon icono=new ImageIcon("src/aplicativo/icon/jpg/foto_fondo.jpg");
        lblMostrarFoto.setIcon(icono);
        txtCodigoUsuarioLogin.setText("");
        txtContraseñaLogin.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header1 = new Hospital.Vista.componentes.Header();
        panelTransparent1 = new aplicativo.swing.PanelTransparent();
        jLabel5 = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtCodDoctor = new javax.swing.JTextField();
        lblNombres = new javax.swing.JLabel();
        txtNomDoctor = new javax.swing.JTextField();
        lblFechaNa = new javax.swing.JLabel();
        btnAgregarDoctor = new javax.swing.JButton();
        btnEditarDoctor = new javax.swing.JButton();
        btnEliminarDoctor = new javax.swing.JButton();
        jFechaNa = new com.toedter.calendar.JDateChooser();
        lblTele = new javax.swing.JLabel();
        txtDNIDoctor = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        txtDireccionDoctor = new javax.swing.JTextField();
        lblFoto = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        txtCorreoDoctor = new javax.swing.JTextField();
        lblMostrarFoto = new javax.swing.JLabel();
        btnBuscarFoto = new javax.swing.JButton();
        lblCodigoUsuarioLogin = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        txtApellidosDoctor = new javax.swing.JTextField();
        lblDNI = new javax.swing.JLabel();
        txtTelefonoDoctor = new javax.swing.JTextField();
        scrollBarCustom1 = new aplicativo.swing.scrollbar.ScrollBarCustom();
        lblContraseñaLogin = new javax.swing.JLabel();
        txtCodigoUsuarioLogin = new javax.swing.JTextField();
        txtContraseñaLogin = new javax.swing.JTextField();
        lblCorreo1 = new javax.swing.JLabel();
        txtEspecialidadDoctor = new javax.swing.JTextField();
        txtRuta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTablaMostrarDoctor = new javax.swing.JTable();

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel5.setText("CRUD DOCTOR");

        lblCodigo.setText("Codigo:");

        txtCodDoctor.setEnabled(false);

        lblNombres.setText("Nombres:");

        lblFechaNa.setText("Fecha Nacimiento:");

        btnAgregarDoctor.setText("Añadir");
        btnAgregarDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDoctorActionPerformed(evt);
            }
        });

        btnEditarDoctor.setText("Editar");
        btnEditarDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarDoctorActionPerformed(evt);
            }
        });

        btnEliminarDoctor.setText("Eliminar");
        btnEliminarDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDoctorActionPerformed(evt);
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

        lblCorreo1.setText("Especialidad:");

        txtRuta.setEnabled(false);

        javax.swing.GroupLayout panelTransparent1Layout = new javax.swing.GroupLayout(panelTransparent1);
        panelTransparent1.setLayout(panelTransparent1Layout);
        panelTransparent1Layout.setHorizontalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelTransparent1Layout.createSequentialGroup()
                            .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelTransparent1Layout.createSequentialGroup()
                                    .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34)
                                    .addComponent(txtEspecialidadDoctor))
                                .addGroup(panelTransparent1Layout.createSequentialGroup()
                                    .addGap(37, 37, 37)
                                    .addComponent(txtCorreoDoctor))))
                        .addGroup(panelTransparent1Layout.createSequentialGroup()
                            .addComponent(lblContraseñaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtContraseñaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelTransparent1Layout.createSequentialGroup()
                            .addGap(107, 107, 107)
                            .addComponent(btnAgregarDoctor)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEditarDoctor)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEliminarDoctor))
                        .addGroup(panelTransparent1Layout.createSequentialGroup()
                            .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(44, 44, 44)
                            .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtApellidosDoctor, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodDoctor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNomDoctor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtDNIDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelTransparent1Layout.createSequentialGroup()
                            .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblFechaNa)
                                .addComponent(lblTele, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTelefonoDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jFechaNa, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelTransparent1Layout.createSequentialGroup()
                            .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(44, 44, 44)
                            .addComponent(txtDireccionDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelTransparent1Layout.createSequentialGroup()
                            .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(42, 42, 42)
                            .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelTransparent1Layout.createSequentialGroup()
                                    .addComponent(lblMostrarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnBuscarFoto))
                                .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addComponent(lblCodigoUsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodigoUsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(txtCodDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombres))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellidosDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApellidos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDNIDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDNI))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaNa)
                    .addComponent(jFechaNa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTele)
                    .addComponent(txtTelefonoDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDireccion)
                    .addComponent(txtDireccionDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCorreoDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCorreo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCorreo1)
                        .addComponent(txtEspecialidadDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(btnAgregarDoctor)
                    .addComponent(btnEditarDoctor)
                    .addComponent(btnEliminarDoctor))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        JTablaMostrarDoctor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTablaMostrarDoctor.setOpaque(false);
        JTablaMostrarDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTablaMostrarDoctorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTablaMostrarDoctor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnAgregarDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDoctorActionPerformed
        if (txtNomDoctor.getText().isEmpty() || txtApellidosDoctor.getText().isEmpty() || jFechaNa.getDateFormatString().isEmpty() || txtDNIDoctor.getText().isEmpty() ||
            txtDireccionDoctor.getText().isEmpty() || txtTelefonoDoctor.getText().isEmpty() || txtCorreoDoctor.getText().isEmpty() || txtEspecialidadDoctor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
        }else{
            ModelDoctor doctor=new ModelDoctor();
            doctor.setNombre(txtNomDoctor.getText());
            doctor.setApellido(txtApellidosDoctor.getText());
            String dni = txtDNIDoctor.getText().trim();
            if (dni.length() == 8 && dni.matches("\\d+")) {
                doctor.setDni(dni);
            } else {
                JOptionPane.showMessageDialog(null, "El DNI debe contener exactamente 8 dígitos numéricos.");
                return; 
            }
            doctor.setFecha_Nacimiento(jFechaNa.getDate());            
            doctor.setTelefono(txtTelefonoDoctor.getText());
            doctor.setDireccion(txtDireccionDoctor.getText());
            String email = txtCorreoDoctor.getText().trim();
            if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un correo electrónico válido.");
                return;
            }
            doctor.setEmail(email);
            doctor.setEmail(txtCorreoDoctor.getText());
            doctor.setEspecialidad(txtEspecialidadDoctor.getText());                       

            try {
                File ruta=new File(txtRuta.getText());
                byte[] icono=new byte[(int)ruta.length()];
                InputStream input= new FileInputStream(ruta);
                input.read(icono);
                doctor.setFoto(icono);
            } catch (Exception e) {
                doctor.setFoto(null);
            }            

            // Crear objeto Usuario
            ModelUsuario usuario = new ModelUsuario();
            usuario.setCodigo_Usuario(txtCodigoUsuarioLogin.getText());
            usuario.setContraseña(new String(txtContraseñaLogin.getText()));
            usuario.setRolID(2); 
            usuario.setFoto(doctor.getFoto()); // Usar la misma foto que el doctor

            // Llamar al método de inserción
            CDoctorDAO objdoc = new CDoctorDAO();
            boolean resultado = objdoc.InsertardoctorYUsuario(doctor, usuario);

            if (resultado) {
                JOptionPane.showMessageDialog(null, "doctor y Usuario agregados exitosamente.");
                objdoc.MostrarTablaDoctor(JTablaMostrarDoctor);
                limpiarcampos();
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar doctor y Usuario.");
            }
        }

    }//GEN-LAST:event_btnAgregarDoctorActionPerformed

    private void btnEditarDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarDoctorActionPerformed
        CDoctorDAO objdoc=new CDoctorDAO();
        objdoc.Modificardoctor(txtCodDoctor, txtNomDoctor, txtApellidosDoctor, txtDNIDoctor, jFechaNa, txtTelefonoDoctor, txtDireccionDoctor,
            txtCorreoDoctor,txtEspecialidadDoctor ,lblMostrarFoto,txtRuta,txtCodigoUsuarioLogin,txtContraseñaLogin);
        objdoc.MostrarTablaDoctor(JTablaMostrarDoctor);
        limpiarcampos();
        btnAgregarDoctor.setEnabled(true);
    }//GEN-LAST:event_btnEditarDoctorActionPerformed

    private void btnEliminarDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDoctorActionPerformed
        int filaSeleccionada = JTablaMostrarDoctor.getSelectedRow();

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
                CDoctorDAO objdoc=new CDoctorDAO();
                objdoc.EliminarDoctor(txtCodigoUsuarioLogin,txtCodDoctor);
                objdoc.MostrarTablaDoctor(JTablaMostrarDoctor);
                System.out.println("Registro eliminado.");
            } else {
                System.out.println("Operación cancelada.");
                JOptionPane.showMessageDialog(this, "Operación cancelada.");
            }
        }
        limpiarcampos();
    }//GEN-LAST:event_btnEliminarDoctorActionPerformed

    private void JTablaMostrarDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTablaMostrarDoctorMouseClicked
        CDoctorDAO objdoc=new CDoctorDAO();
        objdoc.Seleccionardoctor(JTablaMostrarDoctor, txtCodDoctor, txtNomDoctor, txtApellidosDoctor, txtDNIDoctor, jFechaNa,
            txtTelefonoDoctor,txtDireccionDoctor, txtCorreoDoctor, txtEspecialidadDoctor, lblMostrarFoto, txtCodigoUsuarioLogin,txtContraseñaLogin);
        btnAgregarDoctor.setEnabled(false);
    }//GEN-LAST:event_JTablaMostrarDoctorMouseClicked

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
            Doctor_image = bos.toByteArray();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar la imagen: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscarFotoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTablaMostrarDoctor;
    private javax.swing.JButton btnAgregarDoctor;
    private javax.swing.JButton btnBuscarFoto;
    private javax.swing.JButton btnEditarDoctor;
    private javax.swing.JButton btnEliminarDoctor;
    private Hospital.Vista.componentes.Header header1;
    private com.toedter.calendar.JDateChooser jFechaNa;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigoUsuarioLogin;
    private javax.swing.JLabel lblContraseñaLogin;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblCorreo1;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFechaNa;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblMostrarFoto;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblTele;
    private aplicativo.swing.PanelTransparent panelTransparent1;
    private aplicativo.swing.scrollbar.ScrollBarCustom scrollBarCustom1;
    private javax.swing.JTextField txtApellidosDoctor;
    private javax.swing.JTextField txtCodDoctor;
    private javax.swing.JTextField txtCodigoUsuarioLogin;
    private javax.swing.JTextField txtContraseñaLogin;
    private javax.swing.JTextField txtCorreoDoctor;
    private javax.swing.JTextField txtDNIDoctor;
    private javax.swing.JTextField txtDireccionDoctor;
    private javax.swing.JTextField txtEspecialidadDoctor;
    private javax.swing.JTextField txtNomDoctor;
    private javax.swing.JTextField txtRuta;
    private javax.swing.JTextField txtTelefonoDoctor;
    // End of variables declaration//GEN-END:variables
}
