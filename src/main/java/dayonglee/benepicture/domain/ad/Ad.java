package dayonglee.benepicture.domain.ad;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Ad {

    private int adId;
    private String adState;
    private String adName;
    private String adEmail;
    private String adPhone;
    private String adDescription;

    private String adImageURI;

}
