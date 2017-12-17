Feature:
  Scenario Outline: Login Fail Page Scenerio
    Given Załadowaną strone logowana
    When Wprowadzam dane użytkownika "<user>" i hasło "<password>"
    And Nacisnełem przycisk logowania by się zalogować
    Then Ukazuje mi się strona logowania z blędem

    Examples:
      | user              | password |
      | tostzchlebem@maslo.pl | costam  |
      | top@top.pl      | rrfdf      |
      | niemam@loginu.ll     | ihasla      |