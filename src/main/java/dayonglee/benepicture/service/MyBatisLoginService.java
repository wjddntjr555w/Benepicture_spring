package dayonglee.benepicture.service;


import dayonglee.benepicture.domain.user.User;
import dayonglee.benepicture.repository.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyBatisLoginService {


    @Autowired
    private UserMapper userMapper;

    @Transactional
    public User login(String userId, String userPassword){
        log.info("login");

        dayonglee.benepicture.domain.user.User login = userMapper.login(userId, userPassword);

        return login;
    }
}
