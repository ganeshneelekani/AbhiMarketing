package org.marketing.dao.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.marketing.controller.ProductController;
import org.marketing.dao.ProductDao;
import org.marketing.model.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

/**
 * Created by gn033604 on 9/23/17.
 */
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    static Logger logger = Logger.getLogger(ProductDao.class);

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void save(Product product) throws Exception {
        sessionFactory.getCurrentSession().save(product);
    }

    @Override
    public boolean findByProductId(Product product) {

        List list = sessionFactory.getCurrentSession().createCriteria(Product.class)
                .add(Restrictions.like("productId", product.getProductId())).list();

        if (list.size() > 0) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public List getAllTheProducts() {

        List productList = sessionFactory.getCurrentSession().createCriteria(Product.class).list();
        return productList;
    }

}
