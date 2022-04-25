package dayonglee.benepicture.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class User {

    private Long id;
    private String userId;
    private String userName;
    private String userPassword;
}
