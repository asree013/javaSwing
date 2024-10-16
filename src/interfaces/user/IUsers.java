package interfaces.user;

public interface IUsers {
    String getId();
    String getUsername();
    String getPassword();
    String getFirstName();
    String getLastName();
    String getImage();
    String getIdCard();
    String getPhoneNumber();
    String getEmail();
    String getCareer();

    void setId(String id);
    void setUsername(String username);
    void setPassword(String password);
    void setFirstName(String firstName);
    void setLastName(String lastName);
    void setImage(String image);
    void setIdCard(String idCard);
    void setPhoneNumber(String phoneNumber);
    void setEmail(String email);
    void setCareer(String career);
}
