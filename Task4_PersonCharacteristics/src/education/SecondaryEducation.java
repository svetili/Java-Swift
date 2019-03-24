package education;

import java.time.LocalDate;

public class SecondaryEducation extends GradedEducation {

	public SecondaryEducation(LocalDate enrollmentDate, LocalDate graduationDate, String institutionName,
			float finalGrade) {
		super(enrollmentDate, graduationDate, institutionName, 'S', finalGrade);
	}
	
	public String getDegree() {
		return "secondary";
	}
}
