package com.cinema.cinemaapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cinema.cinemambp.model.UmsMenu;
import com.cinema.cinemambp.model.UmsResource;
import com.cinema.cinemambp.model.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UmsRoleService extends IService<UmsRole> {

    /*
    * 根据管理员ID获取对应菜单
    * */
    List<UmsMenu> getMenuList(Long adminId);

    int update(Long id, UmsRole role);
    /**
     * 分页获取角色列表
     */
    List<UmsRole> listByKeyword(String keyword, Integer pageSize, Integer pageNum);
    /**
     * 获取角色相关菜单
     */
    List<UmsMenu> listMenu(Long roleId);
    /**
     * 获取角色相关资源
     */
    List<UmsResource> listResource(Long roleId);
    /**
     * 给角色分配菜单
     */
    @Transactional
    int allocMenu(Long roleId, List<Long> menuIds);

    /**
     * 给角色分配资源
     */
    @Transactional
    int allocResource(Long roleId, List<Long> resourceIds);

}
