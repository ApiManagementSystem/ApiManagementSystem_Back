
/*user*/
INSERT INTO user_info(user_id, user_name, email, password)
    VALUES (1000, 'May','may.yjie@gmail.com','123456');
INSERT INTO user_info(user_id, user_name, email, password)
VALUES (1001, 'qqqq','may.yjie@gmail.com','22222');

/*project*/
INSERT INTO project_info(project_id, project_name, project_address, description)
    VALUES (9, 'TestProject','www.test.com','This is a test');
INSERT INTO project_info(project_id, project_name, project_address, description)
VALUES (1001, 'project','www.test2.com','This is a test2');

/*interface*/
INSERT INTO interface_info(interface_id, interface_name, method, description, url, json, project_id)
    VALUES (100,'TestInterface','post','this is a test','/test','{\n" +
                "    \"message\":\"操作成功\"，\n" +
                "    \"status\":200,\n" +
                "    \"data\":null\n" +
                "}',9);
