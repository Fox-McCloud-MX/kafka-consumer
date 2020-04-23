# Apache Kafka Consumer - Producer.

Kafka Consumer - Producer based on Spring Kafka.

[Download](https://kafka.apache.org/downloads) Kafka binaries
[Download](https://zookeeper.apache.org/releases.html) ZooKeper binaries

Run Zookeeper Server.

```shell
${zookeper.dir}/zookeeper-server-start.{bat|sh} ${zookeper.dir}/config/zookeeper.properties
```

Run Kafka Server.

```shell
${kafka.dir}/kafka-server-start.{bat|sh} ${kafka.dir}/config/server.properties
```

Create Kafka Topic.

```shell
${kafka.dir}/kafka-topics.{bat|sh} --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic ${topic.name}
```

Create Kafka Consumer.

```shell
${kafka.dir}/kafka-console-consumer.{bat|sh} --bootstrap-server localhost:9092 --topic ${topic.name} --from-beginning
```

