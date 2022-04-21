package dayonglee.benepicture.domain.user;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {

    private Long id;
    private String userId;
    private String userName;
    private String userPassword;
}
