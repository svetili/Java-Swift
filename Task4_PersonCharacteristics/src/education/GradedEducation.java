package education;

import java.time.LocalDate;

public abstract class GradedEducation extends Education {

	private float finalGrade;

	public GradedEducation(LocalDate enrollmentDate, LocalDate graduationDate, String institutionName, char degree,
			float finalGrade) {
		super(enrollmentDate, graduationDate, institutionName, degree);
		this.finalGrade = finalGrade;
	}

	public float getFinalGrade() {
		if (this.isGraduated()) {
			return finalGrade;
		} else {
			return -1;
		}
	}

	// changed a little the condition because I don't understand what gotGraduated
	// should do ... so isGraduated check the time of graduation to be greater than
	// now and GotGraduate check if the FinalGrade is available.
	// This is used in printInfo for person to try to get the FinalGrade or not if not available

	@Override
	public boolean gotGraduated() {
		if (this.getFinalGrade() > 0) {
			return true;
		}
		return false;
	}

}
