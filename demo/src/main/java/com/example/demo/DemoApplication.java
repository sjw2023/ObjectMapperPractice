package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Slf4j
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		ObjectMapper objectMapper = new ObjectMapper();

		Person person = new Person("홍길동", "남", "010-123-1234");
		try{
			objectMapper.writeValue(new File("./person.json"), person);
		}
		catch ( IOException e){
			e.printStackTrace();
		}

		String JSONstring = "{\"name\":\"복순이\",\"sex\":\"여\",\"phone\":\"010-12345-1231\"}";
		try {
			Person deserialization = objectMapper.readValue(JSONstring, Person.class);
			log.info("JSON deserialization : {}", deserialization.toString());
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}


}
