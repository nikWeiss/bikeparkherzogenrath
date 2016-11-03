package com.weiss.forum.db.repository;

import com.weiss.forum.logic.CrewContent;
import java.math.BigInteger;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Niklas
 */
public interface CrewRepository extends MongoRepository<CrewContent, BigInteger> {

}
