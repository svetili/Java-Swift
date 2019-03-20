package education;

import java.time.LocalDate;

public class SecondaryEducation {

	private double finalGrade;
	private boolean graduated;
	private LocalDate enrollmentDate;
	private LocalDate graduationDate;
	private String institutionName;


	public SecondaryEducation(String institutionName, LocalDate enrollmentDate, LocalDate graduationDate,
			double finalGrade) {
		this.institutionName = institutionName;
		this.enrollmentDate = enrollmentDate;
		this.graduationDate = graduationDate;
		this.finalGrade = finalGrade;
		if (finalGrade != -1) {
			this.graduated = true;
		} else {
			this.graduated = false;
		}
	}

	public double getFinalGrade() {
		return finalGrade;
	}
	
	public boolean getGraduated() {
		return graduated;
	}

	public void setFinalGrade(double grade) {
		if (grade > 3 && grade <= 6) {
			this.finalGrade = grade;
			this.graduated = true;
		}
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public LocalDate getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(LocalDate graduationDate) {
		this.graduationDate = graduationDate;
	}

	public String getInstitutionName() {
		return institutionName;
	}

}
