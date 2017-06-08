package com.zzm.user.controller;

import com.zzm.user.service.UserService;
import com.zzm.utils.ResultBuilder;
import com.zzm.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResultVo getUserById(@PathVariable Integer id) {
    String userName = userService.getUserById(id).getName();
    return ResultBuilder.buildSuccess().with("userName", userName);
  }

}