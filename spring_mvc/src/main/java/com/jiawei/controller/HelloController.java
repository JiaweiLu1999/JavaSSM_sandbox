package com.jiawei.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class HelloController {
    private static final String SUCCESS = "success";
    private static final String RESPONSE_SUCCESS = "response_success";

    @RequestMapping("/HelloController/*")
    public String helloWorld() {
        System.out.println("==> HelloController!");
        return SUCCESS;
    }

    @RequestMapping("/setCookie")
    public String setCookie(HttpSession session) {
        System.out.println(session.getId());
        return SUCCESS;
    }

    @RequestMapping("/getCookie")
    public String getCookie(@CookieValue String JSESSIONID, HttpServletRequest request) {
        System.out.println(JSESSIONID);
        System.out.println(request.getServletContext().getRealPath("WEB-INF/pages/index.html"));
        return SUCCESS;
    }

    @GetMapping("/testModelAndView")
    public ModelAndView testModelAndView() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName(RESPONSE_SUCCESS);

        mv.addObject("name", "jiawei");

        return mv;
    }

    @GetMapping("/testMap")
    public String testMap(Map<String, Object> map, Model model) {
        model.addAttribute("name", "didi");
        return RESPONSE_SUCCESS;
    }

}
