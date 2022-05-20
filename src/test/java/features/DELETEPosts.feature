Feature: DeletePosts 
 Testando operações DELETE sem <Authorization> usando json-server .\db.json

Scenario: Verifique a operação DELETE após o POST 
 
	Given eu garanto realizar a operação POST para "/posts" com corpo como 
		|id |      title        |      author     |
		|12 |API Testing Guide  |Eduardo          |
 
	And Eu executo a operação DELETE para "/posts/{postid}/" 
        |postid|
		|12     |
	And eu realizo a operação GET com o parâmetro de caminho para "/posts/{postid}" 
		|postid |
        |1     |
	Then eu "não deveria" ver o corpo com o título como "API Testing Guide"