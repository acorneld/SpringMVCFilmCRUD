package com.skilldistillery.mvcfilmsite.data;
import java.util.List;

import com.skilldistillery.mvcfilmsite.entities.Actor;
import com.skilldistillery.mvcfilmsite.entities.Film;

public interface FilmDAO {
	public Film findFilmById(int filmId);

	public Actor findActorById(int actorId);

	public List<Actor> findActorsByFilmId(int filmId);

	public List<Film> findFilmsByKeyword(String string);

	public String findLanguageByLanguageId(int langId);
	
	public Film addFilm(Film f);
	
	public boolean deleteFilm(Film f);
	
	public boolean updateFilm(Film f);
}

