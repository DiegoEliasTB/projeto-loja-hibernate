--Ajusta o create para cliente

ALTER TABLE cliente
CHANGE COLUMN `nomeCliente` `nome` VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
CHANGE COLUMN `emailCliente` `email` VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
CHANGE COLUMN `compleEnderecoCliente` `compleEndereco` VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
CHANGE COLUMN `endereco` `compleEndereco` INT(11) NOT NULL;
