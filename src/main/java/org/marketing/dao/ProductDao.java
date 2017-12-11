package org.marketing.dao;

import java.util.List;

import org.marketing.model.bean.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by gn033604 on 9/23/17.
 */
public interface ProductDao {

    public void save(Product product) throws Exception;

    public void saveOrUpdate(Product product) throws Exception;

    public boolean findByProductId(Product product);

    public List getAllTheProducts();

    public Product  getProduct(String productId);

    public void deleteProduct(String consignee);
}
