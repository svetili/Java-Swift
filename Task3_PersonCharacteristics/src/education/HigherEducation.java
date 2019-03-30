package education;

import java.time.LocalDate;

public class HigherEducation extends GradedEducation {
	public HigherEducation(LocalDate enrollmentDate, LocalDate graduationDate, String institutionName, char degree,
			float finalGrade) {
		super(enrollmentDate, graduationDate, institutionName, degree, finalGrade);
	}

	public String getDegree() {
		switch(this.getDegreeChar()) {
		case 'B': return "bachelor";
		case 'M': return "master";
		case 'D': return "doctor";
		default: return "";
		}
	}
}
