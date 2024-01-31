public class User {

    String login;
    String password;

    public User (String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin () {
        return login;
    }

    public String getPassword () {
        return password;
    }

    public String getUser() {
        String login = getLogin();
        String password = getPassword();
        String user = "{\"login\":\"" + login + "\",\"password\":\"" + password + "\"}";
        return user;
    }    
}
