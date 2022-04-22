package dayonglee.benepicture.web;


import dayonglee.benepicture.SessionConst;
import dayonglee.benepicture.domain.ad.Ad;
import dayonglee.benepicture.domain.ad.AdRepository;
import dayonglee.benepicture.domain.notice.NoticeRepository;
import dayonglee.benepicture.domain.user.User;
import dayonglee.benepicture.domain.user.UserRepository;
import dayonglee.benepicture.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final LoginService loginService;

    private final NoticeRepository noticeRepository;
    private final AdRepository adRepository;

    @GetMapping("/login")
    public String loginPage(@ModelAttribute User user){
        log.info("user/login GetMapping");
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request){

        log.info("user ={}",user);

        User loginUser = loginService.login(user.getUserId(), user.getUserPassword());

        if (loginUser == null){
            bindingResult.reject("loginFail","아이디 또는 비밀번호가 맞지 않습니다.");
            log.info("login Fail");
            return "user/login";
        }

        HttpSession session = request.getSession(true);
        log.info("session ={}",session);

        session.setAttribute(SessionConst.LOGIN_USER, loginUser);

        log.info("login Success");
        return "redirect:/";
    }

    @GetMapping("/addUser")
    public String addUserPage(){
        return "user/addUserForm";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user){

        userRepository.save(user);

        log.info("saved user = {}",userRepository.findById(user.getUserId()));

        return "redirect:/user/login";
    }

    @GetMapping("/adminHome")
    public String adminHome(Model model) {

        model.addAttribute("notices",noticeRepository.findAll());

        List<Ad> adList = adRepository.findAll();
        model.addAttribute("ads",adList);


        return "user/adminHome";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }

        return "redirect:/";
    }
}
