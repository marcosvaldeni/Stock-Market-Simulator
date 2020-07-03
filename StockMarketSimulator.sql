DROP DATABASE IF EXISTS StockMarketSimulator;
CREATE DATABASE StockMarketSimulator;

USE StockMarketSimulator;

DROP TABLE IF EXISTS simulations;
CREATE TABLE simulations(
simulation_id INT AUTO_INCREMENT NOT NULL unique,
simulation_date INT(16) NOT NULL,
PRIMARY KEY(simulation_id)
);

DROP TABLE IF EXISTS companies;
CREATE TABLE companies(
company_id INT AUTO_INCREMENT NOT NULL unique,
company_name VARCHAR(45) NOT NULL,
company_shares INT NOT NULL,
company_sharePrice FLOAT NOT NULL,
company_type ENUM('Textile', 'Automotive', 'Mine', 'Tech', 'Aero', 'AeroSpace', 'Gas', 'Cosmetics', 'Petro', 'Electric') NOT NULL,
simulation_id INT NOT NULL,
PRIMARY KEY(company_id)
);

DROP TABLE IF EXISTS investors;
CREATE TABLE investors(
investor_id INT AUTO_INCREMENT NOT NULL unique,
investor_name VARCHAR(45) NOT NULL,
investor_budget FLOAT NOT NULL,
simulation_id INT NOT NULL,
PRIMARY KEY(investor_id)
);

DROP TABLE IF EXISTS transactions;
CREATE TABLE transactions(
transaction_id INT AUTO_INCREMENT NOT NULL unique,
transaction_sharePrice FLOAT NOT NULL,
investor_id INT NOT NULL,
company_id INT NOT NULL,
simulation_id INT NOT NULL,
PRIMARY KEY(transaction_id)
);