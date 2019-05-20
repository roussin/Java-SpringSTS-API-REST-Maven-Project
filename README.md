# Java-SpringSTS-API-REST-Maven-Project

# Technologies utilisées
- Spring-Boot-2.1.4-RELEASE
- Java-1.8
- Frameworks : Maven, SpringMVC, Mockito, JSON
- Tomcat-8
- IDE : Spring STS 4
- La plupart des technologies sont embarquées par Spring Boot

# Services REST
L’alternative à une API RESt est une API SOAP (Simple Object Access Protocol) cependant la complexité de ce type d’API et le format de réponse limité (uniquement XML) ne jouent pas en faveur de ce type d’API.

Les services REST représentent un style d'architecture pour développer des services web. Une API qui respecte les principes REST est appelée API-RESTful.

Les principes clés de REST impliquent la séparation de l'API en ressources logiques. Ce qui revient à penser à comment obtenir chaque ressource.

Une ressource est un objet ou une représentation d'objets contenant éventuellement des données. Exemple : un employé d'une société est une ressource. La manipulation de ces ressources repose sur le protocole HTTP à travers les méthodes d'actions GET, POST, PUT, PATCH, DELETE.

Pour obtenir une ressource, il faut déjà l'identifier à travers une URL et bien la nommer.

Une URL (Uniform Ressource Locator) indique le chemin vers une ressource. Cette ressource n'est pas toujours disponible. Lorsque l'URL pointe vers une ressource disponible, on parle d'une URI.

Une URI (Uniform Ressource Identifier) est l'identifiant unique de ressource sur un réseau (URI = URL + Ressource). Une URI est donc une URL qui pointe vers une ressource bien identifiée.

Dans l'implémentation des services REST, une bonne identification de la ressource est l'utilisation des noms et non des verbes. Par exemple, pour notre portail de connexion, j'aurai besoin d'une ressource utilisateur nommée User et d'une URL qui pointe vers cette ressource (l'ensemble formera l'URI de la ressource User), ce qui donne par exemple :

http://localhost:8080/springboot-restserver/user

Une fois que la ressource est identifiée, on a besoin de la manipuler. Par exemple la mettre à jour, supprimer, ou en créer une autre.

Pour ce faire on utilise les méthodes HTTP suivantes :

GET /users -- extraction de tous les utilisateurs.
GET /users/1 -- extraction de l'utilisateur ayant l'identifiant 1.
DELETE /users/1 -- suppression de l'utilisateur 1.
POST /users -- création d'un nouvel utilisateur.
PUT /users/1 -- mise à jour de l'utilisateur 1.
PATCH /users/1 -- mise à jour partielle de l'utilisateur 1.

# Les 5 règles de l'architecture REST
https://blog.nicolashachet.com/niveaux/confirme/larchitecture-rest-expliquee-en-5-regles
