package com.skilldistillery.mvcfilmsite.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.mvcfilmsite.data.FilmDAO;
import com.skilldistillery.mvcfilmsite.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private FilmDAO filmDAO;

	@RequestMapping(path = { "/", "home.do" })
	public String home() {

		return "WEB-INF/home.jsp";
	}

	@RequestMapping(path = "getFilmData.do", method = RequestMethod.GET)
	public ModelAndView findFilmById(@RequestParam("id")int filmId) {
		ModelAndView MV = new ModelAndView();
		Film F = filmDAO.findFilmById(filmId);
		MV.addObject("film", F);
		MV.setViewName("WEB-INF/results.jsp");

		return MV;
	}
	
	@RequestMapping(path = "addFilm.do", method = RequestMethod.POST)
	public ModelAndView addFilm(@RequestParam("title")String title, @RequestParam("desc")String desc, @RequestParam("releaseYear")int releaseYear, @RequestParam("rating")String rating, @RequestParam("length")int length) {
		ModelAndView MV = new ModelAndView();
		Film F = new Film();
		F.setTitle(title);
		F.setDescription(desc);
		F.setReleaseYear(releaseYear);
		F.setRating(rating);
		F.setLength(length);
		F.setLanguage("english");
		F.setCategory("Romantic Comedy");
		F.setLanguageId(1);
		
		Film X = filmDAO.addFilm(F);
		MV.addObject("film", X);
		MV.setViewName("WEB-INF/filmAdded.jsp");

		return MV;
	}
	
	@RequestMapping(path = "deleteFilm.do", method = RequestMethod.POST)
	public ModelAndView deleteFilmById(@RequestParam("id")int filmId) {
		ModelAndView MV = new ModelAndView();
		Film F = filmDAO.findFilmById(filmId);
		boolean deleted = filmDAO.deleteFilm(F);
		MV.setViewName("WEB-INF/home.jsp");

		return MV;
	}
	
	@RequestMapping(path = "updateFilm.do", method = RequestMethod.POST)
	public ModelAndView updateFilm(@RequestParam("id")int filmId) {
		ModelAndView MV = new ModelAndView();
		Film F = filmDAO.findFilmById(filmId);
		MV.addObject(F);
		MV.setViewName("WEB-INF/updateFilm.jsp");
		return MV;
	}
	
	@RequestMapping(path = "updateFilmById.do", method = RequestMethod.POST)
	public ModelAndView updateFilmById(Film film) {
		ModelAndView MV = new ModelAndView();
		boolean updated = filmDAO.updateFilm(film);
		MV.setViewName("WEB-INF/home.jsp");
		return MV;
	}
	
	@RequestMapping(path = "findFilmByKeyword.do", method = RequestMethod.GET)
	public ModelAndView findFilmbyId(@RequestParam("keyword")String keyword) {
		ModelAndView MV = new ModelAndView();
		List<Film> F = filmDAO.findFilmsByKeyword(keyword);
		MV.addObject("filmList", F);
		MV.setViewName("WEB-INF/results.jsp");
		return MV;
	}
}
