package org.jd_bootcamp.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class UserManager {
    private final List<User> users = new ArrayList<>();
    public List<String> userNames = new ArrayList<>();
    public List<String> emails = new ArrayList<>();

    public void addUser(User user) {
        if (isEmailExist(user.getEmail()) | isUserNameExist(user.getUserName())) {
            System.out.println("Kullanıcı adı veya email daha önce tanımlanmış");
            return;
        }
        emails.add(user.getEmail());
        userNames.add(user.getUserName());
        users.add(user);
    }

    public List<User> allUsers() {
        return users;
    }

    public void listUsers() {
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    public void createAccount() {
        System.out.println("\n\t\t****** Kayıt Ekranı ******");
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        System.out.print("\t\tAdınız: ");
        user.setName(scanner.nextLine());
        System.out.print("\t\tSoyadınız: ");
        user.setSurname(scanner.nextLine());

        String userName, email;

        while (true) {
            System.out.print("\t\tKullanıcı Adınız: ");
            userName = scanner.nextLine();
            if (!isUserNameExist(userName)) break;
            System.out.println("\t\tGeçersiz kullanıcı adı");
        }
        user.setUserName(userName);
        userNames.add(userName);

        while (true) {
            System.out.print("\t\tEmail: ");
            email = scanner.nextLine();
            if (!isEmailExist(email)) break;
            System.out.println("\t\tGeçersiz email");
        }
        user.setEmail(email);
        emails.add(email);

        System.out.print("\t\tŞifre: ");
        user.setPassword(scanner.nextLine());

        users.add(user);
        System.out.println();
        //System.out.println("\t\t**************************\n");
    }

    public boolean removeAccount(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                users.remove(user);
                return true;
            }
        }
        return false;
    }

    public String searchAccountById(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user.toString();
            }
        }
        return null;
    }

    public String searchAccountByName(String fullName) {
        for (User user : users) {
            String nameAndSurname = user.getName() + user.getSurname();
            if (nameAndSurname.contains(fullName)) {
                return user.toString();
            }
        }
        return null;
    }

    public boolean isEmailExist(String email) {
        for (String mail : emails) {
            if (mail.equals(email)) return true;
        }
        return false;
    }

    public boolean isUserNameExist(String userName) {
        for (String username : userNames) {
            if (username.equals(userName)) return true;
        }
        return false;
    }

    public void initUsers(){
        User user1 = new User("Cihan", "Korkmaz", "chnkrkmz", "1245", "chnkrkmz@gmail.com");
        User user2 = new User("Ece", "Gören", "ecegoren", "124*5", "ecegoren@gmail.com");
        User user3 = new User("Hasan", "Akkoyun", "hsnkk", "1#245", "hsnkk@gmail.com");
        User user4 = new User("Ekin", "Bulut", "ekinbulut", "5263s", "ekinbulut@gmail.com");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
    }
}