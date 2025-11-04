package Model;

import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

/**
 * Model class untuk User
 */
public class User {
    private int idUser;
    private String nama;
    private String username;
    private String password;
    private String email;
    private String noTelp;
    private String role;
    
    // Constructors
    public User() {}
    
    public User(int idUser, String nama, String username, String email, String noTelp, String role) {
        this.idUser = idUser;
        this.nama = nama;
        this.username = username;
        this.email = email;
        this.noTelp = noTelp;
        this.role = role;
    }
    
    // Getters and Setters
    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }
    
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getNoTelp() { return noTelp; }
    public void setNoTelp(String noTelp) { this.noTelp = noTelp; }
    
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    
    /**
     * Method untuk enkripsi password dengan MD5
     */
    public static String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Method untuk login user
     */
    public static User login(String username, String password) {
        Connection conn = Koneksi.getKoneksi();
        User user = null;
        
        try {
            String encryptedPass = encryptPassword(password);
            String query = "SELECT * FROM user WHERE username = ? AND password = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, encryptedPass);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                user = new User();
                user.setIdUser(rs.getInt("id_user"));
                user.setNama(rs.getString("nama"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setNoTelp(rs.getString("no_telp"));
                user.setRole(rs.getString("role"));
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat login: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return user;
    }
    
    /**
     * Method untuk tambah user baru
     */
    public boolean tambahUser() {
        Connection conn = Koneksi.getKoneksi();
        boolean success = false;
        
        try {
            String query = "INSERT INTO user (nama, username, password, email, no_telp, role) " +
                          "VALUES (?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, this.nama);
            ps.setString(2, this.username);
            ps.setString(3, encryptPassword(this.password));
            ps.setString(4, this.email);
            ps.setString(5, this.noTelp);
            ps.setString(6, this.role);
            
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    this.idUser = rs.getInt(1);
                }
                success = true;
            }
            
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat menambah user: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return success;
    }
    
    /**
     * Method untuk update user
     */
    public boolean updateUser() {
        Connection conn = Koneksi.getKoneksi();
        boolean success = false;
        
        try {
            String query = "UPDATE user SET nama=?, username=?, email=?, no_telp=?, role=? " +
                          "WHERE id_user=?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, this.nama);
            ps.setString(2, this.username);
            ps.setString(3, this.email);
            ps.setString(4, this.noTelp);
            ps.setString(5, this.role);
            ps.setInt(6, this.idUser);
            
            int rowsAffected = ps.executeUpdate();
            success = (rowsAffected > 0);
            
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat update user: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return success;
    }
    
    /**
     * Method untuk hapus user
     */
    public boolean hapusUser(int idUser) {
        Connection conn = Koneksi.getKoneksi();
        boolean success = false;
        
        try {
            String query = "DELETE FROM user WHERE id_user=?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idUser);
            
            int rowsAffected = ps.executeUpdate();
            success = (rowsAffected > 0);
            
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat hapus user: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return success;
    }
    
    /**
     * Method untuk cari user by username
     */
    public static User cariByUsername(String username) {
        Connection conn = Koneksi.getKoneksi();
        User user = null;
        
        try {
            String query = "SELECT * FROM user WHERE username = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                user = new User();
                user.setIdUser(rs.getInt("id_user"));
                user.setNama(rs.getString("nama"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setNoTelp(rs.getString("no_telp"));
                user.setRole(rs.getString("role"));
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error saat mencari user: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } finally {
            Koneksi.closeKoneksi();
        }
        
        return user;
    }
}