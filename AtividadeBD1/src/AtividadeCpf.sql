create database atividade1
use atividade1

create table pessoa(
cpf char(11),
nome varchar(100)
primary key(CPF)
)

go
CREATE PROCEDURE inserepessoa (@cpf char(11), @nome varchar(100), @saida varchar(200) OUTPUT)
AS
BEGIN
  DECLARE @contador INT,
          @soma INT,
          @dig1 INT,
          @dig2 INT,
          @cpf_temp CHAR(11),
          @digitos_iguais CHAR(1)
          
  SET @cpf_temp = SUBSTRING(@cpf,1,1)

  SET @contador = 1
  SET @digitos_iguais = 'S'

  WHILE (@contador <= 11)
  BEGIN
    IF SUBSTRING(@cpf,@contador,1) <> @cpf_temp
      SET @digitos_iguais = 'N'
    SET @contador = @contador + 1
  END;

  IF @digitos_iguais = 'S'
  BEGIN
	RAISERROR('O CPF não pode ter todos os digitos iguais',16,1)
  END
  ELSE
  BEGIN

    SET @soma = 0
    SET @contador = 1
    WHILE (@contador <= 9)
    BEGIN
      SET @soma = @soma + CONVERT(INT,SUBSTRING(@cpf,@contador,1)) * (11 - @contador);
      SET @contador = @contador + 1
    END

    SET @dig1 = 11 - (@soma % 11)

    IF @dig1 > 9
      SET @dig1 = 0;

    SET @soma = 0
    SET @contador = 1
    WHILE (@contador <= 10)
    BEGIN
      SET @soma = @soma + CONVERT(INT,SUBSTRING(@cpf,@contador,1)) * (12 - @contador);
      SET @contador = @contador + 1
    END

    SET @dig2 = 11 - (@soma % 11)

    IF @dig2 > 9
      SET @dig2 = 0;

    IF (@dig1 = SUBSTRING(@cpf,LEN(@cpf)-1,1)) AND (@dig2 = SUBSTRING(@cpf,LEN(@cpf),1))
	  BEGIN
	  INSERT INTO pessoa VALUES(@cpf,@nome)
	  SET @saida = 'CPF válido! Pessoa Cadastrada com sucesso!'
	  END
    ELSE
	  RAISERROR('CPF invalido!',16,1)
  END
END

