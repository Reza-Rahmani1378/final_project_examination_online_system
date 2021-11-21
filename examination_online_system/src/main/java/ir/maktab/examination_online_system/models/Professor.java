package ir.maktab.examination_online_system.models;

import ir.maktab.examination_online_system.models.enumeration.UserType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = Professor.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
public class Professor extends User {

    public static final String TABLE_NAME = "professor_table";
    public static final String PROFESSOR_NUMBER = "professor_number";


    public Professor(String firstName, String lastName,
                     String username, String nationalCode,
                     String email, String password) {
        super(firstName, lastName, username, password, nationalCode, UserType.PROFESSOR, email, false);
    }


}
