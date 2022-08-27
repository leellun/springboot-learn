package com.newland.es.service;

import com.newland.es.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: leell
 * Date: 2022/8/26 17:55:30
 */
@Service
public class ElasticService {
    @Autowired
    ProductDao productDao;

    public void save2() {
    }
}
