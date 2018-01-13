package org.marketing.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.marketing.model.LoginUser;
import org.marketing.model.bean.Product;
import org.marketing.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    static Logger LOGGER = Logger.getLogger(LoginController.class);

    @Autowired
    LoginUserService loginUserService;

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {

        return "welcome";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView userLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("login", new LoginUser());
        return mav;
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public ModelAndView validateLogin(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute("LoginPage") LoginUser user) {

        ModelAndView modelAndView = new ModelAndView("LoginPage");
        LOGGER.info(user.getUserName() + "   ======== UserName ");
        LOGGER.info(user.getPassword() + "   ======== Password ");

        Boolean status = loginUserService.validateUser(user);


        if (status.equals(true)) {

        } else {

            LOGGER.info("=======================#######==========" + status);

            modelAndView.addObject("errorMessage", "Invalid User");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.GET)
    public ModelAndView addUserGetRequest(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute("login") LoginUser user) {

        LOGGER.info("=========================3=========");

        ModelAndView mav = new ModelAndView("login");
        mav.addObject("LoginPage", new LoginUser());
        return mav;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute("login") LoginUser user) {

        LOGGER.info("=========================3=========" + user.getUserName() + "   " + user.getPassword());

        ModelAndView mav = new ModelAndView("addUser");
        mav.addObject("addUser", new LoginUser());
        return mav;
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ModelAndView saveUser(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute("login") LoginUser user) {

        LOGGER.info("=========================43=========" + user.getUserName() + "   " + user.getPassword());


        ModelAndView mav = new ModelAndView("addUser");
        mav.addObject("addUser", new LoginUser());
        return mav;
    }
}