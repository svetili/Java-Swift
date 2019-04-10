package education;

import java.time.LocalDate;

public abstract class Education {
	private Degree degree;
	private boolean graduated;
	private LocalDate enrollmentDate;
	private LocalDate graduationDate;
	private String institutionName;

	public Education(LocalDate enrollmentDate, LocalDate graduationDate, String institutionName, Degree degree) {
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

	public Degree getDegree() {
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

	public String getDegreeString() {
		return String.format("%s", this.getDegree());
	}

	abstract public boolean gotGraduated() throws Exception;
}
