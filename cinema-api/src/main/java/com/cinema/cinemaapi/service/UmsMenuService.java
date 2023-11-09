package com.cinema.cinemaapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cinema.cinemaapi.dto.UmsMenuNode;
import com.cinema.cinemambp.model.UmsMenu;

import java.util.List;

public interface UmsMenuService extends IService<UmsMenu> {
    boolean create(UmsMenu umsMenu);
    int update(Long id, UmsMenu umsMenu);

    List<UmsMenuNode> treeList();

    int updateHidden(Long id, Integer hidden);
}
