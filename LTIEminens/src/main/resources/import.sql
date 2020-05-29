insert into Difficulty (id, name) values(1,'easy');
insert into Difficulty (id, name) values(2,'medium');
insert into Difficulty (id, name) values(3,'hard');

insert into Test (id, name) values (1, 'This is the first test');

insert into Problem (problem_id, difficulty_id, test_id, question, correct_answer, incorrect_answer1, incorrect_answer2, incorrect_answer3) values (1, 1, 1, 'Ki vagyok en?', 'Orsi', 'Zsorsi', 'Porsi', 'Florsi');
insert into Problem (problem_id, difficulty_id, test_id, question, correct_answer, incorrect_answer1, incorrect_answer2, incorrect_answer3) values (2, 1, 1, 'Hany eves vagyok?', '26', '11', '45', '36');