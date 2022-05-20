Feature: Operandor requisição POST 
 Testando operações POST sem <Authorization> usando json-server .\db.json

 Scenario:
Verificação da operação POST 
	Given eu realizo a operação POST para "/posts" 
	Given eu garanto realizar a operação POST para "/posts" com corpo como 
		| id | title              | author            |
		| 14 | API Testing Guide | jau |
 
 Scenario:
Verificar operação de postagem para o perfil 
	Given que realizo a operação POST para "/posts/{profileNo}/profile" com corpo 
		|name | profile |
        |jacob  | 6     |
	Then devo ver que o corpo tem o nome "jacob"