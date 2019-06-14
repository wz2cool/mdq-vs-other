package com.github.wz2cool.mdqvsother.jpa.dao;

import com.github.wz2cool.mdqvsother.jpa.model.entity.UserDO;

import java.util.List;

public interface UserCustomRepository {
    List<UserDO> getCustomUserList();
}
