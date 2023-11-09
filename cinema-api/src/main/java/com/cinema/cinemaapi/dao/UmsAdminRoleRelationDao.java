package com.cinema.cinemaapi.dao;

import com.cinema.cinemambp.model.UmsAdminRoleRelation;
import com.cinema.cinemambp.model.UmsResource;
import com.cinema.cinemambp.model.UmsRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UmsAdminRoleRelationDao {
    /*
    * 获取用户所有可访问资源
    * */
    List<UmsResource> getResourceList(@Param("adminId") Long adminId);

    /*
    * 获取所有角色
    * */
    List<UmsRole> getRoleList(@Param("adminId")Long adminId);

    /**
     * 批量插入用户角色关系
     */
    int insertList(@Param("list") List<UmsAdminRoleRelation> adminRoleRelationList);

}
