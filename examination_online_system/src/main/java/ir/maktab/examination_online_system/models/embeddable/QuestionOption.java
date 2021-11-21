package ir.maktab.examination_online_system.models.embeddable;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionOption {
    private static final String OPTION_TEXT = "option_text";
    @Lob
    @Column(name = QuestionOption.OPTION_TEXT)
    private String optionText;
}
