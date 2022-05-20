$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/GETDadosComplexos.feature");
formatter.feature({
  "line": 1,
  "name": "Dados Complexos",
  "description": "Verificação completa de dados com \u003cAuthorization\u003e start-auth",
  "id": "dados-complexos",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1767743700,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Verifique a operação GET para dados complexos",
  "description": "",
  "id": "dados-complexos;verifique-a-operação-get-para-dados-complexos",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "que eu realizo a operação de autenticação para \"/auth/login\" com o corpo",
  "rows": [
    {
      "cells": [
        "email",
        "senha"
      ],
      "line": 7
    },
    {
      "cells": [
        "techie@email.com",
        "techie"
      ],
      "line": 8
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "/auth/login",
      "offset": 48
    }
  ],
  "location": "GetPostSteps.que_eu_realizo_a_operao_de_autenticao_para_something_com_o_corpo(String,DataTable)"
});
