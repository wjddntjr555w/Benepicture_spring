package dayonglee.benepicture.service;

import dayonglee.benepicture.model.Notice;
import dayonglee.benepicture.domain.notice.NoticeRepository;
import dayonglee.benepicture.repository.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final NoticeMapper noticeMapper;


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

//        noticeRepository.save(newNotice);
        noticeMapper.save(newNotice);


        return newNotice;
    }

    @Transactional
    public List<Notice> findAll(){
        return noticeRepository.findAll();
    }

}
