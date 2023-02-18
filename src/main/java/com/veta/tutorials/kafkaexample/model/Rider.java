package com.veta.tutorials.kafkaexample.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rider implements Serializable {
	private static final long serialVersionUID = -7817224776021728682L;
	String Id;
	String riderName;
}
