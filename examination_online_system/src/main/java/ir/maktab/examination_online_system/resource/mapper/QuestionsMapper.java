package ir.maktab.examination_online_system.resource.mapper;

import ir.maktab.examination_online_system.base.mapper.BaseMapper;
import ir.maktab.examination_online_system.models.Course;
import ir.maktab.examination_online_system.models.Questions;
import ir.maktab.examination_online_system.services.dto.CourseDTO;
import ir.maktab.examination_online_system.services.dto.QuestionsDTO;
import org.mapstruct.Mapper;

@Mapper
public interface QuestionsMapper extends BaseMapper<Questions, QuestionsDTO> {
}
