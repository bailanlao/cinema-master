package com.cinema.cinemaapi.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cinema.cinemaapi.dto.UmsAdminParam;
import com.cinema.cinemambp.model.UmsAdmin;
import com.cinema.cinemambp.model.UmsResource;
import com.cinema.cinemambp.model.UmsRole;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UmsAdminService extends IService<UmsAdmin> {

    /*
    * 根据用户名获取后台管理员
    * */
    UmsAdmin getAdminByUsername(String username);

    /*
    * 注册功能
    * */
    UmsAdmin register(UmsAdminParam umsAdminParam);

    /*
    * 登录功能
    * */
    String login(String username,String password);

    /*
    * 获取用户信息
    * */
    UserDetails loadUserByUsername(String username);

    /*
    * 获取缓存服务
    * */
    UmsAdminCacheService getCacheService();

    /*
    * 获取指定用户的可访问资源
    * */
    List<UmsResource> getResourceList(Long adminId);

    /*
    * 获取用户对应角色
    * */
    List<UmsRole> getRoleList(Long adminId);

    /**
     * 根据用户名或昵称分页查询用户
     */
    Page<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 修改指定用户信息
     */
    int update(Long id, UmsAdmin admin);

    /**
     * 根据用户id获取用户
     */
    UmsAdmin getItem(Long id);

    /**
     * 删除指定用户
     */
    int delete(Long id);

    /**
     * 修改用户角色关系
     */
    @Transactional
    int updateRole(Long adminId, List<Long> roleIds);
}
