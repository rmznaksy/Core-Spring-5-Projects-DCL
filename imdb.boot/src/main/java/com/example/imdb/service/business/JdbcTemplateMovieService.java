package com.example.imdb.service.business;

import java.util.Collection;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.imdb.entity.Director;
import com.example.imdb.entity.Genre;
import com.example.imdb.entity.Movie;
import com.example.imdb.service.MovieService;
import com.example.imdb.viewmodel.CriteriaBean;

@Repository
@ConditionalOnProperty(name = "persistence.method", havingValue ="jdbc")
public class JdbcTemplateMovieService implements MovieService {
 private JdbcTemplate jdbcTemplate;
 
 public JdbcTemplateMovieService(JdbcTemplate jdbcTemplate) {
  super();
  this.jdbcTemplate = jdbcTemplate;
 }

 @Override
 public Movie findMovieById(int id) {
  // TODO Auto-generated method stub
  return null;
 }

 @Override
 public Collection<Movie> findAllMovies() {
	  // TODO Auto-generated method stub
	  return null;
	 }

 @Override
 public Collection<Movie> findAllMoviesByYearRange(int fromYear, int toYear) {
  // TODO Auto-generated method stub
  return null;
 }

 @Override
 public Collection<Movie> findAllMoviesByDirectorId(int directorId) {
  // TODO Auto-generated method stub
  return null;
 }

 @Override
 public Collection<Movie> findAllMoviesByYearRangeAndGenre(String genre, int fromYear, int toYear) {
  // TODO Auto-generated method stub
  return null;
 }

 @Override
 public Collection<Movie> findAllMoviesByGenre(String genre) {
	 return jdbcTemplate.query("""
			 select m.* from movies m, genres g, moviegenres mg
			 where m.movieID = mg.movieID
			   AND g.genreID = mg.genreID
			   AND g.description = '""" + genre + "'",
			 (rs,rowNum) ->
			      new Movie(rs.getInt("movieID"),
			        rs.getString("title"),
			        rs.getInt("year"),
			        rs.getString("imdb"))
			 );
 }

 @Override
 public Collection<Movie> findAllMoviesByCriteria(CriteriaBean criteria) {
  // TODO Auto-generated method stub
  return null;
 }

 @Override
 public Movie addMovie(Movie movie) {
  // TODO Auto-generated method stub
  return null;
 }

 @Override
 public Genre findGenreByName(String genre) {
  // TODO Auto-generated method stub
  return null;
 }
 
 @Override
 public Collection<Genre> findAllGenres() {
  return jdbcTemplate.query("select genreID, description from genres",
    (rs,rowNum) ->
  new Genre(rs.getInt("genreID"),rs.getString("description"))
  );
 }

 @Override
 public Collection<Director> findAllDirectors() {
  // TODO Auto-generated method stub
  return null;
 }

}