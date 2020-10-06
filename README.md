# Desafio Zé Delivery

Docker  
$ docker run -it --name mysql -e MYSQL_ROOT_PASSWORD=mysql -p 3307:3306 -d mysql  
$ docker exec -it mysql bash  
$ mysql -u root -p

docker stop "container id"   
docker start "container id"  



GET http://localhost:8080/pdvs?trandingName=Adega    
GET http://localhost:8080/pdvs   
POST http://localhost:8080/pdvs   
GET http://localhost:8080/pdvs/1 
PUT http://localhost:8080/pdvs/1  
GET http://localhost:8080/pdvs/partner?lgn=-3.7364947&lat=-38.736494   



TODO
- Swagger
- Dockerizar
- Tratar exceptions HttpMessageNotReadableException
