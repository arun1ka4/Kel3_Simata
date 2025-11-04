package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Model class untuk Pemeliharaan
 */
public class Pemeliharaan {
    private int idPemeliharaan;
    private int idPetugasPemeliharaan;
    private int idSatwa;
    private Date tanggalPemeliharaan;
    private String kegiatan;
    private String hasilPemeliharaan;
    private String statusVerifikasi;
    private Date tanggalVerifikasi;
    private String keterangan;
    private Integer verifiedBy;
    
    // Extra fields untuk join
    private String namaPetugas;
    private String namaSatwa;
    private String namaAdmin;
    
    // Constructors
    public Pemeliharaan() {}
    
    public Pemeliharaan(int idPetugasPemeliharaan, int idSatwa, Date tanggalPemeliharaan,
                        String kegiatan, String hasilPemeliharaan) {
        this.idPetugasPemeliharaan = idPetugasPemeliharaan;
        this.idSatwa = idSatwa;
        this.tanggalPemeliharaan = tanggalPemeliharaan;
        this.kegiatan = kegiatan;
        this.hasilPemeliharaan = hasilPemeliharaan;
        this.statusVerifikasi = "Menunggu";
    }
    
    // Getters and Setters
    public int getIdPemeliharaan() { return idPemeliharaan; }
    public void setIdPemeliharaan(int idPemeliharaan) { 
        this.idPemeliharaan = idPemeliharaan; 
    }
    
    public int getIdPetugasPemeliharaan() { return idPetugasPemeliharaan; }
    public void setIdPetugasPemeliharaan(int idPetugasPemeliharaan) { 
        this.idPetugasPemeliharaan = idPetugasPemeliharaan; 
    }
    
    public int getIdSatwa() { return idSatwa; }
    public void setIdSatwa(int idSatwa) { this.idSatwa = idSatwa; }
    
    public Date getTanggalPemeliharaan() { return tanggalPemeliharaan; }
    public void setTanggalPemeliharaan(Date tanggalPemeliharaan) { 
        this.tanggalPemeliharaan = tanggalPemeliharaan; 
    }
    
    public String getKegiatan() { return kegiatan; }
    public void setKegiatan(String kegiatan) { this.kegiatan = kegiatan; }
    
    public String getHasilPemeliharaan() { return hasilPemeliharaan; }
    public void setHasilPemeliharaan(String hasilPemeliharaan) { 
        this.hasilPemeliharaan = hasilPemeliharaan; 
    }
    
    public String getStatusVerifikasi() { return statusVerifikasi; }
    public void setStatusVerifikasi(String statusVerifikasi) { 
        this.statusVerifikasi = statusVerifikasi; 
    }
    
    public Date getTanggalVerifikasi() { return tanggalVerifikasi; }
    public void setTanggalVerifikasi(Date tanggalVerifikasi) { 
        this.tanggalVerifikasi = tanggalVerifikasi; 
    }
    
    public String getKeterangan() { return keterangan; }
    public void setKeterangan(String keterangan) { this.keterangan = keterangan; }
    
    public Integer getVerifiedBy() { return verifiedBy; }
    public void setVerifiedBy(Integer verifiedBy) { this.verifiedBy = verifiedBy; }
    
    public String getNamaPetugas() { return namaPetugas; }
    public void setNamaPetugas(String namaPetugas) { this.namaPetugas = namaPetugas; }
    
    public String getNamaSatwa() { return namaSatwa; }
    public void setNamaSatwa(String namaSatwa) { this.namaSatwa = namaSatwa; }
    
    public String getNamaAdmin() { return namaAdmin; }
    public void setNamaAdmin(String namaAdmin) { this.namaAdmin = namaAdmin; }
    
    /**
     * Method untuk tambah pemeliharaan baru
     */
    public boolean tambahPemeliharaan() {
        Connection conn = Koneksi.getKoneksi();
        boolean success = false;
        
        try {
            String query = "INSERT INTO pemeliharaan (id_petugas_pemeliharaan, id_satwa, " +
                          "tanggal_pemeliharaan, kegiatan, hasil_pemeliharaan, " +
                          "status_verifikasi) VALUES (?, ?, ?, ?, ?, 'Menunggu')";
            
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, this.idPetugasPemeliharaan);
            ps.setInt(2, this.idSatwa);
            ps.setDate(3, this.tanggalPemeliharaan);
            ps.setString(4, this.kegiatan);
            ps.setString(5, this.hasilPemeliharaan);
            
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    this.idPemeliharaan = rs.getInt(1);
                }
                success = true;
            }
            
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat menambah pemeliharaan: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return success;
    }
    
    /**
     * Method untuk update pemeliharaan
     */
    public boolean updatePemeliharaan() {
        Connection conn = Koneksi.getKoneksi();
        boolean success = false;
        
        try {
            String query = "UPDATE pemeliharaan SET id_satwa=?, tanggal_pemeliharaan=?, " +
                          "kegiatan=?, hasil_pemeliharaan=? WHERE id_pemeliharaan=?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, this.idSatwa);
            ps.setDate(2, this.tanggalPemeliharaan);
            ps.setString(3, this.kegiatan);
            ps.setString(4, this.hasilPemeliharaan);
            ps.setInt(5, this.idPemeliharaan);
            
            int rowsAffected = ps.executeUpdate();
            success = (rowsAffected > 0);
            
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat update pemeliharaan: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return success;
    }
    
    /**
     * Method untuk hapus pemeliharaan
     */
    public static boolean hapusPemeliharaan(int idPemeliharaan) {
        Connection conn = Koneksi.getKoneksi();
        boolean success = false;
        
        try {
            String query = "DELETE FROM pemeliharaan WHERE id_pemeliharaan=?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idPemeliharaan);
            
            int rowsAffected = ps.executeUpdate();
            success = (rowsAffected > 0);
            
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat hapus pemeliharaan: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return success;
    }
    
    /**
     * Method untuk verifikasi pemeliharaan
     */
    public static boolean verifikasiPemeliharaan(int idPemeliharaan, String status, 
                                                  Date tanggalVerif, String keterangan, 
                                                  int idAdmin) {
        Connection conn = Koneksi.getKoneksi();
        boolean success = false;
        
        try {
            String query = "UPDATE pemeliharaan SET status_verifikasi=?, " +
                          "tanggal_verifikasi=?, keterangan=?, verified_by=? " +
                          "WHERE id_pemeliharaan=?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, status);
            ps.setDate(2, tanggalVerif);
            ps.setString(3, keterangan);
            ps.setInt(4, idAdmin);
            ps.setInt(5, idPemeliharaan);
            
            int rowsAffected = ps.executeUpdate();
            success = (rowsAffected > 0);
            
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat verifikasi pemeliharaan: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return success;
    }
    
    /**
     * Method untuk get semua pemeliharaan dengan detail
     */
    public static List<Pemeliharaan> getAllPemeliharaan() {
        Connection conn = Koneksi.getKoneksi();
        List<Pemeliharaan> listPemeliharaan = new ArrayList<>();
        
        try {
            String query = "SELECT p.*, u.nama as nama_petugas, s.nama_satwa, " +
                          "ua.nama as nama_admin " +
                          "FROM pemeliharaan p " +
                          "JOIN petugas_pemeliharaan pp ON p.id_petugas_pemeliharaan = pp.id_petugas_pemeliharaan " +
                          "JOIN user u ON pp.id_user = u.id_user " +
                          "JOIN satwa s ON p.id_satwa = s.id_satwa " +
                          "LEFT JOIN admin a ON p.verified_by = a.id_admin " +
                          "LEFT JOIN user ua ON a.id_user = ua.id_user " +
                          "ORDER BY p.tanggal_pemeliharaan DESC";
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                Pemeliharaan pemeliharaan = new Pemeliharaan();
                pemeliharaan.setIdPemeliharaan(rs.getInt("id_pemeliharaan"));
                pemeliharaan.setIdPetugasPemeliharaan(rs.getInt("id_petugas_pemeliharaan"));
                pemeliharaan.setIdSatwa(rs.getInt("id_satwa"));
                pemeliharaan.setTanggalPemeliharaan(rs.getDate("tanggal_pemeliharaan"));
                pemeliharaan.setKegiatan(rs.getString("kegiatan"));
                pemeliharaan.setHasilPemeliharaan(rs.getString("hasil_pemeliharaan"));
                pemeliharaan.setStatusVerifikasi(rs.getString("status_verifikasi"));
                pemeliharaan.setTanggalVerifikasi(rs.getDate("tanggal_verifikasi"));
                pemeliharaan.setKeterangan(rs.getString("keterangan"));
                
                int verifiedBy = rs.getInt("verified_by");
                pemeliharaan.setVerifiedBy(rs.wasNull() ? null : verifiedBy);
                
                pemeliharaan.setNamaPetugas(rs.getString("nama_petugas"));
                pemeliharaan.setNamaSatwa(rs.getString("nama_satwa"));
                pemeliharaan.setNamaAdmin(rs.getString("nama_admin"));
                
                listPemeliharaan.add(pemeliharaan);
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat mengambil data pemeliharaan: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return listPemeliharaan;
    }
    
    /**
     * Method untuk get pemeliharaan by petugas
     */
    public static List<Pemeliharaan> getPemeliharaanByPetugas(int idPetugasPemeliharaan) {
        Connection conn = Koneksi.getKoneksi();
        List<Pemeliharaan> listPemeliharaan = new ArrayList<>();
        
        try {
            String query = "SELECT p.*, s.nama_satwa " +
                          "FROM pemeliharaan p " +
                          "JOIN satwa s ON p.id_satwa = s.id_satwa " +
                          "WHERE p.id_petugas_pemeliharaan = ? " +
                          "ORDER BY p.tanggal_pemeliharaan DESC";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idPetugasPemeliharaan);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Pemeliharaan pemeliharaan = new Pemeliharaan();
                pemeliharaan.setIdPemeliharaan(rs.getInt("id_pemeliharaan"));
                pemeliharaan.setIdPetugasPemeliharaan(rs.getInt("id_petugas_pemeliharaan"));
                pemeliharaan.setIdSatwa(rs.getInt("id_satwa"));
                pemeliharaan.setTanggalPemeliharaan(rs.getDate("tanggal_pemeliharaan"));
                pemeliharaan.setKegiatan(rs.getString("kegiatan"));
                pemeliharaan.setHasilPemeliharaan(rs.getString("hasil_pemeliharaan"));
                pemeliharaan.setStatusVerifikasi(rs.getString("status_verifikasi"));
                pemeliharaan.setTanggalVerifikasi(rs.getDate("tanggal_verifikasi"));
                pemeliharaan.setKeterangan(rs.getString("keterangan"));
                pemeliharaan.setNamaSatwa(rs.getString("nama_satwa"));
                
                listPemeliharaan.add(pemeliharaan);
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat mengambil data pemeliharaan: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return listPemeliharaan;
    }
    
    /**
     * Method untuk filter pemeliharaan by status
     */
    public static List<Pemeliharaan> filterByStatus(String status) {
        Connection conn = Koneksi.getKoneksi();
        List<Pemeliharaan> listPemeliharaan = new ArrayList<>();
        
        try {
            String query = "SELECT p.*, u.nama as nama_petugas, s.nama_satwa " +
                          "FROM pemeliharaan p " +
                          "JOIN petugas_pemeliharaan pp ON p.id_petugas_pemeliharaan = pp.id_petugas_pemeliharaan " +
                          "JOIN user u ON pp.id_user = u.id_user " +
                          "JOIN satwa s ON p.id_satwa = s.id_satwa " +
                          "WHERE p.status_verifikasi = ? " +
                          "ORDER BY p.tanggal_pemeliharaan DESC";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, status);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Pemeliharaan pemeliharaan = new Pemeliharaan();
                pemeliharaan.setIdPemeliharaan(rs.getInt("id_pemeliharaan"));
                pemeliharaan.setTanggalPemeliharaan(rs.getDate("tanggal_pemeliharaan"));
                pemeliharaan.setKegiatan(rs.getString("kegiatan"));
                pemeliharaan.setHasilPemeliharaan(rs.getString("hasil_pemeliharaan"));
                pemeliharaan.setStatusVerifikasi(rs.getString("status_verifikasi"));
                pemeliharaan.setNamaPetugas(rs.getString("nama_petugas"));
                pemeliharaan.setNamaSatwa(rs.getString("nama_satwa"));
                
                listPemeliharaan.add(pemeliharaan);
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat filter pemeliharaan: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return listPemeliharaan;
    }
    
    /**
     * Method untuk get pemeliharaan by ID
     */
    public static Pemeliharaan getPemeliharaanById(int idPemeliharaan) {
        Connection conn = Koneksi.getKoneksi();
        Pemeliharaan pemeliharaan = null;
        
        try {
            String query = "SELECT p.*, u.nama as nama_petugas, s.nama_satwa " +
                          "FROM pemeliharaan p " +
                          "JOIN petugas_pemeliharaan pp ON p.id_petugas_pemeliharaan = pp.id_petugas_pemeliharaan " +
                          "JOIN user u ON pp.id_user = u.id_user " +
                          "JOIN satwa s ON p.id_satwa = s.id_satwa " +
                          "WHERE p.id_pemeliharaan = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idPemeliharaan);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                pemeliharaan = new Pemeliharaan();
                pemeliharaan.setIdPemeliharaan(rs.getInt("id_pemeliharaan"));
                pemeliharaan.setIdPetugasPemeliharaan(rs.getInt("id_petugas_pemeliharaan"));
                pemeliharaan.setIdSatwa(rs.getInt("id_satwa"));
                pemeliharaan.setTanggalPemeliharaan(rs.getDate("tanggal_pemeliharaan"));
                pemeliharaan.setKegiatan(rs.getString("kegiatan"));
                pemeliharaan.setHasilPemeliharaan(rs.getString("hasil_pemeliharaan"));
                pemeliharaan.setStatusVerifikasi(rs.getString("status_verifikasi"));
                pemeliharaan.setTanggalVerifikasi(rs.getDate("tanggal_verifikasi"));
                pemeliharaan.setKeterangan(rs.getString("keterangan"));
                pemeliharaan.setNamaPetugas(rs.getString("nama_petugas"));
                pemeliharaan.setNamaSatwa(rs.getString("nama_satwa"));
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat mengambil data pemeliharaan: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return pemeliharaan;
    }
}