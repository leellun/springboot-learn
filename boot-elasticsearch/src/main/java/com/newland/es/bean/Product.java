package com.newland.es.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Spring Data通过注解来声明字段的映射属性，有下面的三个注解：
 *
 * - @Document
 *   作用在类，标记实体类为文档对象，一般有四个属性
 * - indexName：对应索引库名称
 * - type：对应在索引库中的类型
 * - shards：分片数量，默认5
 * - replicas：副本数量，默认1
 * - @Id 作用在成员变量，标记一个字段作为id主键
 * - field
 *   作用在成员变量，标记为文档的字段，并指定字段映射属性：
 * - type：字段类型，取值是枚举：FieldType
 * - index：是否索引，布尔类型，默认是true
 * - store：是否存储，布尔类型，默认是false
 * - analyzer：分词器名称：ik_max_word
 * - searchAnalyzer：搜索时的分词器名称
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(indexName = "product", shards = 3, replicas = 1)
public class Product {
    @Id
    private Long id;//商品唯一标识
    @Field(type = FieldType.Text)
    private String title;//商品名称
    @Field(type = FieldType.Keyword)
    private String category;//分类名称
    @Field(type = FieldType.Double)
    private Double price;//商品价格
    @Field(type = FieldType.Keyword, index = false)
    private String images;//图片地址
}
