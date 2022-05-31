--Ajusta tabela Vendedor para suportar a super classe.
--------------------------------------------------------------------------------------------------------------------
ALTER TABLE `vendedor` 
CHANGE `nomeVendedor` `nome` VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
CHANGE `emailVendedor` `email` VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
CHANGE `compleEnderecoVendedor` `compleEndereco` VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
CHANGE `endereco_idcep` `endereco` INT(11) NOT NULL;
--------------------------------------------------------------------------------------------------------------------


--Ajusta tabela Fornecedor para suportar a super classe.
--------------------------------------------------------------------------------------------------------------------
ALTER TABLE `fornecedor` 
CHANGE `nomeFantasiaFornecedor` `nome` VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
CHANGE `emailFornecedor` `email` VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
CHANGE `compleEnderecofornecedor` `compleEndereco` VARCHAR(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
CHANGE `endereco_idcep` `endereco` INT(11) NOT NULL;
--------------------------------------------------------------------------------------------------------------------
