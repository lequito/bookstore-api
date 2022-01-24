package com.alexbookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.alexbookstore.services.DBServices;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBServices dbServices;
	
	@Bean
	public void instacia() {
		this.dbServices.instanciaDb();
	}

}
