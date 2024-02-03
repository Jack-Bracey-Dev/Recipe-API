CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Creation of recipe table
CREATE TABLE IF NOT EXISTS recipe (
  id serial PRIMARY KEY,
  name text NOT NULL,
  source varchar(100),
  url text,
  prep_time INT,
  cook_time INT,
  difficulty varchar(20),
  serves INT,
  description text,
  calories INT,
  fat DECIMAL(6,2),
  saturates DECIMAL(6,2),
  carbs DECIMAL(6,2),
  sugars DECIMAL(6,2),
  fibre DECIMAL(6,2),
  protein DECIMAL(6,2),
  salt DECIMAL(6,2)
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
    beginning_metric INTEGER NOT NULL,
    target_metric INTEGER NOT NULL,
    multiplier decimal NOT NULL,
    PRIMARY KEY(beginning_metric, target_metric),
    FOREIGN KEY (beginning_metric) REFERENCES measurement (id),
    FOREIGN KEY (target_metric) REFERENCES measurement (id)
);

-- Creation of ingredients table
CREATE TABLE IF NOT EXISTS ingredient (
    id serial PRIMARY KEY,
    recipe_id integer,
    FOREIGN KEY (recipe_id) REFERENCES recipe(id),
    description varchar(250) NOT NULL,
    amount decimal,
    measurement_id integer,
    FOREIGN KEY (measurement_id) REFERENCES measurement (id),
    header varchar(100),
    optional BOOLEAN DEFAULT false
);

-- Creation of api keys table
CREATE TABLE IF NOT EXISTS api_keys (
    id serial PRIMARY KEY,
    api_key uuid DEFAULT uuid_generate_v4(),
    type varchar(40),
    requests BIGINT,
    UNIQUE (api_key)
);

-- Creation of permissions table
CREATE TABLE IF NOT EXISTS permissions (
    id serial PRIMARY KEY,
    name varchar(100)
);

-- Creation of api key permissions table
CREATE TABLE IF NOT EXISTS api_key_permissions (
    apikey_id integer NOT NULL,
    permission_id integer NOT NULL,
    PRIMARY KEY (apikey_id, permission_id),
    FOREIGN KEY (apikey_id) REFERENCES api_keys (id),
    FOREIGN KEY (permission_id) REFERENCES permissions (id)
);

-- Creation of feature flag table
CREATE TABLE IF NOT EXISTS feature_flag (
    name varchar(200) PRIMARY KEY,
    value varchar(200) NOT NULL,
    data_type varchar(100) NOT NULL
);

-- Creation of recipe overview table
CREATE TABLE IF NOT EXISTS recipe_overview (
    id serial PRIMARY KEY,
    name varchar(100),
    url varchar(200),
    post_format varchar(50),
    external_id varchar(40),
    image_url varchar(300),
    source varchar(100),
    source_id varchar(100),
    misc_details varchar(300),
    scraped BOOLEAN,
    ignore BOOLEAN
);

-- Creation of scraping info table
CREATE TABLE IF NOT EXISTS scraping_info (
    id varchar(100) PRIMARY KEY,
    number INT,
    text varchar(300)
);

-- Creation of recipe steps table
CREATE TABLE IF NOT EXISTS recipe_steps (
    id serial PRIMARY KEY,
    recipe_id integer,
    FOREIGN KEY (recipe_id) REFERENCES recipe (id),
    step_number INT,
    step_text text
);