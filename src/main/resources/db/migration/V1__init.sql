CREATE TABLE category
(
    id               BIGINT NOT NULL,
    created_at       datetime NULL,
    last_modified_at datetime NULL,
    deleted          BIT(1) NOT NULL,
    name             VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE joined_table_instructor
(
    user_id BIGINT NOT NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_joined_table_instructor PRIMARY KEY (user_id)
);

CREATE TABLE joined_table_mentor
(
    user_id BIGINT NOT NULL,
    avg_rating DOUBLE NOT NULL,
    company VARCHAR(255) NULL,
    CONSTRAINT pk_joined_table_mentor PRIMARY KEY (user_id)
);

CREATE TABLE joined_table_user
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_joined_table_user PRIMARY KEY (id)
);

CREATE TABLE mapped_super_class_instructor
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_mapped_super_class_instructor PRIMARY KEY (id)
);

CREATE TABLE mapped_super_class_mentor
(
    id      BIGINT NOT NULL,
    name    VARCHAR(255) NULL,
    email   VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    company VARCHAR(255) NULL,
    CONSTRAINT pk_mapped_super_class_mentor PRIMARY KEY (id)
);

CREATE TABLE product
(
    id               BIGINT NOT NULL,
    created_at       datetime NULL,
    last_modified_at datetime NULL,
    deleted          BIT(1) NOT NULL,
    title            VARCHAR(255) NULL,
    price DOUBLE NULL,
    category_id      BIGINT NULL,
    `description`    VARCHAR(255) NULL,
    imageurl         VARCHAR(255) NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE single_table_user
(
    id         BIGINT NOT NULL,
    user_table INT NULL,
    name       VARCHAR(255) NULL,
    email      VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    company    VARCHAR(255) NULL,
    CONSTRAINT pk_single_table_user PRIMARY KEY (id)
);

CREATE TABLE table_per_class_instructor
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_table_per_class_instructor PRIMARY KEY (id)
);

CREATE TABLE table_per_class_mentor
(
    id      BIGINT NOT NULL,
    name    VARCHAR(255) NULL,
    email   VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    company VARCHAR(255) NULL,
    CONSTRAINT pk_table_per_class_mentor PRIMARY KEY (id)
);

CREATE TABLE table_per_class_user
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_table_per_class_user PRIMARY KEY (id)
);

ALTER TABLE joined_table_instructor
    ADD CONSTRAINT FK_JOINED_TABLE_INSTRUCTOR_ON_USER FOREIGN KEY (user_id) REFERENCES joined_table_user (id);

ALTER TABLE joined_table_mentor
    ADD CONSTRAINT FK_JOINED_TABLE_MENTOR_ON_USER FOREIGN KEY (user_id) REFERENCES joined_table_user (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);

CREATE TABLE product_seq
(
    next_val BIGINT NOT NULL
);

CREATE TABLE category_seq
(
    next_val BIGINT NOT NULL
);