package dayonglee.benepicture.domain.ad;

import dayonglee.benepicture.model.Ad;
import dayonglee.benepicture.repository.AdRepositoryInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
@Repository
public class AdRepository implements AdRepositoryInterface {

    private final JdbcTemplate template;

    public AdRepository(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public Ad save(Ad ad) {
        log.info("adRepository sava Ad = {}",ad);
        String sql = "insert into ad(adId,adState,adName,adEmail,adPhone,adDescription,adImageURI) values(?,?,?,?,?,?,?)";

        template.update(sql,ad.getAdId(),ad.getAdState(),ad.getAdName(),ad.getAdEmail(),ad.getAdPhone(),ad.getAdDescription(),ad.getAdImageURI());

        return ad;
    }

    @Override
    public List<Ad> findAll() {
        String sql = "select * from ad";
        List<Ad> ad = template.query(sql, AdMapper());

        return ad;
    }

    private RowMapper<Ad> AdMapper() {
        return (rs, rowNum) -> {
            Ad ad = new Ad();
            ad.setAdId(rs.getInt("adid"));
            ad.setAdState(rs.getString("adState"));
            ad.setAdName(rs.getString("adName"));
            ad.setAdEmail(rs.getString("adEmail"));
            ad.setAdPhone(rs.getString("adPhone"));
            ad.setAdDescription(rs.getString("adDescription"));

            String fileStore = rs.getString("adImageURI");
            String fildDir = "/Users/jeong-useog/Desktop/spring/adImage/"; // 로컬에 파일을 저장하도록 설정
            ad.setAdImageURI("file:"+fildDir+fileStore);
//            ad.setAdImageURI(rs.getString("adImageURI"));

            return ad;
        };
    }
}