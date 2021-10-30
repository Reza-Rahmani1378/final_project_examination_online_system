package ir.maktab.examination_online_system.models;

import ir.maktab.examination_online_system.models.base.BaseEntity;
import ir.maktab.examination_online_system.models.enumeration.UserType;
import lombok.*;

import javax.persistence.*;

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

    @Column(name = User.FIRSTNAME )
    private String firstName;

    @Column(name = User.LASTNAME)
    private String lastName;

    @Column(name = User.NATIONAL_CODE )
    private String nationalCode;

    @Column(name = User.USERTYPE)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(name = User.EMAIL)
    private String email;

    @Column(name = User.IS_CONFIRMED )
    private boolean isConfirmed;



}
