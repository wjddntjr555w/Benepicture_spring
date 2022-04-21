package dayonglee.benepicture.web;


import dayonglee.benepicture.domain.notice.Notice;
import dayonglee.benepicture.domain.notice.NoticeRepository;
import dayonglee.benepicture.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;
    private final NoticeRepository noticeRepository;

    @GetMapping("/addNotice")
    public String addNoticePage(){
        return "notice/addNotice";
    }

    @PostMapping("/addNotice")
    public String addNotice(@ModelAttribute Notice notice, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        log.info("notice = {}",notice);

        if (notice.getTitle() == ""){
            log.info("Notice Error");
        }

        Notice newNotice = noticeService.addNotice(notice.getTitle(), notice.getDescription());

        noticeRepository.save(newNotice);

        List<Notice> notices = noticeRepository.findAll();
        log.info("notices ={}",notices);
        redirectAttributes.addFlashAttribute("notices",notices);

        return "redirect:/";
    }
}
