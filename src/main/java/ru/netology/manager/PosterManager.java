package ru.netology.manager;


import ru.netology.domain.FilmPoster;

public class PosterManager {
    private int maxPosters;

    private FilmPoster[] posters = new FilmPoster[0];


    public PosterManager() {
        this(5);
    }

    public PosterManager(int maxPosters) {
        this.maxPosters = maxPosters;
    }

    public void add(FilmPoster... posters) {
        FilmPoster[] tmp = new FilmPoster[this.posters.length + posters.length];
        for (int i = 0; i < this.posters.length; i++) {
            tmp[i] = this.posters[i];
        }
        for (int i = 0; i < posters.length; i++) {
            tmp[this.posters.length + i] = posters[i];
        }
        this.posters = tmp;
    }

    public FilmPoster[] findAll() {
        return posters;
    }

    public FilmPoster[] findLast() {
        int resultLength = Math.min(maxPosters, posters.length);
        FilmPoster[] lastReversed = new FilmPoster[resultLength];
        for (int i = 0; i < resultLength; i++) {
            lastReversed[i] = posters[posters.length - 1 - i];
        }
        return lastReversed;
    }
}
