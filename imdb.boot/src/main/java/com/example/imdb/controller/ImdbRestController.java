package com.example.imdb.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.imdb.entity.Director;
import com.example.imdb.entity.Genre;
import com.example.imdb.entity.Movie;
import com.example.imdb.service.MovieService;

@RestController
@RequestScope
// http(s)://localhost:8100/imdb/api/v1/movies
@CrossOrigin("*")
public class ImdbRestController {
	private MovieService movieService;

	public ImdbRestController(MovieService movieService) {
		this.movieService = movieService;
	}

	// GET http://localhost:8100/imdb/api/v1/genres
	@GetMapping(value = "/genres")
	public Collection<Genre> getAllGenres() {
		return movieService.findAllGenres();
	}

	// GET http://localhost:8100/imdb/api/v1/movies?genre=Drama
	@GetMapping("movies")
	public Collection<Movie> getMoviesByGenre(@RequestParam String genre) {
		return movieService.findAllMoviesByGenre(genre);
	}
	
	// GET http://localhost:8100/imdb/api/v1/directors
	@GetMapping("directors")
	public Collection<Director> getAllDirectors() {
		return movieService.findAllDirectors();
	}
}