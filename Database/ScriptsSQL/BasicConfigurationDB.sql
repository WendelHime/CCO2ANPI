--Cria usuario caso não exista
CREATE USER IF NOT EXISTS 'alunos'@'localhost' IDENTIFIED BY 'alunos';
--Cria banco de dados caso não exista
CREATE DATABASE IF NOT EXISTS SystemBuildingControl;
--Permite ao usuario acesso ao banco de dados
GRANT ALL PRIVILEGES ON SystemBuildingControl.* TO 'alunos'@'localhost';

