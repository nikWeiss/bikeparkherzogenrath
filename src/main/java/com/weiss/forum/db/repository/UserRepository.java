package com.weiss.forum.db.repository;

import com.weiss.forum.security.MyUser;
import java.math.BigInteger;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Niklas
 */
public interface UserRepository extends MongoRepository<MyUser, BigInteger> {

    public MyUser findByUsername(String username);
}
