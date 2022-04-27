package dayonglee.benepicture.repository;

import dayonglee.benepicture.model.Notice;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface NoticeMapper {

    // save, findAll

    void save(Notice notice);

    Notice findAll();
}
