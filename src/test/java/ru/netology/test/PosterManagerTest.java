package ru.netology.test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmPoster;
import ru.netology.manager.PosterManager;


public class PosterManagerTest {
    FilmPoster poster1 = new FilmPoster(1, "Хищник");
    FilmPoster poster2 = new FilmPoster(2, "Рэмбо");
    FilmPoster poster3 = new FilmPoster(3, "Ярость");
    FilmPoster poster4 = new FilmPoster(4, "Спартак");
    FilmPoster poster5 = new FilmPoster(5, "Спартак");
    FilmPoster poster6 = new FilmPoster(6, "Противостояние");
    FilmPoster poster7 = new FilmPoster(7, "Мажор");
    FilmPoster poster8 = new FilmPoster(8, "Враг у ворот");

    @Test
    void shouldAdd() {
        PosterManager manage = new PosterManager();
        manage.add(poster1);
        manage.add(poster2);
        manage.add(poster3);

        FilmPoster[] expected = {poster1, poster2, poster3};
        FilmPoster[] actual = manage.getPosters();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAll(){
        PosterManager manage = new PosterManager();
        manage.add(poster1, poster2, poster3, poster4, poster5, poster6,poster7, poster8);

        FilmPoster[] expected = {poster1, poster2, poster3, poster4, poster5, poster6,poster7, poster8};
        FilmPoster[] actual = manage.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindLastNoArgs(){
        PosterManager manage = new PosterManager();
        manage.add(poster1, poster2, poster3, poster4, poster5, poster6,poster7, poster8);

        FilmPoster[] expected = {poster8, poster7, poster6, poster5, poster4};
        FilmPoster[] actual = manage.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    void shouldFindLast(){
        PosterManager manage = new PosterManager(6);
        manage.add(poster1, poster2, poster3, poster4, poster5, poster6,poster7, poster8);

        FilmPoster[] expected = {poster8, poster7, poster6, poster5, poster4, poster3};
        FilmPoster[] actual = manage.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    void shouldFindLastWithLesserPosters(){
        PosterManager manage = new PosterManager(6);
        manage.add(poster1, poster2, poster3);

        FilmPoster[] expected = {poster3, poster2, poster1};
        FilmPoster[] actual = manage.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

}
