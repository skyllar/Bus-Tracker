# Bus-Tracker
The project aims at simulating an “application platform” which involves tracking a bus movement from a remote app(android).

Description of Components:

1. Sensors: Sensors in bus will timely collect data and forward these to the gateway.

2. Gateway: Transmitters the received location data(bus) ato other gateways and ultimately to some filter server via communication channel.

3. Filter Server: They store, filter and forward information(bus location data) to android applications as per their requirement.

4. App Engine: It is the application Server to which clients (android) connect for bus tracking related information.

5. Registry: Sensors will collect different type of data based on their requirements. So, registry will map sensors (i.e. sensor id) to the data type. 

6. Repository: Repository will keep track of the sensors registered to the gateway. So, it will map sensor id to the gateway.

7. Security Registry: Security information will be maintained here. 
