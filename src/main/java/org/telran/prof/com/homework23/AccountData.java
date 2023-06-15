package org.telran.prof.com.homework23;

import java.util.HashMap;
import java.util.Map;

public class AccountData {
    private Map<String, Storage> data = new HashMap<>();

    public AccountData(Map<String, Storage> data) {
        this.data = data;
    }

    public Map<String, Storage> getData() {
        return data;
    }
}

//Хорошо,
//
//
////Если постоянно вводить неправильный ответ,
////то у вас будет постоянно вызываться этот метод
////таким образом, при большом старании - будет StackOverFlow исключение
////так как будет постоянно выделяться все новый и новый блок памяти
////такие вещи нужно делать через while
//public boolean getDecision(){
//
//
//        Класс Storage - нет форматирования
//
//
////Если переменные задали и не собираетесь менять,
////сделайте их константами
//private String bankAccountPattern = "[A-Z]{2}\d{18,32}";
//private String codePattern = "\d{6}";
//
//
////Данный метод и делает авторизацию и проверяет код и возвращает аккаунт клиента
//        //так не правильно.
//        //там где вызывается этот метод , нужно запрашивать ввод и уже потом введенный
//        //аккаунт передать в метод проверки типа isCorrectIban
//        //если проверка прошла , тогда уже делать действия дальше, иначе возвращаться к вводу по новой
//        // то же самое с кодом
//
//
////Как пример шаблона :
//
//        String clientsBankAccount = null;
//        boolean сorrectIban = false;
//        while (сorrectIban) {
//        //ввод пока ибан не корректен или по достижению попыток
//        сorrectIban = !isCorrectIban(clientsBankAccount);
//        //сообщения,подсчет попыток
//        }
//        if(!сorrectIban) {
//        //попытки закончились и ибан не корректен, тогда выходим
//        //throw new IncorrectIbanNumberException
//        }
////Аналогично повторяем с кодом авторизации
//
////и уже после авторизации можно будет применять те действия
////что и планировалось для авторизованного аккаунта
////который будет храниться в clientsBankAccount
//
//
//public String authorize(){
//
//        Необходимо избавиться от всех рекурсий, так как этог ограниченное исполнение кода.
//        И вынести код в сервисы, создавайте сервисы, если явно не указано их не делать
