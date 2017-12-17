Feature:
  Scenario Outline: Register Page Scenerio
    Given Załadowaną stronę z logowaniem użytkownika
    When Wpisuję swoje konto "<user>"
    And Klikam przycisk rejestracji
    Then Ukazuje mi się formularz rejestracji
    And Uzupełniam go swoimi danymi "<password>", "<adres>", "<miasto>", "<imie>", "<nazwisko>", "<telefon>", "<kodpocztowy>"
    Then Wysyłam formularz
    Then Ukazuje mi się strona mojego konta

    Examples:
      | user     | password | adres | miasto | imie  | nazwisko | telefon   | kodpocztowy |
      | szkolas  | abecdeef | jeden | dwa    | trzhy | cztery   | 123456789 | 85952       |
      | takmabyc | abecdeef | jeden | dwa    | trzhy | cztery   | 123456789 | 85952       |
      | sebaabe  | abecdeef | jeden | dwa    | trzhy | cztery   | 123456789 | 85952       |