package com.weiss.forum.logic;

import java.math.BigInteger;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Niklas
 */
public class DatesContent {
    @Id
    private BigInteger id;

    public BigInteger getId() {
	return id;
    }

    public void setId(BigInteger id) {
	this.id = id;
    }

}
