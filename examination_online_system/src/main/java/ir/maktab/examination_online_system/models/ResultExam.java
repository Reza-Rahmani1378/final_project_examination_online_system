/*
package ir.maktab.examination_online_system.models;

import ir.maktab.examination_online_system.base.BaseEntity;
import ir.maktab.examination_online_system.models.embeddable.AnswerStudent;
import ir.maktab.examination_online_system.models.embeddable.QuestionOption;
import ir.maktab.examination_online_system.models.enumeration.ExamStatus;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = ResultExam.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ResultExam extends BaseEntity<Long> {

    public final static String TABLE_NAME = "result_exam";
    private final static String EXAM_STATUS = "exam_status";


    @Column(name = EXAM_STATUS)
    @Enumerated(EnumType.STRING)
    private ExamStatus examStatus;

    @ElementCollection
    @CollectionTable(name = "result_student_exam", joinColumns = @JoinColumn(name = "result_id"))
    private List<AnswerStudent> answerStudents = new ArrayList<>();

    @ManyToOne
    private Student student;

    @ManyToOne
    private Exam exam;



}
*/
