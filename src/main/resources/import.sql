INSERT INTO tb_book (id, title, author, isbn, disponivel) VALUES (1, 'Dom Quixote', 'Miguel de Cervantes', '978-3-16-148410-0', true);
INSERT INTO tb_book (id, title, author, isbn, disponivel) VALUES (2, 'Guerra e Paz', 'Liev Tolstói', '978-0-14-044793-4', true);
INSERT INTO tb_book (id, title, author, isbn, disponivel) VALUES (3, 'Cem Anos de Solidão', 'Gabriel García Márquez', '978-0-06-088328-7', true);
INSERT INTO tb_book (id, title, author, isbn, disponivel) VALUES (4, '1984', 'George Orwell', '978-0-452-28423-4', true);
INSERT INTO tb_book (id, title, author, isbn, disponivel) VALUES (5, 'O Senhor dos Anéis', 'J.R.R. Tolkien', '978-0-618-00222-8', true);
INSERT INTO tb_book (id, title, author, isbn, disponivel) VALUES (6, 'O Grande Gatsby', 'F. Scott Fitzgerald', '978-0-7432-7356-5', true);
INSERT INTO tb_book (id, title, author, isbn, disponivel) VALUES (7, 'Moby Dick', 'Herman Melville', '978-0-14-243724-7', true);
INSERT INTO tb_book (id, title, author, isbn, disponivel) VALUES (8, 'A Revolução dos Bichos', 'George Orwell', '978-0-452-28424-1', true);
INSERT INTO tb_book (id, title, author, isbn, disponivel) VALUES (9, 'Orgulho e Preconceito', 'Jane Austen', '978-0-19-953556-9', true);
INSERT INTO tb_book (id, title, author, isbn, disponivel) VALUES (10, 'O Apanhador no Campo de Centeio', 'J.D. Salinger', '978-0-316-76948-0', true);
INSERT INTO tb_book (id, title, author, isbn, disponivel) VALUES (11, 'Jane Eyre', 'Charlotte Brontë', '978-0-14-243720-9', true);
INSERT INTO tb_book (id, title, author, isbn, disponivel) VALUES (12, 'Crime e Castigo', 'Fiódor Dostoiévski', '978-0-14-305814-4', true);
INSERT INTO tb_book (id, title, author, isbn, disponivel) VALUES (13, 'A Metamorfose', 'Franz Kafka', '978-0-14-310524-8', true);
INSERT INTO tb_book (id, title, author, isbn, disponivel) VALUES (14, 'O Processo', 'Franz Kafka', '978-0-14-310552-1', true);
INSERT INTO tb_book (id, title, author, isbn, disponivel) VALUES (15, 'A Divina Comédia', 'Dante Alighieri', '978-0-14-243722-3', true);
INSERT INTO tb_book (id, title, author, isbn, disponivel) VALUES (16, 'O Retrato de Dorian Gray', 'Oscar Wilde', '978-0-14-143957-0', true);
INSERT INTO tb_book (id, title, author, isbn, disponivel) VALUES (17, 'Ulisses', 'James Joyce', '978-0-679-72232-7', false);
INSERT INTO tb_book (id, title, author, isbn, disponivel) VALUES (18, 'As Aventuras de Huckleberry Finn', 'Mark Twain', '978-0-14-243717-9', false);
INSERT INTO tb_book (id, title, author, isbn, disponivel) VALUES (19, 'O Som e a Fúria', 'William Faulkner', '978-0-679-73224-1', false);
INSERT INTO tb_book (id, title, author, isbn, disponivel) VALUES (20, 'Don Juan', 'Lord Byron', '978-0-14-042216-8', false);

SELECT id, title FROM tb_book WHERE title IN ('Ulisses', 'As Aventuras de Huckleberry Finn', 'O Som e a Fúria', 'Don Juan');



INSERT INTO tb_reserve (start_date, end_date, user_name, book_id) VALUES ('2024-07-01', '2024-07-15', 'Ulisses Santana', 17);
INSERT INTO tb_reserve (start_date, end_date, user_name, book_id) VALUES ('2024-07-02', '2024-07-16', 'Lais Alves', 18);
INSERT INTO tb_reserve (start_date, end_date, user_name, book_id) VALUES ('2024-07-03', '2024-07-17', 'Eloisa Viana', 19);
INSERT INTO tb_reserve (start_date, end_date, user_name, book_id) VALUES ('2024-07-04', '2024-07-18', 'Beantriz Santana', 20);