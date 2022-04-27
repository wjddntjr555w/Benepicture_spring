package dayonglee.benepicture.service;


import dayonglee.benepicture.repository.UserMapper;
import dayonglee.benepicture.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class MyBatisLoginService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public User login(String userId, String userPassword){
        log.info("user Info = {} {}",userId,userPassword);

        User loginUser = userMapper.login(userId, userPassword);

        log.info("loginUser= {}",loginUser);
        return loginUser;

    }

    @Transactional
    public User save(User user){

        userMapper.save(user);

        log.info("saved user = {}",user);
        return user;
    };
}
