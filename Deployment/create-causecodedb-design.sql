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
INSERT INTO store(storeName,address,zipcode) values('Trufant Bros. Tattoo','4238 Sherwood Way #3',76901 );
INSERT INTO store(storeName,address,zipcode) values('Sunset Mall','4001 Sunset Dr #1268',76901 );
INSERT INTO store(storeName,address,zipcode) values('Rice Village','2400 University Blvd',77001 );
INSERT INTO store(storeName,address,zipcode) values('Topman The Galleria','5085 Westheimer Rd', 77001);
INSERT INTO store(storeName,address,zipcode) values('Gracies','2228 Strand St', 77550);
INSERT INTO store(storeName,address,zipcode) values('Murdochs','2215 Seawall Blvd',77550 );
INSERT INTO store(storeName,address,zipcode) values('Off the Top Barber Shop','2710 Hillcrest Dr', 78201);
INSERT INTO store(storeName,address,zipcode) values('Top of the Line Barber Shop','2222 E Commerce St',78201);
INSERT INTO store(storeName,address,zipcode) values('Twisted Tattoo','441 McCarty Rd',78201);
INSERT INTO store(storeName,address,zipcode) values('Local Coffee','5903 Broadway St',78201 );
INSERT INTO store(storeName,address,zipcode) values('Hesters Cafe','1714 S Alameda St',78401 );
INSERT INTO store(storeName,address,zipcode) values('Flawless Barber Shop','1101 Airline Rd',78401 );
INSERT INTO store(storeName,address,zipcode) values('Top Gun Marine','421 N A. S Dr', 78401);


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