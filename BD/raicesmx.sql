CREATE DATABASE raicesmx;
USE raicesmx;

CREATE TABLE user (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(45) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    birthdate DATE NOT NULL,
    address VARCHAR(256) NOT NULL,
    phone VARCHAR(10) NOT NULL,
    role ENUM('admin', 'user') NOT NULL DEFAULT 'user'
);

CREATE TABLE subscription (
    subscription_id INT AUTO_INCREMENT PRIMARY KEY,
    subscription_type ENUM('Raíces Basic', 'Raíces Gold', 'Raíces Premium') NOT NULL,
    benefits VARCHAR(256) NOT NULL,
    price INT DEFAULT 0
);

CREATE TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    date_time DATETIME NOT NULL,
    notes VARCHAR(256),
    quantity INT NOT NULL,
    status ENUM('en preparación', 'en camino', 'entregado'),
    user_id_fk INT NOT NULL,
    CONSTRAINT fk_order_user FOREIGN KEY (user_id_fk)
        REFERENCES user (user_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);

CREATE TABLE user_subscription (
    user_subscription_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    subscription_id INT NOT NULL,
    start_date DATE DEFAULT NULL,
    end_date DATE DEFAULT NULL,
    is_active BOOLEAN DEFAULT TRUE,
    CONSTRAINT fk_user_subscription_user FOREIGN KEY (user_id)
        REFERENCES user (user_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_user_subscription_subscription FOREIGN KEY (subscription_id)
        REFERENCES subscription (subscription_id)
        ON DELETE CASCADE,
    CONSTRAINT unique_user_subscription UNIQUE (user_id)
);

CREATE TABLE product (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(256) NOT NULL,
    ingredients VARCHAR(256) NOT NULL,
    meal_time VARCHAR(20) NOT NULL,
    image VARCHAR(256) NOT NULL,
    price INT NOT NULL,
    extras VARCHAR(50),
    stock INT NOT NULL
);

CREATE TABLE order_has_product (
    order_id_fk INT NOT NULL,
    product_id_fk INT NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY (order_id_fk, product_id_fk),
    CONSTRAINT fk_order_product_order FOREIGN KEY (order_id_fk)
        REFERENCES orders (order_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_order_product_product FOREIGN KEY (product_id_fk)
        REFERENCES product (product_id)
        ON DELETE CASCADE
);

CREATE TABLE diet (
    diet_id INT AUTO_INCREMENT PRIMARY KEY,
    diet_type VARCHAR(50) NOT NULL,
    additional_info VARCHAR(256)
);

CREATE TABLE diet_has_product (
    diet_id_fk INT NOT NULL,
    product_id_fk INT NOT NULL,
    PRIMARY KEY (diet_id_fk, product_id_fk),
    CONSTRAINT fk_diet_product_diet FOREIGN KEY (diet_id_fk)
        REFERENCES diet (diet_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_diet_product_product FOREIGN KEY (product_id_fk)
        REFERENCES product (product_id)
        ON DELETE CASCADE
);


