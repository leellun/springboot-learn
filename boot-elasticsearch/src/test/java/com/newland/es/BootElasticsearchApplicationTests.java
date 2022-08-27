package com.newland.es;

import com.newland.es.bean.Product;
import com.newland.es.dao.ProductDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;

import java.util.List;
import java.util.Map;

@SpringBootTest
class BootElasticsearchApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Autowired
    private ProductDao productDao;

    /**
     * 创建索引
     */
    @Test
    public void createIndex() {
        // 创建索引，会根据Item类的@Document注解信息来创建
        Document document=elasticsearchRestTemplate.indexOps(Product.class).createMapping(Product.class);
        // 配置映射，会根据Item类中的@Id、@Field等字段来自动完成映射
        System.out.println(document);
    }

    /**
     * 查询索引
     */
    @Test
    public void getIndex() {
        Map<String, Object> map = elasticsearchRestTemplate.indexOps(Product.class).getMapping();
        for (String key : map.keySet()) {
            System.out.println(key + "===" + map.get(key));
        }
    }

    @Test
    public void deleteIndex() {
        //删除索引
        boolean result = elasticsearchRestTemplate.indexOps(Product.class).delete();
        System.out.println("===============>" + result);
    }

    @Test
    public void createDoc() {
        Product product = new Product();
        product.setId(1L);
        product.setPrice(234.0d);
        product.setTitle("sdfsdfsdf");
        product.setImages("http://234/.sdf");
        product.setCategory("士大夫");
        elasticsearchRestTemplate.save(product, IndexCoordinates.of("product"));
    }

    @Test
    public void getDoc() {
        Product product = elasticsearchRestTemplate.get(String.valueOf(1L), Product.class);
        System.out.println(product);
    }
    @Test
    public void getProduct(){
        Iterable<Product> productList=productDao.findAll();
        productList.forEach(product -> {
            System.out.println(product);
        });
    }
}
