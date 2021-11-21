package ir.maktab.examination_online_system.services.dto;

import ir.maktab.examination_online_system.base.BaseDTO;
import ir.maktab.examination_online_system.base.mapper.BaseMapper;
import ir.maktab.examination_online_system.models.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseDTO extends BaseDTO<Long> {


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate startCourse;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate endCourse;
    private Long id;
    private String titleCourse;

}
