package ir.maktab.examination_online_system.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import ir.maktab.examination_online_system.base.BaseEntity;
import ir.maktab.examination_online_system.models.embeddable.AcceptableInExam;
import lombok.*;
import lombok.extern.java.Log;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private static final String EXAM_IMAGE_URL = "exam_image_url";


    private String title;

    @Lob
    private String description;

    @Column(name = TIME_EXAM)
    private Integer timeExam;

    @Lob
    @Column(name = EXAM_IMAGE_URL)
    private String examImageUrl;

    @ManyToOne
    private Course course;

    // use the elementCollection for check that student can just one time for join the exam
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "exam_check_allow_join_exam_student", joinColumns = @JoinColumn(name = "exam_id"))
    private List<AcceptableInExam> students = new ArrayList<>();


}
