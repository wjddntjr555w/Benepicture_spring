package dayonglee.benepicture.dao;

import dayonglee.benepicture.model.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {

    User login(String userId, String userPassword);
}
