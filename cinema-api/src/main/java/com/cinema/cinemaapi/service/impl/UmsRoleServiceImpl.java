package com.cinema.cinemaapi.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cinema.cinemaapi.dao.UmsRoleDao;
import com.cinema.cinemaapi.service.UmsRoleMenuRelationService;
import com.cinema.cinemaapi.service.UmsRoleResourceRelationService;
import com.cinema.cinemaapi.service.UmsRoleService;
import com.cinema.cinemambp.mapper.UmsRoleMapper;
import com.cinema.cinemambp.model.*;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmsRoleServiceImpl extends ServiceImpl<UmsRoleMapper, UmsRole> implements UmsRoleService {

    @Autowired
    private UmsRoleDao roleDao;

    @Autowired
    private UmsRoleMenuRelationService roleMenuRelationService;

    @Autowired
    private UmsRoleResourceRelationService roleResourceRelationService;

    @Override
    public List<UmsMenu> getMenuList(Long adminId) {
        return roleDao.getMenuList(adminId);
    }

    @Override
    public int update(Long id, UmsRole role) {
        role.setId(id);
        return roleDao.updateByPrimaryKeySelective(role);
    }

    @Override
    public List<UmsRole> listByKeyword(String keyword, Integer pageSize, Integer pageNum) {
        return roleDao.listByName(keyword,pageSize,pageNum);
    }

    @Override
    public List<UmsMenu> listMenu(Long roleId) {
        return roleDao.getMenuListByRoleId(roleId);
    }

    @Override
    public List<UmsResource> listResource(Long roleId) {
        return roleDao.getResourceListByRoleId(roleId);
    }

    @Override
    public int allocMenu(Long roleId, List<Long> menuIds) {
        //先删除原有关系
        // 创建LambdaQueryWrapper对象
        LambdaQueryWrapper<UmsRoleMenuRelation> queryWrapper = new LambdaQueryWrapper<>();

        // 设置查询条件，即roleId等于指定的值
        queryWrapper.eq(UmsRoleMenuRelation::getRoleId, roleId);

        // 调用delete方法删除符合条件的记录
        roleMenuRelationService.remove(queryWrapper);
        //批量插入新关系
        for (Long menuId : menuIds) {
            UmsRoleMenuRelation relation = new UmsRoleMenuRelation();
            relation.setRoleId(roleId);
            relation.setMenuId(menuId);
            roleMenuRelationService.save(relation);
        }
        return menuIds.size();
    }

    @Override
    public int allocResource(Long roleId, List<Long> resourceIds) {
        //先删除原有关系
        // 创建LambdaQueryWrapper对象
        LambdaQueryWrapper<UmsRoleResourceRelation> queryWrapper = new LambdaQueryWrapper<>();

        // 设置查询条件，即roleId等于指定的值
        queryWrapper.eq(UmsRoleResourceRelation::getRoleId, roleId);

        // 调用delete方法删除符合条件的记录
        roleResourceRelationService.remove(queryWrapper);
        //批量插入新关系
        for (Long resourceId : resourceIds) {
            UmsRoleResourceRelation relation = new UmsRoleResourceRelation();
            relation.setRoleId(roleId);
            relation.setResourceId(resourceId);
            roleResourceRelationService.save(relation);
        }
        roleResourceRelationService.delResourceListByRole(roleId);
        return resourceIds.size();
    }
}
