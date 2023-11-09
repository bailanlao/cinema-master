package com.cinema.cinemaapi.dto;/**
 * @Description
 * @Author
 * @Date 2023/10/30
 */

import com.cinema.cinemambp.model.UmsMenu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @FileName UmsMenuNode
 * @Description
 * @Author ht
 * @date 2023-10-30
 **/
@Getter
@Setter
public class UmsMenuNode extends UmsMenu {
    @ApiModelProperty(value = "子级菜单")
    private List<UmsMenuNode> children;
}
