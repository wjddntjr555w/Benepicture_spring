package dayonglee.benepicture.web;


import dayonglee.benepicture.domain.notice.NoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final NoticeRepository noticeRepository;

    @GetMapping("/")
    public String home(Model model){

        model.addAttribute("notices",noticeRepository.findAll());
        return "home";
    }
}
