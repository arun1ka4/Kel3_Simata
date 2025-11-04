package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Model class untuk Petugas Pemeliharaan
 */
public class PetugasPemeliharaan {
    private int idPetugasPemeliharaan;
    private int idUser;
    private String keahlian;
    private String sertifikasi;
    
    // Extra fields dari User
    private String nama;
    private String username;
    private String email;
    private String noTelp;
    
    // Constructors
    public PetugasPemeliharaan() {}
    
    public PetugasPemeliharaan(int idUser, String keahlian, String sertifikasi) {
        this.idUser = idUser;
        this.keahlian = keahlian;
        this.sertifikasi = sertifikasi;
    }
    
    // Getters and Setters
    public int getIdPetugasPemeliharaan() { return idPetugasPemeliharaan; }
    public void setIdPetugasPemeliharaan(int idPetugasPemeliharaan) { 
        this.idPetugasPemeliharaan = idPetugasPemeliharaan; 
    }
    
    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }
    
    public String getKeahlian() { return keahlian; }
    public void setKeahlian(String keahlian) { this.keahlian = keahlian; }
    
    public String getSertifikasi() { return sertifikasi; }
    public void setSertifikasi(String sertifikasi) { this.sertifikasi = sertifikasi; }
    
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getNoTelp() { return noTelp; }
    public void setNoTelp(String noTelp) { this.noTelp = noTelp; }
    
    /**
     * Method untuk tambah petugas pemeliharaan baru
     */
    public boolean tambahPetugasPemeliharaan() {
        Connection conn = Koneksi.getKoneksi();
        boolean success = false;
        
        try {
            String query = "INSERT INTO petugas_pemeliharaan (id_user, keahlian, " +
                          "sertifikasi) VALUES (?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, this.idUser);
            ps.setString(2, this.keahlian);
            ps.setString(3, this.sertifikasi);
            
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    this.idPetugasPemeliharaan = rs.getInt(1);
                }
                success = true;
            }
            
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat menambah petugas pemeliharaan: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return success;
    }
    
    /**
     * Method untuk update petugas pemeliharaan
     */
    public boolean updatePetugasPemeliharaan() {
        Connection conn = Koneksi.getKoneksi();
        boolean success = false;
        
        try {
            String query = "UPDATE petugas_pemeliharaan SET keahlian=?, " +
                          "sertifikasi=? WHERE id_petugas_pemeliharaan=?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, this.keahlian);
            ps.setString(2, this.sertifikasi);
            ps.setInt(3, this.idPetugasPemeliharaan);
            
            int rowsAffected = ps.executeUpdate();
            success = (rowsAffected > 0);
            
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat update petugas pemeliharaan: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return success;
    }
    
    /**
     * Method untuk get petugas pemeliharaan by user ID
     */
    public static PetugasPemeliharaan getPetugasByUserId(int idUser) {
        Connection conn = Koneksi.getKoneksi();
        PetugasPemeliharaan petugas = null;
        
        try {
            String query = "SELECT pp.*, u.nama, u.username, u.email, u.no_telp " +
                          "FROM petugas_pemeliharaan pp " +
                          "JOIN user u ON pp.id_user = u.id_user " +
                          "WHERE pp.id_user = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idUser);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                petugas = new PetugasPemeliharaan();
                petugas.setIdPetugasPemeliharaan(rs.getInt("id_petugas_pemeliharaan"));
                petugas.setIdUser(rs.getInt("id_user"));
                petugas.setKeahlian(rs.getString("keahlian"));
                petugas.setSertifikasi(rs.getString("sertifikasi"));
                petugas.setNama(rs.getString("nama"));
                petugas.setUsername(rs.getString("username"));
                petugas.setEmail(rs.getString("email"));
                petugas.setNoTelp(rs.getString("no_telp"));
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat mengambil data petugas: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return petugas;
    }
    
    /**
     * Method untuk get petugas pemeliharaan by ID
     */
    public static PetugasPemeliharaan getPetugasById(int idPetugasPemeliharaan) {
        Connection conn = Koneksi.getKoneksi();
        PetugasPemeliharaan petugas = null;
        
        try {
            String query = "SELECT pp.*, u.nama, u.username, u.email, u.no_telp " +
                          "FROM petugas_pemeliharaan pp " +
                          "JOIN user u ON pp.id_user = u.id_user " +
                          "WHERE pp.id_petugas_pemeliharaan = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idPetugasPemeliharaan);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                petugas = new PetugasPemeliharaan();
                petugas.setIdPetugasPemeliharaan(rs.getInt("id_petugas_pemeliharaan"));
                petugas.setIdUser(rs.getInt("id_user"));
                petugas.setKeahlian(rs.getString("keahlian"));
                petugas.setSertifikasi(rs.getString("sertifikasi"));
                petugas.setNama(rs.getString("nama"));
                petugas.setUsername(rs.getString("username"));
                petugas.setEmail(rs.getString("email"));
                petugas.setNoTelp(rs.getString("no_telp"));
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat mengambil data petugas: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return petugas;
    }
    
    /**
     * Method untuk get semua petugas pemeliharaan
     */
    public static List<PetugasPemeliharaan> getAllPetugasPemeliharaan() {
        Connection conn = Koneksi.getKoneksi();
        List<PetugasPemeliharaan> listPetugas = new ArrayList<>();
        
        try {
            String query = "SELECT pp.*, u.nama, u.username, u.email, u.no_telp " +
                          "FROM petugas_pemeliharaan pp " +
                          "JOIN user u ON pp.id_user = u.id_user " +
                          "ORDER BY u.nama";
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                PetugasPemeliharaan petugas = new PetugasPemeliharaan();
                petugas.setIdPetugasPemeliharaan(rs.getInt("id_petugas_pemeliharaan"));
                petugas.setIdUser(rs.getInt("id_user"));
                petugas.setKeahlian(rs.getString("keahlian"));
                petugas.setSertifikasi(rs.getString("sertifikasi"));
                petugas.setNama(rs.getString("nama"));
                petugas.setUsername(rs.getString("username"));
                petugas.setEmail(rs.getString("email"));
                petugas.setNoTelp(rs.getString("no_telp"));
                
                listPetugas.add(petugas);
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat mengambil data petugas pemeliharaan: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return listPetugas;
    }
    
    /**
     * Method untuk get jumlah pemeliharaan petugas
     */
    public static int getJumlahPemeliharaan(int idPetugasPemeliharaan) {
        Connection conn = Koneksi.getKoneksi();
        int jumlah = 0;
        
        try {
            String query = "SELECT COUNT(*) as total FROM pemeliharaan " +
                          "WHERE id_petugas_pemeliharaan = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idPetugasPemeliharaan);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                jumlah = rs.getInt("total");
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return jumlah;
    }
}