package com.cinema.cinemaapi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cinema.cinemaapi.service.CinemasService;

import com.cinema.cinemacommon.api.CommonResult;
import com.cinema.cinemambp.model.Cinemas;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(tags="CinemasController")
@Tag(name = "CinemasController",description = "电影院管理")
@RequestMapping("/cinema")
public class CinemasController {
    @Autowired
    private CinemasService cinemasService;

    @ApiOperation("创建新电影院")
    @PostMapping("/create")
    public CommonResult<String> create(@RequestBody @ApiParam("电影院") Cinemas cinema ){
        cinemasService.save(cinema);
        return CommonResult.success("创建电影院成功");
    }

    @ApiOperation("通过id获取电影院")
    @GetMapping("/getCinema/{id}")
    public CommonResult<Cinemas> getCinema(@PathVariable("id") @ApiParam("id") Integer id){
        Cinemas cinema = cinemasService.getById(id);
        return CommonResult.success(cinema);
    }

    @ApiOperation("通过id更新电影院")
    @PostMapping("/update/{id}")
    public CommonResult<String> updateCinema(@PathVariable("id") @ApiParam("id") Integer id,@RequestBody @ApiParam("电影院") Cinemas cinemas){
        if(cinemas.getId()==null){
            cinemas.setId(id);
        }
        cinemasService.updateById(cinemas);
        return CommonResult.success("修改电影院信息成功");

    }

    @ApiOperation("分页获取电影院")
    @GetMapping("/fetchCinemaList")
    public CommonResult<Page> fetchCinemaList(@RequestParam(value = "pageNum", defaultValue = "1") @ApiParam("页码") Integer pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "5")@ApiParam("每页数量") Integer pageSize){
        Page<Cinemas> pageInfo = new Page<>(pageNum, pageSize);
        cinemasService.page(pageInfo);
        return CommonResult.success(pageInfo);
    }

    @ApiOperation("通过id删除电影院")
    @PostMapping("/delete/{id}")
    public CommonResult<String> deleteCinema(@PathVariable("id") @ApiParam("id")Integer id){
        cinemasService.removeById(id);
        return CommonResult.success("删除电影院成功");
    }
}

