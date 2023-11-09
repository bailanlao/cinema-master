package com.cinema.cinemaapi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cinema.cinemambp.mapper.CinemasMapper;
import com.cinema.cinemaapi.service.CinemasService;
import com.cinema.cinemambp.model.Cinemas;
import org.springframework.stereotype.Service;

@Service
public class CinemasServiceImpl extends ServiceImpl<CinemasMapper,Cinemas> implements CinemasService{
}
