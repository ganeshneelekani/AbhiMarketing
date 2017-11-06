package org.marketing.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.marketing.model.bean.Consignee;
import org.marketing.model.bean.Product;
import org.apache.log4j.Logger;
import org.marketing.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by gn033604 on 9/23/17.
 */
@Controller
public class ProductController {

    static Logger logger = Logger.getLogger(ProductController.class);
    static String rootPath = new File("").getAbsolutePath() + File.separator + "Images";

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/AddProduct", method = RequestMethod.GET)
    public ModelAndView getProductBean(HttpServletRequest request, HttpServletResponse response) {

        logger.info("===================1===============");

        ModelAndView modelAndView = new ModelAndView("addProduct");
        modelAndView.addObject("addProduct", new Product());


        return modelAndView;
    }

    @RequestMapping(value = "/SaveProduct", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("addProduct") Product product, HttpServletRequest request,
            HttpServletResponse response) {

        logger.info("===================2===============");

        logger.info("Name:" + product.getProductName());
        logger.info("Product Id:" + product.getProductId());
        logger.info("HSN Code:" + product.getHsnCode());
        logger.info("Price:" + product.getBasicPrice());
        logger.info("GSt:" + product.getGstPercentage());
        logger.info("JARS/Cartoon:" + product.getNoOfJarsPerCartoon());
        logger.info("Piece/jar:" + product.getNoOfPiecesPerJar());
        logger.info("weight/jar:" + product.getWeightPerJar());

        //   writeFileToDisk(file, product.getProductId());

        Boolean status = productService.findByProductId(product);

        ModelAndView modelAndView = new ModelAndView("addProduct");

        if (status.equals(true)) {

            Boolean productServiceStatus = productService.save(product);

            if (productServiceStatus.equals(true)) {

                modelAndView.addObject("addProduct", new Product());
                modelAndView.addObject("successMessage", "Product added sucessfully");

            } else {
                modelAndView.addObject("errorMessage", "Some Thing went wrong!!");
            }
        } else {
            modelAndView.addObject("errorMessage", "Product Id is already exist");
        }

        return modelAndView;
    }

    @RequestMapping(value = "/listOfProduct", method = RequestMethod.GET)
    public ModelAndView getListOfProduct(HttpServletRequest request, HttpServletResponse response) {


        logger.info("===================1===============");

        List listOfProduct = productService.getAllTheProducts();

        Iterator iterator = listOfProduct.iterator();
        while (iterator.hasNext()) {

            Product product123 = (Product) iterator.next();

            logger.info("Name123:" + product123.getProductName());
            logger.info("Product Id123:" + product123.getProductId());
            logger.info("HSN Code:" + product123.getHsnCode());
            logger.info("Price:" + product123.getBasicPrice());
            logger.info("GSt:" + product123.getGstPercentage());
            logger.info("JARS/Cartoon:" + product123.getNoOfJarsPerCartoon());
            logger.info("Piece/jar:" + product123.getNoOfPiecesPerJar());
            logger.info("weight/jar:" + product123.getWeightPerJar());

        }

        ArrayList arrayList=new ArrayList();
        ArrayList arrayList1=new ArrayList(5);
        ModelAndView modelAndView = new ModelAndView("listOfProduct");
        modelAndView.addObject("listOfProduct", listOfProduct);
        modelAndView.addObject("imageLocation", rootPath);


        return modelAndView;
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public ModelAndView editProduct(HttpServletRequest request, HttpServletResponse response,
            @PathVariable("productId") String productId, Model model) {

        logger.info("===================1===============");

        Product product = productService.getProduct(productId);

        ModelAndView modelAndView = new ModelAndView("editProduct");
        modelAndView.addObject("editProduct", product);

        return modelAndView;
    }


    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
    public ModelAndView updateProduct(@ModelAttribute("editProduct") Product product, HttpServletRequest request,
            HttpServletResponse response) {

        logger.info("===================== UpdateProduct ===================");

        Boolean status = productService.saveOrUpdate(product);

        if (status.equals(true)) {

            ModelAndView modelAndView = new ModelAndView("redirect:/listOfProduct");
            return modelAndView;

        } else {

            ModelAndView modelAndView = new ModelAndView("editProduct");
            modelAndView.addObject("editProduct", product);
            modelAndView.addObject("errorMessage", "Some Thing went wrong!!");
            return modelAndView;
        }
    }

    private void writeFileToDisk(MultipartFile file, String productId) {

        String latestUploadPhoto = "";
        logger.info("   rootPath " + rootPath);

        File dir = new File(rootPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename()
                .replace(file.getOriginalFilename(), productId) + ".jpg");
        latestUploadPhoto = file.getOriginalFilename();
        logger.info(" latestUploadPhoto 1 " + latestUploadPhoto);

        //write uploaded image to disk
        try {

            InputStream is = file.getInputStream();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));

            int i;
            while ((i = is.read()) != -1) {
                stream.write(i);
            }
            stream.flush();

        } catch (Exception e) {
            System.out.println("error : " + e.getMessage());
        }

    }

}
