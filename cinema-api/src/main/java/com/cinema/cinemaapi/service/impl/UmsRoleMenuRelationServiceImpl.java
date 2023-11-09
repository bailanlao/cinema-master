package com.cinema.cinemaapi.service.impl;/**
 * @Description
 * @Author
 * @Date 2023/10/31
 */

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cinema.cinemaapi.service.UmsRoleMenuRelationService;
import com.cinema.cinemambp.mapper.UmsRoleMapper;
import com.cinema.cinemambp.mapper.UmsRoleMenuRelationMapper;
import com.cinema.cinemambp.model.UmsRole;
import com.cinema.cinemambp.model.UmsRoleMenuRelation;
import org.springframework.stereotype.Service;

/**
 * @FileName UmsRoleMenuRelationServiceImpl
 * @Description
 * @Author ht
 * @date 2023-10-31
 **/
@Service
public class UmsRoleMenuRelationServiceImpl extends ServiceImpl<UmsRoleMenuRelationMapper, UmsRoleMenuRelation> implements UmsRoleMenuRelationService {
}
