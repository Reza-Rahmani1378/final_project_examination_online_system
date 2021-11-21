package ir.maktab.examination_online_system.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import ir.maktab.examination_online_system.base.BaseEntity;
import lombok.*;
import lombok.extern.java.Log;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = Exam.TABLE_NAME)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Exam extends BaseEntity<Long> {
    public static final String TABLE_NAME = "exam_table";

    private static final String TIME_EXAM = "time_exam";


    private String title;

    @Lob
    private String description;

    @Column(name = TIME_EXAM)
    private Integer timeExam;

    @ManyToOne
    private Course course;


}
