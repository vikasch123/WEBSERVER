# Single-Threaded Web Server

This repository contains a simple single-threaded web server and client implementation in Java. The server listens for incoming client connections, exchanges messages, and closes the connection once the interaction is complete. This basic implementation demonstrates the use of Java's `Socket` and `ServerSocket` classes for networking.

## Features
- Simple server-client communication using sockets.
- Server listens on a specified port and accepts one connection at a time.
- Timeout feature to automatically close the server socket after 10 seconds of inactivity.
- Bidirectional message exchange between the client and server.

## Prerequisites
- Java Development Kit (JDK) installed (version 8 or higher).
- Basic understanding of Java and socket programming.

## How to Run

### Clone the Repository
```bash
git clone <repository_url>
cd single-threaded-web-server
```

### Compile the Code
Use the `javac` command to compile both the server and client classes:
```bash
javac Server.java
javac Client.java
```

### Run the Server
Start the server by running:
```bash
java Server
```
The server will listen for incoming connections on port `8020`.

### Run the Client
In a new terminal, run the client:
```bash
java Client
```
The client will connect to the server and exchange messages.

### Expected Output
#### Server:
```plaintext
server is listening on port 8020
connection accepted from /127.0.0.1:random_port
```

#### Client:
```plaintext
Hello from server
```

## Code Overview

### Server
- **Port**: The server listens on port `8020`.
- **Timeout**: The server socket is configured to close automatically after 10 seconds of inactivity (`socket.setSoTimeout(10000)`).
- **Message Exchange**:
  - Sends a "Hello from server" message to the client.
  - Closes the connection after completing the message exchange.

### Client
- Connects to the server on `localhost` at port `8020`.
- Sends a "Hello from client" message to the server.
- Reads and prints the server's response.





## Notes
1. This implementation is single-threaded, meaning the server can handle only one client connection at a time. For handling multiple clients, a multi-threaded server or asynchronous I/O is required.
2. The server will terminate any connection attempt made after 10 seconds of inactivity due to the socket timeout.

## Potential Improvements
- Add support for handling multiple clients using threads or an `ExecutorService`.
- Implement more advanced server functionalities like HTTP request handling.
- Add error handling for common networking issues, such as connection timeouts or unreachable hosts.

## License
This project is licensed under the [MIT License](LICENSE).

## Contributing
Feel free to fork this repository, make changes, and submit a pull request if you'd like to contribute!

---
Happy Coding! 😊

