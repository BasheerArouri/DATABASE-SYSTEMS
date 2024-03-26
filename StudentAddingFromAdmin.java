package application;

public class StudentAddingFromAdmin {
	
	int id;
	String name;
	String address;
	int tel;
	int mobile;
	String work;
	String gender;
	int typeOfTraning;
	
	///EXIST
	int t_number;
	int v_number;
	
	public StudentAddingFromAdmin(int id, String name, String address,String work, int tel, String gender, int mobile
			, int t_number, int v_number, int typeOfTraning) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.mobile = mobile;
		this.work = work;
		this.gender = gender;
		this.typeOfTraning = typeOfTraning;
		
	
		///default zero
		this.t_number = 1;
		this.v_number = 1;
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddrase() {
		return address;
	}
	public void setAddrase(String address) {
		this.address = address;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getTypeOfTraning() {
		return typeOfTraning;
	}
	public void setTypeOfTraning(int typeOfTraning) {
		this.typeOfTraning = typeOfTraning;
	}
	
//	public int getT_number() {
//		return t_number;
//	}
//	public void setT_number(int t_number) {
//		this.t_number = t_number;
//	}
//	public int getV_number() {
//		return v_number;
//	}
//	public void setV_number(int v_number) {
//		this.v_number = v_number;
//	}
//	public String getTybe_number() {
//		return tybe_number;
//	}
//	public void setTybe_number(String tybe_number) {
//		this.tybe_number = tybe_number;
//	}
	//@Override
//	public String toString() {
//		return "Student [id=" + id + ", name=" + name + ", addrase=" + address + ", tel=" + tel + ", mobile=" + mobile
//				+ ", work=" + work + ", gender=" + gender + ", typeOfTraning=" + typeOfTraning + ", t_number="
//				+ t_number + ", v_number=" + v_number + ", tybe_number=" + tybe_number + "]";
//	}
	
	
	
	
}
