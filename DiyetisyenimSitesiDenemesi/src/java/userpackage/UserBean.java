package userpackage;
import javax.faces.bean.ManagedBean;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author YEmre
 */
@ManagedBean(name = "user")
public final class UserBean {

    int id;
    String email;
    String username;
    String password;
    String repassword;

    String err_email; // Email hatası
    String err_username; // Username hatası
    String err_password; // Şifre hatası
    
    String page_main;

    static String msg; // Olası exceptionlar için
    
    boolean login;
    
    public UserBean() {
        login = false;
        hideErr("all");
    }
    
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        UserBean.msg = msg;
    }

    public String login() {
        boolean error = false;

        if (!UserOperations.checkUserName(username)) {
            showErr("username");
            error = true;
        } else if (!UserOperations.checkPassword(password)){
            showErr("password");
            error = true;
        }
        
        if (!error) {
            login = true;
            return "user_info?faces-redirect=true"; // Sayfaya bağlanma
        }

        return "";
    }

    /**
     * Kayıl ol butonu eylemi
     *
     * @return Yönlendirilecek sayfa
     */
    public String register() {
        boolean error = false;

        if (!UserOperations.isNewEmail(email)) {
            showErr("email");

            error = true;
        }
        if (!UserOperations.isNewUsername(username)) {
            showErr("username");

            error = true;
        }
        if (!UserOperations.checkPassword(password, repassword)) {
            showErr("password");

            error = true;
        }

        if (!error) {
            UserOperations.createUser(username, password, email);
            return "user_info?faces-redirect=true"; // Sayfaya bağlanma
        }

        return "";
    }

    /**
     * Hata mesajlarını görünmez kılar.
     * @param type Gizlenmek istenen hata mesajı ("username", "password" ... "all")
     */
    public void hideErr(String type) {
        if (type.equalsIgnoreCase("username")) {
            err_username = "color: orangered;\n"
                    + "    font-size: 15px;\n"
                    + "    font-style: initial;\n"
                    + "    display: none;";
        } else if (type.equalsIgnoreCase("password")) {
            err_password = "color: orangered;\n"
                    + "    font-size: 15px;\n"
                    + "    font-style: initial;\n"
                    + "    display: none;";
        } else if (type.equalsIgnoreCase("email")) {
            err_email = "color: orangered;\n"
                    + "    font-size: 15px;\n"
                    + "    font-style: initial;\n"
                    + "    display: none;";
        } else if (type.equalsIgnoreCase("all")) {
            err_email = "color: orangered;\n"
                    + "    font-size: 15px;\n"
                    + "    font-style: initial;\n"
                    + "    display: none;";
            err_username = "color: orangered;\n"
                    + "    font-size: 15px;\n"
                    + "    font-style: initial;\n"
                    + "    display: none;";
            err_password = "color: orangered;\n"
                    + "    font-size: 15px;\n"
                    + "    font-style: initial;\n"
                    + "    display: none;";
        }
    }

    /**
     * Hata mesajlarını görünür kılar.
     * @param type Gösterilmek istenen hata mesajı ("username", "password" ... "all")
     */
    public void showErr(String type) {
        if (type.equalsIgnoreCase("username")) {
            err_username = "color: orangered;\n"
                    + "    font-size: 15px;\n"
                    + "    font-style: initial;\n"
                    + "    display: block;";
        } else if (type.equalsIgnoreCase("password")) {
            err_password = "color: orangered;\n"
                    + "    font-size: 15px;\n"
                    + "    font-style: initial;\n"
                    + "    display: block;";
        } else if (type.equalsIgnoreCase("email")) {
            err_email = "color: orangered;\n"
                    + "    font-size: 15px;\n"
                    + "    font-style: initial;\n"
                    + "    display: block;";
        } else if (type.equalsIgnoreCase("all")) {
            err_username = "color: orangered;\n"
                    + "    font-size: 15px;\n"
                    + "    font-style: initial;\n"
                    + "    display: block;";
            err_password = "color: orangered;\n"
                    + "    font-size: 15px;\n"
                    + "    font-style: initial;\n"
                    + "    display: block;";
            err_email = "color: orangered;\n"
                    + "    font-size: 15px;\n"
                    + "    font-style: initial;\n"
                    + "    display: block;";
        }
    }

    public String getPage_main() {
        if (login)
            page_main = "user_info.xhtml";
        return page_main;
    }

    public void setPage_main(String page_main) {
        this.page_main = page_main;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }
    

    public String getErr_email() {
        return err_email;
    }

    public void setErr_email(String err_email) {
        this.err_email = err_email;
    }

    public String getErr_username() {
        return err_username;
    }

    public void setErr_username(String err_username) {
        this.err_username = err_username;
    }

    public String getErr_password() {
        return err_password;
    }

    public void setErr_password(String err_password) {
        this.err_password = err_password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

}
