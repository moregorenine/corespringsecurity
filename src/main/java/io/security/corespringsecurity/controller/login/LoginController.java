package io.security.corespringsecurity.controller.login;


import io.security.corespringsecurity.domain.entity.Account;
import io.security.corespringsecurity.security.authentication.services.UserDetail;
import io.security.corespringsecurity.service.RoleService;
import io.security.corespringsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/denied")
    public String accessDenied() throws Exception {

        return "user/login/denied";
    }

    // 외부 인증 서버에서 로그인 후 정보를 전달받는 엔드포인트
    @GetMapping("/custom-login")
    public String login(@RequestParam String username, HttpServletRequest request) {

        // 외부 인증 서버에서 받은 사용자 정보를 바탕으로 Spring Security Authentication 객체 생성
        Account account = userService.findByUsername(username);
        UserDetails userDetails = userDetailsService.loadUserByUsername(account.getUsername());

        // Authentication 객체 생성 (단순히 사용자의 정보만 필요한 경우)
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(((UserDetail) userDetails).getAccount(), null, userDetails.getAuthorities());

        // SecurityContext에 인증된 사용자 설정
        SecurityContextHolder.getContext().setAuthentication(authentication);
        request.getSession(true).setMaxInactiveInterval(43200);


//        // SecurityContext에 인증 정보 설정
//        SecurityContext context = SecurityContextHolder.createEmptyContext();
//        context.setAuthentication(authentication);
//        SecurityContextHolder.setContext(context);
//
//        // HttpSession에 SecurityContext 저장
//        request.getSession(true).setAttribute("SPRING_SECURITY_CONTEXT", context);

        // 로그인 후 리다이렉트할 URL
        return "redirect:/";
    }
}
