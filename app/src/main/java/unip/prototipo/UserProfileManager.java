package unip.prototipo;

// Classe simples para simular o armazenamento de dados do usuário em memória.
public class UserProfileManager {

    private static String name = "Admin";
    private static String email = "admin@helpdesk.com";
    private static String position = "Administrador";
    private static String department = "TI";

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        UserProfileManager.name = name;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        UserProfileManager.email = email;
    }

    public static String getPosition() {
        return position;
    }

    public static void setPosition(String position) {
        UserProfileManager.position = position;
    }

    public static String getDepartment() {
        return department;
    }

    public static void setDepartment(String department) {
        UserProfileManager.department = department;
    }
}
