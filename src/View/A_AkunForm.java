/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import Model.*;
import javax.swing.*;
import java.sql.*;
import java.util.regex.Pattern;

/**
 *
 * @author nitro
 */
public class A_AkunForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(A_AkunForm.class.getName());
    private int userId = -1;
    private boolean isEditMode = false;

    // Constructor for Create mode
    public A_AkunForm() {
        initComponents();
        isEditMode = false;
        setupPlaceholders();
        setupRoleListener();
        this.setSize(800, 635);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
    }
    
    // Constructor for Edit mode
    public A_AkunForm(int userId) {
        initComponents();
        this.userId = userId;
        this.isEditMode = true;
        setupPlaceholders();
        setupRoleListener();
        loadUserData();
    }
    
    private void setupPlaceholders() {
        // Remove placeholder text on focus
        removePlaceholder(jTextField5, "Nama lengkap");
        removePlaceholder(jTextField2, "Username");
        removePlaceholder(jTextField3, "Password");
        removePlaceholder(jTextField4, "Email");
        removePlaceholder(jTextField9, "Nomor telepon");
        removePlaceholder(jTextField8, "Jabatan");
        removePlaceholder(jTextField1, "Keahlian");
        removePlaceholder(jTextField10, "Sertifikasi");
        removePlaceholder(jTextField11, "Wilayah tugas");
        removePlaceholder(jTextField6, "Alat pengamatan");
    }
    
    private void removePlaceholder(JTextField field, String placeholder) {
        field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (field.getText().trim().isEmpty()) {
                    field.setText(placeholder);
                }
            }
        });
    }
    
    private void setupRoleListener() {
        jComboBox1.addActionListener(e -> toggleRoleFields());
        toggleRoleFields(); // Initial state
    }
    
    private void toggleRoleFields() {
        String role = (String) jComboBox1.getSelectedItem();
        
        // Disable all role-specific fields first
        jTextField8.setEnabled(false);  // Jabatan
        jTextField1.setEnabled(false);  // Keahlian
        jTextField10.setEnabled(false); // Sertifikasi
        jTextField11.setEnabled(false); // Wilayah tugas
        jTextField6.setEnabled(false);  // Alat pengamatan
        
        // Enable based on role
        switch (role) {
            case "Admin":
                jTextField8.setEnabled(true); // Jabatan
                break;
            case "Petugas Lapangan":
                jTextField11.setEnabled(true); // Wilayah tugas
                jTextField6.setEnabled(true);  // Alat pengamatan
                break;
            case "Petugas Pemeliharaan":
                jTextField1.setEnabled(true);  // Keahlian
                jTextField10.setEnabled(true); // Sertifikasi
                break;
        }
    }
    
    private void loadUserData() {
        try {
            Connection conn = Koneksi.getKoneksi();
            String query = "SELECT * FROM user WHERE id_user = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                jTextField5.setText(rs.getString("nama"));
                jTextField2.setText(rs.getString("username"));
                jTextField4.setText(rs.getString("email"));
                jTextField9.setText(rs.getString("no_telp"));
                jComboBox1.setSelectedItem(rs.getString("role"));
                
                String role = rs.getString("role");
                loadRoleSpecificData(role);
            }
            
            rs.close();
            ps.close();
            Koneksi.closeKoneksi();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Error loading user data: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void loadRoleSpecificData(String role) {
        try {
            Connection conn = Koneksi.getKoneksi();
            
            switch (role) {
                case "Admin":
                    Admin admin = Admin.getAdminByUserId(userId);
                    if (admin != null) {
                        jTextField8.setText(admin.getJabatan());
                    }
                    break;
                    
                case "Petugas Lapangan":
                    PetugasLapangan pl = PetugasLapangan.getPetugasByUserId(userId);
                    if (pl != null) {
                        jTextField11.setText(pl.getWilayahTugas());
                        jTextField6.setText(pl.getAlatPengamatan());
                    }
                    break;
                    
                case "Petugas Pemeliharaan":
                    PetugasPemeliharaan pp = PetugasPemeliharaan.getPetugasByUserId(userId);
                    if (pp != null) {
                        jTextField1.setText(pp.getKeahlian());
                        jTextField10.setText(pp.getSertifikasi());
                    }
                    break;
            }
            
            Koneksi.closeKoneksi();
            
        } catch (Exception e) {
            e.printStackTrace();
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

        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Myanmar Text", 1, 30)); // NOI18N
        jLabel2.setText("KELOLA AKUN");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 30, 230, 50);

        jPanel2.setLayout(null);

        jTextField1.setText("Keahlian");
        jPanel2.add(jTextField1);
        jTextField1.setBounds(260, 290, 190, 40);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(68, 84, 41));
        jLabel3.setText("Nama Lengkap");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 20, 128, 20);

        jTextField2.setText("Username");
        jPanel2.add(jTextField2);
        jTextField2.setBounds(20, 130, 190, 40);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(68, 84, 41));
        jLabel4.setText("Username");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 100, 128, 20);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(68, 84, 41));
        jLabel5.setText("Password");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 180, 128, 20);

        jTextField3.setText("Password");
        jPanel2.add(jTextField3);
        jTextField3.setBounds(20, 210, 190, 40);

        jTextField4.setText("Email");
        jPanel2.add(jTextField4);
        jTextField4.setBounds(20, 290, 190, 40);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(68, 84, 41));
        jLabel6.setText("Email");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(20, 260, 128, 20);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(68, 84, 41));
        jLabel7.setText("No. Telepon");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(260, 20, 128, 20);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(68, 84, 41));
        jLabel8.setText("Role");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(260, 100, 128, 20);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(68, 84, 41));
        jLabel9.setText("Jabatan");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(260, 180, 128, 20);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(68, 84, 41));
        jLabel10.setText("Keahlian");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(260, 260, 128, 20);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(68, 84, 41));
        jLabel11.setText("Sertifikasi");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(500, 20, 190, 20);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(68, 84, 41));
        jLabel12.setText("Wilayah Tugas");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(500, 100, 190, 20);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(68, 84, 41));
        jLabel13.setText("Alat Pengamatan");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(500, 180, 190, 20);

        jTextField5.setText("Nama lengkap");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField5);
        jTextField5.setBounds(20, 50, 190, 40);

        jTextField6.setText("Alat pengamatan");
        jPanel2.add(jTextField6);
        jTextField6.setBounds(500, 210, 190, 40);

        jTextField8.setText("Jabatan");
        jPanel2.add(jTextField8);
        jTextField8.setBounds(260, 210, 190, 40);

        jTextField9.setText("Nomor telepon");
        jPanel2.add(jTextField9);
        jTextField9.setBounds(260, 50, 190, 40);

        jTextField10.setText("Sertifikasi");
        jPanel2.add(jTextField10);
        jTextField10.setBounds(500, 50, 190, 40);

        jTextField11.setText("Wilayah tugas");
        jPanel2.add(jTextField11);
        jTextField11.setBounds(500, 130, 190, 40);

        jButton1.setBackground(new java.awt.Color(112, 146, 63));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(602, 380, 80, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Petugas Lapangan", "Petugas Pemeliharaan" }));
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(260, 130, 190, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(40, 80, 720, 440);

        jButton3.setBackground(new java.awt.Color(112, 146, 63));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Kembali");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(40, 550, 90, 27);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bg_admin.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 798, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        handleSimpan();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        new A_Akun().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed
    
     private void handleSimpan() {
        if (!validateInput()) return;
        
        try {
            User user = new User();
            user.setNama(getFieldText(jTextField5));
            user.setUsername(getFieldText(jTextField2));
            user.setEmail(getFieldText(jTextField4));
            user.setNoTelp(getFieldText(jTextField9));
            user.setRole((String) jComboBox1.getSelectedItem());
            
            if (isEditMode) {
                user.setIdUser(userId);
                if (user.updateUser()) {
                    updateRoleSpecificData(user.getRole());
                    JOptionPane.showMessageDialog(this,
                        "User berhasil diupdate!",
                        "Sukses",
                        JOptionPane.INFORMATION_MESSAGE);
                    new A_Akun().setVisible(true);
                    this.dispose();
                }
            } else {
                user.setPassword(getFieldText(jTextField3));
                if (user.tambahUser()) {
                    createRoleSpecificEntry(user);
                    JOptionPane.showMessageDialog(this,
                        "User berhasil ditambahkan!",
                        "Sukses",
                        JOptionPane.INFORMATION_MESSAGE);
                    new A_Akun().setVisible(true);
                    this.dispose();
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Error: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void createRoleSpecificEntry(User user) {
        String role = user.getRole();
        
        switch (role) {
            case "Admin":
                Admin admin = new Admin(user.getIdUser(), getFieldText(jTextField8));
                admin.tambahAdmin();
                break;
                
            case "Petugas Lapangan":
                PetugasLapangan pl = new PetugasLapangan(user.getIdUser(), 
                    getFieldText(jTextField11), getFieldText(jTextField6));
                pl.tambahPetugasLapangan();
                break;
                
            case "Petugas Pemeliharaan":
                PetugasPemeliharaan pp = new PetugasPemeliharaan(user.getIdUser(),
                    getFieldText(jTextField1), getFieldText(jTextField10));
                pp.tambahPetugasPemeliharaan();
                break;
        }
    }
    
    private void updateRoleSpecificData(String role) {
        switch (role) {
            case "Admin":
                Admin admin = Admin.getAdminByUserId(userId);
                if (admin != null) {
                    admin.setJabatan(getFieldText(jTextField8));
                    admin.updateAdmin();
                }
                break;
                
            case "Petugas Lapangan":
                PetugasLapangan pl = PetugasLapangan.getPetugasByUserId(userId);
                if (pl != null) {
                    pl.setWilayahTugas(getFieldText(jTextField11));
                    pl.setAlatPengamatan(getFieldText(jTextField6));
                    pl.updatePetugasLapangan();
                }
                break;
                
            case "Petugas Pemeliharaan":
                PetugasPemeliharaan pp = PetugasPemeliharaan.getPetugasByUserId(userId);
                if (pp != null) {
                    pp.setKeahlian(getFieldText(jTextField1));
                    pp.setSertifikasi(getFieldText(jTextField10));
                    pp.updatePetugasPemeliharaan();
                }
                break;
        }
    }
    
    private boolean isValidName(String name) {
    Pattern namePattern = Pattern.compile("^[a-zA-Z\\s]+$");
    return namePattern.matcher(name).matches();
    }
    
    private boolean isValidUsername(String username) {
    // Username: huruf, angka, underscore, dash (no spaces)
    Pattern usernamePattern = Pattern.compile("^[a-zA-Z0-9_-]+$");
    return usernamePattern.matcher(username).matches();
    }
    
    private boolean isValidEmail(String email) {
    Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    return emailPattern.matcher(email).matches();
    }
    
    private boolean isValidPhone(String phone) {
    Pattern phonePattern = Pattern.compile("^\\+?[0-9]{10,15}$");
    return phonePattern.matcher(phone).matches();
    }
    
    private boolean containsInvalidCharacters(String text) {
    Pattern invalidPattern = Pattern.compile("[^a-zA-Z0-9\\s,.\\-']");
    return invalidPattern.matcher(text).find();
    }
    
    private boolean validateInput() {
    String nama = getFieldText(jTextField5);
    String username = getFieldText(jTextField2);
    String password = getFieldText(jTextField3);
    String email = getFieldText(jTextField4);
    String noTelp = getFieldText(jTextField9);
    String role = (String) jComboBox1.getSelectedItem();
    
    // ========== VALIDASI NAMA LENGKAP ==========
    if (nama.isEmpty()) {
        JOptionPane.showMessageDialog(this,
            "Nama Lengkap harus diisi!",
            "Validasi Gagal",
            JOptionPane.WARNING_MESSAGE);
        jTextField5.requestFocus();
        return false;
    }
    
    if (!isValidName(nama)) {
        JOptionPane.showMessageDialog(this,
            "Nama Lengkap tidak boleh mengandung angka atau karakter khusus!\n" +
            "Hanya diperbolehkan: huruf dan spasi",
            "Format Nama Salah",
            JOptionPane.WARNING_MESSAGE);
        jTextField5.requestFocus();
        return false;
    }
    
    if (nama.length() < 3) {
        JOptionPane.showMessageDialog(this,
            "Nama Lengkap minimal 3 karakter!",
            "Validasi Gagal",
            JOptionPane.WARNING_MESSAGE);
        jTextField5.requestFocus();
        return false;
    }
    
    if (nama.length() > 100) {
        JOptionPane.showMessageDialog(this,
            "Nama Lengkap maksimal 100 karakter!",
            "Validasi Gagal",
            JOptionPane.WARNING_MESSAGE);
        jTextField5.requestFocus();
        return false;
    }
    
    // ========== VALIDASI USERNAME ==========
    if (username.isEmpty()) {
        JOptionPane.showMessageDialog(this,
            "Username harus diisi!",
            "Validasi Gagal",
            JOptionPane.WARNING_MESSAGE);
        jTextField2.requestFocus();
        return false;
    }
    
    if (!isValidUsername(username)) {
        JOptionPane.showMessageDialog(this,
            "Username tidak valid!\n" +
            "Hanya diperbolehkan: huruf, angka, underscore (_), dan dash (-)\n" +
            "Tidak boleh ada spasi atau karakter khusus lainnya",
            "Format Salah",
            JOptionPane.WARNING_MESSAGE);
        jTextField2.requestFocus();
        return false;
    }
    
    if (username.length() < 4) {
        JOptionPane.showMessageDialog(this,
            "Username minimal 4 karakter!",
            "Upsss",
            JOptionPane.WARNING_MESSAGE);
        jTextField2.requestFocus();
        return false;
    }
    
    if (username.length() > 50) {
        JOptionPane.showMessageDialog(this,
            "Username maksimal 50 karakter!",
            "Awwwwww",
            JOptionPane.WARNING_MESSAGE);
        jTextField2.requestFocus();
        return false;
    }
    
    // ========== VALIDASI PASSWORD (hanya untuk create mode) ==========
    if (!isEditMode) {
        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Password harus diisi!",
                "Ngawur Cik",
                JOptionPane.WARNING_MESSAGE);
            jTextField3.requestFocus();
            return false;
        }
        
        if (password.length() < 6) {
            JOptionPane.showMessageDialog(this,
                "Password minimal 6 karakter!",
                "Kocaakkkk",
                JOptionPane.WARNING_MESSAGE);
            jTextField3.requestFocus();
            return false;
        }
        
        if (password.length() > 255) {
            JOptionPane.showMessageDialog(this,
                "Password maksimal 255 karakter!",
                "Panjang Amat",
                JOptionPane.WARNING_MESSAGE);
            jTextField3.requestFocus();
            return false;
        }
    }
    
    // ========== VALIDASI EMAIL ==========
    if (email.isEmpty()) {
        JOptionPane.showMessageDialog(this,
            "Email harus diisi!",
            "Lucu",
            JOptionPane.WARNING_MESSAGE);
        jTextField4.requestFocus();
        return false;
    }
    
    if (!isValidEmail(email)) {
        JOptionPane.showMessageDialog(this,
            "Format email tidak valid!\n" +
            "Contoh: user@example.com",
            "Ulang",
            JOptionPane.WARNING_MESSAGE);
        jTextField4.requestFocus();
        return false;
    }
    
    // ========== VALIDASI NOMOR TELEPON ==========
    if (noTelp.isEmpty()) {
        JOptionPane.showMessageDialog(this,
            "Nomor Telepon harus diisi!",
            "wkwkkwkwkwk",
            JOptionPane.WARNING_MESSAGE);
        jTextField9.requestFocus();
        return false;
    }
    
    if (!isValidPhone(noTelp)) {
        JOptionPane.showMessageDialog(this,
            "Format Nomor Telepon tidak valid!\n" +
            "Hanya diperbolehkan: angka (10-15 digit)\n" +
            "Contoh: 081234567890 atau +6281234567890",
            "Validasi Gagal",
            JOptionPane.WARNING_MESSAGE);
        jTextField9.requestFocus();
        return false;
    }
    
    // ========== VALIDASI ROLE ==========
    if (role == null || role.isEmpty()) {
        JOptionPane.showMessageDialog(this,
            "Role harus dipilih!",
            "Validasi Gagal",
            JOptionPane.WARNING_MESSAGE);
        jComboBox1.requestFocus();
        return false;
    }
    
    // ========== VALIDASI ROLE-SPECIFIC FIELDS ==========
    return validateRoleSpecificFields(role);
}
    private boolean validateRoleSpecificFields(String role) {
    switch (role) {
        case "Admin":
            String jabatan = getFieldText(jTextField8);
            if (jabatan.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Jabatan harus diisi untuk Admin!",
                    "Validasi Gagal",
                    JOptionPane.WARNING_MESSAGE);
                jTextField8.requestFocus();
                return false;
            }
            
            if (containsInvalidCharacters(jabatan)) {
                JOptionPane.showMessageDialog(this,
                    "Jabatan tidak boleh mengandung karakter khusus!",
                    "Validasi Gagal",
                    JOptionPane.WARNING_MESSAGE);
                jTextField8.requestFocus();
                return false;
            }
            
            if (jabatan.length() < 3) {
                JOptionPane.showMessageDialog(this,
                    "Jabatan minimal 3 karakter!",
                    "Validasi Gagal",
                    JOptionPane.WARNING_MESSAGE);
                jTextField8.requestFocus();
                return false;
            }
            break;
            
        case "Petugas Lapangan":
            String wilayah = getFieldText(jTextField11);
            String alat = getFieldText(jTextField6);
            
            if (wilayah.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Wilayah Tugas harus diisi untuk Petugas Lapangan!",
                    "Isi kocak",
                    JOptionPane.WARNING_MESSAGE);
                jTextField11.requestFocus();
                return false;
            }
            
            if (containsInvalidCharacters(wilayah)) {
                JOptionPane.showMessageDialog(this,
                    "Wilayah Tugas tidak boleh mengandung karakter khusus!",
                    "HMMMMM",
                    JOptionPane.WARNING_MESSAGE);
                jTextField11.requestFocus();
                return false;
            }
            
            if (wilayah.length() < 3) {
                JOptionPane.showMessageDialog(this,
                    "Wilayah Tugas minimal 3 karakter!",
                    "Upsss",
                    JOptionPane.WARNING_MESSAGE);
                jTextField11.requestFocus();
                return false;
            }
            
            if (alat.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Alat Pengamatan harus diisi untuk Petugas Lapangan!",
                    "Hey",
                    JOptionPane.WARNING_MESSAGE);
                jTextField6.requestFocus();
                return false;
            }
            
            if (alat.length() < 3) {
                JOptionPane.showMessageDialog(this,
                    "Alat Pengamatan minimal 3 karakter!",
                    "Alat apa itu wok",
                    JOptionPane.WARNING_MESSAGE);
                jTextField6.requestFocus();
                return false;
            }
            break;
            
        case "Petugas Pemeliharaan":
            String keahlian = getFieldText(jTextField1);
            String sertifikasi = getFieldText(jTextField10);
            
            if (keahlian.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Keahlian harus diisi untuk Petugas Pemeliharaan!",
                    "Ndak ACC",
                    JOptionPane.WARNING_MESSAGE);
                jTextField1.requestFocus();
                return false;
            }
            
            if (containsInvalidCharacters(keahlian)) {
                JOptionPane.showMessageDialog(this,
                    "Keahlian tidak boleh mengandung karakter khusus!",
                    "Keahlian apa itu wok",
                    JOptionPane.WARNING_MESSAGE);
                jTextField1.requestFocus();
                return false;
            }
            
            if (keahlian.length() < 3) {
                JOptionPane.showMessageDialog(this,
                    "Keahlian minimal 3 karakter!",
                    "3333333",
                    JOptionPane.WARNING_MESSAGE);
                jTextField1.requestFocus();
                return false;
            }
            
            if (sertifikasi.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Sertifikasi harus diisi untuk Petugas Pemeliharaan!",
                    "Hadeuh",
                    JOptionPane.WARNING_MESSAGE);
                jTextField10.requestFocus();
                return false;
            }
            
            if (containsInvalidCharacters(sertifikasi)) {
                JOptionPane.showMessageDialog(this,
                    "Sertifikasi tidak boleh mengandung karakter khusus!",
                    ":<",
                    JOptionPane.WARNING_MESSAGE);
                jTextField10.requestFocus();
                return false;
            }
            
            if (sertifikasi.length() < 3) {
                JOptionPane.showMessageDialog(this,
                    "Sertifikasi minimal 3 karakter!",
                    "ihhhh",
                    JOptionPane.WARNING_MESSAGE);
                jTextField10.requestFocus();
                return false;
            }
            break;
    }
    
    return true;
}
    
        private String getFieldText(JTextField field) {
        String text = field.getText().trim();
        // Check if it's still placeholder
        if (text.equals("Nama lengkap") || text.equals("Username") || 
            text.equals("Password") || text.equals("Email") || 
            text.equals("Nomor telepon") || text.equals("Jabatan") ||
            text.equals("Keahlian") || text.equals("Sertifikasi") ||
            text.equals("Wilayah tugas") || text.equals("Alat pengamatan")) {
            return "";
        }
        return text;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> new A_AkunForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
