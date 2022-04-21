package dayonglee.benepicture.domain.user;

import dayonglee.benepicture.repository.UserRepositoryInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;

/*
*
* JDBC Template 적용
* */

@Slf4j
@Repository
public class UserRepository implements UserRepositoryInterface {

    private final JdbcTemplate template;

    public UserRepository(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }


    @Override
    public User save(User user) {
        String sql = "insert into user(user_id, user_password) values (?, ?)";
        template.update(sql, user.getUserId(), user.getUserPassword());
        return user;
    }

    @Override
    public User findById(String userId) {
        String sql = "select * from user where user_id = ?";
        return template.queryForObject(sql, userRowMapper(), userId);
    }

    public User login(String userId, String userPW){
        String sql = "select * from user where user_id = ? and user_password = ?";
        return template.queryForObject(sql, userRowMapper(), userId,userPW);
    }

    private RowMapper<User> userRowMapper() {
        return (rs, rowNum) -> {
            User user = new User();
            user.setUserId(rs.getString("user_id"));
            user.setUserPassword(rs.getString("user_password"));
            return user;
        };
    }
}
