
package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Model class untuk Pengamatan (Laporan Lapangan)
 */
public class Pengamatan {
    private int idPengamatan;
    private int idPetugasLapangan;
    private int idHabitat;
    private int idSatwa;
    private Date tanggalPengamatan;
    private int jumlahTeramati;
    private String perilakuSatwa;
    private String kondisiLingkungan;
    private String catatanTambahan;
    private String statusVerifikasi;
    private Date tanggalVerifikasi;
    
    // Extra fields untuk join
    private String namaPetugas;
    private String namaHabitat;
    private String namaSatwa;
    private String lokasi;
    
    // Constructors
    public Pengamatan() {}
    
    // Getters and Setters
    public int getIdPengamatan() { return idPengamatan; }
    public void setIdPengamatan(int idPengamatan) { this.idPengamatan = idPengamatan; }
    
    public int getIdPetugasLapangan() { return idPetugasLapangan; }
    public void setIdPetugasLapangan(int idPetugasLapangan) { 
        this.idPetugasLapangan = idPetugasLapangan; 
    }
    
    public int getIdHabitat() { return idHabitat; }
    public void setIdHabitat(int idHabitat) { this.idHabitat = idHabitat; }
    
    public int getIdSatwa() { return idSatwa; }
    public void setIdSatwa(int idSatwa) { this.idSatwa = idSatwa; }
    
    public Date getTanggalPengamatan() { return tanggalPengamatan; }
    public void setTanggalPengamatan(Date tanggalPengamatan) { 
        this.tanggalPengamatan = tanggalPengamatan; 
    }
    
    public int getJumlahTeramati() { return jumlahTeramati; }
    public void setJumlahTeramati(int jumlahTeramati) { 
        this.jumlahTeramati = jumlahTeramati; 
    }
    
    public String getPerilakuSatwa() { return perilakuSatwa; }
    public void setPerilakuSatwa(String perilakuSatwa) { 
        this.perilakuSatwa = perilakuSatwa; 
    }
    
    public String getKondisiLingkungan() { return kondisiLingkungan; }
    public void setKondisiLingkungan(String kondisiLingkungan) { 
        this.kondisiLingkungan = kondisiLingkungan; 
    }
    
    public String getCatatanTambahan() { return catatanTambahan; }
    public void setCatatanTambahan(String catatanTambahan) { 
        this.catatanTambahan = catatanTambahan; 
    }
    
    public String getStatusVerifikasi() { return statusVerifikasi; }
    public void setStatusVerifikasi(String statusVerifikasi) { 
        this.statusVerifikasi = statusVerifikasi; 
    }
    
    public Date getTanggalVerifikasi() { return tanggalVerifikasi; }
    public void setTanggalVerifikasi(Date tanggalVerifikasi) { 
        this.tanggalVerifikasi = tanggalVerifikasi; 
    }
    
    public String getNamaPetugas() { return namaPetugas; }
    public void setNamaPetugas(String namaPetugas) { this.namaPetugas = namaPetugas; }
    
    public String getNamaHabitat() { return namaHabitat; }
    public void setNamaHabitat(String namaHabitat) { this.namaHabitat = namaHabitat; }
    
    public String getNamaSatwa() { return namaSatwa; }
    public void setNamaSatwa(String namaSatwa) { this.namaSatwa = namaSatwa; }
    
    public String getLokasi() { return lokasi; }
    public void setLokasi(String lokasi) { this.lokasi = lokasi; }
    
    /**
     * Method untuk tambah pengamatan baru
     */
    public boolean tambahPengamatan() {
        Connection conn = Koneksi.getKoneksi();
        boolean success = false;
        
        try {
            String query = "INSERT INTO pengamatan (id_petugas_lapangan, id_habitat, id_satwa, " +
                          "tanggal_pengamatan, jumlah_teramati, perilaku_satwa, " +
                          "kondisi_lingkungan, catatan_tambahan, status_verifikasi) " +
                          "VALUES (?, ?, ?, ?, ?, ?, ?, ?, 'Menunggu')";
            
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, this.idPetugasLapangan);
            ps.setInt(2, this.idHabitat);
            ps.setInt(3, this.idSatwa);
            ps.setDate(4, this.tanggalPengamatan);
            ps.setInt(5, this.jumlahTeramati);
            ps.setString(6, this.perilakuSatwa);
            ps.setString(7, this.kondisiLingkungan);
            ps.setString(8, this.catatanTambahan);
            
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    this.idPengamatan = rs.getInt(1);
                }
                success = true;
            }
            
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat menambah pengamatan: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return success;
    }
    
    /**
     * Method untuk update pengamatan
     */
    public boolean updatePengamatan() {
        Connection conn = Koneksi.getKoneksi();
        boolean success = false;
        
        try {
            String query = "UPDATE pengamatan SET id_habitat=?, id_satwa=?, " +
                          "tanggal_pengamatan=?, jumlah_teramati=?, perilaku_satwa=?, " +
                          "kondisi_lingkungan=?, catatan_tambahan=? " +
                          "WHERE id_pengamatan=?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, this.idHabitat);
            ps.setInt(2, this.idSatwa);
            ps.setDate(3, this.tanggalPengamatan);
            ps.setInt(4, this.jumlahTeramati);
            ps.setString(5, this.perilakuSatwa);
            ps.setString(6, this.kondisiLingkungan);
            ps.setString(7, this.catatanTambahan);
            ps.setInt(8, this.idPengamatan);
            
            int rowsAffected = ps.executeUpdate();
            success = (rowsAffected > 0);
            
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat update pengamatan: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return success;
    }
    
    /**
     * Method untuk hapus pengamatan
     */
    public static boolean hapusPengamatan(int idPengamatan) {
        Connection conn = Koneksi.getKoneksi();
        boolean success = false;
        
        try {
            String query = "DELETE FROM pengamatan WHERE id_pengamatan=?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idPengamatan);
            
            int rowsAffected = ps.executeUpdate();
            success = (rowsAffected > 0);
            
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat hapus pengamatan: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return success;
    }
    
    /**
     * Method untuk verifikasi pengamatan
     */
    public static boolean verifikasiPengamatan(int idPengamatan, String status, Date tanggalVerif) {
        Connection conn = Koneksi.getKoneksi();
        boolean success = false;
        
        try {
            String query = "UPDATE pengamatan SET status_verifikasi=?, tanggal_verifikasi=? " +
                          "WHERE id_pengamatan=?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, status);
            ps.setDate(2, tanggalVerif);
            ps.setInt(3, idPengamatan);
            
            int rowsAffected = ps.executeUpdate();
            success = (rowsAffected > 0);
            
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat verifikasi pengamatan: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return success;
    }
    
    /**
     * Method untuk get semua pengamatan dengan detail
     */
    public static List<Pengamatan> getAllPengamatan() {
        Connection conn = Koneksi.getKoneksi();
        List<Pengamatan> listPengamatan = new ArrayList<>();
        
        try {
            String query = "SELECT p.*, u.nama as nama_petugas, h.nama_habitat, " +
                          "h.lokasi, s.nama_satwa " +
                          "FROM pengamatan p " +
                          "JOIN petugas_lapangan pl ON p.id_petugas_lapangan = pl.id_petugas_lapangan " +
                          "JOIN user u ON pl.id_user = u.id_user " +
                          "JOIN habitat h ON p.id_habitat = h.id_habitat " +
                          "JOIN satwa s ON p.id_satwa = s.id_satwa " +
                          "ORDER BY p.tanggal_pengamatan DESC";
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                Pengamatan pengamatan = new Pengamatan();
                pengamatan.setIdPengamatan(rs.getInt("id_pengamatan"));
                pengamatan.setIdPetugasLapangan(rs.getInt("id_petugas_lapangan"));
                pengamatan.setIdHabitat(rs.getInt("id_habitat"));
                pengamatan.setIdSatwa(rs.getInt("id_satwa"));
                pengamatan.setTanggalPengamatan(rs.getDate("tanggal_pengamatan"));
                pengamatan.setJumlahTeramati(rs.getInt("jumlah_teramati"));
                pengamatan.setPerilakuSatwa(rs.getString("perilaku_satwa"));
                pengamatan.setKondisiLingkungan(rs.getString("kondisi_lingkungan"));
                pengamatan.setCatatanTambahan(rs.getString("catatan_tambahan"));
                pengamatan.setStatusVerifikasi(rs.getString("status_verifikasi"));
                pengamatan.setTanggalVerifikasi(rs.getDate("tanggal_verifikasi"));
                
                pengamatan.setNamaPetugas(rs.getString("nama_petugas"));
                pengamatan.setNamaHabitat(rs.getString("nama_habitat"));
                pengamatan.setLokasi(rs.getString("lokasi"));
                pengamatan.setNamaSatwa(rs.getString("nama_satwa"));
                
                listPengamatan.add(pengamatan);
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat mengambil data pengamatan: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return listPengamatan;
    }
    
    /**
     * Method untuk filter pengamatan by lokasi
     */
    public static List<Pengamatan> filterByLokasi(String lokasi) {
        Connection conn = Koneksi.getKoneksi();
        List<Pengamatan> listPengamatan = new ArrayList<>();
        
        try {
            String query = "SELECT p.*, u.nama as nama_petugas, h.nama_habitat, " +
                          "h.lokasi, s.nama_satwa " +
                          "FROM pengamatan p " +
                          "JOIN petugas_lapangan pl ON p.id_petugas_lapangan = pl.id_petugas_lapangan " +
                          "JOIN user u ON pl.id_user = u.id_user " +
                          "JOIN habitat h ON p.id_habitat = h.id_habitat " +
                          "JOIN satwa s ON p.id_satwa = s.id_satwa " +
                          "WHERE h.lokasi LIKE ? " +
                          "ORDER BY p.tanggal_pengamatan DESC";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + lokasi + "%");
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Pengamatan pengamatan = new Pengamatan();
                pengamatan.setIdPengamatan(rs.getInt("id_pengamatan"));
                pengamatan.setTanggalPengamatan(rs.getDate("tanggal_pengamatan"));
                pengamatan.setJumlahTeramati(rs.getInt("jumlah_teramati"));
                pengamatan.setStatusVerifikasi(rs.getString("status_verifikasi"));
                pengamatan.setNamaPetugas(rs.getString("nama_petugas"));
                pengamatan.setNamaHabitat(rs.getString("nama_habitat"));
                pengamatan.setLokasi(rs.getString("lokasi"));
                pengamatan.setNamaSatwa(rs.getString("nama_satwa"));
                
                listPengamatan.add(pengamatan);
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat filter pengamatan: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return listPengamatan;
    }
}