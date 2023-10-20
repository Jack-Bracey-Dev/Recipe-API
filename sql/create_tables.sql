-- Creation of recipe table
CREATE TABLE IF NOT EXISTS recipe (
  id serial PRIMARY KEY,
  name varchar(250) NOT NULL,
  source varchar(100),
  url varchar(500),
  prep_time INT,
  cook_time INT,
  difficulty varchar(20),
  serves INT,
  description varchar(500),
  calories INT,
  fat INT,
  saturates INT,
  carbs INT,
  sugars INT,
  fibre INT,
  protein INT,
  salt INT
);

-- Creation of ingredients table
CREATE TABLE IF NOT EXISTS ingredient (
    id serial PRIMARY KEY,
    recipe_id serial NOT NULL,
    name varchar(250) NOT NULL,
    amount decimal,
    measurement_id serial
);

-- Creation of measurements table
CREATE TABLE IF NOT EXISTS measurement (
    id serial PRIMARY KEY,
    name varchar(100) NOT NULL,
    short_name varchar(50),
    other_names varchar(250),
    UNIQUE(name)
);

-- Creation of measurement conversions
CREATE TABLE IF NOT EXISTS measurement_conversions (
    beginning_metric varchar(100) NOT NULL,
    target_metric varchar(100) NOT NULL,
    multiplier decimal NOT NULL,
    PRIMARY KEY(beginning_metric, target_metric)
);

-- Add foreign keys to ingredient table
ALTER TABLE ingredient
    ADD CONSTRAINT fk_measurement FOREIGN KEY (measurement_id) REFERENCES measurement (id);
ALTER TABLE ingredient
    ADD CONSTRAINT fk_recipe FOREIGN KEY (recipe_id) REFERENCES recipe (id);

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS api_keys (
    id serial PRIMARY KEY,
    api_key uuid DEFAULT uuid_generate_v4(),
    type varchar(40),
    requests BIGINT,
    UNIQUE (api_key)
);

CREATE TABLE IF NOT EXISTS permissions (
    id serial PRIMARY KEY,
    name varchar(100)
);

CREATE TABLE IF NOT EXISTS api_key_permissions (
    apikey_id serial NOT NULL,
    permission_id serial NOT NULL,
    PRIMARY KEY (apikey_id, permission_id),
    FOREIGN KEY (apikey_id) REFERENCES api_keys (id),
    FOREIGN KEY (permission_id) REFERENCES permissions (id)
);

CREATE TABLE IF NOT EXISTS feature_flag (
    name varchar(200) PRIMARY KEY,
    value varchar(200) NOT NULL,
    data_type smallint NOT NULL
);

CREATE TABLE IF NOT EXISTS recipe_overview (
    id serial PRIMARY KEY,
    name varchar(100),
    url varchar(200),
    post_format varchar(50),
    external_id varchar(40),
    image_url varchar(300),
    scraped BOOLEAN,
    last_scraped TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    extra_scraping_info varchar(300),
    source varchar(60)
);