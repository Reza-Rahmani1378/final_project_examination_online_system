package ir.maktab.examination_online_system.services.dto;

import ir.maktab.examination_online_system.base.BaseDTO;
import ir.maktab.examination_online_system.models.Exam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExamDTO extends BaseDTO<Long> {

    private Long id;

    private String title;

    private String description;

    private Integer timeExam;

}
