package com.cinema.cinemaapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cinema.cinemambp.model.UmsRoleMenuRelation;
import com.cinema.cinemambp.model.UmsRoleResourceRelation;

/**
 * @Description
 * @Author
 * @Date 2023/10/31
 */
public interface UmsRoleResourceRelationService extends IService<UmsRoleResourceRelation> {
    /**
     * 当角色相关资源信息改变时删除相关后台用户缓存
     */
    void delResourceListByRole(Long roleId);
}
