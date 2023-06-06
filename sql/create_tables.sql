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

CREATE TABLE IF NOT EXISTS user_details(
    id serial PRIMARY KEY,
    email varchar(100) NOT NULL,
    password varchar(150) NOT NULL
);