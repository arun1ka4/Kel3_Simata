package Model;

/**
 * Utility class untuk manage user session
 * Menyimpan informasi user yang sedang login
 */
public class SessionManager {
    private static SessionManager instance;
    private User currentUser;
    private Admin currentAdmin;
    private PetugasLapangan currentPetugasLapangan;
    private PetugasPemeliharaan currentPetugasPemeliharaan;
    
    // Private constructor untuk Singleton pattern
    private SessionManager() {}
    
    /**
     * Get instance of SessionManager (Singleton)
     */
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }
    
    /**
     * Set current user session
     */
    public void setCurrentUser(User user) {
        this.currentUser = user;
        
        // Load additional data based on role
        if (user != null) {
            switch (user.getRole()) {
                case "Admin":
                    this.currentAdmin = Admin.getAdminByUserId(user.getIdUser());
                    break;
                case "Petugas Lapangan":
                    this.currentPetugasLapangan = PetugasLapangan.getPetugasByUserId(user.getIdUser());
                    break;
                case "Petugas Pemeliharaan":
                    this.currentPetugasPemeliharaan = PetugasPemeliharaan.getPetugasByUserId(user.getIdUser());
                    break;
            }
        }
    }
    
    /**
     * Get current user
     */
    public User getCurrentUser() {
        return currentUser;
    }
    
    /**
     * Get current admin
     */
    public Admin getCurrentAdmin() {
        return currentAdmin;
    }
    
    /**
     * Get current petugas lapangan
     */
    public PetugasLapangan getCurrentPetugasLapangan() {
        return currentPetugasLapangan;
    }
    
    /**
     * Get current petugas pemeliharaan
     */
    public PetugasPemeliharaan getCurrentPetugasPemeliharaan() {
        return currentPetugasPemeliharaan;
    }
    
    /**
     * Check if user is logged in
     */
    public boolean isLoggedIn() {
        return currentUser != null;
    }
    
    /**
     * Check if current user is Admin
     */
    public boolean isAdmin() {
        return currentUser != null && "Admin".equals(currentUser.getRole());
    }
    
    /**
     * Check if current user is Petugas Lapangan
     */
    public boolean isPetugasLapangan() {
        return currentUser != null && "Petugas Lapangan".equals(currentUser.getRole());
    }
    
    /**
     * Check if current user is Petugas Pemeliharaan
     */
    public boolean isPetugasPemeliharaan() {
        return currentUser != null && "Petugas Pemeliharaan".equals(currentUser.getRole());
    }
    
    /**
     * Get current user's name
     */
    public String getCurrentUserName() {
        return currentUser != null ? currentUser.getNama() : "";
    }
    
    /**
     * Get current user's role
     */
    public String getCurrentUserRole() {
        return currentUser != null ? currentUser.getRole() : "";
    }
    
    /**
     * Logout current user
     */
    public void logout() {
        this.currentUser = null;
        this.currentAdmin = null;
        this.currentPetugasLapangan = null;
        this.currentPetugasPemeliharaan = null;
    }
    
    /**
     * Clear session
     */
    public void clearSession() {
        logout();
    }
    
    /**
     * Get user ID based on role
     */
    public Integer getRoleSpecificId() {
        if (currentUser == null) return null;
        
        switch (currentUser.getRole()) {
            case "Admin":
                return currentAdmin != null ? currentAdmin.getIdAdmin() : null;
            case "Petugas Lapangan":
                return currentPetugasLapangan != null ? currentPetugasLapangan.getIdPetugasLapangan() : null;
            case "Petugas Pemeliharaan":
                return currentPetugasPemeliharaan != null ? currentPetugasPemeliharaan.getIdPetugasPemeliharaan() : null;
            default:
                return null;
        }
    }
    
    /**
     * Display current session info (for debugging)
     */
    public void displaySessionInfo() {
        if (currentUser != null) {
            System.out.println("=== SESSION INFO ===");
            System.out.println("User ID: " + currentUser.getIdUser());
            System.out.println("Nama: " + currentUser.getNama());
            System.out.println("Username: " + currentUser.getUsername());
            System.out.println("Role: " + currentUser.getRole());
            System.out.println("==================");
        } else {
            System.out.println("No active session");
        }
    }
}