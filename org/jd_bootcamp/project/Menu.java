package org.jd_bootcamp.project;

import org.jd_bootcamp.project.film.FilmManager;
import org.jd_bootcamp.project.user.User;
import org.jd_bootcamp.project.user.UserManager;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        FilmManager filmManager = new FilmManager();
        User user;

        User admin = new User("Zeynep", "Özdemir", "zeyn-app", "123456", "zeynepozdemir@gmail.com");
        userManager.addUser(admin);

        filmManager.initFilms();
        userManager.initUsers();

        System.out.println();
        Scanner scanner = new Scanner(System.in);

        String choice;

        outerLoop:
        while (true) {
            System.out.println("1- Kayıt Ol\n2- Giriş Yap\n3- Filmleri İncele");
            System.out.print("İşleminiz: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    userManager.createAccount();
                case "2":
                    user = userManager.login();
                    if(user == null){
                        System.out.println("\t\tBöyle bir kullanıcı bulunamadı.\n\n");
                        break;
                    }
                    System.out.println();

                    if (user.equals(admin)) {
                        adminInterface();

                        innerLoop:
                        while (true) {
                            System.out.print("İşleminiz: ");
                            choice = scanner.nextLine();
                            switch (choice) {
                                case "1": // list users
                                    userManager.listUsers();
                                    break;
                                case "2": // add new user
                                    userManager.createAccount();
                                    break;
                                case "3": // remove user
                                    userManager.removeAccount();
                                    break;
                                case "4": // search user
                                    System.out.println("1- İsim Soyisim ile Ara\t\t2- Id ile Ara");
                                    System.out.print("İşleminiz: ");
                                    choice = scanner.nextLine();
                                    if (choice.equals("1")) {
                                        userManager.searchAccountByName();
                                    } else if (choice.equals("2")) {
                                        userManager.searchAccountById();
                                    } else {
                                        System.out.println("Hatalı seçim yaptınız");
                                        break;
                                    }
                                    break;
                                case "5": // add film
                                    filmManager.newFilm();
                                    break;
                                case "6": // search film
                                    System.out.println("1- Film Adı ile Ara\t\t2- Id ile Ara");
                                    System.out.print("İşleminiz: ");
                                    choice = scanner.nextLine();
                                    if (choice.equals("1")) {
                                        filmManager.searchFilmByName();
                                    } else if (choice.equals("2")) {
                                        filmManager.searchFilmById();
                                    } else {
                                        System.out.println("Hatalı seçim yaptınız");
                                        break;
                                    }
                                    break;
                                case "7": // list films
                                    filmManager.listFilm();
                                    break;
                                case "8": // remove film
                                    filmManager.remove();
                                    break;
                                case "9": // log out
                                    System.out.println();
                                    break innerLoop;
                                case "10": // terminate
                                    System.out.println(".........Program Sonlandırıldı.........");
                                    break outerLoop;
                                default:
                                    System.out.println("Hatalı seçim yaptınız");
                                    break;
                            }
                        } // end-innerLoop

                    } else {
                        userInterface();
                        innerLoop2:
                        while (true) {
                            System.out.print("İşleminiz: ");
                            choice = scanner.nextLine();
                            switch (choice) {
                                case "1": // add film
                                    filmManager.newFilm();
                                    break;
                                case "2": // search film
                                    System.out.println("1- Film Adı ile Ara\t\t2- Id ile Ara");
                                    System.out.print("İşleminiz: ");
                                    choice = scanner.nextLine();
                                    if (choice.equals("1")) {
                                        filmManager.searchFilmByName();
                                    } else if (choice.equals("2")) {
                                        filmManager.searchFilmById();
                                    } else {
                                        System.out.println("Hatalı seçim yaptınız");
                                        break;
                                    }
                                    break;
                                case "3": // list films
                                    filmManager.listFilm();
                                    break;
                                case "4": // remove film
                                    filmManager.remove();
                                    break;
                                case "5": // log out
                                    System.out.println();
                                    break innerLoop2;
                                case "6": // terminate
                                    System.out.println(".........Program Sonlandırıldı.........");
                                    break outerLoop;
                                default:
                                    System.out.println("Hatalı seçim yaptınız");
                                    break;
                            }
                        }
                    }
                    break;
                case "3":
                    System.out.println("****** FILMLER ******");
                    filmManager.listFilm();
                    break;
                default:
                    System.out.println("Hatalı seçim yaptınız");
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
                        "\t\t9- Çıkış Yap\n" +
                        "\t\t10- Programı Sonlandır\n");
    }

    public static void userInterface() {
        System.out.println("\t\t1- Film Ekle\n" +
                "\t\t2- Film Ara\n" +
                "\t\t3- Filmleri Listele\n" +
                "\t\t4- Film Sil\n" +
                "\t\t5- Çıkış Yap\n" +
                "\t\t6- Programı Sonlandır\n");
    }
}