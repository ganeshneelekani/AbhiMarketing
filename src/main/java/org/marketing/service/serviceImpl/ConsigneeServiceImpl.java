package org.marketing.service.serviceImpl;

import org.apache.log4j.Logger;
import org.marketing.dao.ConsigneeDao;
import org.marketing.dao.daoImpl.ConsigneeDaoImpl;
import org.marketing.model.bean.Consignee;
import org.marketing.model.bean.Product;
import org.marketing.service.ConsigneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gn033604 on 9/24/17.
 */
@Service
public class ConsigneeServiceImpl implements ConsigneeService {

    static Logger logger = Logger.getLogger(ConsigneeDaoImpl.class);
    @Autowired
    ConsigneeDao consigneeDao;

    @Override
    public boolean save(Consignee consignee) {

        try {
            consigneeDao.save(consignee);
        } catch (Exception e) {
            logger.info(" ======== EXCEPTION ====="+e);
            return false;
        }
        return true;
    }

    @Override
    public boolean findByProductId(Consignee consignee) {

        Boolean status = consigneeDao.findByProductId(consignee);
        return status;
    }
}
