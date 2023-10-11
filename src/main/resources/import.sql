INSERT INTO user(name,email,password,active) VALUES('John Doe', 'john.doe@email.com','password1',TRUE);
INSERT INTO user(name,email,password,active) VALUES('Luis Ponce', 'luis@email.com','password2',TRUE);
INSERT INTO user(name,email,password,active) VALUES('Daniel Pech', 'Daniel@email.com','password3',TRUE);


INSERT INTO profile(age,sex, cellphone,fk_user_id) VALUES(20,'male',9991006652,1);
INSERT INTO profile(age,sex, cellphone,fk_user_id) VALUES(25,'female',9991856652,2);
INSERT INTO profile(age,sex, cellphone,fk_user_id) VALUES(18,'male',9991070652,3);


INSERT INTO school(name,cp) VALUES('schoolOne', '003541SDF');
INSERT INTO school(name,cp) VALUES('schoolTwo', '004567ASD');
INSERT INTO school(name,cp) VALUES('schoolThree', '00456GFSD');




INSERT INTO certifications (name, description, date) VALUES ('Certificación de Desarrollador Front-End', 'Certificación de Desarrollador Front-End otorgada por la empresa XYZ', '2023-01-15');
INSERT INTO certifications (name, description, date) VALUES ('Certificación Scrum Master', 'Certificación Scrum Master obtenida en un curso de capacitación', '2022-11-20');
INSERT INTO certifications (name, description, date) VALUES ('Certificación de Seguridad de la Información', 'Certificación en Seguridad de la Información por el Instituto de Seguridad', '2023-02-28');
INSERT INTO certifications (name, description, date) VALUES ('Certificación de Gestión de Proyectos', 'Certificación en Gestión de Proyectos PMP', '2022-09-10');
INSERT INTO certifications (name, description, date) VALUES ('Certificación de Analista de Datos', 'Certificación como Analista de Datos por la Asociación de Analistas', '2023-03-05');
INSERT INTO certifications (name, description, date) VALUES ('Certificación de Administrador de Redes', 'Certificación como Administrador de Redes CISCO', '2022-12-12');
INSERT INTO certifications (name, description, date) VALUES ('Certificación de Seguridad Cibernética', 'Certificación en Seguridad Cibernética otorgada por EC-Council', '2022-10-02');
INSERT INTO certifications (name, description, date) VALUES ('Certificación de Cloud Computing', 'Certificación en Cloud Computing por AWS', '2023-04-18');

INSERT INTO user_certifications(user_id, certification_id) VALUES(1, 1);
INSERT INTO user_certifications(user_id, certification_id) VALUES(1, 4);
INSERT INTO user_certifications(user_id, certification_id) VALUES(1, 7);


