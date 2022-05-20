Feature: Sample for create scenarios the of generation the tokem and conteudo

Background: 
	Given que tenha carregado o plano de execucao no jira 
	
Scenario: Validar solicitacao de token de acesso na aplicacao do sts 
	And que tenha configuado o header 
		|Content-type					  |
		|application/x-www-form-urlencoded|
	And que tenha criado o body 
		|grand_type			|x-itau-flowID|x-itau-correlationID|client_id	  |client_secret|
		|client_credentials |1 			  |2				   |jksdfksdjsdkfs|djksjslkdjkj |
	When enviar uma requiscao para a web api 
		|endpoint			   |
		|https://des-sts.com.br|
	Then sera posivel validar o status code 
		|satus_code|
		|200	   | 
	And a mensagem de retorno 
		|mensagem|
		|ok		 | 
		
		
Scenario: Validar o cadatro de um conteudo 
	Given que tenha carregado token 
		|client_id	   |client_secret|
		|jksdfksdjsdkfs|djksjslkdjkj |
	And que tenha configuado o header 
		|Content-type					  |
		|application/x-www-form-urlencoded|
	And que tenha criado o body 
		|grand_type			|x-itau-flowID|x-itau-correlationID|client_id	  |client_secret|
		|client_credentials |1 			  |2				   |jksdfksdjsdkfs|djksjslkdjkj |
	When enviar uma requiscao para a web api 
		|endpoint			   |
		|https://des-sts.com.br|
	Then sera posivel validar o status code 
		|satus_code|
		|200	   | 
	And a mensagem de retorno 
		|mensagem|
		|ok		 | And que tenha configuado o header|
		|Content-type					  |
		|application/x-www-form-urlencoded|
	And que tenha criado o body 
		|grand_type			|x-itau-flowID|x-itau-correlationID|client_id	  |client_secret|
		|client_credentials |1 			  |2				   |jksdfksdjsdkfs|djksjslkdjkj |
	When enviar uma requiscao para a web api 
		|endpoint			   |
		|https://des-sts.com.br|
	Then sera posivel validar o status code 
		|satus_code|
		|200	   | 
	And a mensagem de retorno 
		|mensagem|
		|ok		 | 