#kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic hello-producer-demo --from-beginning
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic hello-producer-demo -group first_app --from-beginning
