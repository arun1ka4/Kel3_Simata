package Main;

import View.MenuLogin;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * Main class untuk menjalankan aplikasi SIMATA
 */
public class Simata_project {
    
    public static void main(String[] args) {
        // Set Look and Feel
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            System.err.println("Error setting Look and Feel: " + ex.getMessage());
        }
        
        // Run application
        SwingUtilities.invokeLater(() -> {
            MenuLogin loginForm = new MenuLogin();
            loginForm.setLocationRelativeTo(null); // Center on screen
            loginForm.setVisible(true);
        });
    }
}