package net.huayiyun.eureka_client.util;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Project : eurekademo1
 * @Package Name : net.huayiyun.eureka_client.util
 * @Description : TODO
 * @Author : zlj
 * @Creation Date : 2019年06月27日 15:02
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
@Configuration
public class RabbitMQUtil {


    /**
     Broker:它提供一种传输服务,它的角色就是维护一条从生产者到消费者的路线，保证数据能按照指定的方式进行传输,
     Exchange：消息交换机,它指定消息按什么规则,路由到哪个队列。
     Queue:消息的载体,每个消息都会被投到一个或多个队列。
     Binding:绑定，它的作用就是把exchange和queue按照路由规则绑定起来.
     Routing Key:路由关键字,exchange根据这个关键字进行消息投递。
     vhost:虚拟主机,一个broker里可以有多个vhost，用作不同用户的权限分离。
     Producer:消息生产者,就是投递消息的程序.
     Consumer:消息消费者,就是接受消息的程序.
     Channel:消息通道,在客户端的每个连接里,可建立多个channel.

     ---------------------
     作者：梦里梦不出梦里梦的梦
     来源：CSDN
     原文：https://blog.csdn.net/qq_38455201/article/details/80308771
     */

    @Bean
    public Queue helloQueue() {
        return new Queue("helloQueue");
    }

//    @Bean
//    public Queue userQueue() {
//        return new Queue("user");
//    }
//
//    //===============以下是验证topic Exchange的队列==========
//    @Bean
//    public Queue queueMessage() {
//        return new Queue("topic.message");
//    }
//
//    @Bean
//    public Queue queueMessages() {
//        return new Queue("topic.messages");
//    }
//    //===============以上是验证topic Exchange的队列==========
//
//
//    //===============以下是验证Fanout Exchange的队列==========
//    @Bean
//    public Queue AMessage() {
//        return new Queue("fanout.A");
//    }
//
//    @Bean
//    public Queue BMessage() {
//        return new Queue("fanout.B");
//    }
//
//    @Bean
//    public Queue CMessage() {
//        return new Queue("fanout.C");
//    }
//    //===============以上是验证Fanout Exchange的队列==========
//
//
//    @Bean
//    TopicExchange exchange() {
//        return new TopicExchange("exchange");
//    }
//    @Bean
//    FanoutExchange fanoutExchange() {
//        return new FanoutExchange("fanoutExchange");
//    }
//
//    /**
//     * 将队列topic.message与exchange绑定，binding_key为topic.message,就是完全匹配
//     * @param queueMessage
//     * @param exchange
//     * @return
//     */
//    @Bean
//    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
//        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
//    }
//
//    /**
//     * 将队列topic.messages与exchange绑定，binding_key为topic.#,模糊匹配
//     * @param queueMessages,exchange
//     * @param exchange
//     * @return
//     */
//    @Bean
//    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
//        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
//    }
//
//    @Bean
//    Binding bindingExchangeA(Queue AMessage,FanoutExchange fanoutExchange) {
//        return BindingBuilder.bind(AMessage).to(fanoutExchange);
//    }
//
//    @Bean
//    Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
//        return BindingBuilder.bind(BMessage).to(fanoutExchange);
//    }
//
//    @Bean
//    Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
//        return BindingBuilder.bind(CMessage).to(fanoutExchange);
//    }
}
