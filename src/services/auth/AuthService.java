package services.auth;

import models.user.UserModel;
import java.io.*;
import java.net.*;
import configs.enviroment.Enviroment;

public class AuthService {
    private String basePath;
    private String auth;
    private UserModel user;

    public AuthService() {
        this.basePath = new Enviroment().getBaseUrl();
        this.auth = new Enviroment().getLogin();
    }

    public UserModel login(UserModel user) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(this.basePath + auth);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            // สร้าง JSON ด้วย String
            String jsonInputString = createJson(user);

            // เขียน JSON ไปยัง OutputStream
            try (OutputStream os = connection.getOutputStream()) {
                os.write(jsonInputString.getBytes("utf-8"));
            }

            // ตรวจสอบสถานะการตอบกลับ
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // อ่าน response ด้วย BufferedReader
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line.trim());
                    }
                    // สร้าง UserModel จาก JSON response
                    return parseJson(response.toString());
                }
            } else {
                System.out.println("Login failed with response code: " + connection.getResponseCode());
            }
        } catch (IOException e) {
            System.err.println("IOException occurred: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.disconnect(); // ปิดการเชื่อมต่อ
            }
        }
        return null; // ถ้าล้มเหลว คืนค่า null
    }

    // ฟังก์ชันเพื่อสร้าง JSON จาก UserModel
    private String createJson(UserModel user) {
        return String.format(
            "{\"id\":\"%s\", \"username\":\"%s\", \"password\":\"%s\", \"first_name\":\"%s\", \"last_name\":\"%s\", \"image\":\"%s\", \"id_card\":\"%s\", \"phone_number\":\"%s\", \"email\":\"%s\", \"career\":\"%s\"}",
            user.getId(),
            user.getUsername(),
            user.getPassword(),
            user.getFirstName(),
            user.getLastName(),
            user.getImage(),
            user.getIdCard(),
            user.getPhoneNumber(),
            user.getEmail(),
            user.getCareer()
        );
    }

    // ฟังก์ชันเพื่อแปลง JSON response กลับเป็น UserModel
    private UserModel parseJson(String json) {
        UserModel user = new UserModel();
        // แยกข้อมูล JSON ที่ส่งกลับมา และตั้งค่าให้กับ user object
        String[] fields = json.replace("{", "").replace("}", "").replace("\"", "").split(", ");
        for (String field : fields) {
            String[] keyValue = field.split(":");
            switch (keyValue[0]) {
                case "id": user.setId(keyValue[1]); break;
                case "username": user.setUsername(keyValue[1]); break;
                case "password": user.setPassword(keyValue[1]); break;
                case "first_name": user.setFirstName(keyValue[1]); break;
                case "last_name": user.setLastName(keyValue[1]); break;
                case "image": user.setImage(keyValue[1]); break;
                case "id_card": user.setIdCard(keyValue[1]); break;
                case "phone_number": user.setPhoneNumber(keyValue[1]); break;
                case "email": user.setEmail(keyValue[1]); break;
                case "career": user.setCareer(keyValue[1]); break;
            }
        }
        return user;
    }
}
