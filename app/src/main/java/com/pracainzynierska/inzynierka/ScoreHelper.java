package com.pracainzynierska.inzynierka;

public class ScoreHelper {
    /*
    Ok, to wygląda to tak, że SharedPreferences jest magazynem na dane typu klucz-wartość
    i tak jak mówisz, nadpisujesz wcześniej zapisane wartośći.
    Klucze muszą być unikalne, więc za każdym razem musiałbyś zapisywać pod innym kluczem,
    żeby nie zmieniać wcześniejszych wartości.

Myślę, że ok rozwiązaniem przy niewielkiej liczbie wyników będzie zapisywanie ich w postaci listy.
SharedPreferences samo w sobie nie udostępnia metod do zapisu list,
ale jest metoda putString, a w Stringu możesz wpisać co chcesz.

Więc proponuję żeby założyć klasę na wynik i przetrzymywać wszystkie wyniki w liście,
którą będziesz serializować do Stringa i zapisywać w SharedPreferences.
Potem przy odczycie będziesz deserializować do listy wyników i ewentualnie sortować po dacie.

Serializować możesz np. przy użyciu Gsona. Tu jest przykład z listą https://www.baeldung.com/gson-list
     */


}
