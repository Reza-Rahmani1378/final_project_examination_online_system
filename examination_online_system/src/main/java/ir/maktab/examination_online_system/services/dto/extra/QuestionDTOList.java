package ir.maktab.examination_online_system.services.dto.extra;

import io.swagger.annotations.ResponseHeader;
import ir.maktab.examination_online_system.base.BaseDTO;
import ir.maktab.examination_online_system.models.embeddable.QuestionOption;
import ir.maktab.examination_online_system.models.embeddable.QuestionScore;
import ir.maktab.examination_online_system.models.enumeration.QuestionType;
import lombok.*;

import javax.persistence.Column;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionDTOList extends BaseDTO<Long> {

    private Long id;

//    private String questionTitle;

    private String header;

//    private String questionAnswer;

    private String type;

//    private List<QuestionScore<Long>> questionScores;

    private Set<QuestionOption> options = new HashSet<>();


}
