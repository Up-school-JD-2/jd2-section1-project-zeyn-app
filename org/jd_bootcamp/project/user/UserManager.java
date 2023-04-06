package org.jd_bootcamp.project.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class UserManager {
    private final List<User> users = new ArrayList<>();
    private final List<String> userNames = new ArrayList<>();
    private final List<String> emails = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void addUser(User user) {
        if (isEmailExist(user.getEmail()) | isUserNameExist(user.getUserName())) {
            System.out.println("Kullanıcı adı veya email daha önce tanımlanmış");
            return;
        }
        emails.add(user.getEmail());
        userNames.add(user.getUserName());
        users.add(user);
    }

    public void listUsers() {
        if(users.isEmpty()) {
            System.out.println("\n\t\tHerhangi Bir Kayıt Bulunamadı.\n");
            return;
        }
        System.out.println("\n========================================================================= " +
                "KULLANICILAR " +
                "=========================================================================");
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("============================================================================" +
                "=====================================================================================\n");
    }

    public void createAccount() {
        System.out.println("\n\t\t****** Kayıt Ekranı ******");
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

    public User login() {

        System.out.println("\t\t****** Kullanıcı Girişi ******");

        System.out.print("\t\tKullanıcı Adınız veya Email Adresiniz: ");
        String userNameOrEmail = scanner.nextLine();

        System.out.print("\t\tŞifreniz: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if ((user.getUserName().equals(userNameOrEmail) && user.getPassword().equals(password)) || (user.getEmail().equals(userNameOrEmail) && user.getPassword().equals(password))) {
                return user;
            }
        }
        return null;
    }

    public void removeAccount() {
        System.out.print("Kullanıcı id' sini giriniz: ");
        String id = scanner.nextLine();

        for (User user : users) {
            if (user.getId().equals(id) && !user.getUserName().equals("zeyn-app")) {
                users.remove(user);
                System.out.println("İşlem Başarılı");
                return;
            }
        }
        System.out.println("İşlem Başarısız");
    }

    public void searchAccountById() {
        System.out.print("Kullanıcı Id Giriniz: ");
        String id = scanner.nextLine();
        for (User user : users) {
            if (user.getId().equals(id)) {
                System.out.println("\n" + user + "\n");
                return;
            }
        }
        System.out.println("Kullanıcı Bulunamadı\n");
    }

    public void searchAccountByName() {
        System.out.print("Kullanıcının Adını ve Soyadını Giriniz: ");
        String fullName = scanner.nextLine();

        for (User user : users) {
            String nameAndSurname = user.getName() + " " + user.getSurname();
            if (nameAndSurname.contains(fullName)) {
                System.out.println("\n" + user + "\n");
                return;
            }
        }
        System.out.println("Kullanıcı Bulunamadı\n");
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

    public void initUsers() {
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