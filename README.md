# Course: *Network Programming*
------
# Topic: *Sockets API Client Server App*
### Author: *Drumea Vasile*
------
## Objectives :
1. Get familiar with Sockets API of the chosen language;

2. Develop a transfer protocol of data(messages), using the TCP;

## Protocol description : 

1. Service - The service provided by the server part is to implement some basic commands which return text responses, also to store the messages sent by the user;

2. Transport/Execution path - We have the client which formulates the request and it is sent by the TCP to the server, next the server creates a thread which processes the request and returns the response;

3. Vocabulary(the Commands) :
  * help - available commands;
  * about - display some text about the system;
  * threads - display number of active threads;
  * time - display the current time on server;
  * add String - adds a message in the list;
  * rem String - removes a message from the list;
  * print-msg - prints all the messages;

4. Request format - <Command> [Message];
  
## Structure overview :



## Screenshot

![](img/)

