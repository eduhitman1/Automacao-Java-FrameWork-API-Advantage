Feature: Dados Complexos 
	Verificação completa de dados com <Authorization> usando npm run start-auth
 
@smoke 
Scenario: Verifique a operação GET para dados complexos 
	Given que eu realizo a operação de autenticação para "/auth/login" com o corpo 
		| email           | password |
		|techie@email.com |techie |
		And eu executo a operação GET com o parâmetro de caminho para o endereço "/location/" 
		| id |
		| 1 |
	Then Devo ver o nome da rua como "1st street" 
	
@smoke 
Scenario: verificar a operação GET com token de autenticação do portador 
	Given que eu realizo a operação de autenticação para "/auth/login" com o corpo 
		| email | password |
		| edu.hitman01.eh@gmail.com | eduhitman1 |
	Given que eu realizo a operação GET para "/posts/1" 
	Then devo ver o nome do autor como "Eduardo" 
	
@smoke 
Scenario: 
	Verifique a operação GET com o token de autenticação do portador para validação de esquema json
	Given que eu realizo a operação de autenticação para "/auth/login" com o corpo 
		| email | password |
		| edu.hitman01.eh@gmail.com | eduhitman1 |
	Given que eu realizo a operação GET para "/posts/1" 
	Then devo ver o nome do autor como "Eduardo" com validação json 
	