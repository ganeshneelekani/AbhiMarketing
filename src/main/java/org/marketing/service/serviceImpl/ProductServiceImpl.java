package org.marketing.service.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.marketing.dao.ProductDao;
import org.marketing.dao.daoImpl.ConsigneeDaoImpl;
import org.marketing.dao.daoImpl.ProductDaoImpl;
import org.marketing.model.bean.Product;
import org.marketing.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gn033604 on 9/23/17.
 */
@Service
public class ProductServiceImpl implements ProductService {

    static Logger logger = Logger.getLogger(ProductServiceImpl.class);

    @Autowired
    ProductDao productDao;

    @Override
    public boolean save(Product product) {
        try {
            productDao.save(product);

        } catch (Exception e) {
            logger.info(" ======== EXCEPTION =====" + e);
            return false;
        }
        return true;
    }

    @Override
    public boolean findByProductId(Product product) {

        Boolean status = productDao.findByProductId(product);
        return status;
    }

    @Override
    public List getAllTheProducts() {
        List productList = productDao.getAllTheProducts();
        return productList;
    }
}
