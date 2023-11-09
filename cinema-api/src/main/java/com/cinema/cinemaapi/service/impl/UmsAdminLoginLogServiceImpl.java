package com.cinema.cinemaapi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cinema.cinemaapi.service.UmsAdminLoginLogService;
import com.cinema.cinemambp.mapper.UmsAdminLoginLogMapper;
import com.cinema.cinemambp.model.UmsAdminLoginLog;
import org.springframework.stereotype.Service;

@Service
public class UmsAdminLoginLogServiceImpl extends ServiceImpl<UmsAdminLoginLogMapper, UmsAdminLoginLog> implements UmsAdminLoginLogService {
}
