package dayonglee.benepicture.domain;

import dayonglee.benepicture.model.Notice;
import dayonglee.benepicture.repository.NoticeRepositoryInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
@Repository
public class NoticeRepository implements NoticeRepositoryInterface {

    private final JdbcTemplate template;

    public NoticeRepository(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public Notice save(Notice notice) {
        String sql = "insert into notice(notice_id, title, description, createdat) values(?,?,?,?)";

        template.update(sql,notice.getNoticeId(),notice.getTitle(),notice.getDescription(),notice.getCreatedAt());

        return notice;
    }

    @Override
    public List<Notice> findAll() {
        String sql = "select * from notice";
        List<Notice> notices = template.query(sql, NoticeMapper());

        return notices;
    }

    private RowMapper<Notice> NoticeMapper() {
        return (rs, rowNum) -> {
            Notice notice = new Notice();
            notice.setNoticeId(rs.getInt("notice_id"));
            notice.setTitle(rs.getString("title"));
            notice.setDescription(rs.getString("description"));
            notice.setCreatedAt(rs.getDate("createdat"));
            return notice;
        };
    }
}
