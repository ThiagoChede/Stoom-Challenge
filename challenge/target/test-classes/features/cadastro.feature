Feature: beer resources

  Scenario: Create location Address return success
    When I make a POST call to "/location" endpoint with post body:
    """
    {

      "streetName": "Rua jose carlos pragidi",

      "number": 375,

      "complement": "casa",

      "neighbourhood": "bacana",

      "city": "sumare",

      "state": "SAO PAULO",

      "country": "BRASIL",

      "zipcode": "13174430"

    }
    """
    Then response status code should be 201

  Scenario: Query the addresses
    Given I have only the following rows in the "endereco" table:
      | id | rua                    | numero                      | complemento     | vizinhanca| cidade  | estado    | pais |codigo_postal  |latitude   |longitude         |
      |1   | Rua jose carlos pragidi| 375                         | casa            | bacana       | sumare| sao paulo| brasil  | 13174430|-22.8953306|-47.06298079999999|

    When I make a GET call to "/location/1" endpoint
    Then response status code should be 200
    And response should be json:
    """
    {
        "id": 1,
        "streetName": "Rua jose carlos pragidi",
        "number": 375,
        "complement": "casa",
        "neighbourhood": "bacana",
        "city": "sumare",
        "state": "sao paulo",
        "country": "brasil",
        "zipcode": "13174430",
        "latitude": "${json-unit.ignore}",
        "longitude": "${json-unit.ignore}"
    }
    """
