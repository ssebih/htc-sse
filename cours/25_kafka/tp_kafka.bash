==> 1 --Create topic 1 et 2
./kafka-topics.sh --create --topic sales_raw_2 --zookeeper localhost:2181 --partitions 1 --replication-factor 1


==> 2
./kafka-topics.sh --create --topic sales_vip_2 --zookeeper localhost:2181 --partitions 1 --replication-factor 1


==> 3 --run jar 1 
java -jar csv2KafkaLuncher-1.jar ./sales.csv sales_raw_2


==> 4 --run jar 2
java -jar kafka2KafkaSaleFilter-1.jar sales_raw_2 sales_vip_2 1.0  100

==> 5 : lunch consumer
./kafka-console-consumer.sh --topic sales_vip_2 --bootstrap-server sandbox-hdp.hortonworks.com:6667 --from-beginning
