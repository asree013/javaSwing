package configs.enviroment;


public class Enviroment {
    private static final String BASE_URL = "https://api-ems.m-mert.com/v1";
    private static final String LOGIN = "/auth";

    // สร้าง getter methods
    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static String getLogin() {
        return LOGIN;
    }
}
