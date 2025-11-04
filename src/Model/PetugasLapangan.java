package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Model class untuk Petugas Lapangan
 */
public class PetugasLapangan {
    private int idPetugasLapangan;
    private int idUser;
    private String wilayahTugas;
    private String alatPengamatan;
    
    // Extra fields dari User
    private String nama;
    private String username;
    private String email;
    private String noTelp;
    
    // Constructors
    public PetugasLapangan() {}
    
    public PetugasLapangan(int idUser, String wilayahTugas, String alatPengamatan) {
        this.idUser = idUser;
        this.wilayahTugas = wilayahTugas;
        this.alatPengamatan = alatPengamatan;
    }
    
    // Getters and Setters
    public int getIdPetugasLapangan() { return idPetugasLapangan; }
    public void setIdPetugasLapangan(int idPetugasLapangan) { 
        this.idPetugasLapangan = idPetugasLapangan; 
    }
    
    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }
    
    public String getWilayahTugas() { return wilayahTugas; }
    public void setWilayahTugas(String wilayahTugas) { 
        this.wilayahTugas = wilayahTugas; 
    }
    
    public String getAlatPengamatan() { return alatPengamatan; }
    public void setAlatPengamatan(String alatPengamatan) { 
        this.alatPengamatan = alatPengamatan; 
    }
    
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getNoTelp() { return noTelp; }
    public void setNoTelp(String noTelp) { this.noTelp = noTelp; }
    
    /**
     * Method untuk tambah petugas lapangan baru
     */
    public boolean tambahPetugasLapangan() {
        Connection conn = Koneksi.getKoneksi();
        boolean success = false;
        
        try {
            String query = "INSERT INTO petugas_lapangan (id_user, wilayah_tugas, " +
                          "alat_pengamatan) VALUES (?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, this.idUser);
            ps.setString(2, this.wilayahTugas);
            ps.setString(3, this.alatPengamatan);
            
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    this.idPetugasLapangan = rs.getInt(1);
                }
                success = true;
            }
            
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat menambah petugas lapangan: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return success;
    }
    
    /**
     * Method untuk update petugas lapangan
     */
    public boolean updatePetugasLapangan() {
        Connection conn = Koneksi.getKoneksi();
        boolean success = false;
        
        try {
            String query = "UPDATE petugas_lapangan SET wilayah_tugas=?, " +
                          "alat_pengamatan=? WHERE id_petugas_lapangan=?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, this.wilayahTugas);
            ps.setString(2, this.alatPengamatan);
            ps.setInt(3, this.idPetugasLapangan);
            
            int rowsAffected = ps.executeUpdate();
            success = (rowsAffected > 0);
            
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat update petugas lapangan: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return success;
    }
    
    /**
     * Method untuk get petugas lapangan by user ID
     */
    public static PetugasLapangan getPetugasByUserId(int idUser) {
        Connection conn = Koneksi.getKoneksi();
        PetugasLapangan petugas = null;
        
        try {
            String query = "SELECT pl.*, u.nama, u.username, u.email, u.no_telp " +
                          "FROM petugas_lapangan pl " +
                          "JOIN user u ON pl.id_user = u.id_user " +
                          "WHERE pl.id_user = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idUser);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                petugas = new PetugasLapangan();
                petugas.setIdPetugasLapangan(rs.getInt("id_petugas_lapangan"));
                petugas.setIdUser(rs.getInt("id_user"));
                petugas.setWilayahTugas(rs.getString("wilayah_tugas"));
                petugas.setAlatPengamatan(rs.getString("alat_pengamatan"));
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
     * Method untuk get petugas lapangan by ID
     */
    public static PetugasLapangan getPetugasById(int idPetugasLapangan) {
        Connection conn = Koneksi.getKoneksi();
        PetugasLapangan petugas = null;
        
        try {
            String query = "SELECT pl.*, u.nama, u.username, u.email, u.no_telp " +
                          "FROM petugas_lapangan pl " +
                          "JOIN user u ON pl.id_user = u.id_user " +
                          "WHERE pl.id_petugas_lapangan = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idPetugasLapangan);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                petugas = new PetugasLapangan();
                petugas.setIdPetugasLapangan(rs.getInt("id_petugas_lapangan"));
                petugas.setIdUser(rs.getInt("id_user"));
                petugas.setWilayahTugas(rs.getString("wilayah_tugas"));
                petugas.setAlatPengamatan(rs.getString("alat_pengamatan"));
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
     * Method untuk get semua petugas lapangan
     */
    public static List<PetugasLapangan> getAllPetugasLapangan() {
        Connection conn = Koneksi.getKoneksi();
        List<PetugasLapangan> listPetugas = new ArrayList<>();
        
        try {
            String query = "SELECT pl.*, u.nama, u.username, u.email, u.no_telp " +
                          "FROM petugas_lapangan pl " +
                          "JOIN user u ON pl.id_user = u.id_user " +
                          "ORDER BY u.nama";
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                PetugasLapangan petugas = new PetugasLapangan();
                petugas.setIdPetugasLapangan(rs.getInt("id_petugas_lapangan"));
                petugas.setIdUser(rs.getInt("id_user"));
                petugas.setWilayahTugas(rs.getString("wilayah_tugas"));
                petugas.setAlatPengamatan(rs.getString("alat_pengamatan"));
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
                "Error saat mengambil data petugas lapangan: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return listPetugas;
    }
    
    /**
     * Method untuk get jumlah pengamatan petugas
     */
    public static int getJumlahPengamatan(int idPetugasLapangan) {
        Connection conn = Koneksi.getKoneksi();
        int jumlah = 0;
        
        try {
            String query = "SELECT COUNT(*) as total FROM pengamatan " +
                          "WHERE id_petugas_lapangan = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idPetugasLapangan);
            
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