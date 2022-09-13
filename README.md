# TeleComDemo 

This is a microservices based demo project that will have the following \
microservices communicating with each other using REST API.

1. Load Balancer Service
2. Processor Service <-> Rules DB (Postgresql)
3. Traffic Service   <-> Traffic DB keeping traffic and count (MySQL)
4. Subscriber Service<-> Subscriber DB (NoSQL) 
7. Bridge/ API Gateway : User will send message to router via bridge


UI will be simple Web that takes above data and fill up on screen.


