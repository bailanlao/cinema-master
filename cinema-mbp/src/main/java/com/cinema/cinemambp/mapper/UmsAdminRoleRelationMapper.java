package com.cinema.cinemambp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cinema.cinemambp.model.UmsAdminRoleRelation;
import com.cinema.cinemambp.model.UmsAdminRoleRelationExample;

public interface UmsAdminRoleRelationMapper extends BaseMapper<UmsAdminRoleRelation> {
    int deleteByExample(UmsAdminRoleRelationExample example);

}
