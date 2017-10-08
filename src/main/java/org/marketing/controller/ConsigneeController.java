package org.marketing.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.marketing.model.bean.Consignee;
import org.marketing.model.bean.Product;
import org.marketing.service.ConsigneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by gn033604 on 9/24/17.
 */

@Controller
public class ConsigneeController {

    static Logger logger = Logger.getLogger(ConsigneeController.class);

    @Autowired
    ConsigneeService consigneeService;

    @RequestMapping(value = "/AddConsignee", method = RequestMethod.GET)
    public ModelAndView getProductBean(HttpServletRequest request, HttpServletResponse response) {

        logger.info("==================ConsigneeController================");

        ModelAndView modelAndView = new ModelAndView("addConsignee");
        modelAndView.addObject("consignee", new Consignee());

        return modelAndView;
    }

    @RequestMapping(value = "/SaveConsignee", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("consignee") Consignee consignee, HttpServletRequest request,
            HttpServletResponse response) {

        logger.info("===================SaveConsignee===============");

        logger.info("Name:" + consignee.getConsigneeName());
        logger.info("Address:" + consignee.getAddress());
        logger.info("Gstin" + consignee.getGstin());
        logger.info("Mobile No:" + consignee.getMobileNo());
        logger.info("State:" + consignee.getState());
        logger.info("StateCode:" + consignee.getStateCode());
        logger.info("Pincode" + consignee.getPincode());

        Boolean status = consigneeService.findByProductId(consignee);

        ModelAndView modelAndView = new ModelAndView("addConsignee");

        if (status.equals(true)) {

            Boolean consigneeServiceStatus = consigneeService.save(consignee);

            if (consigneeServiceStatus.equals(true)) {

                modelAndView.addObject("consignee", new Consignee());
                modelAndView.addObject("sucessMessage", "Consignee added sucessfully");

            } else {
                modelAndView.addObject("errorMessage", "Some Thing went wrong!!");
            }

        } else {
            modelAndView.addObject("errorMessage", "Consignee is already exist");
        }

        return modelAndView;
    }


    @RequestMapping(value = "/listOfConsignee", method = RequestMethod.GET)
    public ModelAndView getListOfProduct(HttpServletRequest request, HttpServletResponse response) {


        logger.info("===================1 ===============");

        List listOfConsignee = consigneeService.getAllTheConsignee();

        ModelAndView modelAndView = new ModelAndView("listOfConsignee");
        modelAndView.addObject("listOfConsignee", listOfConsignee);


        return modelAndView;
    }

}
