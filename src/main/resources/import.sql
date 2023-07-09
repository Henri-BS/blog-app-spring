INSERT INTO tb_user(user_name, email, password, version) VALUES('Nortt', 'Nortt000f@gmail.com', '123232', 2);
INSERT INTO tb_user(user_name, email, password, version) VALUES('Gartt', 'Gartt111@gmail.com', '123232', 2);
INSERT INTO tb_post(title, description, user_id, version) VALUES('Minha publicação', 'Descrição da minha publicação', 1, 2);
INSERT INTO tb_comment(body, post_id, user_id, version) VALUES('Descrição do meu comentário', 1, 1, 1);
INSERT INTO tb_comment(body, post_id, user_id, version) VALUES('Minha resposta de um comentário', 1, 2, 1);
INSERT INTO tb_answer(answer_to, answer_from, version) VALUES(1, 2, 1)
