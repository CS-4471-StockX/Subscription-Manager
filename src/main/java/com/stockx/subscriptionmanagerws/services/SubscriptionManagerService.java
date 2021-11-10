package com.stockx.subscriptionmanagerws.services;

import com.stockx.subscriptionmanagerws.entity.Topic;
import com.stockx.subscriptionmanagerws.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionManagerService {

    @Autowired
    private TopicRepository topicRepository;

    public void subscribeToTopic(String symbol, String service) {
        Topic topic = topicRepository.getTopicBySymbol(symbol);
        if (topic != null) {
            topic.setNumOfSubscribers(topic.getNumOfSubscribers() + 1);
        } else {
            topic = new Topic(symbol, service, 1);
        }
        topicRepository.save(topic);
    }

    public void unsubscribeFromTopic(String symbol) {
        Topic topic = topicRepository.getTopicBySymbol(symbol);
        if (topic != null) {
            if (topic.getNumOfSubscribers() > 1) {
                topic.setNumOfSubscribers(topic.getNumOfSubscribers() - 1);
                topicRepository.save(topic);
            } else {
                topicRepository.deleteTopic(topic);
            }
        }
    }

}
