package org.marketing.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.marketing.model.Login;
import org.apache.log4j.Logger;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    static Logger LOGGER = Logger.getLogger(LoginController.class);

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {

        return "welcome";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView userLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("login", new Login());
        return mav;
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public ModelAndView validateLogin(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute("login") Login user) {

        LOGGER.info(user.getUsername()+"   ======== UserName ");
        LOGGER.info(user.getPassword()+"   ======== Password ");



        return new ModelAndView("login");
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.GET)
    public ModelAndView addUserGetRequest(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute("login") Login user) {

        LOGGER.info("=========================3=========");

        ModelAndView mav = new ModelAndView("login");
        mav.addObject("login", new Login());
        return mav;
    }
}