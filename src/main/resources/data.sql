-- delete all records from tables to be able to restart
DELETE FROM rt_user_user_group;
DELETE FROM video_sets;
DELETE FROM user_groups;
DELETE FROM users;
-- insert demo records to tables
INSERT INTO users (user_id, email, enabled, first_name, last_name, password, role)
VALUES
  (1,'omniadmin',TRUE ,'Omni','Admin','$2a$10$nx8LBdkZ/mB12mPEza8pdOujSDllNjEs7x9b19M9bYXNM2AvXfTBO', 'omniadmin'),
  (2,'admin',TRUE,'Ad','Min','$2a$10$yDaIKKS.6.on6TdQMq5ofe4g6R4N36q19shiyq84iON6xpObchQ2m', 'admin'),
  (3,'chiefeditor',TRUE,'Chief','Editor','$2a$10$9xV5ETX.bQ3EIV6SmN0Y1uV/ReGQxEobNN6CGNTWfqnGVcygCCsdi', 'chiefeditor'),
  (4,'editor',TRUE,'Edi','Tor','$2a$10$UVieifdQjIK3M.bNs/7xUutzG2QMAyaJxvuQJRdtqmEDZz1qb7PFS', 'editor'),
  (11,'1omniadmin',TRUE ,'Omni','Admin','$2a$10$nx8LBdkZ/mB12mPEza8pdOujSDllNjEs7x9b19M9bYXNM2AvXfTBO', 'omniadmin'),
  (12,'1admin',TRUE,'Ad','Min','$2a$10$yDaIKKS.6.on6TdQMq5ofe4g6R4N36q19shiyq84iON6xpObchQ2m', 'admin'),
  (13,'1chiefeditor',TRUE,'Chief','Editor','$2a$10$9xV5ETX.bQ3EIV6SmN0Y1uV/ReGQxEobNN6CGNTWfqnGVcygCCsdi', 'chiefeditor'),
  (14,'1editor',TRUE,'Edi','Tor','$2a$10$UVieifdQjIK3M.bNs/7xUutzG2QMAyaJxvuQJRdtqmEDZz1qb7PFS', 'editor'),
  (21,'2omniadmin',TRUE ,'Omni','Admin','$2a$10$nx8LBdkZ/mB12mPEza8pdOujSDllNjEs7x9b19M9bYXNM2AvXfTBO', 'omniadmin'),
  (22,'2admin',TRUE,'Ad','Min','$2a$10$yDaIKKS.6.on6TdQMq5ofe4g6R4N36q19shiyq84iON6xpObchQ2m', 'admin'),
  (23,'2chiefeditor',TRUE,'Chief','Editor','$2a$10$9xV5ETX.bQ3EIV6SmN0Y1uV/ReGQxEobNN6CGNTWfqnGVcygCCsdi', 'chiefeditor'),
  (24,'2editor',TRUE,'Edi','Tor','$2a$10$UVieifdQjIK3M.bNs/7xUutzG2QMAyaJxvuQJRdtqmEDZz1qb7PFS', 'editor'),
  (31,'3omniadmin',TRUE ,'Omni','Admin','$2a$10$nx8LBdkZ/mB12mPEza8pdOujSDllNjEs7x9b19M9bYXNM2AvXfTBO', 'omniadmin'),
  (32,'3admin',TRUE,'Ad','Min','$2a$10$yDaIKKS.6.on6TdQMq5ofe4g6R4N36q19shiyq84iON6xpObchQ2m', 'admin'),
  (33,'3chiefeditor',TRUE,'Chief','Editor','$2a$10$9xV5ETX.bQ3EIV6SmN0Y1uV/ReGQxEobNN6CGNTWfqnGVcygCCsdi', 'chiefeditor'),
  (34,'3editor',TRUE,'Edi','Tor','$2a$10$UVieifdQjIK3M.bNs/7xUutzG2QMAyaJxvuQJRdtqmEDZz1qb7PFS', 'editor'),
  (41,'4omniadmin',TRUE ,'Omni','Admin','$2a$10$nx8LBdkZ/mB12mPEza8pdOujSDllNjEs7x9b19M9bYXNM2AvXfTBO', 'omniadmin'),
  (42,'4admin',TRUE,'Ad','Min','$2a$10$yDaIKKS.6.on6TdQMq5ofe4g6R4N36q19shiyq84iON6xpObchQ2m', 'admin'),
  (43,'4chiefeditor',TRUE,'Chief','Editor','$2a$10$9xV5ETX.bQ3EIV6SmN0Y1uV/ReGQxEobNN6CGNTWfqnGVcygCCsdi', 'chiefeditor'),
  (44,'4editor',TRUE,'Edi','Tor','$2a$10$UVieifdQjIK3M.bNs/7xUutzG2QMAyaJxvuQJRdtqmEDZz1qb7PFS', 'editor'),
  (51,'5omniadmin',TRUE ,'Omni','Admin','$2a$10$nx8LBdkZ/mB12mPEza8pdOujSDllNjEs7x9b19M9bYXNM2AvXfTBO', 'omniadmin'),
  (52,'5admin',TRUE,'Ad','Min','$2a$10$yDaIKKS.6.on6TdQMq5ofe4g6R4N36q19shiyq84iON6xpObchQ2m', 'admin'),
  (53,'5chiefeditor',TRUE,'Chief','Editor','$2a$10$9xV5ETX.bQ3EIV6SmN0Y1uV/ReGQxEobNN6CGNTWfqnGVcygCCsdi', 'chiefeditor'),
  (54,'5editor',TRUE,'Edi','Tor','$2a$10$UVieifdQjIK3M.bNs/7xUutzG2QMAyaJxvuQJRdtqmEDZz1qb7PFS', 'editor'),
  (61,'6omniadmin',TRUE ,'Omni','Admin','$2a$10$nx8LBdkZ/mB12mPEza8pdOujSDllNjEs7x9b19M9bYXNM2AvXfTBO', 'omniadmin'),
  (62,'6admin',TRUE,'Ad','Min','$2a$10$yDaIKKS.6.on6TdQMq5ofe4g6R4N36q19shiyq84iON6xpObchQ2m', 'admin'),
  (63,'6chiefeditor',TRUE,'Chief','Editor','$2a$10$9xV5ETX.bQ3EIV6SmN0Y1uV/ReGQxEobNN6CGNTWfqnGVcygCCsdi', 'chiefeditor'),
  (64,'6editor',TRUE,'Edi','Tor','$2a$10$UVieifdQjIK3M.bNs/7xUutzG2QMAyaJxvuQJRdtqmEDZz1qb7PFS', 'editor'),
  (65,'parwand',TRUE,'Parwand','Alsino','$2a$12$quJx7eaqYZVmCbiPArr6ZO5Yqtx/5JrUhpG1A.aj93er.gEyDF.ka', 'admin');


INSERT INTO user_groups (user_group_id, deleted, user_group_name)
VALUES
  (1,FALSE,'twt'),
  (2,FALSE,'commerzbanker'),
  (3,FALSE,'mediathek'),
  (4,FALSE,'blog'),
  (11,FALSE,'1twt'),
  (12,FALSE,'1commerzbanker'),
  (13,FALSE,'1mediathek'),
  (14,FALSE,'1blog'),
  (21,FALSE,'2twt'),
  (22,FALSE,'2commerzbanker'),
  (23,FALSE,'2mediathek'),
  (24,FALSE,'2blog'),
  (31,FALSE,'3twt'),
  (32,FALSE,'3commerzbanker'),
  (33,FALSE,'3mediathek'),
  (34,FALSE,'3blog'),
  (41,FALSE,'4twt'),
  (42,FALSE,'4commerzbanker'),
  (43,FALSE,'4mediathek'),
  (44,FALSE,'4blog'),
  (51,FALSE,'5twt'),
  (52,FALSE,'5commerzbanker'),
  (53,FALSE,'5mediathek'),
  (54,FALSE,'5blog'),
  (61,FALSE,'6twt'),
  (62,FALSE,'6commerzbanker'),
  (63,FALSE,'6mediathek'),
  (64,FALSE,'6blog');

INSERT INTO video_sets (video_set_id, date, deleted, filename, mime_type, is_external, title, transcoded, user_id, user_group_id)
VALUES
  (1,STR_TO_DATE('17-09-2012 18:47:52.690', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'omniadmin,twt',TRUE,1,1),
  (2,STR_TO_DATE('17-09-2013 18:47:52.690', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'omniadmin,commerzbanker',TRUE,1,2),
  (3,STR_TO_DATE('17-09-2014 18:47:52.690', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'omniadmin,mediathek',TRUE,1,3),
  (4,STR_TO_DATE('17-09-2015 18:47:52.690', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'omniadmin,blog',TRUE,1,4),
  (5,STR_TO_DATE('17-09-2012 18:47:52.690', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'admin,twt',TRUE,2,1),
  (6,STR_TO_DATE('17-10-2012 18:47:52.690', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'admin,commerzbanker',TRUE,2,2),
  (7,STR_TO_DATE('17-11-2012 18:47:52.690', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'admin,mediathek',TRUE,2,3),
  (8,STR_TO_DATE('17-12-2012 18:47:52.690', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'admin,blog',TRUE,2,4),
  (9,STR_TO_DATE('17-01-2012 18:47:52.690', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'chiefeditor,twt',TRUE,3,1),
  (10,STR_TO_DATE('17-09-2012 18:47:52.690', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'chiefeditor,commerzbanker',TRUE,3,2),
  (11,STR_TO_DATE('18-09-2012 18:47:52.690', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'chiefeditor,mediathek',TRUE,3,3),
  (12,STR_TO_DATE('19-09-2012 18:47:52.690', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'chiefeditor,blog',TRUE,3,4),
  (13,STR_TO_DATE('20-09-2012 18:47:52.690', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'editor,twt',TRUE,4,1),
  (14,STR_TO_DATE('17-09-2012 19:47:52.690', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'editor,commerzbanker',TRUE,4,2),
  (15,STR_TO_DATE('17-09-2012 20:47:52.690', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'editor,mediathek',TRUE,4,3),
  (16,STR_TO_DATE('17-09-2012 21:47:52.690', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'editor,blog',TRUE,4,4),
  (101,STR_TO_DATE('17-09-2005 18:47:52.690', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'omniadmin,twt',TRUE,1,1),
  (102,STR_TO_DATE('17-09-2006 18:48:52.690', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'omniadmin,commerzbanker',TRUE,1,2),
  (103,STR_TO_DATE('17-09-2007 18:49:52.690', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'omniadmin,mediathek',TRUE,1,3),
  (104,STR_TO_DATE('17-09-2008 18:50:52.690', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'omniadmin,blog',TRUE,1,4),
  (105,STR_TO_DATE('17-09-2009 18:47:52.690', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'admin,twt',TRUE,2,1),
  (106,STR_TO_DATE('17-09-2010 18:47:53.690', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'admin,commerzbanker',TRUE,2,2),
  (107,STR_TO_DATE('17-09-2011 18:47:54.690', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'admin,mediathek',TRUE,2,3),
  (108,STR_TO_DATE('17-02-2012 18:47:55.690', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'admin,blog',TRUE,2,4),
  (109,STR_TO_DATE('17-03-2012 18:47:52.690', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'chiefeditor,twt',TRUE,3,1),
  (110,STR_TO_DATE('17-04-2012 18:47:52.790', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'chiefeditor,commerzbanker',TRUE,3,2),
  (111,STR_TO_DATE('17-05-2012 18:47:52.890', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'chiefeditor,mediathek',TRUE,3,3),
  (112,STR_TO_DATE('17-06-2012 18:47:52.990', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'chiefeditor,blog',TRUE,3,4),
  (113,STR_TO_DATE('17-07-2012 18:47:52.090', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'editor,twt',TRUE,4,1),
  (114,STR_TO_DATE('17-08-2012 18:47:52.690', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'editor,commerzbanker',TRUE,4,2),
  (115,STR_TO_DATE('07-09-2012 18:47:52.600', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'editor,mediathek',TRUE,4,3),
  (116,STR_TO_DATE('27-09-2012 18:47:52.610', '%d-%m-%Y %H:%i:%s.%f'),FALSE,'file.mp4','video/mp4',FALSE,'editor,blog',TRUE,4,4);

INSERT INTO rt_user_user_group (user_id, user_group_id)
VALUES
  (1,1),
  (2,2),
  (3,3),
  (4,4);
