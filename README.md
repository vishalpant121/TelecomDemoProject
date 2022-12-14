# TeleComDemo 

This is a microservices based demo project that will have the following \
microservices communicating with each other using REST API.

Service #   Port 
1. Processor Service <-> Rules DB (MongoDB) # 8082 
2. Subscriber Service<-> Subscriber DB (MySQL)  # 8080

Swagger UI for each service
For now Enterprise can access Subscriber Service using swagger.

For now Customer can access Processor Service using swagger.

Enterprise can:
- Create Subscriber
- Delete Subscriber
- Update Subscriber
- Get/Read Subscriber
- Get all Subscribers

Customer can:
- Get/Read their data and duration by providing uid.
- Create/Add more data i.e. recharge (For now directly using gateway. Can be enhanced by creating and integrating payment service.
- "Do" Something, like music, video, blog. Each action to consume data.

Subscriber in Subscriber DB:
Name
Uid
Data
Duration
Data usage : Limited time or data;  unlimited time and data

Rule in Mongo DB:
If video : spend data at 2x and provide buffer of audio and video
If audio: spend data at x and provide buffer of audio
If text/blog: Do not spend data and no buffer

Call flow:
Customer asks to consume data, asks processor service to process data usage request. 
Processor gets details of the subscriber. (if unlimited time and data, allow, else inform)
Data, is available, is allotted.
Customer is consuming data.

Customer asks to consume data again, asks processor service to process data usage request.
Processor gets details of the subscriber. (if unlimited time and data, allow, else inform)
Data is not available, not allotted.
Customer can't consume data. Needs to recharge.




