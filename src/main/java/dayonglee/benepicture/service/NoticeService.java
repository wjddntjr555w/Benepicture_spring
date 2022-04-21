package dayonglee.benepicture.service;

import dayonglee.benepicture.domain.notice.Notice;
import dayonglee.benepicture.domain.notice.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

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
