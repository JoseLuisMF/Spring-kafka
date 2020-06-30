package com.pratica.springboot.app.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaTestListener {

	// En la función listenTopic1 con la etiqueta @KafkaListener, definiremos el
	// topics , en plural pues pueden ser varios, que queremos escuchar. En este
	// caso escucharemos los definidos en la variable message.topic.name del fichero
	// properties de Spring Boot. Si esa variable no estuviera definida, tendrá el
	// valor profesorp. Además especificamos el grupo al que pertenece el listener.
	// Recordar si no lo definimos cogerá el que hayamos configurado con el
	// parametro spring.kafka.consumer.group-id
	
	//En la función listenTopic2 recibiremos los mensajes del topic message.topic.name2.

	@KafkaListener(topics = "${message.topic.name:profesorp}", groupId = "${message.group.name:profegroup}")
	public void listenTopic1(String message) {
		System.out.println("Mensaje recibido del topic1 en el oyente: " + message);
	}

	@KafkaListener(topics = "${message.topic.name2:profesorp-group}", groupId = "${message.group.name:profegroup}")
	public void listenTopic2(String message) {
		System.out.println("Mensaje recibido del topic2 en el oyente " + message);
	}

}
