# Apache Kafka Consumer - Producer.

Kafka Consumer - Producer based on Spring Kafka.

##### The Hard Mode.

[Download](https://kafka.apache.org/downloads) Kafka binaries

[Download](https://zookeeper.apache.org/releases.html) ZooKepeer binaries

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

##### The easy mode.

You also can run Kafka and Zookeeper Server with Docker.

```shell
docker run \
    -d --name ${container.name} \
    -p 9092:9092 \
    -e KAFKA_ZOOKEEPER_CONNECT=zookeeper-server:2181 \
    -e ALLOW_PLAINTEXT_LISTENER=yes \
    --link zookeeper-server:zookeeper-server \
    bitnami/kafka:latest
```

Enter to docker container.

```shell
docker exec -ti ${container.name} bash
```

##### Consumer

```shell
export KAFKA_OPTS="-Djava.security.auth.login.config=/opt/bitnami/kafka/conf/kafka_jaas.conf"

kafka-console-consumer.sh \
    --bootstrap-server 127.0.0.1:9092 \
    --topic ${topic.name} \
    --consumer.config /opt/bitnami/kafka/conf/consumer.properties
```

