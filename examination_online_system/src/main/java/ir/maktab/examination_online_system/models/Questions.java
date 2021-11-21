package ir.maktab.examination_online_system.models;

import ir.maktab.examination_online_system.base.BaseEntity;
import ir.maktab.examination_online_system.models.embeddable.QuestionOption;
import ir.maktab.examination_online_system.models.embeddable.QuestionScore;
import ir.maktab.examination_online_system.models.enumeration.QuestionType;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = Questions.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Questions extends BaseEntity<Long> {
    public static final String TABLE_NAME = "questions_table";
    public static final String QUESTION_TITLE = "question_title";
    public static final String QUESTION_TEXT = "question_text";
    public static final String QUESTION_TYPE = "question_type";
    public static final String QUESTION_ANSWER = "question_answer";

    @Lob
    @Column(name = QUESTION_TITLE)
    private String questionTitle;

    @Lob
    @Column(name = QUESTION_TEXT)
    private String questionText;

    @Lob
    @Column(name = QUESTION_ANSWER)
    private String questionAnswer;


    // we have two type for questions and when we have more type for questions we can add type question in QuestionType
    @Column(name = QUESTION_TYPE)
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @ManyToOne
    private QuestionBank questionBank;

    // we know that my question can have many exams and exams can have many question in one course

    @ManyToMany
    @JoinTable(name = "question_exam",
            joinColumns = @JoinColumn(name = "questions_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "exam_id", referencedColumnName = "id"))
    private List<Exam> exams = new ArrayList<>();


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "question_scores", joinColumns = @JoinColumn(name = "question_id"))
    private List<QuestionScore<Long>> questionScores;

    @ElementCollection
    @CollectionTable(name = "question_options", joinColumns = @JoinColumn(name = "question_d"))
    private Set<QuestionOption> questionOptions;


}
