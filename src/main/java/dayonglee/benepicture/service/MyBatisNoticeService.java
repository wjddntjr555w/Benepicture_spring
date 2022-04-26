package dayonglee.benepicture.service;

import dayonglee.benepicture.model.Notice;
import dayonglee.benepicture.repository.NoticeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Random;

@Slf4j
@Service
public class MyBatisNoticeService {

    @Autowired
    NoticeMapper noticeMapper;

    @Transactional
    public Notice addNotice(String title, String description){

        Notice newNotice = new Notice();

        Random random = new Random();
        int ran = random.nextInt();

        newNotice.setNoticeId(ran);
        newNotice.setTitle(title);
        newNotice.setDescription(description);

        Date now = new Date();
        newNotice.setCreatedAt(now);

        return newNotice;
    }
}
