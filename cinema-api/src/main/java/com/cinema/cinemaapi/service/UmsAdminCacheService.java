package com.cinema.cinemaapi.service;

import com.cinema.cinemambp.model.UmsAdmin;
import com.cinema.cinemambp.model.UmsResource;

import java.util.List;

/*
* 后台用户缓存操作Service
* */
public interface UmsAdminCacheService {
    /*
    * 获取缓存后台用户信息
    * */
    UmsAdmin getAdmin(String username);

    /*
    * 设置缓存后台用户信息
    * */
    void setAdmin(UmsAdmin admin);

    /*
    * 获取缓存后台用户资源列表
    * */
    List<UmsResource> getResourceList(Long adminId);

    /*
    * 设置缓存后台用户资源列表
    * */
    void setResourceList(Long adminId,List<UmsResource> resourceList);

    /**
     * 删除后台用户缓存
     */
    void delAdmin(Long adminId);

    /**
     * 删除后台用户资源列表缓存
     */
    void delResourceList(Long adminId);

}
