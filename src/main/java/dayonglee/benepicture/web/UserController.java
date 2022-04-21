package dayonglee.benepicture.web;


import dayonglee.benepicture.SessionConst;
import dayonglee.benepicture.domain.user.User;
import dayonglee.benepicture.domain.user.UserRepository;
import dayonglee.benepicture.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final LoginService loginService;

    @GetMapping("/login")
    public String loginPage(@ModelAttribute User user){
        log.info("user/login GetMapping");
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request){
        // ModelAttribute로 넘어온 값을 user에 바로 넣어줌
        log.info("user ={}",user);

        User loginUser = loginService.login(user.getUserId(), user.getUserPassword());

        if (loginUser == null){
            bindingResult.reject("loginFail","아이디 또는 비밀번호가 맞지 않습니다.");
            log.info("login Fail");
            return "user/login";
        }

        HttpSession session = request.getSession();
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
    public String adminHome(){
        return "user/adminHome";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }

        return "redirect:/user/login";
    }
}
