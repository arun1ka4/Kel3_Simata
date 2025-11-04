package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Class Satwa menerapkan konsep Abstraction & Inheritance
 * Turunan dari class abstrak Hewan
 */
public class Satwa extends Hewan {

    // Constructor kosong
    public Satwa() {}

    // Constructor lengkap
    public Satwa(int idSatwa, String namaSatwa, String namaLatin, String kategori,
                 String statusKonservasi, String deskripsi, String fotoSatwa) {
        this.idSatwa = idSatwa;
        this.namaSatwa = namaSatwa;
        this.namaLatin = namaLatin;
        this.kategori = kategori;
        this.statusKonservasi = statusKonservasi;
        this.deskripsi = deskripsi;
        this.fotoSatwa = fotoSatwa;
    }

    /**
     * Method untuk tambah satwa (implementasi abstraction)
     */
    @Override
    public boolean tambahSatwa() {
        Connection conn = Koneksi.getKoneksi();
        boolean success = false;

        try {
            String query = "INSERT INTO satwa (nama_satwa, nama_latin, kategori, " +
                           "status_konservasi, deskripsi, foto_satwa) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, this.namaSatwa);
            ps.setString(2, this.namaLatin);
            ps.setString(3, this.kategori);
            ps.setString(4, this.statusKonservasi);
            ps.setString(5, this.deskripsi);
            ps.setString(6, this.fotoSatwa);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    this.idSatwa = rs.getInt(1);
                }
                success = true;
            }

            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Error saat menambah satwa: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }

        return success;
    }

    /**
     * Method untuk update satwa (implementasi abstraction)
     */
    @Override
    public boolean updateSatwa() {
        Connection conn = Koneksi.getKoneksi();
        boolean success = false;

        try {
            String query = "UPDATE satwa SET nama_satwa=?, nama_latin=?, kategori=?, " +
                           "status_konservasi=?, deskripsi=?, foto_satwa=? WHERE id_satwa=?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, this.namaSatwa);
            ps.setString(2, this.namaLatin);
            ps.setString(3, this.kategori);
            ps.setString(4, this.statusKonservasi);
            ps.setString(5, this.deskripsi);
            ps.setString(6, this.fotoSatwa);
            ps.setInt(7, this.idSatwa);

            int rowsAffected = ps.executeUpdate();
            success = (rowsAffected > 0);

            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Error saat update satwa: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }

        return success;
    }

    /**
     * Method untuk hapus satwa
     */
    public static boolean hapusSatwa(int idSatwa) {
        Connection conn = Koneksi.getKoneksi();
        boolean success = false;

        try {
            String query = "DELETE FROM satwa WHERE id_satwa=?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idSatwa);

            int rowsAffected = ps.executeUpdate();
            success = (rowsAffected > 0);

            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Error saat hapus satwa: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }

        return success;
    }

    /**
     * Method untuk get semua data satwa
     */
    public static List<Satwa> getAllSatwa() {
        Connection conn = Koneksi.getKoneksi();
        List<Satwa> listSatwa = new ArrayList<>();

        try {
            String query = "SELECT * FROM satwa ORDER BY nama_satwa";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Satwa satwa = new Satwa();
                satwa.setIdSatwa(rs.getInt("id_satwa"));
                satwa.setNamaSatwa(rs.getString("nama_satwa"));
                satwa.setNamaLatin(rs.getString("nama_latin"));
                satwa.setKategori(rs.getString("kategori"));
                satwa.setStatusKonservasi(rs.getString("status_konservasi"));
                satwa.setDeskripsi(rs.getString("deskripsi"));
                satwa.setFotoSatwa(rs.getString("foto_satwa"));

                listSatwa.add(satwa);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Error saat mengambil data satwa: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }

        return listSatwa;
    }

    /**
     * Method untuk get satwa by ID
     */
    public static Satwa getSatwaById(int idSatwa) {
        Connection conn = Koneksi.getKoneksi();
        Satwa satwa = null;

        try {
            String query = "SELECT * FROM satwa WHERE id_satwa = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idSatwa);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                satwa = new Satwa();
                satwa.setIdSatwa(rs.getInt("id_satwa"));
                satwa.setNamaSatwa(rs.getString("nama_satwa"));
                satwa.setNamaLatin(rs.getString("nama_latin"));
                satwa.setKategori(rs.getString("kategori"));
                satwa.setStatusKonservasi(rs.getString("status_konservasi"));
                satwa.setDeskripsi(rs.getString("deskripsi"));
                satwa.setFotoSatwa(rs.getString("foto_satwa"));
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Error saat mengambil data satwa: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }

        return satwa;
    }

    /**
     * Method untuk cari satwa by nama atau nama latin
     */
    public static List<Satwa> cariSatwa(String keyword) {
        Connection conn = Koneksi.getKoneksi();
        List<Satwa> listSatwa = new ArrayList<>();

        try {
            String query = "SELECT * FROM satwa WHERE nama_satwa LIKE ? OR nama_latin LIKE ? ORDER BY nama_satwa";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Satwa satwa = new Satwa();
                satwa.setIdSatwa(rs.getInt("id_satwa"));
                satwa.setNamaSatwa(rs.getString("nama_satwa"));
                satwa.setNamaLatin(rs.getString("nama_latin"));
                satwa.setKategori(rs.getString("kategori"));
                satwa.setStatusKonservasi(rs.getString("status_konservasi"));
                satwa.setDeskripsi(rs.getString("deskripsi"));
                satwa.setFotoSatwa(rs.getString("foto_satwa"));

                listSatwa.add(satwa);
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Error saat mencari satwa: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }

        return listSatwa;
    }
}
