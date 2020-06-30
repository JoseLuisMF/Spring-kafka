package com.pratica.springboot.app.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.google.gson.Gson;
import com.pratica.springboot.app.models.Entidad;
import com.pratica.springboot.app.models.Entidad.Corona;
import com.pratica.springboot.app.models.Entidad.Dgorefen;

@Component
public class KafkaMessageProducer {

	// Lo primero será pedir a Spring que nos inyecte un objeto tipo KafkaTemplate
	
	// En la función sendMessage sobre el topic mandado mandaremos el mensaje
	// deseado
	
	// Para ello crearemos un ListenableFuture a partir de kafkaTemplate. De esta
	// manera la llamada al servidor de Kafka será asíncrona. Para hacerla
	// simplemente usaremos la función addCallback de la clase ListenableFuture,
	// pasándole el interface ListenableFutureCallback.

	//La función onSuccess será ejecutada si todo va bien y la función onFailure en caso de error.
	
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Value(value = "${message.topic.name:profesorp}")
	private String topicName;

	public void sendMessage(String topic) {
		
		//Enviando informacion
		String message = "{\r\n" + 
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
		Entidad doble = gson.fromJson(message, Entidad.class);
		Corona coronas = doble.getCorona();
		Dgorefen dgorefens= doble.getDgorefen();
		
		//Enviando informacion
		
		if (topic == null || topic.trim().equals(""))
			topic = topicName;
		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);
		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
			@Override
			public void onSuccess(SendResult<String, String> result) {
				System.out.println("Envia mensaje=[" + message + "] con compensacion=["
						+ result.getRecordMetadata().offset() + "]");
			}

			@Override
			public void onFailure(Throwable ex) {
				System.err.println("No se puede enviar el mensaje=[" + message + "] debido a : " + ex.getMessage());
			}
		});
	}

}
