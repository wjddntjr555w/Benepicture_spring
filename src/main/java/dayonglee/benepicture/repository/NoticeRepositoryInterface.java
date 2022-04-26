package dayonglee.benepicture.repository;

import dayonglee.benepicture.model.Notice;

import java.util.List;

public interface NoticeRepositoryInterface {

    Notice save(Notice notice);

    List<Notice> findAll();


}
