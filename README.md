# TeleComDemo 

This is a microservices based demo project that will have the following \
microservices communicating with each other using REST API.

1. Router
2. Processor
3. Traffic   <-> Traffic DB keeping traffic and count (MySQL)
4. Add Rules <-> Policy DB (Postgresql)
5. Logs: To collect traffic logs and store in MySQL (3?) 
6. Subscriber Details <-> Subscriber DB (NoSQL) 
7. Bridge : User will send message to router via bridge


UI will be simple Web that takes above data and fill up on screen.


