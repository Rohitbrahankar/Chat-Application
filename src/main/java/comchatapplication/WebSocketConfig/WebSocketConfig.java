package comchatapplication.WebSocketConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@EnableWebSocketMessageBroker
@Configuration

public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    //STOMP : Simple Text Oriented Messaging Protocol (it enable chilent to communicate with mess broker )


    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
            // set mess broker
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");


    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat")
                .setAllowedOrigins("http://localhost:8080")
                .withSockJS();

    }
}
