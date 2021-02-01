DROP TABLE IF EXISTS user;  
CREATE TABLE user (  
    id INT AUTO_INCREMENT PRIMARY KEY,  
    email VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS feature;  
CREATE TABLE feature (  
    id INT AUTO_INCREMENT PRIMARY KEY,  
    name VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS user_features;  
CREATE TABLE user_features (
    user_id INT NOT NULL,
    feature_id INT NOT NULL
);