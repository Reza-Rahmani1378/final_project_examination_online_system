package ir.maktab.examination_online_system.models;

import ir.maktab.examination_online_system.base.BaseEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = Course.TABLE_NAME)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course extends BaseEntity<Long> {


    public static final String TABLE_NAME = "course_table";
    public static final String TITLE_COURSE = "title_course";
    public static final String START_COURSE = "start_course";
    public static final String END_COURSE = "end_course";


    @Column(name = Course.TITLE_COURSE)
    public String titleCourse;
    @Column(name = Course.START_COURSE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate startCourse;
    @Column(name = Course.END_COURSE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate endCourse;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    public Admin admin;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "course_student_join_table",
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id")
    )
    Set<Student> students = new HashSet<>();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professor_id")
    private Professor professor;

//    @OneToOne
//    private QuestionBank questionBank;


//    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
//    private List<Exam> exams = new ArrayList<>();


}
