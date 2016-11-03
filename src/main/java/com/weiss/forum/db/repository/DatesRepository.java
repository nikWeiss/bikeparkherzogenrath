/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weiss.forum.db.repository;

import com.weiss.forum.logic.DatesContent;
import java.math.BigInteger;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Niklas
 */
public interface DatesRepository extends MongoRepository<DatesContent, BigInteger> {

}
