package com.cinema.cinemambp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cinema.cinemambp.model.UmsAdmin;
import org.apache.ibatis.annotations.Param;

public interface UmsAdminMapper extends BaseMapper<UmsAdmin> {
    UmsAdmin selectByPrimaryKey(@Param("id")Long id);

    int updateByPrimaryKeySelective(UmsAdmin record);

    int deleteByPrimaryKey(@Param("id")Long id);
}
