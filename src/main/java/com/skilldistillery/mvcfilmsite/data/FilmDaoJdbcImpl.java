package com.skilldistillery.mvcfilmsite.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.mvcfilmsite.entities.Actor;
import com.skilldistillery.mvcfilmsite.entities.Film;

public class FilmDaoJdbcImpl implements FilmDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private String user = "student";
	private String pass = "student";
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver not found.");
			throw new RuntimeException("Unable to load MySQL driver class");
		}

	}

	@Override
	public Film findFilmById(int filmId) {
//		Implement the findFilmById method that takes an int film ID, and returns 
//		a Film object (or null, if the film ID returns no data.)
		try {
			String sqltext = "SELECT * FROM film WHERE id = ?";
			conn = DriverManager.getConnection(URL, user, pass);
			stmt = conn.prepareStatement(sqltext);
			stmt.setInt(1, filmId);
			rs = stmt.executeQuery();

			int lang = 0;
			Film newFilm = null;
			if (rs.next()) {
				// change to robs way using setters latter.
				newFilm = new Film(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
						rs.getInt("release_year"), lang = rs.getInt("language_id"), rs.getInt("rental_duration"),
						rs.getDouble("rental_rate"), rs.getInt("length"), rs.getDouble("replacement_cost"),
						rs.getString("rating"), rs.getString("special_features"), findActorsByFilmId(filmId),
						findLanguageByLanguageId(lang), findCategoryByFilmId(filmId));
			}

			return newFilm;

		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				} // Not needed, stmt.close() will close it; but good practice
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.err.println(sqle);
			}
		}
		return null;
	}

	@Override
	public String findLanguageByLanguageId(int langId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sqltext = "SELECT * From Language WHERE id = ?";
			conn = DriverManager.getConnection(URL, user, pass);
			stmt = conn.prepareStatement(sqltext);
			stmt.setInt(1, langId);
			rs = stmt.executeQuery();

			rs.next();
			return rs.getString("name");

		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				} // Not needed, stmt.close() will close it; but good practice
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.err.println(sqle);
			}
		}
		return null;

	}

	@Override
	public Actor findActorById(int actorId) {
//		Implement findActorById method that takes an int actor ID, and returns an Actor object (or null, if the actor ID returns no data.)
		try {
			String sqltext = "SELECT * FROM actor WHERE id = ?";
			conn = DriverManager.getConnection(URL, user, pass);
			stmt = conn.prepareStatement(sqltext);
			stmt.setInt(1, actorId);
			rs = stmt.executeQuery();

			rs.next();
//			Actor(int id, String first_name, String last_name)
			return new Actor(rs.getInt("Id"), rs.getString("first_name"), rs.getString("last_name"));

		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				} // Not needed, stmt.close() will close it; but good practice
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.err.println(sqle);
			}
		}
		return null;

	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
//		Implement findActorsByFilmId with an appropriate List implementation that will be populated using a ResultSet and returned.
//		Make sure your JDBC code uses PreparedStatement with bind variables instead of concatenating values into SQL strings.
//		SELECT a.first_name, a.last_name, f.id FROM actor a JOIN film_actor ON a.id = fa.actor_id JOIN film f ON fa.film_id = f.id WHERE f.id = ? ORDER BY f.title;
		try {
			List<Actor> actorList = new ArrayList<Actor>();
			String sqltext = "SELECT a.id,  a.first_name, a.last_name, f.id FROM actor a JOIN film_actor fa ON a.id = fa.actor_id JOIN film f ON fa.film_id = f.id WHERE f.id = ? ORDER BY f.title";
			conn = DriverManager.getConnection(URL, user, pass);
			stmt = conn.prepareStatement(sqltext);
			stmt.setInt(1, filmId);
			rs = stmt.executeQuery();

			while (rs.next()) {
				actorList.add(new Actor(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name")));
			}
			return actorList;

		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				} // Not needed, stmt.close() will close it; but good practice
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.err.println(sqle);
			}
		}
		return null;
	}

	@Override
	public List<Film> findFilmsByKeyword(String string) {
		try {
			Film film = null;
			List<Film> filmList = new ArrayList<Film>();
			String sqltext = "SELECT * From film WHERE description LIKE ? or title LIKE ?";
			conn = DriverManager.getConnection(URL, user, pass);
			stmt = conn.prepareStatement(sqltext);
			stmt.setString(1, "%" + string + "%");
			stmt.setString(2, "%" + string + "%");
			ResultSet rs = stmt.executeQuery();
			int count = 0;
			int id = 0;
			while (rs.next()) {
				film = new Film();
				film.setId(id = rs.getInt("id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setLanguageId(rs.getInt("language_id"));
				film.setRentalDuration(rs.getInt("rental_duration"));
				film.setRentalRate(rs.getInt("rental_rate"));
				film.setLength(rs.getInt("length"));
				film.setReplacementCost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				film.setSpecialFeatures(rs.getString("special_features"));
				film.setActorList(findActorsByFilmId(id));
				film.setLanguage(findLanguageByLanguageId(id));
				film.setCategory(findCategoryByFilmId(id));
				filmList.add(film);
				
				count++;
			}
			System.out.println(count);
			return filmList;

		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.err.println(sqle);
			}
		}
		return null;
	}

	public String findCategoryByFilmId(int filmId) {
		String category = "";
		try {
			String sqltext = "SELECT f.id,  c.name FROM category c JOIN film_category fc ON c.id = fc.category_id JOIN film f ON fc.film_id = f.id WHERE f.id = ? ORDER BY f.title";
			conn = DriverManager.getConnection(URL, user, pass);
			stmt = conn.prepareStatement(sqltext);
			stmt.setInt(1, filmId);
			rs = stmt.executeQuery();

			if (rs.next()) {
				System.out.println("here");
				category = rs.getString("name");
			} else {
				category = "No category listed for selected film.";
			}

			return category;

		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				} // Not needed, stmt.close() will close it; but good practice
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.err.println(sqle);
			}
		}
		return category;
	}

	@Override
	public Film addFilm(Film film) {
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "INSERT INTO film " + " (title, description, release_year, rating, length, language_id) "
			// TODO: Add the rest of the film properties
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setString(4, film.getRating());
			stmt.setInt(5, film.getLength());
			stmt.setInt(6, film.getLanguageId());

			conn.setAutoCommit(false);
			int updateCount = stmt.executeUpdate();

			if (updateCount != 1) {
				System.out.println("Boooooo, something went el wrongo!");
				conn.rollback();
			} else {
				// 5) display result(s)
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					film.setId(keys.getInt(1));
					System.out.println("Id: " + keys.getInt(1));
					keys.close();
				}
			}
			// 6) done! Huzzah!
			conn.commit();

			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			film = null;
		}

		return film;
	}

	public boolean deleteFilm(Film f) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "DELETE FROM film WHERE id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, f.getId());
			int updateCount = stmt.executeUpdate();

			if (updateCount != 1) {
				System.out.println("Somthing went big wrong!");
				conn.rollback();
			} else {
				System.out.println("Delete Successful!");
			}

			conn.commit(); // COMMIT TRANSACTION
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;
	}

	public boolean updateFilm(Film film) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);

			conn.setAutoCommit(false); // START TRANSACTION

			String sql = "UPDATE film SET title=?, description=?, release_year=?, language_id =?, rental_duration=?, rental_rate=?, length=?, replacement_cost=?, rating=?, special_features=? "
		               + " WHERE id=?";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getLanguageId());
			stmt.setInt(5, film.getRentalDuration());
			stmt.setDouble(6, film.getRentalRate());
			stmt.setInt(7, film.getLength());
			stmt.setDouble(8, film.getReplacementCost());
			stmt.setString(9, film.getRating());
			stmt.setString(10, film.getSpecialFeatures());
			stmt.setInt(11, film.getId());
				
			System.out.println(stmt);
			int updateCount = stmt.executeUpdate();

			if (updateCount == 1) {
				// Replace actor's film list
				System.out.println("Film Updated");

				conn.commit(); // COMMIT TRANSACTION
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} // ROLLBACK TRANSACTION ON ERROR
				catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;
	}
}
