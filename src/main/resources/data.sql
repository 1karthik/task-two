DROP TABLE IF EXISTS sample;

CREATE TABLE sample(
   id       INTEGER  NOT NULL PRIMARY KEY 
  ,parent_id INTEGER  NOT NULL
  ,name     VARCHAR(25) NOT NULL
  ,color    VARCHAR(9) NOT NULL
);
INSERT INTO sample(id,parent_id,name,color) VALUES (1,0,'Warrior','red');
INSERT INTO sample(id,parent_id,name,color) VALUES (2,0,'Wizard','green');
INSERT INTO sample(id,parent_id,name,color) VALUES (3,0,'Priest','white');
INSERT INTO sample(id,parent_id,name,color) VALUES (4,0,'Rogue','yellow');
INSERT INTO sample(id,parent_id,name,color) VALUES (5,1,'Fighter','blue');
INSERT INTO sample(id,parent_id,name,color) VALUES (6,1,'Paladin','lighblue');
INSERT INTO sample(id,parent_id,name,color) VALUES (7,1,'Ranger','lighgreen');
INSERT INTO sample(id,parent_id,name,color) VALUES (8,2,'Mage','grey');
INSERT INTO sample(id,parent_id,name,color) VALUES (9,2,'Specialist wizard','lightgrey');
INSERT INTO sample(id,parent_id,name,color) VALUES (10,3,'Cleric','red');
INSERT INTO sample(id,parent_id,name,color) VALUES (11,3,'Druid','green');
INSERT INTO sample(id,parent_id,name,color) VALUES (12,3,'Priest of specific mythos','white');
INSERT INTO sample(id,parent_id,name,color) VALUES (13,4,'Thief','yellow');
INSERT INTO sample(id,parent_id,name,color) VALUES (14,4,'Bard','blue');
INSERT INTO sample(id,parent_id,name,color) VALUES (15,13,'Assassin','lighblue');
