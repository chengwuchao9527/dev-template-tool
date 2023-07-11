package com.cheng.dao;

import com.cheng.domain.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author chengwuchao
 * @date 2023/7/6
 */
@Repository
public interface UserDAO extends JpaRepository<UserDO, Long> {
}
