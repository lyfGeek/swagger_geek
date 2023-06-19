package com.geek.swagger_geek.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 只要接口中存在实体类，就会被扫描到 Swagger 中。
 * // @Api(注释)
 * // @Models
 *
 * @author geek
 */
@ApiModel("用户实体类")
public class User {

    @ApiModelProperty("用户名")
    public String username;
    @ApiModelProperty("密码")
    public String password;

}
