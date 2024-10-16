package models.user;

import interfaces.user.IUsers;

public class UserModel implements IUsers {

    public String id;
    public String username;
    public String password;
    public String first_name;
    public String last_name;
    public String image;
    public String id_card;
    public String phone_number;
    public String email;
    public String career;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return first_name;
    }

    @Override
    public String getLastName() {
        return last_name;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getIdCard() {
        return id_card;
    }

    @Override
    public String getPhoneNumber() {
        return phone_number;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getCareer() {
        return career;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setIdCard(String idCard) {
        this.id_card = idCard;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phone_number = phoneNumber;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setCareer(String career) {
        this.career = career;
    }

    public String toJsonString() {
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"id\":\"").append(id).append("\",");
        json.append("\"username\":\"").append(username).append("\",");
        json.append("\"password\":\"").append(password).append("\",");
        json.append("\"first_name\":\"").append(first_name).append("\",");
        json.append("\"last_name\":\"").append(last_name).append("\",");
        json.append("\"image\":\"").append(image).append("\",");
        json.append("\"id_card\":\"").append(id_card).append("\",");
        json.append("\"phone_number\":\"").append(phone_number).append("\",");
        json.append("\"email\":\"").append(email).append("\",");
        json.append("\"career\":\"").append(career).append("\"");
        json.append("}");
        return json.toString();
    }

    public UserModel jsonToUserModel(String json) {
        // การแปลง JSON ที่ง่ายที่สุด โดยใช้ String.split() และการจัดการข้อมูล
        UserModel user = new UserModel();
        String[] pairs = json.replaceAll("[{}\"]", "").split(",");
        for (String pair : pairs) {
            String[] keyValue = pair.split(":");
            String key = keyValue[0].trim();
            String value = keyValue.length > 1 ? keyValue[1].trim() : "";
            switch (key) {
                case "id":
                    user.id = value;
                    break;
                case "username":
                    user.username = value;
                    break;
                case "password":
                    user.password = value;
                    break;
                case "first_name":
                    user.first_name = value;
                    break;
                case "last_name":
                    user.last_name = value;
                    break;
                case "image":
                    user.image = value;
                    break;
                case "id_card":
                    user.id_card = value;
                    break;
                case "phone_number":
                    user.phone_number = value;
                    break;
                case "email":
                    user.email = value;
                    break;
                case "career":
                    user.career = value;
                    break;
            }
        }
        return user;
    }

}
