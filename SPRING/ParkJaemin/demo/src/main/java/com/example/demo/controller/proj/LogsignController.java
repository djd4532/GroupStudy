package com.example.demo.controller.proj;


import com.example.demo.entity.TestMember;
import com.example.demo.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/proj")
public class LogsignController {
    private static final Logger log =
            LoggerFactory.getLogger(LogsignController.class);

    @Autowired
    private BoardService service;


    @RequestMapping(value = "/home",
            method = RequestMethod.GET, params = "register")
    public String getRegisterForm(Model model) {
        log.info("/get?register()");

        model.addAttribute("testMember", new TestMember());

        return "proj/signup/registerForm.html";
    }
//
    @PostMapping("/register")
    public String doRegisters(TestMember testMember) {
        log.info("doRegister()");
        log.info("userId = " + testMember.getUserName());
        log.info("passwd = " + testMember.getPassword());
        log.info("passwdiden = " + testMember.getPasswordiden());
        log.info("phoneNum = " + testMember.getPhoneNum());
        log.info("Email = " + testMember.getEmail());

        return "proj/signup/complete.html";
    }

    @RequestMapping(value = "/home",
            method = RequestMethod.GET, params = "login")
    public String getLoginForm(Model model) {
        log.info("/get?login");

        model.addAttribute("testMember", new TestMember());

        return "proj/login/login.html";
    }


    @PostMapping("/login")
    public String doLogin(TestMember testMember) {
        log.info("doLogin()");
        log.info("userId = " + testMember.getUserName());
        log.info("passwd = " + testMember.getPassword());

        return "proj/login/logincomplete.html";
    }



    @GetMapping("/list")
    public String getList(Model model) throws Exception {
        log.info("getList()");

        model.addAttribute("list", service.list());

        return "spring/real_board/list";
    }


    // <form action="result.html" th:action="@{/proj/register}" 역할은 result.html

}
