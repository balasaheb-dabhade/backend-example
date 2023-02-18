package com.veta.tutorials.kafkaexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import com.veta.tutorials.kafkaexample.annotations.LogExecutionTime;
import com.veta.tutorials.kafkaexample.dao.IRiderDAO;
import com.veta.tutorials.kafkaexample.model.Rider;

@SpringBootApplication
public class KafkaexampleApplication {

	@Autowired  
	IRiderDAO riderDAOImpl;


	public static void main(String[] args) {
		SpringApplication.run(KafkaexampleApplication.class, args);
	}

	@LogExecutionTime
	@KafkaListener(topics = "quickstart-events", groupId = "location-consumers")
	public void listen(String message) {
		System.out.println("Received Rider Info in group - location-consumers: " + message);
		String[] data = message.split("\\s+");
		System.out.println(data[0]+"="+data[1]);
		Rider rider = new Rider(data[0],data[1]);
		riderDAOImpl.saveRider(rider);
	}

}
