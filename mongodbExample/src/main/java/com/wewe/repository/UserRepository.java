package com.wewe.repository;

import com.wewe.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Author: fei2
 * Date:  18-9-12 上午11:30
 * Description:
 * Refer To:
 */
public interface UserRepository extends MongoRepository<User, Long> {

    User findByUsername(String username);

}
