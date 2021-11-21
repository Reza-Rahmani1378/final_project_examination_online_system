package ir.maktab.examination_online_system.services.dto;

import ir.maktab.examination_online_system.base.BaseDTO;
import ir.maktab.examination_online_system.models.enumeration.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionsDTO extends BaseDTO<Long> {


    @NotNull
    private Long id;

    @NotNull
    private String questionTitle;


    @NotNull
    private String questionText;

    @NotNull
    private String questionAnswer;


    @NotNull
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;
}
