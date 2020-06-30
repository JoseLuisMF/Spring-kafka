package com.pratica.springboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.Gson;
import com.pratica.springboot.app.models.Entidad;
import com.pratica.springboot.app.models.Entidad.Corona;
import com.pratica.springboot.app.models.Entidad.Dgorefen;

@SpringBootApplication
public class SpringKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaApplication.class, args);
		
		/*String json = "{\r\n" + 
				"  \"ccenint\": \"aaaa\",\r\n" + 
				"  \"cdcanalp\": \"OFI\",\r\n" + 
				"  \"cdcarter\": \"bbbb\",\r\n" + 
				"  \"cdestref\": \"cccc\",\r\n" + 
				"  \"corona\": {\r\n" + 
				"    \"codser\": \"dddd\",\r\n" + 
				"    \"feccor\": 2020-06-15,\r\n" + 
				"    \"nueref\": 1234,\r\n" + 
				"    \"surefe\": \"\"\r\n" + 
				"  },\r\n" + 
				"  \"dgorefen\": {\r\n" + 
				"    \"catrpbat\": \"mmmm\",\r\n" + 
				"    \"cdtrpbat\": \"nnnnnn\",\r\n" + 
				"    \"fedgoref\": \"2020-06-15\",\r\n" + 
				"    \"idcentdg\": \"dsfs45\",\r\n" + 
				"    \"idemprdg\": \"ttgg\",\r\n" + 
				"    \"numdgodg\": 5456,\r\n" + 
				"    \"termbtdg\": \"adfd\"\r\n" + 
				"  },\r\n" + 
				"  \"eempint\": \"123\"\r\n" + 
				"}";

		Gson gson = new Gson();
		Entidad doble = gson.fromJson(json, Entidad.class);
		Corona coronas = doble.getCorona();
		Dgorefen dgorefens= doble.getDgorefen();
		
		System.out.println(doble);*/
	}

}
