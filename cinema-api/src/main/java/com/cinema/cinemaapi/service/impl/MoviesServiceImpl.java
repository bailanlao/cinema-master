package com.cinema.cinemaapi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cinema.cinemambp.mapper.MoviesMapper;

import com.cinema.cinemaapi.service.MoviesService;
import com.cinema.cinemambp.model.Movies;
import org.springframework.stereotype.Service;

@Service
public class MoviesServiceImpl extends ServiceImpl<MoviesMapper, Movies> implements MoviesService {
}
