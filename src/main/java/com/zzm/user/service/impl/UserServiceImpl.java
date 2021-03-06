package com.zzm.user.service.impl;

import com.zzm.user.dao.UserDao;
import com.zzm.user.service.UserService;
import com.zzm.user.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserVo getUserById(Integer id) {
        if (id == null || id.intValue() <= 0) {
            throw new IllegalArgumentException("userId is invalid");
        }
        return userDao.getUserById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
    public Integer add(UserVo userVo) {
        if (StringUtils.isBlank(userVo.getName())) {
            throw new IllegalArgumentException("userName is invalid");
        }
        if (userVo.getAge() == null || userVo.getAge() <= 0) {
            throw new IllegalArgumentException("userAge is invalid");
        }
        userDao.add(userVo);
        return userVo.getId();
    }

}
