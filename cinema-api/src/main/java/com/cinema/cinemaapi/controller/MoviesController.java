package com.cinema.cinemaapi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cinema.cinemaapi.service.MoviesService;
import com.cinema.cinemacommon.api.CommonResult;
import com.cinema.cinemambp.model.Movies;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags="MoviesController")
@Tag(name = "MoviesController",description = "电影管理")
@RequestMapping("/movie")
public class MoviesController {
    @Autowired
    private MoviesService moviesService;

    @ApiOperation("创建新电影")
    @PostMapping("/create")
    public CommonResult<String> createMovie(@RequestBody@ApiParam("电影") Movies movies){
        moviesService.save(movies);
        return CommonResult.success("创建电影成功");
    }

    @ApiOperation("通过id获取电影")
    @GetMapping("/getMovie/{id}")
    public CommonResult<Movies> getMovie(@PathVariable("id") @ApiParam("id")Integer id){
        Movies movie = moviesService.getById(id);
        return CommonResult.success(movie);
    }

    @ApiOperation("更新电影以及id")
    @PostMapping("/update/{id}")
    public CommonResult<String> updateMovie(@PathVariable("id") @ApiParam("id")Integer id,
                                 @RequestBody @ApiParam("电影") Movies movie){
        if(movie.getId()==null){
            movie.setId(id);
        }
        moviesService.updateById(movie);
        return CommonResult.success("更新电影成功");
    }

    @ApiOperation("分页获取电影")
    @GetMapping("/fetchMovieList")
    public CommonResult<Page> fetchMovieList(@RequestParam(value = "pageNum", defaultValue = "1") @ApiParam("页码") Integer pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "5")@ApiParam("每页数量") Integer pageSize){
        Page<Movies> pageInfo = new Page<>(pageNum, pageSize);
        moviesService.page(pageInfo);
        return CommonResult.success(pageInfo);
    }

    @ApiOperation("通过id删除电影")
    @PostMapping("/delete/{id}")
    public CommonResult<String> deleteMovie(@PathVariable("id")@ApiParam("id") Integer id){
        moviesService.removeById(id);
        return CommonResult.success("删除电影成功");
    }
}