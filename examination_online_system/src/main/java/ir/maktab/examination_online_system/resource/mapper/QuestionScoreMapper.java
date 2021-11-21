package ir.maktab.examination_online_system.resource.mapper;

import ir.maktab.examination_online_system.base.mapper.BaseMapper;
import ir.maktab.examination_online_system.models.Exam;
import ir.maktab.examination_online_system.models.embeddable.QuestionScore;
import ir.maktab.examination_online_system.services.dto.ExamDTO;
import ir.maktab.examination_online_system.services.dto.QuestionScoreDTO;
import org.mapstruct.Mapper;

@Mapper
public interface QuestionScoreMapper extends BaseMapper<QuestionScore<Long>, QuestionScoreDTO> {
}
