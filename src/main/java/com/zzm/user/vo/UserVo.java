package com.zzm.user.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserVo implements Serializable {

    private Integer userId;
    private String userName;
    private Integer userAge;
}
