package chat.auth;

public interface AuthService {

    void start(); // тут могут быть подклбчены бд

    String getUsernameByLoginAndPassword(String login, String password); // сответсвует ли логин пароль клиента?
    // правильность ввода возвращает username

    void close();


}
