package education;

import java.time.LocalDate;

public abstract class GradedEducation extends Education {

	private float finalGrade;

	public GradedEducation(LocalDate enrollmentDate, LocalDate graduationDate, String institutionName, Degree degree,
			float finalGrade) {
		super(enrollmentDate, graduationDate, institutionName, degree);
		this.finalGrade = finalGrade;
	}

	public float getFinalGrade() throws Exception {
		if (this.isGraduated()) {
			return finalGrade;
		} else {
			throw new Exception("No final grade can be provided before graduation.");
		}
	}

	// changed a little the condition because I don't understand what gotGraduated
	// should do ... so isGraduated check the time of graduation to be before
	// now and GotGraduated check if the FinalGrade is available.
	// This is used in Person.toString() to try to get the FinalGrade or not if not available

	@Override
	public boolean gotGraduated() throws Exception {
		if (this.getFinalGrade() > 0) {
			return true;
		}
		return false;
	}

}
