package com.cinema.cinemaapi.dao;

import com.cinema.cinemambp.model.UmsMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author
 * @Date 2023/10/30
 */
public interface UmsMenuDao {
    int updateByPrimaryKeySelective(@Param("UmsMenu") UmsMenu record);
}
