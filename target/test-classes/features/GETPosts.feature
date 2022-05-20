Feature: verificando diferente GET
Testando operações GET sem <Authorization> usando json-server

Scenario: verifique um autor da postagem 
	Given que eu realizo a operação GET para "/posts/1" 
	Then devo ver o nome do autor como "Eduardo" 
	
Scenario: verifique um autor da postagem 
	Given que eu realizo a operação GET para "/posts" 
	Then devo ver os nomes dos autores 
	
Scenario: Verifique o parâmetro de Get 
	Given que eu realizo a operação GET para "/posts" 
	Then devo verificar o parâmetro GET 
	
	
  