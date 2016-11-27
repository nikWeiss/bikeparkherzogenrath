package com.weiss.forum.db.repository;

import com.weiss.forum.logic.ProjectContent;
import java.math.BigInteger;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Niklas
 */
public interface ProjectRepository extends MongoRepository<ProjectContent, BigInteger> {

    public List<ProjectContent> findAllByOrderByIdDesc();

    public List<ProjectContent> findAllByOrderByIdAsc();

    public ProjectContent findFirstByOrderByIdDesc();
}
