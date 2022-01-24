package ir.maktab.examination_online_system.models;

import ir.maktab.examination_online_system.base.BaseEntity;
import ir.maktab.examination_online_system.models.enumeration.UserType;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = User.TABLE_NAME)
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity<Long> {

    private static final String FIRSTNAME = "first_name";
    private static final String LASTNAME = "last_name";
    private static final String NATIONAL_CODE = "national_code";
    private static final String USERTYPE = "user_type";
    private static final String EMAIL = "email";
    private static final String IS_CONFIRMED = "is_confirmed";
    public static final String TABLE_NAME = "user_table";

    @Column(name = User.FIRSTNAME)
    private String firstName;

    @Column(name = User.LASTNAME)
    private String lastName;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(name = User.NATIONAL_CODE, unique = true)
    private String nationalCode;

    @Column(name = User.USERTYPE)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(name = User.EMAIL, unique = true)
    private String email;

    private String fullName;


    @Column(name = User.IS_CONFIRMED, columnDefinition = "TINYINT(1) default 0")
    private boolean isConfirmed;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();


    public User(String firstName, String lastName, String username, String password, String nationalCode, UserType userType, String email, boolean isConfirmed) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.nationalCode = nationalCode;
        this.userType = userType;
        this.email = email;
        this.isConfirmed = isConfirmed;
    }


    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", userType=" + userType +
                ", email='" + email + '\'' +
                ", isConfirmed=" + isConfirmed +
                '}';
    }
}
