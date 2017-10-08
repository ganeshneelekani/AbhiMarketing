package org.marketing.service;

import java.util.List;

import org.marketing.model.bean.Consignee;
import org.marketing.model.bean.Product;

/**
 * Created by gn033604 on 9/24/17.
 */
public interface ConsigneeService {

    public boolean save(Consignee consignee);

    public boolean findByProductId(Consignee consignee);

    public List getAllTheConsignee();
}
