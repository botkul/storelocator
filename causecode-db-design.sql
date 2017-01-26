create database causecodedb;
use causecodedb;

create table zipcodes(zipcode INT NOT NULL, city varchar(50) NOT NULL, state varchar(50) NOT NULL, latitude float, longitude float,PRIMARY KEY (zipcode));
create table store(storeId INT NOT NULL AUTO_INCREMENT, storeName varchar(50), address varchar(100),zipcode INT,PRIMARY KEY (storeId));

ALTER TABLE `causecodedb`.`store` ADD CONSTRAINT `FK_store_zipcode` FOREIGN KEY `FK_store_zipcode` (`zipcode`) REFERENCES `zipcodes` (`zipcode`);

--Sample data populated for ZipCodes Tables
INSERT INTO zipcodes values (78701,'AUSTIN','Texas',30.26,-97.74);
INSERT INTO zipcodes values (75201,'DALLAS','Texas',32.79,-96.76);
INSERT INTO zipcodes values (75701,'TYLER','Texas',32.32,-95.3);
INSERT INTO zipcodes values (76101,'FORT WORTH','Texas',32.75,-97.33);
INSERT INTO zipcodes values (76901,'SAN ANGELO','Texas',31.44,-100.45);

INSERT INTO zipcodes values (77001,'HOUSTON','Texas',29.76,-95.38);
INSERT INTO zipcodes values (77550,'GALVESTON','Texas',29.3,-94.79);
INSERT INTO zipcodes values (78201,'SAN ANTONIO','Texas',29.45,-98.5);
INSERT INTO zipcodes values (78401,'CORPUS CHRISTI','Texas',27.8,-97.39);
INSERT INTO zipcodes values (78589,'SAN JUAN','Texas',26.19,-98.15);


--sample data for Store detail
INSERT INTO store(storeName,address,zipcode) values('Austin Store','Link road Austin', 78701);
INSERT INTO store(storeName,address,zipcode) values('Austio Store2','Main road Austin', 78701);
INSERT INTO store(storeName,address,zipcode) values('DLS Store','Main road DALLAS', 75201);
INSERT INTO store(storeName,address,zipcode) values('D-Store','Opp DLS store, main road DALLAS', 75201);
INSERT INTO store(storeName,address,zipcode) values('Market At the Crossing','2210 Three Lakes Pkwy', 75701);
INSERT INTO store(storeName,address,zipcode) values('Broadway Square','Broadway Square', 75701);
INSERT INTO store(storeName,address,zipcode) values('Mattress Firm Tyler','2119 E SE Loop 323', 75701);
INSERT INTO store(storeName,address,zipcode) values('Best Hat Store','2739 N Main St', 76101);
INSERT INTO store(storeName,address,zipcode) values('Sundance Square','420 Main St', 76101);
INSERT INTO store(storeName,address,zipcode) values('Bouquets Unique Florist','1961 W Beauregard Ave', 76901);

mysql> select * from zipcodes;
+---------+----------------+-------+----------+-----------+
| zipcode | city           | state | latitude | longitude |
+---------+----------------+-------+----------+-----------+
|   75201 | DALLAS         | Texas |    32.79 |    -96.76 |
|   75701 | TYLER          | Texas |    32.32 |     -95.3 |
|   76101 | FORT WORTH     | Texas |    32.75 |    -97.33 |
|   76901 | SAN ANGELO     | Texas |    31.44 |   -100.45 |
|   77001 | HOUSTON        | Texas |    29.76 |    -95.38 |
|   77550 | GALVESTON      | Texas |     29.3 |    -94.79 |
|   78201 | SAN ANTONIO    | Texas |    29.45 |     -98.5 |
|   78401 | CORPUS CHRISTI | Texas |     27.8 |    -97.39 |
|   78589 | SAN JUAN       | Texas |    26.19 |    -98.15 |
|   78701 | AUSTIN         | Texas |    30.26 |    -97.74 |
+---------+----------------+-------+----------+-----------+

mysql> select * from store;
+---------+-------------------------+---------------------------------+---------
+
| storeId | storeName               | address                         | zipcode
|
+---------+-------------------------+---------------------------------+---------
+
|       3 | DLS Store               | Main road DALLAS                |   75201
|
|       4 | D-Store                 | Opp DLS store, main road DALLAS |   75201
|
|       6 | Broadway Square         | Broadway Square                 |   75701
|
|       5 | Market At the Crossing  | 2210 Three Lakes Pkwy           |   75701
|
|       7 | Mattress Firm Tyler     | 2119 E SE Loop 323              |   75701
|
|       9 | Sundance Square         | 420 Main St                     |   76101
|
|       8 | Best Hat Store          | 2739 N Main St                  |   76101
|
|      10 | Bouquets Unique Florist | 1961 W Beauregard Ave           |   76901
|
|       2 | Austio Store2           | Main road Austin                |   78701
|
|       1 | Austin Store            | Link road Austin                |   78701
|
+---------+-------------------------+---------------------------------+---------

--Get Distance in miles of all Cities/Zipcodes from latitude/longitude is 30.26/-97.74
mysql> SELECT *, ( 3959 * acos( cos( radians(30.26) ) * cos( radians( latitude ) ) * cos( radians( longitude ) - radians(-97.74) ) + sin( radians(30.26) ) * sin( radians( latitude ) ) ) ) AS distance FROM zipcodes ORDER BY distance;

+---------+----------------+-------+----------+-----------+---------------------
+
| zipcode | city           | state | latitude | longitude | distance (Miles)
|
+---------+----------------+-------+----------+-----------+---------------------
+
|   78701 | AUSTIN         | Texas |    30.26 |    -97.74 | 0.00011798739433289
|
|   78201 | SAN ANTONIO    | Texas |    29.45 |     -98.5 |     72.158090688184
|
|   77001 | HOUSTON        | Texas |    29.76 |    -95.38 |     145.37065839891
|
|   78401 | CORPUS CHRISTI | Texas |     27.8 |    -97.39 |     171.28996541662
|
|   76101 | FORT WORTH     | Texas |    32.75 |    -97.33 |     173.73959073603
|
|   76901 | SAN ANGELO     | Texas |    31.44 |   -100.45 |     180.24609529831
|
|   75201 | DALLAS         | Texas |    32.79 |    -96.76 |     184.09661574695
|
|   77550 | GALVESTON      | Texas |     29.3 |    -94.79 |     188.93717291854
|
|   75701 | TYLER          | Texas |    32.32 |     -95.3 |      202.5168573235
|
|   78589 | SAN JUAN       | Texas |    26.19 |    -98.15 |     282.33188388554
|
+---------+----------------+-------+----------+-----------+---------------------

--All Zipcodes/Cities within 150 miles from zipcode 78701
mysql> SELECT *, ( 3959 * acos( cos( radians(30.26) ) * cos(radians( latitude )) * cos( radians( longitude ) - radians(-97.74) ) + sin( radians(30.26) ) * sin( radians( latitude ) ) ) ) as distance FROM zipcodes having distance <=150 order by zipcode;

+---------+-------------+-------+----------+-----------+---------------------+
| zipcode | city        | state | latitude | longitude | distance (Miles)    |
+---------+-------------+-------+----------+-----------+---------------------+
|   77001 | HOUSTON     | Texas |    29.76 |    -95.38 |     145.37065839891 |
|   78201 | SAN ANTONIO | Texas |    29.45 |     -98.5 |     72.158090688184 |
|   78701 | AUSTIN      | Texas |    30.26 |    -97.74 | 0.00011798739433289 |
+---------+-------------+-------+----------+-----------+---------------------+


--Get all store within 180 Miles from Austin City zipcode-78701
mysql> SELECT s.storeId, s.storeName, s.address, s.zipcode, (3959 * acos( cos( radians(30.26) ) * cos( radians( z.latitude ) ) * cos( radians( z.longitude ) - radians(-97.74) ) + sin( radians(30.26) ) * sin( radians( z.latitude ) ) ) ) as distance FROM store as s, zipcodes as z WHERE s.zipcode=z.zipcode having distance <=180 order by distance;

+---------+-----------------+------------------+---------+----------------------
+									
| storeId | storeName       | address          | zipcode | distance(Miles)
|
+---------+-----------------+------------------+---------+----------------------
+
|       1 | Austin Store    | Link road Austin |   78701 | 0.000117987394332886
|
|       2 | Austio Store2   | Main road Austin |   78701 | 0.000117987394332886
|
|       9 | Sundance Square | 420 Main St      |   76101 |     173.739590736029
|
|       8 | Best Hat Store  | 2739 N Main St   |   76101 |     173.739590736029
|
+---------+-----------------+------------------+---------+----------------------

--Stored Procedure
DELIMITER $$

DROP PROCEDURE IF EXISTS `causecodedb`.`sp_getStores` $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_getStores`(IN zcode INTEGER, IN miles FLOAT)
BEGIN
DECLARE lat1 FLOAT;
DECLARE lng1 FLOAT;

select latitude,longitude into lat1, lng1 from zipcodes where zipcode=zcode;
select s.storeId, s.storeName, s.address, z.city, z.state, s.zipcode, TRUNCATE((3959 * acos( cos( radians(lat1) ) * cos( radians( z.latitude ) ) * cos( radians( z.longitude ) - radians(lng1) ) + sin( radians(lat1) ) * sin( radians( z.latitude ) ) ) ),2) as distance FROM store as s INNER JOIN zipcodes as z ON s.zipcode=z.zipcode having distance <=miles order by distance;

END $$

DELIMITER ;