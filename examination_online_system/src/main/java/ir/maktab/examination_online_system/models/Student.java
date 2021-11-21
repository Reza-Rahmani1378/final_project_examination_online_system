package ir.maktab.examination_online_system.models;

import ir.maktab.examination_online_system.models.enumeration.UserType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = Student.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
public class Student extends User {
    public static final String TABLE_NAME = "student_table";
    public static final String STUDENT_NUMBER = "student_number";
    public static final String IS_ALLOWED_FOR_EXAM = "is_allow_for_exam";
    @Column(name = Student.IS_ALLOWED_FOR_EXAM, columnDefinition = "TINYINT(1) default 1")
    public boolean isAllowedForExam;
    @ManyToMany(mappedBy = "students")
    private List<Course> courses;

    public Student(String firstName, String lastName,
                   String username, String nationalCode,
                   String email, String password) {
        super(firstName, lastName, username, password, nationalCode, UserType.STUDENT, email, false);
    }


}
