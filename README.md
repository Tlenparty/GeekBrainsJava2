# Java Core Exercises

A set of small console programs in Java Core and a client-server network chat
with a JavaFX GUI.

## Contents

| Directory / package | What it does |
|---------------------|--------------|
| `src/obstacles` | OOP and interfaces: a cat, a human and a robot run an obstacle course (wall, treadmill) |
| `src/exceptions` | Custom exceptions `MyArraySizeException` / `MyArrayDataException` when summing a 4×4 array of strings |
| `src/collections` | Collections: unique words and their frequencies; a phone book with several numbers per surname |
| `src/threads` | Comparing processing of a large array in a single thread vs. two threads with splitting and merging |
| `src/echo` | A one-client, one-server console chat over sockets, with two-way messaging in separate threads |
| `chat/ChatServer` | Multi-user chat server: login/password authentication, broadcast to all, private messages (`/w`), list of online users |
| `chat/ChatClient` | JavaFX chat client: login window, common chat, recipient selection for private messages, disconnect on timeout if login is not completed within 120 seconds |
| `chat-ui-prototype` | JavaFX (FXML) chat window prototype |

Test users on the server: `user1 / 1111`, `user2 / 2222`, `user3 / 3333`.

## Tech stack

| Area | Technologies |
|------|--------------|
| Language | Java 11+ |
| Networking | `java.net.Socket`, `DataInputStream` / `DataOutputStream` |
| UI | JavaFX (FXML) |

## Build and run

The console programs and the server are built with `javac` and have no dependencies:

```bash
javac -encoding UTF-8 -d out $(find src -name '*.java')
java -cp out collections.Main

javac -encoding UTF-8 -d out-server $(find chat/ChatServer -name '*.java')
java -cp out-server ServerApp 8189
```

The client (`chat/ChatClient`) requires the JavaFX SDK. The easiest way is to open it in IntelliJ IDEA
with the JavaFX library attached and run `client.NetworkClient`.
