insert into Difficulty (id, name) values(1,'easy');
insert into Difficulty (id, name) values(2,'medium');
insert into Difficulty (id, name) values(3,'hard');

insert into Test (id, name) values (1, 'This is the first test');
insert into Test (id, name) values (2, 'This is the second test');
insert into Test (id, name) values (3, 'This is the third test');
insert into Test (id, name) values (4, 'This is the 4th test');

insert into Problem (problem_id, difficulty_id, test_id, question, correct_answer, incorrect_answer1, incorrect_answer2, incorrect_answer3) values (1, 1, 1, 'Ki vagyok en?', 'Orsi', 'Zsorsi', 'Porsi', 'Florsi');
insert into Problem (problem_id, difficulty_id, test_id, question, correct_answer, incorrect_answer1, incorrect_answer2, incorrect_answer3) values (2, 1, 1, 'Hany eves vagyok?', '26', '11', '45', '36');
insert into Problem (problem_id, difficulty_id, test_id, question, correct_answer, incorrect_answer1, incorrect_answer2, incorrect_answer3) values (3, 1, 2, 'Question nr. 1 - easy?', 'yes1', 'ab1c', 'de2f', 'gh3i');
insert into Problem (problem_id, difficulty_id, test_id, question, correct_answer, incorrect_answer1, incorrect_answer2, incorrect_answer3) values (4, 1, 2, 'Question nr. 2 - easy?', 'yes2', 'a1bc', 'd2ef', 'ghi3');
insert into Problem (problem_id, difficulty_id, test_id, question, correct_answer, incorrect_answer1, incorrect_answer2, incorrect_answer3) values (5, 1, 2, 'Question nr. 3 - easy?', 'yes3', 'ab1c', 'def2', 'g3hi');
insert into Problem (problem_id, difficulty_id, test_id, question, correct_answer, incorrect_answer1, incorrect_answer2, incorrect_answer3) values (6, 2, 2, 'Question nr. 4 - medium?', 'yes4', '1abc', 'd2ef', 'g3hi');
insert into Problem (problem_id, difficulty_id, test_id, question, correct_answer, incorrect_answer1, incorrect_answer2, incorrect_answer3) values (7, 2, 2, 'Question nr. 5 - medium?', 'yes5', 'ab1c', 'def2', 'g3hi');
insert into Problem (problem_id, difficulty_id, test_id, question, correct_answer, incorrect_answer1, incorrect_answer2, incorrect_answer3) values (8, 2, 2, 'Question nr. 6 - medium?', 'yes6', 'a1bc', 'd2ef', 'gh3i');
insert into Problem (problem_id, difficulty_id, test_id, question, correct_answer, incorrect_answer1, incorrect_answer2, incorrect_answer3) values (9, 3, 2, 'Question nr. 7 - hard?', 'yes7', 'abc1', '2def', 'g3hi');
insert into Problem (problem_id, difficulty_id, test_id, question, correct_answer, incorrect_answer1, incorrect_answer2, incorrect_answer3) values (10, 3, 2, 'Question nr. 8 - hard?', 'yes8', '1abc', 'de2f', 'gh3i');
insert into Problem (problem_id, difficulty_id, test_id, question, correct_answer, incorrect_answer1, incorrect_answer2, incorrect_answer3) values (11, 3, 2, 'Question nr. 9 - hard ?', 'yes9', 'ab1c', 'de2f', 'g3hi');

insert into Role (id, description) values (1, 'Teacher');
insert into Role (id, description) values (2, 'TestTakerStudent');
insert into Role (id, description) values (3, 'WatcherStudent');

--password = a
insert into user_eminens (id, username, password, salt, full_name, role_id) values(1, 'TestTeacher',
    'pKpDWv8IA8XTR8Ld8Jyqy+ooGVtYSXgtwlZq3LmDcy+Bo/O+Sb+WF9au3RS0khhnqN1r7QUH1Qnhhb2s0I8tgA==',
    'k/kKB1ECWC2YdLTIHPJp+iiCnrgssEYjqUJa78De/vdXYCWsAtUgzw2VKfEgPxIdl5Ej+T4ar+WRO3y3LgFW79cKvrVEsDkbyCsNbBqZ6heyKbbLow9k9iMT5tq+JS+R4was1UEpN63w0fRwrcDlOWZBGIZJ5JsVlbhdE+NDcqDO+tUfQ6iPAd/ae17HDgw99tToQ3xWNIeBSGq3kYB5D96bfU8V5yFzuhfL956vh1faNJylxC9jf9buYk+YyEWySJK2aHTfWq6I4yCmldMI4LZRJk0aBDBpfTJO79HP2fTeGo/h7xInzkT6eJ5Tm9kCrey6ZEOgV/OQS7T5mtzzAnhMEmCr/p9aQA34HRon5FWVUu987yLpqV56v2PyvQy4r9L9hROebVZkR4NNb9HMJzu4NmPVVAF1HNA2X5lWSMQe3p56NJUK8o5UP/E7FsJ605wSMqMadbi7vS6Y6xYw8hOl8UH5y9wUPKwq9AHjqmkIBCqZHniBMFZUdkX4ePnFqG/pW1+oTreG4v01rXWHrEO50PyABS57DgP3znhltnLBk60LxndK+ZX2KhBX7c8tZZX9PIK9WuH/mx7CvEK6RZwt5GswNtkeSJEO2rtzpL9hoTr+CdIz184MuVX2RhSYoQQaEpLV8pUHL0slTWjXU8Ni+N3pKAYcGTQbT0yvBr8=',
    'Test Teacher', 1
    );

insert into user_eminens (id, username, password, salt, full_name, role_id) values(2, 'TestWatcher',
    'pKpDWv8IA8XTR8Ld8Jyqy+ooGVtYSXgtwlZq3LmDcy+Bo/O+Sb+WF9au3RS0khhnqN1r7QUH1Qnhhb2s0I8tgA==',
    'k/kKB1ECWC2YdLTIHPJp+iiCnrgssEYjqUJa78De/vdXYCWsAtUgzw2VKfEgPxIdl5Ej+T4ar+WRO3y3LgFW79cKvrVEsDkbyCsNbBqZ6heyKbbLow9k9iMT5tq+JS+R4was1UEpN63w0fRwrcDlOWZBGIZJ5JsVlbhdE+NDcqDO+tUfQ6iPAd/ae17HDgw99tToQ3xWNIeBSGq3kYB5D96bfU8V5yFzuhfL956vh1faNJylxC9jf9buYk+YyEWySJK2aHTfWq6I4yCmldMI4LZRJk0aBDBpfTJO79HP2fTeGo/h7xInzkT6eJ5Tm9kCrey6ZEOgV/OQS7T5mtzzAnhMEmCr/p9aQA34HRon5FWVUu987yLpqV56v2PyvQy4r9L9hROebVZkR4NNb9HMJzu4NmPVVAF1HNA2X5lWSMQe3p56NJUK8o5UP/E7FsJ605wSMqMadbi7vS6Y6xYw8hOl8UH5y9wUPKwq9AHjqmkIBCqZHniBMFZUdkX4ePnFqG/pW1+oTreG4v01rXWHrEO50PyABS57DgP3znhltnLBk60LxndK+ZX2KhBX7c8tZZX9PIK9WuH/mx7CvEK6RZwt5GswNtkeSJEO2rtzpL9hoTr+CdIz184MuVX2RhSYoQQaEpLV8pUHL0slTWjXU8Ni+N3pKAYcGTQbT0yvBr8=',
    'Test Watcher', 3
    );

insert into user_eminens (id, username, password, salt, full_name, role_id) values(3, 'TestStudent',
    'pKpDWv8IA8XTR8Ld8Jyqy+ooGVtYSXgtwlZq3LmDcy+Bo/O+Sb+WF9au3RS0khhnqN1r7QUH1Qnhhb2s0I8tgA==',
    'k/kKB1ECWC2YdLTIHPJp+iiCnrgssEYjqUJa78De/vdXYCWsAtUgzw2VKfEgPxIdl5Ej+T4ar+WRO3y3LgFW79cKvrVEsDkbyCsNbBqZ6heyKbbLow9k9iMT5tq+JS+R4was1UEpN63w0fRwrcDlOWZBGIZJ5JsVlbhdE+NDcqDO+tUfQ6iPAd/ae17HDgw99tToQ3xWNIeBSGq3kYB5D96bfU8V5yFzuhfL956vh1faNJylxC9jf9buYk+YyEWySJK2aHTfWq6I4yCmldMI4LZRJk0aBDBpfTJO79HP2fTeGo/h7xInzkT6eJ5Tm9kCrey6ZEOgV/OQS7T5mtzzAnhMEmCr/p9aQA34HRon5FWVUu987yLpqV56v2PyvQy4r9L9hROebVZkR4NNb9HMJzu4NmPVVAF1HNA2X5lWSMQe3p56NJUK8o5UP/E7FsJ605wSMqMadbi7vS6Y6xYw8hOl8UH5y9wUPKwq9AHjqmkIBCqZHniBMFZUdkX4ePnFqG/pW1+oTreG4v01rXWHrEO50PyABS57DgP3znhltnLBk60LxndK+ZX2KhBX7c8tZZX9PIK9WuH/mx7CvEK6RZwt5GswNtkeSJEO2rtzpL9hoTr+CdIz184MuVX2RhSYoQQaEpLV8pUHL0slTWjXU8Ni+N3pKAYcGTQbT0yvBr8=',
    'Test Student', 2
);
