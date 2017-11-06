package org.marketing.dao;

import java.util.List;

import org.marketing.model.bean.Consignee;
import org.marketing.model.bean.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by gn033604 on 9/24/17.
 */
public interface ConsigneeDao {

    public void save(Consignee consignee) throws  Exception;

    public boolean findByProductId(Consignee consignee);

    public List getAllTheConsignee();

    public Consignee getConsignee(String consigneeName);
}
