package com.github.wz2cool.mdqvsother.jpa.dao;

import com.github.wz2cool.mdqvsother.jpa.model.entity.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<UserDO, Long> {
}
