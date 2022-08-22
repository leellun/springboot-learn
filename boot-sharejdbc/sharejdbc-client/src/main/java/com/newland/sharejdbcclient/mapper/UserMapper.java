package com.newland.sharejdbcclient.mapper;

import com.newland.sharejdbcclient.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Author: leell
 * Date: 2022/8/22 14:41:21
 */
@Mapper
public interface UserMapper {
    /**
     * 保存
     */
    void save(User user);

    /**
     * 查询
     * @param id
     * @return
     */
    User get(@Param("id") Long id);

}
