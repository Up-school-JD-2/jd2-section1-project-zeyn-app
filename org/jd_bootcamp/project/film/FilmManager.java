package org.jd_bootcamp.project.film;

import java.util.*;

public class FilmManager {
    private final List<Film> films = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void add(Film film) {
        films.add(film);
    }

    public void newFilm() {
        System.out.println("\n\t\t****** Film Ekle ******");

        String actor;
        List<String> actors = new ArrayList<>();

        System.out.print("\t\tFilm Adı: ");
        String title = scanner.nextLine();
        System.out.print("\t\tYönetmen: ");
        String director = scanner.nextLine();

        System.out.print("\t\tOyuncu sayısını giriniz: ");
        int countOfActors = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < countOfActors; i++) {
            System.out.print("\t\t" + (i + 1) + ". oyuncu Adı: ");
            actor = scanner.nextLine();
            actors.add(actor);
        }

        System.out.print("\t\tYıl: ");
        String year = scanner.nextLine();
        System.out.print("\t\tAçıklama: ");
        String description = scanner.nextLine();
        System.out.print("\t\tType: (HISTORY, DRAMA, CRIME, ACTION, ADVENTURE, SCI_FI, BIOGRAPHY, WESTERN, OTHER)");
        String type = scanner.nextLine();
        FilmType fType = null;

        for (FilmType filmType : FilmType.values()) {
            if (type.equalsIgnoreCase(filmType.toString())) {
                fType = filmType;
                break;
            }
        }

        Film film = new Film(title, director, actors, year, description, fType);
        films.add(film);

        System.out.println("\t\t***********************\n");
    }

    public void listFilm() {
        if(films.isEmpty()) {
            System.out.println("\n\t\tHerhangi Bir Kayıt Bulunamadı.\n");
            return;
        }
        System.out.println("\n========================================================================= " +
                "FİLMLER " +
                "=========================================================================");
        for (Film film : films) {
            System.out.println(film.toString());
        }
        System.out.println("============================================================================" +
                "=====================================================================================\n");
    }

    public void remove() {
        System.out.print("Film id' sini giriniz: ");
        String id = scanner.nextLine();
        for (Film film : films) {
            if (film.getId().equals(id)) {
                films.remove(film);
                System.out.println("İşlem Başarılı");
                return;
            }
        }
        System.out.println("İşlem Başarısız");
    }

    public void searchFilmByName() {
        System.out.print("Film Adını Giriniz: ");
        String name = scanner.nextLine();
        for (Film film : films) {
            if (film.getTitle().contains(name)) {
                System.out.println("\n" + film + "\n");
                return;
            }
        }
        System.out.println("Aradığınız Film Bulunamadı\n");
    }

    public void searchFilmById() {
        System.out.print("Film Id Giriniz: ");
        String id = scanner.nextLine();
        for (Film film : films) {
            if (film.getId().equals(id)) {
                System.out.println("\n" + film + "\n");
                return;
            }
        }
        System.out.println("Aradığınız Film Bulunamadı\n");
    }

    public void initFilms() {
        List<String> actors1 = new ArrayList<>();
        actors1.add("Tim Robbins");
        actors1.add("Morgan Freeman");
        actors1.add("Bob Gunton");
        actors1.add("William Sadler");
        Film film1 = new Film("The Shawshank Redemption", "Frank Darabont", actors1, "1994", "Over the course of several years, two convicts form a friendship, seeking consolation and, eventually, redemption through basic compassion.", FilmType.DRAMA);
        film1.setId(UUID.randomUUID().toString());

        List<String> actors2 = new ArrayList<>();
        actors2.add("Al Pacino");
        actors2.add("Marlon Brando");
        actors2.add("James Caan");
        actors2.add("Diane Keaton");
        Film film2 = new Film("The Godfather", "Francis Ford Coppola", actors2, "1972", "The aging patriarch of an organized crime dynasty in postwar New York City transfers control of his clandestine empire to his reluctant youngest son.", FilmType.CRIME);
        film2.setId(UUID.randomUUID().toString());

        List<String> actors3 = new ArrayList<>();
        actors3.add("Christian Bale");
        actors3.add("Heath Ledger");
        actors3.add("Aaron Eckhart");
        actors3.add("Michael Caine");
        Film film3 = new Film("The Dark Knight", "Christopher Nolan", actors3, "2008", "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.", FilmType.ACTION);
        film3.setId(UUID.randomUUID().toString());

        List<String> actors4 = new ArrayList<>();
        actors4.add("Liam Neeson");
        actors4.add("Ralph Fiennes");
        actors4.add("Ben Kingsley");
        actors4.add("Caroline Goodall");
        Film film4 = new Film("Schindler's List", "Steven Spielberg", actors4, "1993", "In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.", FilmType.BIOGRAPHY);
        film4.setId(UUID.randomUUID().toString());

        List<String> actors5 = new ArrayList<>();
        actors5.add("Henry Fonda");
        actors5.add("Lee J. Cobb");
        actors5.add("Martin Baslam");
        actors5.add("John Fiedler");
        Film film5 = new Film("12 Angry Men", "Sidney Lumet", actors5, "1957", "he jury in a New York City murder trial is frustrated by a single member whose skeptical caution forces them to more carefully consider the evidence before jumping to a hasty verdict.", FilmType.CRIME);
        film5.setId(UUID.randomUUID().toString());

        List<String> actors6 = new ArrayList<>();
        actors6.add("Leonardo DiCaprio");
        actors6.add("Joseph Gordon-Levitt");
        actors6.add("Elliot Page");
        actors6.add("Ken Watanabe");
        Film film6 = new Film("Inception", "Christopher Nolan", actors6, "2010", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.", FilmType.SCI_FI);
        film6.setId(UUID.randomUUID().toString());

        List<String> actors7 = new ArrayList<>();
        actors7.add("Clint Eastwood");
        actors7.add("Eli Wallach");
        actors7.add("Lee Van Cleef");
        actors7.add("Aldo Giuffrè");
        Film film7 = new Film("The Good, the Bad and the Ugly", "Sergio Leone", actors7, "1966", "A bounty hunting scam joins two men in an uneasy alliance against a third in a race to find a fortune in gold buried in a remote cemetery.", FilmType.WESTERN);
        film7.setId(UUID.randomUUID().toString());

        List<String> actors8 = new ArrayList<>();
        actors8.add("Keanu Reeves");
        actors8.add("Laurence Fishburne");
        actors8.add("Carrie-Anne Moss");
        actors8.add(" Hugo Weaving");
        Film film8 = new Film("Matrix", "Lana-Lilly Wachowsk", actors8, "1999", " When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence.", FilmType.ACTION);
        film8.setId(UUID.randomUUID().toString());


        List<String> actors9 = new ArrayList<>();
        actors9.add("Michael J. Fox");
        actors9.add("Christopher Lloyd");
        actors9.add("Lea Thompson");
        actors9.add("Crispin Glover");
        Film film9 = new Film("Back to the Future", "Robert Zemeckis", actors9, "1985", "Marty McFly, a 17-year-old high school student, is accidentally sent 30 years into the past in a time-traveling DeLorean invented by his close friend, the maverick scientist Doc Brown.", FilmType.ADVENTURE);
        film9.setId(UUID.randomUUID().toString());

        films.add(film1);
        films.add(film2);
        films.add(film3);
        films.add(film4);
        films.add(film5);
        films.add(film6);
        films.add(film7);
        films.add(film8);
        films.add(film9);
    }
}