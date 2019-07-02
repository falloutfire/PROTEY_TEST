package com.protey.test.Repositories;

import com.protey.test.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;

public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    @Modifying
    @Query(value = "update User u set u.status='Away' where u.onlineTime <= :onlineTime and u.status = 'Online'")
    void updateStatus(@Param("onlineTime") Date onlineTime);
}
