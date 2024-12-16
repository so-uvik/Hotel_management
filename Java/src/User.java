public class User {
    private int userId;
    private String fullName;
    private String email;
    private int phoneNumber;
    private String password;

    public User(int userId, String fullName, String email, int phoneNumber, String password) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }


    public int getUserId() {
        return userId;
    }
    public String getFullName() {
        return fullName;
    }
    public String getEmail() {
        return email;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public String getPassword() {
        return password;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setPassword(String password) {
        this.password = password;
    }



}
