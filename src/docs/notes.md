### TCP REVIEW

- Protocolos de rede sao dividodos into diferentes camadas, onde as camadas mais altas dependem de camadas mais baixas

- Cada pacote pacote de dados IP e composto por tres componentes:
  - O endereco de quem destinario
  - O endereco do destinario
  - Os dados da mensagem

- Esse tipo de comunicacao tem os seguintes problemas

What if the message data exceeds the capacity of a single packet?
What if the packet is lost?
Out-of-order packets?

To make things simple, the next layer is added on top of IP packets. TCP provides:

Byte streams instead of packets.
Reliable and ordered delivery.


## TCP Byte Stream vs. UDP Packet
The key difference: boundaries.

- UDP: Each read from a socket corresponds to a single write from the peer.
- TCP: No such correspondence! Data is a continuous flow of bytes.


TCP simply has no mechanism for preserving boundaries.

TCP send buffer: This is where data is stored before transmission. Multiple writes are indistinguishable from a single write.
Data is encapsulated as one or more IP packets, IP boundaries have no relationship to the original write boundaries.
TCP receive buffer: Data is available to applications as it arrives.
The No. 1 beginner trap in socket programming is “concatenating & splitting TCP packets” because there is no such thing as “TCP packets”. Protocols are required to interpret TCP data by imposing boundaries within the byte stream.


## Byte Stream vs. Packet: DNS as an Example
To help you understand the implications of the byte stream, let’s use the DNS protocol (domain name to IP address lookup) as an example.

DNS runs on UDP, the client sends a single request message and the server responds with a single response message. A DNS message is encapsulated in a UDP packet.


## TCP is Bidirectional & Full-Duplex
Once established, the TCP connection can be used as a bi-directional byte stream, with 2 channels for each direction. Many protocols are request-response like HTTP/1.1, where a peer is either sending a request/response or receiving a response/request. But TCP isn’t restricted to this mode of communication. Each peer can send and receive at the same time (e.g. WebSocket), this is called full-duplex communication.
