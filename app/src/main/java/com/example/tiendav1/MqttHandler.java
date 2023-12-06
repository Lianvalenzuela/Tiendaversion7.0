package com.example.tiendav1;
import android.content.Context;
import android.widget.Toast;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttHandler{
    private MqttClient client;

    public void connect(String brokerUrl, String clientId , Context context)  {
        try {
            // persistencia de datos
            MemoryPersistence persistence = new MemoryPersistence();
            MqttConnectOptions connectOptions = new MqttConnectOptions();
            connectOptions.setUserName("androidteststiqq");
            connectOptions.setPassword("W0U2XNxCKinXaOBv".toCharArray());
            // Iniciar cliente MQTT
            client = new MqttClient(brokerUrl, clientId, persistence);
            connectOptions.setCleanSession(true);
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    // Manejar pérdida de conexión
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    // Este método se llama cuando se recibe un mensaje en el tema suscrito
                    String messageText = new String(message.getPayload());
                    // Muestra el mensaje con un Toast
                    Toast.makeText(context, messageText, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    // Este método se llama cuando se ha entregado un mensaje (por ejemplo, después de publicar un mensaje)
                }
            });
            // Conectar al broker
            client.connect(connectOptions);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void publish(String topic, String message) {
        try {
            MqttMessage mqttMessage = new MqttMessage(message.getBytes());
            client.publish(topic, mqttMessage);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void subscribe(String topic) {
        try {
            client.subscribe(topic);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

}


