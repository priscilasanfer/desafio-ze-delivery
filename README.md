# Desafio Zé Delivery



TODO
separar DTO response do DTO Request



Docker  
$ docker run -it --name mysql -e MYSQL_ROOT_PASSWORD=mysql -p 3307:3306 -d mysql  
$ docker exec -it mysql bash  
$ mysql -u root -p

docker stop "container id"   
docker start "container id"  



http://localhost:8080/pdvs?trandingName=Adega  
http://localhost:8080/pdvs  
http://localhost:8080/pdvs/1


  SELECT ST_AsBinary(address) FROM pdv;     
  
  
  
{
    "tradingName": "Adega da Cerveja - Pinheiros",
    "ownerName": "Zé da Silva",
    "document": "1432132123891/0001", //CNPJ
    "coverageArea": { 
      "type": "MultiPolygon", 
      "coordinates": [
        [[[30, 20], [45, 40], [10, 40], [30, 20]]], 
        [[[15, 5], [40, 10], [10, 20], [5, 10], [15, 5]]]
      ]
    }, 
    "address": { 
      "type": "Point",
      "coordinates": [-46.57421, -21.785741]
    }
}



+---------------+--------------+------+-----+---------+----------------+
| Field         | Type         | Null | Key | Default | Extra          |
+---------------+--------------+------+-----+---------+----------------+
| id            | bigint       | NO   | PRI | NULL    | auto_increment |
| address       | point        | NO   |     | NULL    |                |
| coverage_area | multipolygon | YES  |     | NULL    |                |
| document      | varchar(30)  | NO   |     | NULL    |                |
| owner_name    | varchar(30)  | NO   |     | NULL    |                |
| trading_name  | varchar(30)  | NO   |     | NULL    |                |
+---------------+--------------+------+-----+---------+----------------+

+---------------+--------------+------+-----+---------+----------------+
| Field         | Type         | Null | Key | Default | Extra          |
+---------------+--------------+------+-----+---------+----------------+
| id            | bigint       | NO   | PRI | NULL    | auto_increment |
| trading_name  | varchar(30)  | NO   |     |         |                |
| owner_name    | varchar(30)  | NO   |     |         |                |
| document      | varchar(30)  | NO   |     |         |                |
| coverage_area | multipolygon | YES  |     | NULL    |                |
| address       | point        | YES  |     | NULL    |                |
+---------------+--------------+------+-----+---------+----------------+




