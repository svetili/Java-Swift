package education;

import java.time.LocalDate;

public abstract class Education {
	private char degree;
	private boolean graduated;
	private LocalDate enrollmentDate;
	private LocalDate graduationDate;
	private String institutionName;
	
	public Education(LocalDate enrollmentDate, LocalDate graduationDate, String institutionName, char degree) {
		this.enrollmentDate = enrollmentDate;
		this.graduationDate = graduationDate;
		
		this.institutionName = institutionName;
		this.degree = degree;
		if (graduationDate.isBefore(LocalDate.now())) {
			this.graduated = true;
		} else {
			this.graduated = false;
		}
	}
	
	public boolean isGraduated() {
		return graduated;
	}
	
	public char getDegreeChar() {
		return degree;
	}

	
	public LocalDate getGraduationDate() {
		return graduationDate;
	}

	protected void setGraduationDate(LocalDate graduationDate) {
		this.graduationDate = graduationDate;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	abstract public String  getDegree(); 
	abstract public boolean gotGraduated() throws Exception;
}
