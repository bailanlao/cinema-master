package com.cinema.cinemambp.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Movies {
    @ApiModelProperty(value = "主键ID")
    private Integer id;
    @ApiModelProperty(value = "封面")
    private String pic;
    @ApiModelProperty(value = "电影名")
    private String movieName;
    @ApiModelProperty(value = "票价")
    private BigDecimal ticketPrice;
    @ApiModelProperty(value = "开始时间")
    private Date startTime;
    @ApiModelProperty(value = "结束时间")
    private Date endTime;
    @ApiModelProperty(value = "类型")
    private String movieType;
    @ApiModelProperty(value = "来源")
    private String source;
    @ApiModelProperty(value = "语言")
    private String language;
    @ApiModelProperty(value = "版本")
    private String version;
    @ApiModelProperty(value = "时长")
    private Integer duration;
    @ApiModelProperty(value = "细节")
    private String detail;
    @ApiModelProperty(value = "图片相关")
    private String albumPics;
}
