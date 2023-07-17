INSERT INTO tb_user(user_name, email, password, version) VALUES('Nortt', 'Nortt000f@gmail.com', '123232', 2);
INSERT INTO tb_user(user_name, email, password, version) VALUES('Gartt', 'Gartt111@gmail.com', '123232', 2);
INSERT INTO tb_post(title, description, date_created, date_updated, user_id, version) VALUES('Minha publicação', 'Descrição da minha publicação', now(), now(), 1, 2);
INSERT INTO tb_comment(body, post_id, user_id, version) VALUES('Descrição do meu comentário', 1, 1, 1);
INSERT INTO tb_comment(body, post_id, user_id, version) VALUES('Minha resposta de um comentário', 1, 2, 1);
INSERT INTO tb_answer(answer_to, comment, version) VALUES(1, 2, 1)

INSERT INTO tb_topic (title, body, post_id, version) VALUES ('Título do meu tópico', 'Descrição do meu tópico', 1, 1);
INSERT INTO tb_tag (tag_name, category) VALUES ('minha tag', 'minha categoria');
INSERT INTO tb_post_tag(post_id, tag_id) VALUES (1, 1)