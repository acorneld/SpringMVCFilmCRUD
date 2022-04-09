package com.skilldistillery.mvcfilmsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.mvcfilmsite.data.FilmDAO;
import com.skilldistillery.mvcfilmsite.data.FilmDaoJdbcImpl;
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

//	@RequestMapping(path="GetStateData.do",params="name", method= RequestMethod.GET)
//	public ModelAndView getByStateName(@RequestParam("name")String name) {
//		ModelAndView MV = new ModelAndView();
//		MV.setViewName("WEB-INF/result.jsp");
//		MV.addObject("state",statedao.getStateByName(name));
//		return MV;
//		
//	}
}
