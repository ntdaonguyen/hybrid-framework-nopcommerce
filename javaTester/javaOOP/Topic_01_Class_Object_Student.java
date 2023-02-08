package javaOOP;

public class Topic_01_Class_Object_Student {
	public int studentID;
	private String studentName;
	private float knowledgePoint;
	private float practicePoint;
	
	private int getStudentID() {
		return studentID;
	}

	private void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	private String getStudentName() {
		return studentName;
	}

	private void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	private float getKnowledgePoint() {
		return knowledgePoint;
	}

	private void setKnowledgePoint(float knowledgePoint) {
		this.knowledgePoint = knowledgePoint;
	}

	private float getPracticePoint() {
		return practicePoint;
	}

	private void setPracticePoint(float practicePoint) {
		this.practicePoint = practicePoint;
	}

	private float getAveragePoint() {
		return(this.knowledgePoint + this.practicePoint * 2)/3;
	}
	
	private void showStudentInfor() {
		System.out.println("*******************");
		System.out.println("Student ID = " + getStudentID());
		System.out.println("Student Name = " + getStudentName());
		System.out.println("Student's knowledge point = " + getKnowledgePoint());
		System.out.println("Student's practice point = " + getPracticePoint());
		System.out.println("Student's average point = " + getAveragePoint());
	}
	
	public static void main(String[] args) {
		Topic_01_Class_Object_Student firstStudent = new Topic_01_Class_Object_Student();
		firstStudent.setStudentID(123456);
		firstStudent.setStudentName("Harry");
		firstStudent.setKnowledgePoint(7.5f);
		firstStudent.setPracticePoint(8.5f);
		firstStudent.showStudentInfor();
	}
}
