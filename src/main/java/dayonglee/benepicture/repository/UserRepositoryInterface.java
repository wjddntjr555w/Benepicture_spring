package dayonglee.benepicture.repository;

import dayonglee.benepicture.model.User;

public interface UserRepositoryInterface {

    User save(User user);

    User findById(String memberId);

}
