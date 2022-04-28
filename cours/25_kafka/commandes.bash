 
 #Start================================
#-- kafka location 
cd /usr/hdp/current/kafka-broker/bin
 
 #creation de topic
 ./kafka-topics.sh --create --topic test-sse --zookeeper localhost:2181 --partitions 2 --replication-factor 1

#-- création de consumer 
 ./kafka-console-consumer.sh --topic test-sse --bootstrap-server sandbox-hdp.hortonworks.com:6667 --from-beginning
 
 #creation de producer
 ./kafka-console-producer.sh --broker-list sandbox-hdp.hortonworks.com:6667 --topic test-sse
 
 ##--Describe topic
./kafka-topics.sh --describe --zookeeper localhost:2181

##--zookeeper Location
/usr/hdp/current/zookeeper-client/bin

##--zkClient
https://stackoverflow.com/questions/40146921/how-to-list-all-available-kafka-brokers-in-a-cluster
./zkCli.sh
	 ls /brokers/ids/1001  | topics
	 get /brokers/topics/test...

##--Start broker
 bin/kafka-server-start.sh config/server.properties
 
 ##--stop  broker
./kafka-server-stop.sh ../config/server-1.properties
 
 
 
 ##COMMANDE POUR STARTER LES BROKERS AVEC PATH
 ./kafka-server-start.sh /usr/hdp/current/kafka-broker/config/server-1.properties & ./kafka-server-start.sh /usr/hdp/current/kafka-broker/config/server.properties
 
 ###TP KAFKA 
 https://insatunisia.github.io/TP-BigData/tp3/
 
 ### version kafka
 cd /usr/hdp/current/kafka-broker/libs
ls kafka_*.jar