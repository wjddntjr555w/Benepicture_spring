package dayonglee.benepicture.domain.ad;

import dayonglee.benepicture.repository.AdRepositoryInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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
        return null;
    }
}