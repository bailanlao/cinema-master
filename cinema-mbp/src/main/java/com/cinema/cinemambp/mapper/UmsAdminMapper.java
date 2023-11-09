package com.cinema.cinemambp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cinema.cinemambp.model.UmsAdmin;

public interface UmsAdminMapper extends BaseMapper<UmsAdmin> {
    UmsAdmin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsAdmin record);

    int deleteByPrimaryKey(Long id);
}
