package com.newland.mongodb.bean;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Author: leell
 * Date: 2022/8/22 10:18:53
 */
@Data
@ToString
@Accessors(chain = true)
public class Status {

    private Integer weight;
    private Integer height;

}
