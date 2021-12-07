package ir.maktab.examination_online_system.models;

import ir.maktab.examination_online_system.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = StudentResultExam.TABLE_NAME)
public class StudentResultExam extends BaseEntity<Long> {

    public static final String TABLE_NAME = "student_result_table";
    private static final String STUDENT_ANSWER = "student_answer";
    private static final String STUDENT_POINT = "student_point";

    @Column(name = STUDENT_ANSWER)
    private String studentAnswer;

    @OneToOne
    private Student student;

    @Column(name = STUDENT_POINT)
    private Long studentPoint;
}
