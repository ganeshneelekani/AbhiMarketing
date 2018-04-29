package org.marketing.controller;

import org.apache.log4j.Logger;
import org.marketing.model.bean.Customer;
import org.marketing.model.bean.Customer;
import org.marketing.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class CustomerController {

    static Logger LOGGER = Logger.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
    public ModelAndView getProductBean(HttpServletRequest request, HttpServletResponse response) {

        LOGGER.info("==================Customer Controller================");

        ModelAndView modelAndView = new ModelAndView("addCustomer");
        modelAndView.addObject("customer", new Customer());

        return modelAndView;
    }

    @RequestMapping(value = "/registerCustomer", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("customer") Customer customer, HttpServletRequest request,
                             HttpServletResponse response) {

        LOGGER.info("===================Savecustomer===============");

        LOGGER.info("Name:" + customer.getCustomerName());
        LOGGER.info("Address:" + customer.getAddress());
        LOGGER.info("Mobile No:" + customer.getMobileNumber());
        LOGGER.info("State:" + customer.getPassword());
        LOGGER.info("StateCode:" + customer.getCustomerEmailAddress());

        Boolean status = customerService.findByMobileNumer(customer);


        LOGGER.info("status:" + status);


        ModelAndView modelAndView = new ModelAndView("addCustomer");

        if (status.equals(true)) {

            Boolean customerServiceStatus = customerService.save(customer);

            if (customerServiceStatus.equals(true)) {

                modelAndView.addObject("customer", new Customer());
                modelAndView.addObject("sucessMessage", "Customer added sucessfully");

            } else {
                modelAndView.addObject("errorMessage", "Some Thing went wrong!!");
            }

        } else {
            modelAndView.addObject("errorMessage", "Customer mobile number is already exist");
        }

        return modelAndView;
    }

//    @RequestMapping(value = "/updatecustomer", method = RequestMethod.POST)
//    public ModelAndView updateProduct(@ModelAttribute("editProduct") customer customer, HttpServletRequest request,
//                                      HttpServletResponse response) {
//
//        LOGGER.info("===================== Updatecustomer ===================");
//
//        Boolean status = customerService.saveOrUpdate(customer);
//
//        if (status.equals(true)) {
//
//            ModelAndView modelAndView = new ModelAndView("redirect:/listOfcustomer");
//            return modelAndView;
//
//        } else {
//
//            ModelAndView modelAndView = new ModelAndView("editcustomer");
//            modelAndView.addObject("editcustomer", customer);
//            modelAndView.addObject("errorMessage", "Some Thing went wrong!!");
//            return modelAndView;
//        }
//    }
//
//    @RequestMapping(value = "/listOfcustomer", method = RequestMethod.GET)
//    public ModelAndView getListOfProduct(HttpServletRequest request, HttpServletResponse response) {
//
//
//        LOGGER.info("===================1 ===============");
//
//        List listOfcustomer = customerService.getAllThecustomer();
//
//        ModelAndView modelAndView = new ModelAndView("listOfcustomer");
//        modelAndView.addObject("listOfcustomer", listOfcustomer);
//
//
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "edit/customer/{customerName}", method = RequestMethod.GET)
//    public ModelAndView editcustomer(HttpServletRequest request, HttpServletResponse response,
//                                     @PathVariable("customerName") String customerName, Model model) {
//
//        LOGGER.info("===================Edit===============");
//
//        customer customer = customerService.getcustomer(customerName);
//
//        LOGGER.info("===================123===============" + customer.getMobileNo());
//
//        ModelAndView modelAndView = new ModelAndView("editcustomer");
//        modelAndView.addObject("editcustomer", customer);
//
//        return modelAndView;
//    }
//
//
//    @RequestMapping(value = "delete/customer/{customerName}", method = RequestMethod.GET)
//    public String deletecustomer(HttpServletRequest request, HttpServletResponse response,
//                                 @PathVariable("customerName") String customerName, Model model) {
//
//        customerService.deletecustomer(customerName);
//
//        return "redirect:/listOfcustomer";
//
//    }
}
