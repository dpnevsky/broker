package com.pnevsky.broker.service;

import com.pnevsky.broker.service.dto.CreateProductDTO;
import com.pnevsky.broker.service.event.ProductCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;


@Service
public class ProductServiceImpl implements ProductService{

    private final KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    public ProductServiceImpl(KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public String createProduct(CreateProductDTO createProductDTO) {
        // TODO save in DB
        String productId = UUID.randomUUID().toString();

        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent(productId, createProductDTO.getQuantity(),
                createProductDTO.getPrice(), createProductDTO.getTitle());

        CompletableFuture<SendResult<String, ProductCreatedEvent>> future =
                kafkaTemplate.send("product-created-events-topic", productId, productCreatedEvent);

        future.whenComplete((result, exception) -> {
           if(exception != null){
               LOGGER.error("Failed to send message: {}", exception.getMessage());
           } else {
               LOGGER.info("Message send successfully: {}", result.getRecordMetadata());
           }
        });

        future.join();

        LOGGER.info("Return: {}", productId);

        return productId;
    }
}
