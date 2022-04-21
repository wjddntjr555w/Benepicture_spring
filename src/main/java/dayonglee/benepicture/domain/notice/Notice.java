package dayonglee.benepicture.domain.notice;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Notice {

    private int noticeId;
    private String title;
    private String description;
    private Date createdAt;
}
