package ir.maktab.examination_online_system.models.embeddable;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

// add this embeddable class for check that students that allow join the exam for just one time
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcceptableInExam {

    public static final String IS_ALLOWED_FOR_EXAM = "is_allow_for_exam";
    @Column(name = AcceptableInExam.IS_ALLOWED_FOR_EXAM, columnDefinition = "TINYINT(1) default 1")
    public boolean isAllowedForExam;

    private Long studentId;
}
