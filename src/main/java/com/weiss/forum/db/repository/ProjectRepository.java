package com.weiss.forum.db.repository;

import com.weiss.forum.logic.ProjectContent;
import java.math.BigInteger;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Niklas
 */
public interface ProjectRepository extends MongoRepository<ProjectContent, BigInteger> {

}
