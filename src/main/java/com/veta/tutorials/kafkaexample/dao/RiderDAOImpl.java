package com.veta.tutorials.kafkaexample.dao;

import org.springframework.stereotype.Repository;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;
import com.veta.tutorials.kafkaexample.model.Rider;

@Repository
public class RiderDAOImpl implements IRiderDAO {
	
    private final String hashReference= "Rider";

    @Autowired         
    private HashOperations<String, String, Rider> hashOperations;

	@Override
	public void saveRider(Rider rider) {
		hashOperations.put(hashReference, rider.getId(), rider);
	}

	@Override
	public Rider getRider(String id) {
		return hashOperations.get(hashReference, id);
	}

}
