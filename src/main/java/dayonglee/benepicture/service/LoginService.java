package dayonglee.benepicture.service;


import dayonglee.benepicture.domain.user.User;
import dayonglee.benepicture.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;

    @Transactional
    public User login(String userId, String userPassword){

        return bizLogic(userId, userPassword);
    }

    private User bizLogic(String userId, String userPassword){
        return userRepository.login(userId, userPassword);

    }

}
