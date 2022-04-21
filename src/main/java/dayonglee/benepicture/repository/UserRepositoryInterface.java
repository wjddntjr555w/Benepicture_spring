package dayonglee.benepicture.repository;

import dayonglee.benepicture.domain.user.User;

public interface UserRepositoryInterface {

    User save(User user);

    User findById(String memberId);

}
