package ir.maktab.examination_online_system.cofig.security;

public class SecurityConstant {

    private SecurityConstant() {

    }


    public static String[] getPermitAllUrls() {
        return new String[]{
                "/login", "/showReg", "/index", "/registerUser", "/assets", "/assets/css/**", "/assets/js/**", "/assets/img/**", "/views/log-reg/**", "/views**", "/views/home/**",
                "/webjars/bootstrap/4.3.1/css/bootstrap.min.css",
                "/webjars/jquery/3.4.1/jquery.min.js",
                "/webjars/bootstrap/4.3.1/js/bootstrap.min.js",
                "/assets/css/assets/owl.carousel.css",
                "/assets/css/bootstrap.min.css",
                "/assets/main.css",
                "/assets/assets/owl.theme.default.css",
                "/header",
                "https://fonts.googleapis.com/css?family=Open+Sans:400,600",
                "https://fonts.googleapis.com/css?family=Open+Sans:300,400,600",
                "/home",
                "https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i",
                "https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&display=swap"

        };
    }

    public static String[] getAdminPaths() {
        return new String[]{
                "/admin", "/admin/**"

        };
    }

    public static String[] getTeacherPaths() {
        return new String[]{
                "/professor", "/professor/**"
        };
    }

    public static String[] getStudentPath() {
        return new String[]{
                "/students", "/students/**"
        };
    }
}
