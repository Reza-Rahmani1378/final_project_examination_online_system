package ir.maktab.examination_online_system.resource.mapper;

import ir.maktab.examination_online_system.base.mapper.BaseMapper;
import ir.maktab.examination_online_system.models.User;
import ir.maktab.examination_online_system.services.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User, UserDTO> {

}
