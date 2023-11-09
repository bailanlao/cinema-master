package com.cinema.cinemambp.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;


@Data
public class Cinemas {
    @ApiModelProperty(value = "主键ID")
    private Integer id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "细节")
    private String detail;
    @ApiModelProperty(value = "建立时间")
    private Date startDate;
    @ApiModelProperty(value = "经纬度")
    private String latitude;
    @ApiModelProperty(value = "所在省市县")
    private String selectedOptions;
    @ApiModelProperty(value = "精准地址")
    private String state;
    @ApiModelProperty(value = "开店状态")
    private Boolean isOpen;
}
