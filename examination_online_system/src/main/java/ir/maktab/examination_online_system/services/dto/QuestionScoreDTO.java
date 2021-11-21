package ir.maktab.examination_online_system.services.dto;


import ir.maktab.examination_online_system.base.BaseDTO;
import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionScoreDTO extends BaseDTO<Long> {


    // if Score A , B , C , D
    private Long questionScore;

    private Long examId;

}
