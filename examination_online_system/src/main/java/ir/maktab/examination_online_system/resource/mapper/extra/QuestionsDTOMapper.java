package ir.maktab.examination_online_system.resource.mapper.extra;


import ir.maktab.examination_online_system.base.mapper.BaseMapper;
import ir.maktab.examination_online_system.models.Questions;
import ir.maktab.examination_online_system.services.dto.extra.QuestionDTOList;
import org.mapstruct.Mapper;

@Mapper
public interface QuestionsDTOMapper extends BaseMapper<Questions, QuestionDTOList> {

}
