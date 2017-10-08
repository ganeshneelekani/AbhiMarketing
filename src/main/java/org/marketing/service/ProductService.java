package org.marketing.service;

import java.util.List;

import org.marketing.model.bean.Product;

/**
 * Created by gn033604 on 9/23/17.
 */
public interface ProductService {

    public boolean save(Product product);

    public boolean saveOrUpdate(Product product);

    public boolean findByProductId(Product product);

    public List getAllTheProducts();

    public Product  getProduct(String productId);
}
