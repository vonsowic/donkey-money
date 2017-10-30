# aplikacja-do-zarzadzania-wydatkami-swoimi-i-nie-tylko [![Build Status](https://travis-ci.com/vonsowic/donkey-money.svg?token=z5xW5WFyuttX4MbcwYmp&branch=master)](https://travis-ci.com/vonsowic/donkey-money?token=z5xW5WFyuttX4MbcwYmp&branch=master)
[Serwer testowy](https://osiol-test.herokuapp.com/)
[Serwer produkcyjny](https://donkeymoney.herokuapp.com/)

## Baza danych
Na czas tworzenia aplikacji możemy użyć [HSQLDB](https://pl.wikipedia.org/wiki/HSQLDB) - baza danych będzie tworzona w pamięci automatycznie przy każdym uruchomieniu i czyszczona po zakończeniu. Jeśli do testów potrzebne są dane wpisane na stałe, to w pliku [data.sql](src/main/resources/database/hsqldb/data.sql) należy umieścić polecenia SQL. 

## Autoryzacja
OAuth2

### Google
Aby użyć klucza w aplikacji, należy przekazać go w parametrze *key=AIzaSyA-C-ud6dEYn5WahjTkTzLZhCnPk4iroDs*

Dla wszystkich części naszego projektu powinien być utworzony jeden projekt na Google Cloud, ale każdy klient ma mieć wygenerowany własny klucz. Klucze klienckie:
* web - TODO
* Andoroid - TODO

[howto](https://developers.google.com/identity/sign-in/web/devconsole-project)
