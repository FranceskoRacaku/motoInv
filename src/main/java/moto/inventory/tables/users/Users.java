package moto.inventory.tables.users;

import javax.persistence.*;

@Entity
@Table
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String userName;
    private String userEmail;
    private Integer userAge;


    public Users() {
    }

    public Users(Integer id,
                 String userName,
                 String userEmail,
                 Integer userAge ) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userAge = userAge;
    }

    public Users(String userName,
                 String userEmail,
                 Integer userAge ) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userAge = userAge;
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userAge='" + userAge + '\'' +
                '}';
    }
}
