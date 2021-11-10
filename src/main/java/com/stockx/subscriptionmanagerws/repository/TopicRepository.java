package com.stockx.subscriptionmanagerws.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.stockx.subscriptionmanagerws.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class TopicRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public void save(Topic topic) {
        dynamoDBMapper.save(topic);
    }

    public Topic getTopicBySymbol(String symbol) {
        return dynamoDBMapper.load(Topic.class, symbol);
    }

    public void deleteTopic(Topic topic) {
        dynamoDBMapper.delete(topic);
    }

}