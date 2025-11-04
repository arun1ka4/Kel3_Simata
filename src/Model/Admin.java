package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Model class untuk Admin
 */
public class Admin {
    private int idAdmin;
    private int idUser;
    private String jabatan;
    
    // Extra fields dari User
    private String nama;
    private String username;
    private String email;
    private String noTelp;
    
    // Constructors
    public Admin() {}
    
    public Admin(int idUser, String jabatan) {
        this.idUser = idUser;
        this.jabatan = jabatan;
    }
    
    // Getters and Setters
    public int getIdAdmin() { return idAdmin; }
    public void setIdAdmin(int idAdmin) { this.idAdmin = idAdmin; }
    
    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }
    
    public String getJabatan() { return jabatan; }
    public void setJabatan(String jabatan) { this.jabatan = jabatan; }
    
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getNoTelp() { return noTelp; }
    public void setNoTelp(String noTelp) { this.noTelp = noTelp; }
    
    /**
     * Method untuk tambah admin baru
     */
    public boolean tambahAdmin() {
        Connection conn = Koneksi.getKoneksi();
        boolean success = false;
        
        try {
            String query = "INSERT INTO admin (id_user, jabatan) VALUES (?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, this.idUser);
            ps.setString(2, this.jabatan);
            
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    this.idAdmin = rs.getInt(1);
                }
                success = true;
            }
            
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat menambah admin: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return success;
    }
    
    /**
     * Method untuk update admin
     */
    public boolean updateAdmin() {
        Connection conn = Koneksi.getKoneksi();
        boolean success = false;
        
        try {
            String query = "UPDATE admin SET jabatan=? WHERE id_admin=?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, this.jabatan);
            ps.setInt(2, this.idAdmin);
            
            int rowsAffected = ps.executeUpdate();
            success = (rowsAffected > 0);
            
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat update admin: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return success;
    }
    
    /**
     * Method untuk get admin by user ID
     */
    public static Admin getAdminByUserId(int idUser) {
        Connection conn = Koneksi.getKoneksi();
        Admin admin = null;
        
        try {
            String query = "SELECT a.*, u.nama, u.username, u.email, u.no_telp " +
                          "FROM admin a " +
                          "JOIN user u ON a.id_user = u.id_user " +
                          "WHERE a.id_user = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idUser);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                admin = new Admin();
                admin.setIdAdmin(rs.getInt("id_admin"));
                admin.setIdUser(rs.getInt("id_user"));
                admin.setJabatan(rs.getString("jabatan"));
                admin.setNama(rs.getString("nama"));
                admin.setUsername(rs.getString("username"));
                admin.setEmail(rs.getString("email"));
                admin.setNoTelp(rs.getString("no_telp"));
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat mengambil data admin: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return admin;
    }
    
    /**
     * Method untuk get admin by ID
     */
    public static Admin getAdminById(int idAdmin) {
        Connection conn = Koneksi.getKoneksi();
        Admin admin = null;
        
        try {
            String query = "SELECT a.*, u.nama, u.username, u.email, u.no_telp " +
                          "FROM admin a " +
                          "JOIN user u ON a.id_user = u.id_user " +
                          "WHERE a.id_admin = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idAdmin);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                admin = new Admin();
                admin.setIdAdmin(rs.getInt("id_admin"));
                admin.setIdUser(rs.getInt("id_user"));
                admin.setJabatan(rs.getString("jabatan"));
                admin.setNama(rs.getString("nama"));
                admin.setUsername(rs.getString("username"));
                admin.setEmail(rs.getString("email"));
                admin.setNoTelp(rs.getString("no_telp"));
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat mengambil data admin: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return admin;
    }
    
    /**
     * Method untuk get semua admin
     */
    public static List<Admin> getAllAdmin() {
        Connection conn = Koneksi.getKoneksi();
        List<Admin> listAdmin = new ArrayList<>();
        
        try {
            String query = "SELECT a.*, u.nama, u.username, u.email, u.no_telp " +
                          "FROM admin a " +
                          "JOIN user u ON a.id_user = u.id_user " +
                          "ORDER BY u.nama";
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setIdAdmin(rs.getInt("id_admin"));
                admin.setIdUser(rs.getInt("id_user"));
                admin.setJabatan(rs.getString("jabatan"));
                admin.setNama(rs.getString("nama"));
                admin.setUsername(rs.getString("username"));
                admin.setEmail(rs.getString("email"));
                admin.setNoTelp(rs.getString("no_telp"));
                
                listAdmin.add(admin);
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat mengambil data admin: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return listAdmin;
    }
    
    /**
     * Method untuk get statistik dashboard
     */
    public static class DashboardStats {
        public int totalSatwa;
        public int totalHabitat;
        public int totalPengamatan;
        public int totalPemeliharaan;
        public int pengamatanMenunggu;
        public int pemeliharaanMenunggu;
        public int totalUser;
    }
    
    public static DashboardStats getDashboardStats() {
        Connection conn = Koneksi.getKoneksi();
        DashboardStats stats = new DashboardStats();
        
        try {
            // Total Satwa
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) as total FROM satwa");
            if (rs.next()) stats.totalSatwa = rs.getInt("total");
            rs.close();
            
            // Total Habitat
            rs = stmt.executeQuery("SELECT COUNT(*) as total FROM habitat");
            if (rs.next()) stats.totalHabitat = rs.getInt("total");
            rs.close();
            
            // Total Pengamatan
            rs = stmt.executeQuery("SELECT COUNT(*) as total FROM pengamatan");
            if (rs.next()) stats.totalPengamatan = rs.getInt("total");
            rs.close();
            
            // Total Pemeliharaan
            rs = stmt.executeQuery("SELECT COUNT(*) as total FROM pemeliharaan");
            if (rs.next()) stats.totalPemeliharaan = rs.getInt("total");
            rs.close();
            
            // Pengamatan Menunggu Verifikasi
            rs = stmt.executeQuery("SELECT COUNT(*) as total FROM pengamatan WHERE status_verifikasi='Menunggu'");
            if (rs.next()) stats.pengamatanMenunggu = rs.getInt("total");
            rs.close();
            
            // Pemeliharaan Menunggu Verifikasi
            rs = stmt.executeQuery("SELECT COUNT(*) as total FROM pemeliharaan WHERE status_verifikasi='Menunggu'");
            if (rs.next()) stats.pemeliharaanMenunggu = rs.getInt("total");
            rs.close();
            
            // Total User
            rs = stmt.executeQuery("SELECT COUNT(*) as total FROM user");
            if (rs.next()) stats.totalUser = rs.getInt("total");
            rs.close();
            
            stmt.close();
            
        } catch (SQLException e) {
            System.err.println("Error getting dashboard stats: " + e.getMessage());
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return stats;
    }
}