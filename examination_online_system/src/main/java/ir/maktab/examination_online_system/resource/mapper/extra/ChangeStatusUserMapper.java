package ir.maktab.examination_online_system.resource.mapper.extra;

import ir.maktab.examination_online_system.base.mapper.BaseMapper;
import ir.maktab.examination_online_system.models.User;
import ir.maktab.examination_online_system.services.dto.extra.ChangeStatusUserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ChangeStatusUserMapper extends BaseMapper<User, ChangeStatusUserDTO> {
}
