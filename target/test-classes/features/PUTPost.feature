Feature: PUTPost
 Testando operações PUT sem <Authorization> usando json-server .\db.json

  @smoke
  Scenario: Verifique a operação PUT após o POST
    Given  que realizo a operação PUT para "/ posts / {postid}"
      | id | title             | author            |
      | 2  | API Testing Guide | Henrique |

    Then eu "não deveria" ver o corpo com o título como "API Testing Guide" 	