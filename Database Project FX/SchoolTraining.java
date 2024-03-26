package application;

import java.util.ArrayList;

public class SchoolTraining implements Functions {
	ArrayList<StudentAddingFromAdmin> student = new ArrayList<>();

	public SchoolTraining(ArrayList<StudentAddingFromAdmin> student) {
		super();
		this.student = student;
	}
	
	@Override
	public StudentAddingFromAdmin searchStudent(int id) {
		for(int i=0 ; i<student.size();i++) {
			if(id == student.get(i).getId()) {
				return student.get(i);
			}
		}
		return null;
	}
	
	
@Override
public boolean isTheStudentExist (int cosId, String cosName, String cosAddrase, int cosMobile, int cosTel, String cosWorking, String cosGender, int costybeT) {

	
	
	int flag = 0;
	for(int i = 0; i < student.size(); i++) {
		if(student.get(i).getId() == cosId) {
			flag = 1;
			return false;
		}
	}
	
	if (flag == 0) {
	
		StudentAddingFromAdmin newStudent = new StudentAddingFromAdmin(cosId, cosName, cosAddrase, cosWorking, cosTel, cosGender, cosMobile, 0, 0, costybeT);
		student.add(newStudent);
	}
	return true;
} 
			
}

