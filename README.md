# Spring-kafka
Realizaremos una api que conecte un consumer y un poduct y que atraves de un topic nos mande un String que sera mapeado en un Json con la clase Gson.
Primeramente y antes de empezar con el ejercicio, necesitamos tener instalado:
-Java Spring Boot
-Apache Kafka
-Zookeeper
Empezamos arrancando desde el terminal, Kafka y Zookeeper:
C:\kafka_2.12-0.10.2.1>.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
C:\kafka_2.12-0.10.2.1>.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
Tambien creamos como variables de entorno lo siguiente:
export TOPICNAME="mytopic_1"
export TOPICNAME2="mytopic_2"
EXPORT GROUPID="profe_group"
Cada uno en un terminal diferente
Y en otro terminal empezamos a creamos el topic:
bin/windows/kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic mytopic_1
Para luego visualizar que hemos creado correctamente los topics, usamos esta sentencia:
bin/windows/kafka-topics.bat --list --zookeeper localhost:2181
Y ya solo nos quedaria tener la API en funcionamiento y realizar en un terminal, la siguiente sentencia:
curl --request POST localhost:8080/add/mytopic_1

Por otro lado, dentro de la API estan
1. Property:
message.topic.name=profesorp
message.topic.name2=profesorp-group
message.group.name=profegroup
spring.kafka.consumer.group-id=myGroup

Si tuviéramos varios servidores Kakfa como suele ser el caso en producción, los indicaríamos separándolos por comas. (server1:9092,server2:9092, server3:9093 …)
Con el parámetro spring.kafka.consumer.group-id podemos definir el grupo al que por defecto pertenecerán los listeners pero esto es configurable en cada uno de ellos y no es necesario.Los demás parámetros los usaremos más adelante y son solo para poder realizar pruebas.

2. Clase Entidad:
package com.pratica.springboot.app.models;

import java.util.Date;


public class Entidad{
	
	@Override
	public String toString() {
		return "Entidad [ccenint=" + ccenint + ", cdcanalp=" + cdcanalp + ", cdcarter=" + cdcarter + ", cdestref="
				+ cdestref + ", corona=" + corona + ", dgorefen=" + dgorefen + ", eempint=" + eempint + "]";
	}

	private String ccenint;

	private String cdcanalp;

	private String cdcarter;

	private String cdestref;

	private Corona corona;

	private Dgorefen dgorefen;

	private int eempint;

	public String getCcenint() {
		return ccenint;
	}

	public void setCcenint(String ccenint) {
		this.ccenint = ccenint;
	}

	public String getCdcanalp() {
		return cdcanalp;
	}

	public void setCdcanalp(String cdcanalp) {
		this.cdcanalp = cdcanalp;
	}

	public String getCdcarter() {
		return cdcarter;
	}

	public void setCdcarter(String cdcarter) {
		this.cdcarter = cdcarter;
	}

	public String getCdestref() {
		return cdestref;
	}

	public void setCdestref(String cdestref) {
		this.cdestref = cdestref;
	}

	



	public int getEempint() {
		return eempint;
	}

	public void setEempint(int eempint) {
		this.eempint = eempint;
	}

	public Corona getCorona() {
		return corona;
	}

	public void setCorona(Corona corona) {
		this.corona = corona;
	}

	public Dgorefen getDgorefen() {
		return dgorefen;
	}

	public void setDgorefen(Dgorefen dgorefen) {
		this.dgorefen = dgorefen;
	}

	public class Corona{
		
		@Override
		public String toString() {
			return "Corona [codser=" + codser + ", fecha=" + fecha + ", nueref=" + nueref + ", surefe=" + surefe + "]";
		}

		private String codser;
		
		private Date fecha;
		
		private int nueref;
		
		private String surefe;

		public String getCodser() {
			return codser;
		}

		public void setCodser(String codser) {
			this.codser = codser;
		}

		public Date getFecha() {
			return fecha;
		}

		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}

		public int getNueref() {
			return nueref;
		}

		public void setNueref(int nueref) {
			this.nueref = nueref;
		}

		public String getSurefe() {
			return surefe;
		}

		public void setSurefe(String surefe) {
			this.surefe = surefe;
		}

		
		
		
	}
	
	public class Dgorefen{
		
		@Override
		public String toString() {
			return "Dgorefen [catrpbat=" + catrpbat + ", cdtrpbat=" + cdtrpbat + ", fecha2=" + fecha2 + ", idcentdg="
					+ idcentdg + ", idemprdg=" + idemprdg + ", numdgodg=" + numdgodg + ", termbtdg=" + termbtdg + "]";
		}

		private String catrpbat;
		
		private String cdtrpbat;
		
		private Date fecha2;
		
		private String idcentdg;
		
		private String idemprdg;
		
		private int numdgodg;
		
		private String termbtdg;

		public String getCatrpbat() {
			return catrpbat;
		}

		public void setCatrpbat(String catrpbat) {
			this.catrpbat = catrpbat;
		}

		public String getCdtrpbat() {
			return cdtrpbat;
		}

		public void setCdtrpbat(String cdtrpbat) {
			this.cdtrpbat = cdtrpbat;
		}

		public Date getFecha2() {
			return fecha2;
		}

		public void setFecha2(Date fecha2) {
			this.fecha2 = fecha2;
		}

		public String getIdcentdg() {
			return idcentdg;
		}

		public void setIdcentdg(String idcentdg) {
			this.idcentdg = idcentdg;
		}

		public String getIdemprdg() {
			return idemprdg;
		}

		public void setIdemprdg(String idemprdg) {
			this.idemprdg = idemprdg;
		}

		public int getNumdgodg() {
			return numdgodg;
		}

		public void setNumdgodg(int numdgodg) {
			this.numdgodg = numdgodg;
		}

		public String getTermbtdg() {
			return termbtdg;
		}

		public void setTermbtdg(String termbtdg) {
			this.termbtdg = termbtdg;
		}

		


		
	}


}

Que nos servira para el Json que mandaremos como mensaje

3.KafkaTestController

package com.pratica.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pratica.springboot.app.producer.KafkaMessageProducer;

@RestController
public class KafkaTestController {
	
	@Autowired
	KafkaMessageProducer kafkaMessageProducer;
	
	@PostMapping("/add/{topic}")
	public void addIdCustomer( @PathVariable String topic,@RequestBody  String body)
	{
		kafkaMessageProducer.sendMessage(topic);
	}

}
Que como su nombre indica realizara las operaciones Rest para poder realizar nuestro post

4.KafkaTestListener
package com.pratica.springboot.app.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaTestListener {

	
	
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

En la función listenTopic1 con la etiqueta @KafkaListener, definiremos el topics , en plural pues pueden ser varios, que queremos escuchar. En este caso escucharemos los definidos en la variable message.topic.name del fichero properties de Spring Boot. Si esa variable no estuviera definida, tendrá el valor profesorp. Además especificamos el grupo al que pertenece el listener.Recordar si no lo definimos cogerá el que hayamos configurado con el parametro spring.kafka.consumer.group-id

5.KafkaMessageProducer

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
Y en esta ultima parte procederemos a construir el envio del String como Json
