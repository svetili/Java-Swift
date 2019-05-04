package education;

import java.time.LocalDate;

public class PrimaryEducation extends Education {
	
	public PrimaryEducation(LocalDate enrollmentDate, LocalDate graduationDate, String institutionName,
			float finalGrade) {
		super(enrollmentDate, graduationDate, institutionName, Degree.Primary);
	}
	
	
	@Override
	public boolean gotGraduated() {
		return this.isGraduated();
	}
}
