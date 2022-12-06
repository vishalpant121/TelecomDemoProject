# TeleComDemo 

This is a microservices based demo project that will have the following \
microservices communicating with each other using REST API.

Service     Port
1. Load Balancer Service #8083
2. Processor Service <-> Rules DB (Postgresql) #8082
3. Traffic Service   <-> Traffic DB keeping traffic and count (MySQL) #8084
4. Subscriber Service<-> Subscriber DB (NoSQL)  #8081
5. Bridge/ API Gateway: User will send message to router via bridge #8085


UI will be simple Web that takes above data and fill up on screen.




