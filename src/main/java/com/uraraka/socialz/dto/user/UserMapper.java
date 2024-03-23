package com.uraraka.socialz.dto.user;


import com.uraraka.socialz.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper (componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "userDTO.id", target = "userId")
    User userDTOtoUserEntity(UserDTO userDTO);

    @Mapping(source = "user.userId", target = "id")
    UserDTO userEntityToUserDTO(User user);
    @Mapping(source = "userToSaveDTO.id", target = "userId")
    User userToSaveDTOtoUserEntity(UserToSaveDTO userToSaveDTO);

}
