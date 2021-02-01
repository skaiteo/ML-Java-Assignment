INSERT INTO user (id, email) VALUES 
    (1, 'amy@email.com'),
    (2, 'brandon@email.com'),
    (3, 'charlie@email.com');

INSERT INTO feature (id, name) VALUES
    (1, 'donation'),
    (2, 'backup'),
    (3, 'restore');

INSERT INTO user_features (user_id, feature_id) VALUES
    (1, 3),
    (2, 1),
    (3, 1),
    (3, 2);