package ir.maktab.examination_online_system.models.embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerStudent {

    private final static String ANSWER_OF_STUDENT = "answer_of_student";

    @Column(name = ANSWER_OF_STUDENT)
    @Lob
    private String answerStudent;


    private Long score;


}
