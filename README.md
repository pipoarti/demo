# demo
Questions
- How would you improve the system?
Using a cache.
Using 2 different microservices for Phones and Orders.

- How would you avoid your order API to be overflow?
Microservices put a lot of pressure on the api, the solution can be scaling 
the microservices by running multiple instances of the application/microservice 
load balanced across servers.