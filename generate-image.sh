mvn clean install

docker rmi -f rpolnx/producer:latest
docker rmi -f rpolnx/consumer:latest

docker build -t rpolnx/producer:latest producer
docker build -t rpolnx/consumer:latest consumer

docker push rpolnx/producer &
docker push rpolnx/consumer
