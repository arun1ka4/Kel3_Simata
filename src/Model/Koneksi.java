package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Class untuk koneksi database SIMATA
 * @author SIMATA Team
 */
public class Koneksi {
    private static Connection conn;
    
    // Konfigurasi Database
    private static final String DB_URL = "jdbc:mysql://localhost:3306/simata_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    
    /**
     * Method untuk membuat koneksi ke database
     * @return Connection object
     */
    public static Connection getKoneksi() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Buat koneksi
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
            System.out.println("Koneksi database berhasil!");
            return conn;
            
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, 
                "Driver MySQL tidak ditemukan!\n" + e.getMessage(), 
                "Error Driver", 
                JOptionPane.ERROR_MESSAGE);
            return null;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Koneksi database gagal!\n" + e.getMessage(), 
                "Error Koneksi", 
                JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    /**
     * Method untuk menutup koneksi database
     */
    public static void closeKoneksi() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Koneksi database ditutup.");
            }
        } catch (SQLException e) {
            System.err.println("Error saat menutup koneksi: " + e.getMessage());
        }
    }
    
    /**
     * Method untuk test koneksi
     * @return true jika koneksi berhasil
     */
    public static boolean testKoneksi() {
        Connection testConn = getKoneksi();
        if (testConn != null) {
            try {
                testConn.close();
                return true;
            } catch (SQLException e) {
                return false;
            }
        }
        return false;
    }
}