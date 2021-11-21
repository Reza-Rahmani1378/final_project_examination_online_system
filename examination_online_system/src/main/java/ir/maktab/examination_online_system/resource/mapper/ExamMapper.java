package ir.maktab.examination_online_system.resource.mapper;

import ir.maktab.examination_online_system.base.mapper.BaseMapper;
import ir.maktab.examination_online_system.models.Exam;
import ir.maktab.examination_online_system.services.dto.ExamDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ExamMapper extends BaseMapper<Exam, ExamDTO> {
}
