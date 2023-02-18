package com.veta.tutorials.kafkaexample.dao;

import com.veta.tutorials.kafkaexample.model.Rider;

public interface IRiderDAO {
	void saveRider(Rider emp);
    Rider getRider(String id);
}
