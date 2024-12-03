package model;

public class User {
    private  String id ;
    private  String ten ;
    private String email ;
    private String pwd ;
    private int age ;
    private String birth ;
    private String role ;

    public User() {
    }

    public User(String id, String ten, String email, String pwd, int age, String birth, String role) {
        this.id = id;
        this.ten = ten;
        this.email = email;
        this.pwd = pwd;
        this.age = age;
        this.birth = birth;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
