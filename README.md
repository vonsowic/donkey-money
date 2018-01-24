# aplikacja-do-zarzadzania-wydatkami-swoimi-i-nie-tylko 

[Serwer produkcyjny](https://donkeymoney.herokuapp.com/) [![Build Status](https://travis-ci.com/vonsowic/donkey-money.svg?token=z5xW5WFyuttX4MbcwYmp&branch=master)](https://travis-ci.com/vonsowic/donkey-money?token=z5xW5WFyuttX4MbcwYmp&branch=master)

[Serwer testowy](https://osiol-test.herokuapp.com/) [![Build Status](https://travis-ci.com/vonsowic/donkey-money.svg?token=z5xW5WFyuttX4MbcwYmp&branch=develop)](https://travis-ci.com/vonsowic/donkey-money?token=z5xW5WFyuttX4MbcwYmp&branch=develop)

## Baza danych
Na czas tworzenia aplikacji możemy użyć [HSQLDB](https://pl.wikipedia.org/wiki/HSQLDB) - baza danych będzie tworzona w pamięci automatycznie przy każdym uruchomieniu i czyszczona po zakończeniu. Jeśli do testów potrzebne są dane wpisane na stałe, to w pliku [data.sql](src/main/resources/database/hsqldb/data.sql) należy umieścić polecenia SQL. 

