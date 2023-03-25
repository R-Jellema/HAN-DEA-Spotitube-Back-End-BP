## Spotitube API     
Spotitube API by Rick Jellema, student @Hogeschool Arnhem en Nijmegen.

Om de applicatie goed te gebruiken moet je de database scripts "DDL & Insert.sql" uitvoeren op een Microsoft SQL Server. De versie die is gebruikt tijdens het ontwikkelen van de opdracht     
is SQL Server 2019 met Management Studio 18.

Om de database te gebruiken is de System Administrator account (SA) gebruikt.

Om de API met de database te laten verbinden moet je in src/main/resources/database.properties in de connectionString de **{GEBRUIKERSNAAM}** en **{WACHTWOORD}** (Voor privacy redenen mijn gebruikersnaam en wachtwoord weggehaald).


Het project is met maven ontwikkelt. Dus graag eerst **mvn clean install** uitvoeren.

Gebruik je eigen deployment configuratie of pak de map RunConfiguration waar deze readme ook staat en kopieer deze map naar je .idea folder.
Wijzig natuurlijk wel je Apache tomee plus configuratie. Want mijn installatie path daarvan is anders dan van jou.

Probeer nu de applicatie te draaien.
Mocht je er toch niet uitkomen dan is dat helaas pech. 





