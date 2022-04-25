package dayonglee.benepicture.repository;

import dayonglee.benepicture.domain.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {

    User selectUserById(Long id);
    List<User> selectAllUsers();
    void insertUser(User user);

    User login(String userId, String userPassword);
}
