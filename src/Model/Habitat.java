package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Model class untuk Habitat
 */
public class Habitat {
    private int idHabitat;
    private String namaHabitat;
    private String lokasi;
    private String tipeEkosistem;
    private double luasArea;
    private String kondisi;
    
    // Constructors
    public Habitat() {}
    
    public Habitat(int idHabitat, String namaHabitat, String lokasi, 
                   String tipeEkosistem, double luasArea, String kondisi) {
        this.idHabitat = idHabitat;
        this.namaHabitat = namaHabitat;
        this.lokasi = lokasi;
        this.tipeEkosistem = tipeEkosistem;
        this.luasArea = luasArea;
        this.kondisi = kondisi;
    }
    
    // Getters and Setters
    public int getIdHabitat() { return idHabitat; }
    public void setIdHabitat(int idHabitat) { this.idHabitat = idHabitat; }
    
    public String getNamaHabitat() { return namaHabitat; }
    public void setNamaHabitat(String namaHabitat) { this.namaHabitat = namaHabitat; }
    
    public String getLokasi() { return lokasi; }
    public void setLokasi(String lokasi) { this.lokasi = lokasi; }
    
    public String getTipeEkosistem() { return tipeEkosistem; }
    public void setTipeEkosistem(String tipeEkosistem) { this.tipeEkosistem = tipeEkosistem; }
    
    public double getLuasArea() { return luasArea; }
    public void setLuasArea(double luasArea) { this.luasArea = luasArea; }
    
    public String getKondisi() { return kondisi; }
    public void setKondisi(String kondisi) { this.kondisi = kondisi; }
    
    /**
     * Method untuk tambah habitat baru
     */
    public boolean tambahHabitat() {
        Connection conn = Koneksi.getKoneksi();
        boolean success = false;
        
        try {
            String query = "INSERT INTO habitat (nama_habitat, lokasi, tipe_ekosistem, " +
                          "luas_area, kondisi) VALUES (?, ?, ?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, this.namaHabitat);
            ps.setString(2, this.lokasi);
            ps.setString(3, this.tipeEkosistem);
            ps.setDouble(4, this.luasArea);
            ps.setString(5, this.kondisi);
            
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    this.idHabitat = rs.getInt(1);
                }
                success = true;
            }
            
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat menambah habitat: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return success;
    }
    
    /**
     * Method untuk update habitat
     */
    public boolean updateHabitat() {
        Connection conn = Koneksi.getKoneksi();
        boolean success = false;
        
        try {
            String query = "UPDATE habitat SET nama_habitat=?, lokasi=?, tipe_ekosistem=?, " +
                          "luas_area=?, kondisi=? WHERE id_habitat=?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, this.namaHabitat);
            ps.setString(2, this.lokasi);
            ps.setString(3, this.tipeEkosistem);
            ps.setDouble(4, this.luasArea);
            ps.setString(5, this.kondisi);
            ps.setInt(6, this.idHabitat);
            
            int rowsAffected = ps.executeUpdate();
            success = (rowsAffected > 0);
            
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat update habitat: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return success;
    }
    
    /**
     * Method untuk hapus habitat
     */
    public static boolean hapusHabitat(int idHabitat) {
        Connection conn = Koneksi.getKoneksi();
        boolean success = false;
        
        try {
            String query = "DELETE FROM habitat WHERE id_habitat=?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idHabitat);
            
            int rowsAffected = ps.executeUpdate();
            success = (rowsAffected > 0);
            
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat hapus habitat: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return success;
    }
    
    /**
     * Method untuk get semua data habitat
     */
    public static List<Habitat> getAllHabitat() {
        Connection conn = Koneksi.getKoneksi();
        List<Habitat> listHabitat = new ArrayList<>();
        
        try {
            String query = "SELECT * FROM habitat ORDER BY nama_habitat";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                Habitat habitat = new Habitat();
                habitat.setIdHabitat(rs.getInt("id_habitat"));
                habitat.setNamaHabitat(rs.getString("nama_habitat"));
                habitat.setLokasi(rs.getString("lokasi"));
                habitat.setTipeEkosistem(rs.getString("tipe_ekosistem"));
                habitat.setLuasArea(rs.getDouble("luas_area"));
                habitat.setKondisi(rs.getString("kondisi"));
                
                listHabitat.add(habitat);
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat mengambil data habitat: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return listHabitat;
    }
    
    /**
     * Method untuk get habitat by ID
     */
    public static Habitat getHabitatById(int idHabitat) {
        Connection conn = Koneksi.getKoneksi();
        Habitat habitat = null;
        
        try {
            String query = "SELECT * FROM habitat WHERE id_habitat = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idHabitat);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                habitat = new Habitat();
                habitat.setIdHabitat(rs.getInt("id_habitat"));
                habitat.setNamaHabitat(rs.getString("nama_habitat"));
                habitat.setLokasi(rs.getString("lokasi"));
                habitat.setTipeEkosistem(rs.getString("tipe_ekosistem"));
                habitat.setLuasArea(rs.getDouble("luas_area"));
                habitat.setKondisi(rs.getString("kondisi"));
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat mengambil data habitat: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return habitat;
    }
    
    /**
     * Method untuk cari habitat by nama atau lokasi
     */
    public static List<Habitat> cariHabitat(String keyword) {
        Connection conn = Koneksi.getKoneksi();
        List<Habitat> listHabitat = new ArrayList<>();
        
        try {
            String query = "SELECT * FROM habitat WHERE nama_habitat LIKE ? OR lokasi LIKE ? " +
                          "ORDER BY nama_habitat";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Habitat habitat = new Habitat();
                habitat.setIdHabitat(rs.getInt("id_habitat"));
                habitat.setNamaHabitat(rs.getString("nama_habitat"));
                habitat.setLokasi(rs.getString("lokasi"));
                habitat.setTipeEkosistem(rs.getString("tipe_ekosistem"));
                habitat.setLuasArea(rs.getDouble("luas_area"));
                habitat.setKondisi(rs.getString("kondisi"));
                
                listHabitat.add(habitat);
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat mencari habitat: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return listHabitat;
    }
}