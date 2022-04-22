package dayonglee.benepicture.filter;

import dayonglee.benepicture.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
public class LoginCheckFilter implements Filter {

    private static final String[] whitelist = {"/", "/user/login", "/user/addUser", "/user/logout", "/css/*", "/ad/addAd"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        try{
            if(!PatternMatchUtils.simpleMatch(whitelist, requestURI)){
                HttpSession session = httpRequest.getSession();
                if(session == null || session.getAttribute(SessionConst.LOGIN_USER) == null){

                    log.info("미인증 사용자");

                    httpResponse.sendRedirect("/user/login");
                    return;
                }
            }

            chain.doFilter(request,response);
        } catch (Exception e){
            throw e;
        }
    }
}
