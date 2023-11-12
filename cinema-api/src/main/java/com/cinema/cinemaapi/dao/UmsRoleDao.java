package com.cinema.cinemaapi.dao;

import com.cinema.cinemambp.model.UmsMenu;
import com.cinema.cinemambp.model.UmsResource;
import com.cinema.cinemambp.model.UmsRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmsRoleDao {
    /*
     * 根据后台用户ID获取菜单
     */
    List<UmsMenu> getMenuList(@Param("adminId")Long adminId);

    int updateByPrimaryKeySelective(UmsRole record);

    List<UmsRole> listByName(@Param("keyword") String keyword, @Param("pageSize") Integer pageSize, @Param("offset") Integer offset);

    /**
     * 根据角色ID获取菜单
     */
    List<UmsMenu> getMenuListByRoleId(@Param("roleId") Long roleId);
    /**
     * 根据角色ID获取资源
     */
    List<UmsResource> getResourceListByRoleId(@Param("roleId") Long roleId);
}
