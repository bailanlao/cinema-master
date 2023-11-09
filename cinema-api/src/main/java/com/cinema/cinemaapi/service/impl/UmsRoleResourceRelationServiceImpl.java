package com.cinema.cinemaapi.service.impl;/**
 * @Description
 * @Author
 * @Date 2023/10/31
 */

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cinema.cinemaapi.service.UmsAdminRoleRelationService;
import com.cinema.cinemaapi.service.UmsRoleResourceRelationService;
import com.cinema.cinemacommon.service.RedisService;
import com.cinema.cinemambp.mapper.UmsRoleResourceRelationMapper;
import com.cinema.cinemambp.model.UmsAdminRoleRelation;
import com.cinema.cinemambp.model.UmsRoleMenuRelation;
import com.cinema.cinemambp.model.UmsRoleResourceRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @FileName UmsRoleResourceRelationServiceImpl
 * @Description
 * @Author ht
 * @date 2023-10-31
 **/
@Service
public class UmsRoleResourceRelationServiceImpl extends ServiceImpl<UmsRoleResourceRelationMapper, UmsRoleResourceRelation> implements UmsRoleResourceRelationService {
    @Autowired
    private UmsAdminRoleRelationService adminRoleRelationService;
    @Autowired
    private RedisService redisService;
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.key.admin}")
    private String REDIS_KEY_ADMIN;
    @Value("${redis.key.resourceList}")
    private String REDIS_KEY_RESOURCE_LIST;
    @Override
    public void delResourceListByRole(Long roleId) {
        // 创建LambdaQueryWrapper对象
        LambdaQueryWrapper<UmsAdminRoleRelation> queryWrapper = new LambdaQueryWrapper<>();

        // 设置查询条件，即roleId等于指定的值
        queryWrapper.eq(UmsAdminRoleRelation::getRoleId, roleId);
        List<UmsAdminRoleRelation> relationList = adminRoleRelationService.list(queryWrapper);

        if (CollUtil.isNotEmpty(relationList)) {
            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":";
            List<String> keys = relationList.stream().map(relation -> keyPrefix + relation.getAdminId()).collect(Collectors.toList());
            redisService.del(keys);
        }
    }
}
