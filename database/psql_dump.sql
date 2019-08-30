CREATE TABLE application(
   application_id serial PRIMARY KEY,
   external_id VARCHAR (50) UNIQUE NOT NULL,
   user_id VARCHAR (100) UNIQUE NOT NULL,
   applicant_name VARCHAR (50) NOT NULL,
   pharmacist_reg_no integer,
   applicant_status VARCHAR (10),
   created_on TIMESTAMP NOT NULL
);

CREATE USER pharmauser WITH PASSWORD 'pharmapass';

GRANT ALL PRIVILEGES ON DATABASE "postgres" to pharmauser;