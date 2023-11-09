package com.cinema.cinemaapi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cinema.cinemaapi.service.UmsResourceService;
import com.cinema.cinemambp.mapper.UmsResourceMapper;
import com.cinema.cinemambp.model.UmsResource;
import org.springframework.stereotype.Service;

@Service
public class UmsResourceServiceImpl extends ServiceImpl<UmsResourceMapper, UmsResource> implements UmsResourceService {
}
