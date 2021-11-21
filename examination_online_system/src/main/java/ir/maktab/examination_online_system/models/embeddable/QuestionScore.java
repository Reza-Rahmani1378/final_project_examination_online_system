package ir.maktab.examination_online_system.models.embeddable;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionScore<C extends Serializable> {

    private static final String QUESTION_SCORE = "question_score";
    private static final String EXAM_ID = "exam_id";

    // if Score A , B , C , D
    @Column(name = QuestionScore.QUESTION_SCORE)
    private C questionScore;

    @Column(name = QuestionScore.EXAM_ID)
    private Long examId;

    @Override
    public String toString() {
        return "" + questionScore;
    }
}
