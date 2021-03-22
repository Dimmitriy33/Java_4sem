USE master;
GO
--drop DATABASE PLANETS 
CREATE DATABASE PLANETS;
GO
USE PLANETS;

CREATE TABLE Planets
(
	Name nvarchar(32) primary key,
	Radius real default 0.0,
	CoreTemperature real default 0.0,
	Atmosphere nvarchar(3) check (Atmosphere in ('Yes','No')) default 'No',
	Live nvarchar(3) check (Live in ('Yes','No')) default 'No',
);

CREATE TABLE Satellites
(
	Name nvarchar(32) primary key,
	Radius real default 0.0,
	PlanetDistance real default 0.0,
	PlanetName nvarchar(32) foreign key references Planets(Name),
);

INSERT INTO Planets(Name, Radius, CoreTemperature, Atmosphere, Live)
	VALUES('Mercury', 2439, 6000, 'No','No'),
		('Venus', 6051.5, 7358.92, 'Yes', 'No'),
		('Earth', 6382.5, 5882.4, 'Yes', 'Yes'),
		('Mars', 3393, 2000.15, 'Yes', 'Yes'),
		('Jupiter', 71500, 9071.56, 'No','No'),
		('Saturn', 60000, 5528.00, 'No', 'No'),
		('Uranus', 25559, 2489.8, 'No', 'No'),
		('Neptune', 24764, 7000, 'Yes', 'No')


SELECT * FROM Planets;

INSERT INTO Satellites(Name, Radius, PlanetDistance, PlanetName)
	VALUES('Moon', 1737.5, 384403, 'Earth'),
		('Deimos', 6.2, 23460, 'Mars'),
		('Phobos', 11.1, 9380, 'Mars'),
		('Io', 1818.1, 421800, 'Jupiter'),
		('Europa', 1560.7, 671100, 'Jupiter'),
		('Ganymede', 2634.1, 1070400,'Jupiter'),
		('Mimas', 198.2, 185540,'Saturn'),
		('Enceladus', 252.3, 238040, 'Saturn'),
		('Tethys', 536.3, 294670, 'Saturn'),
		('Dione', 562.5, 377420, 'Saturn'),
		('Ariel', 578.9, 190900, 'Uranus'),
		('Umbriel', 584.7, 266000, 'Uranus'),
		('Titania', 788.9, 436300, 'Uranus'),
		('Triton', 1353.4, 354800, 'Neptune'),
		('Nereid', 178.5, 5513820, 'Neptune')

SELECT * FROM Satellites;

SELECT Name FROM Planets WHERE Live='Yes';
