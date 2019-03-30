package education;

import java.time.LocalDate;

public class PrimaryEducation extends Education {
	
	public PrimaryEducation(LocalDate enrollmentDate, LocalDate graduationDate, String institutionName,
			float finalGrade) {
		super(enrollmentDate, graduationDate, institutionName, 'P');
	}
	
	public String getDegree() {
		return "primary";
	}
	
	@Override
	public boolean gotGraduated() {
		return this.isGraduated();
	}
}
