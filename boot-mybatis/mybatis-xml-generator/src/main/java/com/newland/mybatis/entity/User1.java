package com.newland.mybatis.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import lombok.Data;

/**
 * 用户管理
 * t_user1
 * @author leell
 * @date 2023-02-19 13:37:25
 */
@Data
@Schema(name ="用户管理")
public class User1 {
    /**
     */
    private Long id;

    /**
     * 名称
     */
    @Schema(name ="名称")
    private String name;

    /**
     * 性别
     */
    @Schema(name ="性别")
    private Boolean sex;

    /**
     * 创建时间
     */
    @Schema(name ="创建时间")
    private Date createTime;
}