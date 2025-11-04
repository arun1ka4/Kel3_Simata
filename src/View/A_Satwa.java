/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package View;
import Model.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.table.DefaultTableCellRenderer;
import java.io.File;
import java.util.regex.Pattern;

/**
 *
 * @author nitro
 */
public class A_Satwa extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(A_Satwa.class.getName());
    private int selectedSatwaId = -1;
    private String fotoPath = "";

    public A_Satwa() {
        initComponents();
        setupTable();
        loadTableData();
        setupPlaceholders();
        setupTextArea();
        this.setSize(800, 635);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        
        jTable1.getTableHeader().setOpaque(true);
        jTable1.getTableHeader().setBackground(Color.WHITE);
        jTable1.getTableHeader().setForeground(new Color(112,146,63));
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        jTable1.getTableHeader().setAlignmentX(JLabel.CENTER);
        
        ((DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(center);
        
         // Make foto textfield readonly
        jTextField10.setEditable(false);
        jTextField10.setBackground(new Color(240, 240, 240));
    }
    
    private void setupPlaceholders() {
        removePlaceholder(jTextField5, "Nama satwa");
        removePlaceholder(jTextField6, "Nama latin");
        removePlaceholder(jTextField7, "Kategori");
    }
    
    private void setupTextArea() {
        JTextArea txtDeskripsi = new JTextArea();
        txtDeskripsi.setLineWrap(true);
        txtDeskripsi.setWrapStyleWord(true);
        jScrollPane3.setViewportView(txtDeskripsi);
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
    
    private void setupTable() {
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable1.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && jTable1.getSelectedRow() >= 0) {
                loadSelectedRow();
            }
        });
    }
    
     private void loadTableData() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        List<Satwa> listSatwa = Satwa.getAllSatwa();
        for (Satwa satwa : listSatwa) {
            String fotoDisplay = "";
            if (satwa.getFotoSatwa() != null && !satwa.getFotoSatwa().isEmpty()) {
                File fotoFile = new File(satwa.getFotoSatwa());
                fotoDisplay = fotoFile.getName();
            }
            
            Object[] row = {
                satwa.getIdSatwa(),
                satwa.getNamaSatwa(),
                satwa.getNamaLatin(),
                satwa.getKategori(),
                satwa.getDeskripsi(),
                fotoDisplay
            };
            model.addRow(row);
        }
    }
    
    private void loadSelectedRow() {
        int row = jTable1.getSelectedRow();
        if (row >= 0) {
            selectedSatwaId = (int) jTable1.getValueAt(row, 0);
            
            Satwa satwa = Satwa.getSatwaById(selectedSatwaId);
            if (satwa != null) {
                jTextField5.setText(satwa.getNamaSatwa());
                jTextField6.setText(satwa.getNamaLatin());
                jTextField7.setText(satwa.getKategori());
                
                JTextArea txtDeskripsi = (JTextArea) jScrollPane3.getViewport().getView();
                txtDeskripsi.setText(satwa.getDeskripsi());
                
                fotoPath = satwa.getFotoSatwa() != null ? satwa.getFotoSatwa() : "";
                if (!fotoPath.isEmpty()) {
                    File file = new File(fotoPath);
                    jTextField10.setText(file.getName());
                } else {
                    jTextField10.setText("");
                }
            }
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
        jTextField5 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Myanmar Text", 1, 30)); // NOI18N
        jLabel2.setText("KELOLA SATWA");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 30, 230, 50);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jTextField5.setText("Nama satwa");
        jPanel2.add(jTextField5);
        jTextField5.setBounds(26, 32, 296, 32);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(68, 84, 41));
        jLabel3.setText("Nama Satwa");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(26, 6, 128, 20);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(68, 84, 41));
        jLabel4.setText("Nama Latin");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(26, 70, 128, 20);

        jTextField6.setText("Nama latin");
        jPanel2.add(jTextField6);
        jTextField6.setBounds(26, 96, 296, 32);

        jTextField7.setText("Kategori");
        jPanel2.add(jTextField7);
        jTextField7.setBounds(26, 160, 296, 32);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(68, 84, 41));
        jLabel5.setText("Kategori");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(26, 134, 128, 20);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(68, 84, 41));
        jLabel7.setText("Deskripsi");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(355, 70, 128, 20);
        jPanel2.add(jTextField10);
        jTextField10.setBounds(355, 32, 210, 32);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(68, 84, 41));
        jLabel8.setText("Foto Satwa");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(355, 6, 128, 20);

        jButton5.setBackground(new java.awt.Color(112, 146, 63));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Pilih Foto");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(583, 30, 100, 32);

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(360, 100, 320, 90);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(40, 80, 720, 210);

        jButton4.setBackground(new java.awt.Color(112, 146, 63));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Buat");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(70, 300, 110, 30);

        jButton3.setBackground(new java.awt.Color(112, 146, 63));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Lihat Foto");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(600, 300, 110, 30);

        jButton2.setBackground(new java.awt.Color(112, 146, 63));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Hapus");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(420, 300, 110, 30);

        jPanel1.setBackground(new java.awt.Color(204, 198, 185));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama Satwa", "Nama Latin", "Kategori", "Deskripsi", "Foto"
            }
        ));
        jTable1.setSelectionBackground(new java.awt.Color(225, 159, 93));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(40, 340, 720, 190);

        jButton6.setBackground(new java.awt.Color(112, 146, 63));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Edit");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(240, 300, 110, 30);

        jButton1.setBackground(new java.awt.Color(112, 146, 63));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(40, 550, 90, 27);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bg_admin.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Button Lihat Foto - Display photo from drive
        if (fotoPath == null || fotoPath.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Tidak ada foto yang dipilih!",
                "Info",
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        // Check if file exists
        File imageFile = new File(fotoPath);
        if (!imageFile.exists()) {
            JOptionPane.showMessageDialog(this,
                "File foto tidak ditemukan!\nPath: " + fotoPath,
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Check if file exists
//        File imageFile = new File(fotoPath);
        if (!imageFile.exists()) {
            JOptionPane.showMessageDialog(this,
                "File foto tidak ditemukan!\nPath: " + fotoPath,
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            // Create a dialog to display the image
            JDialog dialog = new JDialog(this, "Foto Satwa - " + imageFile.getName(), true);
            dialog.setSize(600, 600);
            dialog.setLocationRelativeTo(this);
            dialog.setLayout(new java.awt.BorderLayout());
            
            // Load and scale image
            ImageIcon imageIcon = new ImageIcon(imageFile.getPath());
            Image image = imageIcon.getImage();
            
            // Scale image to fit dialog
            int maxWidth = 550;
            int maxHeight = 550;
            int imgWidth = imageIcon.getIconWidth();
            int imgHeight = imageIcon.getIconHeight();
            
            double scale = Math.min((double)maxWidth/imgWidth, (double)maxHeight/imgHeight);
            int scaledWidth = (int)(imgWidth * scale);
            int scaledHeight = (int)(imgHeight * scale);
            
            Image scaledImage = image.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            
            JScrollPane scrollPane = new JScrollPane(imageLabel);
            dialog.add(scrollPane, java.awt.BorderLayout.CENTER);
            
            // Add close button
            JButton btnClose = new JButton("Tutup");
            btnClose.addActionListener(e -> dialog.dispose());
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(btnClose);
            dialog.add(buttonPanel, java.awt.BorderLayout.SOUTH);
            
            dialog.setVisible(true);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Error menampilkan foto: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            logger.log(java.util.logging.Level.SEVERE, "Error displaying image", e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Pilih Foto Satwa");
    fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
        "Image Files (*.jpg, *.jpeg, *.png, *.gif)", "jpg", "jpeg", "png", "gif"));
    
    // Set default directory
    String userHome = System.getProperty("user.home");
    File picturesFolder = new File(userHome + "\\Pictures\\simata");
    if (picturesFolder.exists()) {
        fileChooser.setCurrentDirectory(picturesFolder);
    } else {
        picturesFolder = new File(userHome + "\\Pictures");
        if (picturesFolder.exists()) {
            fileChooser.setCurrentDirectory(picturesFolder);
        }
    }
    
    int result = fileChooser.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        
        // Validasi file exists
        if (!selectedFile.exists()) {
            JOptionPane.showMessageDialog(this,
                "File tidak ditemukan!",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Validasi ekstensi file
        String fileName = selectedFile.getName().toLowerCase();
        if (!fileName.endsWith(".jpg") && !fileName.endsWith(".jpeg") && 
            !fileName.endsWith(".png") && !fileName.endsWith(".gif")) {
            JOptionPane.showMessageDialog(this,
                "File harus berupa gambar (jpg, jpeg, png, gif)!",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Validasi ukuran file (max 5MB)
        long fileSize = selectedFile.length();
        long maxSize = 5 * 1024 * 1024; // 5MB
        if (fileSize > maxSize) {
            JOptionPane.showMessageDialog(this,
                "Ukuran file terlalu besar!\nMaksimal 5 MB.\nUkuran file: " + (fileSize / 1024 / 1024) + " MB",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Save full path
        fotoPath = selectedFile.getAbsolutePath();
        jTextField10.setText(selectedFile.getName());
        
        JOptionPane.showMessageDialog(this,
            "Foto berhasil dipilih!\nFile: " + selectedFile.getName(),
            "Sukses",
            JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         handleEdit();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void handleEdit() {
        if (selectedSatwaId == -1) {
            JOptionPane.showMessageDialog(this,
                "Pilih satwa yang ingin diedit dari tabel!",
                "Peringatan",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!validateInput()) return;
        
        Satwa satwa = new Satwa();
        satwa.setIdSatwa(selectedSatwaId);
        satwa.setNamaSatwa(getFieldText(jTextField5));
        satwa.setNamaLatin(getFieldText(jTextField6));
        satwa.setKategori(getFieldText(jTextField7));
        
        JTextArea txtDeskripsi = (JTextArea) jScrollPane3.getViewport().getView();
        satwa.setDeskripsi(txtDeskripsi.getText().trim());
        satwa.setStatusKonservasi("LC");
        satwa.setFotoSatwa(fotoPath); // Save full path
        
        if (satwa.updateSatwa()) {
            JOptionPane.showMessageDialog(this,
                "Satwa berhasil diupdate!",
                "Sukses",
                JOptionPane.INFORMATION_MESSAGE);
            clearForm();
            loadTableData();
        } else {
            JOptionPane.showMessageDialog(this,
                "Gagal mengupdate satwa!",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
          handleBuat();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        handleHapus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new A_Menu().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
 
    private void handleBuat() {
        if (!validateInput()) return;
        
        Satwa satwa = new Satwa();
        satwa.setNamaSatwa(getFieldText(jTextField5));
        satwa.setNamaLatin(getFieldText(jTextField6));
        satwa.setKategori(getFieldText(jTextField7));
        
        JTextArea txtDeskripsi = (JTextArea) jScrollPane3.getViewport().getView();
        satwa.setDeskripsi(txtDeskripsi.getText().trim());
        satwa.setStatusKonservasi("LC");
        satwa.setFotoSatwa(fotoPath); // Save full path
        
        if (satwa.tambahSatwa()) {
            JOptionPane.showMessageDialog(this,
                "Satwa berhasil ditambahkan!",
                "Sukses",
                JOptionPane.INFORMATION_MESSAGE);
            clearForm();
            loadTableData();
        } else {
            JOptionPane.showMessageDialog(this,
                "Gagal menambahkan satwa!",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
        private void handleHapus() {
        if (selectedSatwaId == -1) {
            JOptionPane.showMessageDialog(this,
                "Pilih satwa yang ingin dihapus dari tabel!",
                "Peringatan",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this,
            "Apakah Anda yakin ingin menghapus satwa ini?\n" +
            "Data yang dihapus tidak dapat dikembalikan!",
            "Konfirmasi Hapus",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);
        
        if (confirm == JOptionPane.YES_OPTION) {
            if (Satwa.hapusSatwa(selectedSatwaId)) {
                JOptionPane.showMessageDialog(this,
                    "Satwa berhasil dihapus!",
                    "Sukses",
                    JOptionPane.INFORMATION_MESSAGE);
                clearForm();
                loadTableData();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Gagal menghapus satwa!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // ==================== VALIDATION ====================
    
    private boolean containsInvalidCharacters(String text) {
    // Pattern untuk detect special characters yang tidak diperbolehkan
    // Mengizinkan: huruf (a-z, A-Z), angka (0-9), spasi, koma, titik, dash, apostrof
    Pattern invalidPattern = Pattern.compile("[^a-zA-Z0-9\\s,.\\-']");
    return invalidPattern.matcher(text).find();
}
    
    private boolean validateInput() {
    String nama = getFieldText(jTextField5);
    String namaLatin = getFieldText(jTextField6);
    String kategori = getFieldText(jTextField7);
    
    JTextArea txtDeskripsi = (JTextArea) jScrollPane3.getViewport().getView();
    String deskripsi = txtDeskripsi.getText().trim();
    
    // ========== VALIDASI NAMA SATWA ==========
    if (nama.isEmpty()) {
        JOptionPane.showMessageDialog(this,
            "Nama Satwa harus diisi!",
            "Validasi Gagal",
            JOptionPane.WARNING_MESSAGE);
        jTextField5.requestFocus();
        return false;
    }
    
    if (containsInvalidCharacters(nama)) {
        JOptionPane.showMessageDialog(this,
            "Nama Satwa tidak boleh mengandung karakter khusus!\n" +
            "Hanya diperbolehkan: huruf, angka, spasi, koma, titik, dash (-), apostrof (')",
            "Validasi Gagal",
            JOptionPane.WARNING_MESSAGE);
        jTextField5.requestFocus();
        return false;
    }
    
    if (nama.length() < 3) {
        JOptionPane.showMessageDialog(this,
            "Nama Satwa minimal 3 karakter!",
            "Validasi Gagal",
            JOptionPane.WARNING_MESSAGE);
        jTextField5.requestFocus();
        return false;
    }
    
    // ========== VALIDASI NAMA LATIN ==========
    if (namaLatin.isEmpty()) {
        JOptionPane.showMessageDialog(this,
            "Nama Latin harus diisi!",
            "Validasi Gagal",
            JOptionPane.WARNING_MESSAGE);
        jTextField6.requestFocus();
        return false;
    }
    
    if (containsInvalidCharacters(namaLatin)) {
        JOptionPane.showMessageDialog(this,
            "Nama Latin tidak boleh mengandung karakter khusus!\n" +
            "Hanya diperbolehkan: huruf, angka, spasi",
            "Validasi Gagal",
            JOptionPane.WARNING_MESSAGE);
        jTextField6.requestFocus();
        return false;
    }
    
    if (namaLatin.length() < 3) {
        JOptionPane.showMessageDialog(this,
            "Nama Latin minimal 3 karakter!",
            "Validasi Gagal",
            JOptionPane.WARNING_MESSAGE);
        jTextField6.requestFocus();
        return false;
    }
    
    // ========== VALIDASI KATEGORI ==========
    if (kategori.isEmpty()) {
        JOptionPane.showMessageDialog(this,
            "Kategori harus diisi!",
            "Validasi Gagal",
            JOptionPane.WARNING_MESSAGE);
        jTextField7.requestFocus();
        return false;
    }
    
    if (containsInvalidCharacters(kategori)) {
        JOptionPane.showMessageDialog(this,
            "Kategori tidak boleh mengandung karakter khusus!\n" +
            "Hanya diperbolehkan: huruf, angka, spasi",
            "Validasi Gagal",
            JOptionPane.WARNING_MESSAGE);
        jTextField7.requestFocus();
        return false;
    }
    
    // ========== VALIDASI DESKRIPSI ==========
    if (deskripsi.isEmpty()) {
        JOptionPane.showMessageDialog(this,
            "Deskripsi harus diisi!",
            "Validasi Gagal",
            JOptionPane.WARNING_MESSAGE);
        txtDeskripsi.requestFocus();
        return false;
    }
    
    if (deskripsi.length() < 10) {
        JOptionPane.showMessageDialog(this,
            "Deskripsi minimal 10 karakter!",
            "Validasi Gagal",
            JOptionPane.WARNING_MESSAGE);
        txtDeskripsi.requestFocus();
        return false;
    }
    
    // Deskripsi boleh ada special character tapi tetap di validasi panjangnya
    if (deskripsi.length() > 500) {
        JOptionPane.showMessageDialog(this,
            "Deskripsi maksimal 500 karakter!",
            "Validasi Gagal",
            JOptionPane.WARNING_MESSAGE);
        txtDeskripsi.requestFocus();
        return false;
    }
    
    // ========== VALIDASI FOTO ==========
    if (fotoPath == null || fotoPath.isEmpty()) {
        JOptionPane.showMessageDialog(this,
            "Foto Satwa harus dipilih!\nKlik tombol 'Pilih Foto' untuk memilih gambar.",
            "Validasi Gagal",
            JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
    // Validasi file foto masih ada
    File fotoFile = new File(fotoPath);
    if (!fotoFile.exists()) {
        JOptionPane.showMessageDialog(this,
            "File foto tidak ditemukan!\nPath: " + fotoPath + "\n\nSilakan pilih foto lagi.",
            "Validasi Gagal",
            JOptionPane.WARNING_MESSAGE);
        fotoPath = "";
        jTextField10.setText("");
        return false;
    }
    
    // Validasi ukuran file (max 5MB)
    long fileSize = fotoFile.length();
    long maxSize = 5 * 1024 * 1024; // 5MB in bytes
    if (fileSize > maxSize) {
        JOptionPane.showMessageDialog(this,
            "Ukuran file foto terlalu besar!\nMaksimal 5 MB.\nUkuran file saat ini: " + (fileSize / 1024 / 1024) + " MB",
            "Validasi Gagal",
            JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
    return true;
}

/**
 * Method untuk mendapatkan text dari field, mengabaikan placeholder
 */
private String getFieldText(JTextField field) {
    String text = field.getText().trim();
    if (text.equals("Nama satwa") || text.equals("Nama latin") || 
        text.equals("Kategori")) {
        return "";
    }
    return text;
}
        
    private void clearForm() {
        jTextField5.setText("Nama satwa");
        jTextField6.setText("Nama latin");
        jTextField7.setText("Kategori");
        jTextField10.setText("");
        
        JTextArea txtDeskripsi = (JTextArea) jScrollPane3.getViewport().getView();
        txtDeskripsi.setText("");
        
        fotoPath = "";
        selectedSatwaId = -1;
        jTable1.clearSelection();
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
        
        java.awt.EventQueue.invokeLater(() -> new A_Satwa().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
