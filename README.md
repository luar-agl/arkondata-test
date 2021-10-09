## Micronaut 3.0.2 Documentation

- [User Guide](https://docs.micronaut.io/3.0.2/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.0.2/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.0.2/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

## Instructions for deploy:


1.-  mvn install  

2.- docker build -t arkon-data-test .

3.- docker compose up 

App is deployed in: http://localhost:9002/

## Endpoints: 

1.  Units available 

	- Type : GET 
	- endpoint: http://localhost:9002/vehicle/available

2.  Town halls available 
	
	- Type: GET
	- endpoint: http://localhost:9002/townHall/available

3.  Get the units that have been in the town hall.  
 	
	- Type: GET
	- endpoint: http://localhost:9002/vehicle/findByTownHall/{townHallId}

4. Locations of unit given a vehicle id 
	
	- Type: GET
	- endpoint: http://localhost:9002/vehicle/locations/{vehicleId}
