# financas-JPA

sistema utilizando Tomcato 8.5

Banco de dados MySql 5.3

É necessário criar o database livrariadb, apos subir o servidor e tentar se logar

Caso necessário para facilitar, poderá ser excecutadas as linhas abaixo nas tabelas para o sistema carregar com dados

INSERT INTO `Autor` VALUES (1,'sergio.lopes@caelum.com.br','Sergio Lopes'),(2,'nico.steppat@caelum.com.br','Nico Steppat'),(3,'aniche@teste.com.br','Mauricio Aniche'),(4,'flavio.almeida@caelum.com.br','Flavio Almeida'),(5,'paulo.silveira@caelum.com.br','Paulo Silveira');

INSERT INTO `Livro` VALUES (1,'2016-02-26','121-3-12-312312-3',49.9,'MEAN'),(2,'2016-02-27','123-1-31-212313-1',49.9,'Arquitetura Java'),(3,'2016-03-01','123-1-31-231312-3',39.9,'AngularJS'),(5,'2016-03-01','124-5-55-533223-2',39.9,'TDD'),(7,'2016-03-01','122-3-44-322323-2',59.9,'SOA'),(9,'2016-03-01','123-1-23-131231-2',19.9,'Primefaces'),(10,'2016-03-01','123-1-23-123123-1',79.9,'JSF2'),(11,'2016-03-01','123-1-31-312312-3',59.9,'JPA');

INSERT INTO `Livro_Autor` VALUES (1,4),(2,1),(2,2),(2,5),(3,1),(5,3),(7,2),(9,1),(10,2),(11,4);

INSERT INTO `Venda` VALUES (1, 2016, 253, 1 ), (2, 2017, 350, 1 ), (3, 2016, 150, 2 ), (4, 2017, 353, 2 ), (5, 2016, 39, 3 ), (6, 2017, 122, 3 ), (7, 2016, 163, 11 ),(8, 2017, 321, 11 ), (9, 2016, 350, 5 ), (10, 2017, 292, 5 );

INSERT INTO `Usuario` VALUES(1, "teste@hotmail.com", 1234);
