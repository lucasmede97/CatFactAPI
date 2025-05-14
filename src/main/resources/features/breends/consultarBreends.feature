#language: en

@api
@cat_fact_api
@breends_api
@full_regressive
Feature: Consultar Breends

  #Incluído etapa de background do login por boas práticas
  Background:
    Given realizo login com sucesso
      | usuario | lucas  |
      | senha   | 123456 |

  Scenario Outline: Validar consultar breends com sucesso
    #Não foi incluido etava de given devido a não ter uma pré-condição
    When consulto as raças
      | limit | <limit> |
    Then valido que o status seja <statusCode>
    And valido que os dados foram retornados com sucesso
      | quantidadeRegistros | <quantidadeRegistros> |
    Examples:
      | limit | statusCode | quantidadeRegistros |
      | 1     | 200        | 1                   |
      | 10    | 200        | 10                  |
      | 90    | 200        | 90                  |
      | 0     | 200        | 15                  |
      | teste | 200        | 25                  |
      | true  | 200        | 25                  |

  Scenario Outline: Validar consultar breends com erro
    #Não foi incluido etava de given devido a não ter uma pré-condição
    When consulto as raças
      | limit | <limit> |
    Then valido que o status seja <statusCode>
    Examples:
      | limit | statusCode |
      | -5    | 404        |