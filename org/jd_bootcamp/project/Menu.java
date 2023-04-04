package org.jd_bootcamp.project;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        FilmManager filmManager = new FilmManager();
        User user = new User();

        User admin = new User("Zeynep", "Özdemir", "zeyn-app", "123456", "zeynepozdemir@gmail.com");
        userManager.addUser(admin);

        filmManager.initFilms();
        userManager.initUsers();


        System.out.println();
        Scanner scanner = new Scanner(System.in);

        String choice, adminChoice, userChoice;

        outerLoop:
        while (true) {
            System.out.println("1- Kayıt Ol\n2- Giriş Yap\n3- Filmleri İncele");
            System.out.print("İşleminiz: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    userManager.createAccount();
                case "2":
                    System.out.println("\t\t****** Kullanıcı Girişi ******");
                    boolean flag = false;
                    System.out.print("\t\tKullanıcı adınız: ");
                    String userName = scanner.nextLine();

                    System.out.print("\t\tŞifreniz: ");
                    String password = scanner.nextLine();

                    for (User user_ : userManager.allUsers()) {
                        if (user_.getUserName().equals(userName) && user_.getPassword().equals(password)) {
                            user = user_;
                            flag = true;
                            break;
                        }
                    }

                    if (!flag) {
                        System.out.println("\t\tBöyle bir kullanıcı bulunamadı.\n\n");
                        break;
                    }

                    System.out.println();

                    if (user.equals(admin)) {
                        adminInterface();
                        innerLoop:
                        while (true) {
                            adminChoice = scanner.nextLine();
                            switch (adminChoice) {
                                case "1": // list users
                                    userManager.listUsers();
                                    break;
                                case "2": // add new user
                                    userManager.createAccount();
                                    break;
                                case "3": // remove user
                                    System.out.print("Kullanıcı id' sini giriniz: ");
                                    String id = scanner.nextLine();
                                    if (userManager.removeAccount(id)) System.out.println("İşlem Başarılı");
                                    else System.out.println("İşlem Başarısız");
                                    break;
                                case "4": // search user
                                    System.out.print("1- İsim Soyisim ile Ara\t2- Id ile Ara");
                                    adminChoice = scanner.nextLine();
                                    if (adminChoice.equals("1")) {
                                        String name = scanner.nextLine();
                                        userManager.searchAccountByName(name);
                                    } else if (adminChoice.equals("2")) {
                                        String id_ = scanner.nextLine();
                                        userManager.searchAccountById(id_);
                                    } else {
                                        System.out.println("Hatalı seçim yaptınız");
                                        break;
                                    }
                                    break;
                                case "5": // add film
                                    filmManager.newFilm();
                                    break;
                                case "6": // search film
                                    System.out.print("1- Film Adı ile Ara\t2- Id ile Ara");
                                    adminChoice = scanner.nextLine();
                                    if (adminChoice.equals("1")) {
                                        String name = scanner.nextLine();
                                        filmManager.searchFilmByName(name);
                                    } else if (adminChoice.equals("2")) {
                                        String id_ = scanner.nextLine();
                                        filmManager.searchFilmById(id_);
                                    } else {
                                        System.out.println("Hatalı seçim yaptınız");
                                        break;
                                    }
                                    break;
                                case "7": // list films
                                    filmManager.listFilm();
                                    break;
                                case "8": // remove film
                                    System.out.print("Kullanıcı id' sini giriniz: ");
                                    String id_ = scanner.nextLine();
                                    if (filmManager.removeByID(id_)) System.out.println("İşlem Başarılı");
                                    else System.out.println("İşlem Başarısız");
                                    break;
                                case "9": // back
                                    break innerLoop;
                                case "10": // log out
                                    user = null;
                                    break innerLoop;
                            }
                        } // end-innerLoop

                    } else {
                        userInterface();
                        innerLoop2:
                        while (true) {
                            userChoice = scanner.nextLine();
                            switch (userChoice) {
                                case "1": // add film
                                    filmManager.newFilm();
                                    break;
                                case "2": // search film
                                    System.out.print("1- Film Adı ile Ara\t2- Id ile Ara");
                                    adminChoice = scanner.nextLine();
                                    if (adminChoice.equals("1")) {
                                        String name = scanner.nextLine();
                                        filmManager.searchFilmByName(name);
                                    } else if (adminChoice.equals("2")) {
                                        String id_ = scanner.nextLine();
                                        filmManager.searchFilmById(id_);
                                    } else {
                                        System.out.println("Hatalı seçim yaptınız");
                                        break;
                                    }
                                    break;
                                case "3": // list films
                                    filmManager.listFilm();
                                    break;
                                case "4": // remove film
                                    System.out.print("Kullanıcı id' sini giriniz: ");
                                    String id_ = scanner.nextLine();
                                    if (filmManager.removeByID(id_)) System.out.println("İşlem Başarılı");
                                    else System.out.println("İşlem Başarısız");
                                    break;
                                case "5": // back
                                    break innerLoop2;
                                case "6": // log out
                                    user = null;
                                    break innerLoop2;
                            }
                        }
                    }
                    break;
                case "3":
                    System.out.println("****** FILMLER ******");
                    filmManager.listFilm();
                    break;
            }
        } // end-outerLoop
    }

    public static void adminInterface() {
        System.out.println(
                "\t\t1- Kullanıcıları Listele\n" +
                        "\t\t2- Yeni Kullanıcı Oluştur\n" +
                        "\t\t3- Kullanıcı Sil\n" +
                        "\t\t4- Kullanıcı Ara\n" +
                        "\t\t5- Film Ekle\n" +
                        "\t\t6- Film Ara\n" +
                        "\t\t7- Filmleri Listele\n" +
                        "\t\t8- Film Sil\n" +
                        "\t\t9- Geri" +
                        "\t\t10- Çıkış Yap");
    }

    public static void userInterface() {
        System.out.println("\t\t1- Film Ekle\n" +
                "\t\t2- Film Ara\n" +
                "\t\t3- Filmleri Listele\n" +
                "\t\t4- Film Sil\n" +
                "\t\t5- Geri" +
                "\t\t6- Çıkış Yap");
    }
}