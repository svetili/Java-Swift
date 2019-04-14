package file;

import java.io.Serializable;
import java.time.LocalDate;

public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;
	private String title;
	private String director;
	private String[] actors;
	private LocalDate releaseDate;

	public Movie(String title, String director, String[] actors, LocalDate releaseDate) {
		super();
		this.title = title;
		this.director = director;
		this.actors = actors;
		this.releaseDate = releaseDate;
	}

	public String getTitle() {
		return title;
	}

	public String getDirector() {
		return director;
	}

	public String[] getActors() {
		return actors;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	@Override
	public String toString() {
		String s = String.format("Movie: %s\n", this.title);
		s += String.format("Director: %s\n", this.director);
		s += "Actors: \n";
		for (int i = 0; i < this.actors.length; i++) {
			s += "\t" + this.actors[i] + "\n";
		}
		s += String.format("Release date: %s", this.releaseDate);
		return s;
	}

}
