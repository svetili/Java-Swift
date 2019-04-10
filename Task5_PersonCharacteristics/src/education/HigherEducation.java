package education;

import java.time.LocalDate;

public class HigherEducation extends GradedEducation {
	public HigherEducation(LocalDate enrollmentDate, LocalDate graduationDate, String institutionName, Degree degree,
			float finalGrade) {
		super(enrollmentDate, graduationDate, institutionName, degree, finalGrade);
	}

}
