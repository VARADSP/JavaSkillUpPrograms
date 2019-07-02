package day9_11.assignment1;

//POJO class
public class User {
	Integer userId;
	String name;
	String userRole;
	String address;
	String city;
	String salary;
	Long TelNumber;




	public User(Integer userId, String name, String userRole, String address, String city, String salary,
			Long telNumber) {
		super();
		this.userId = userId;
		this.name = name;
		this.userRole = userRole;
		this.address = address;
		this.city = city;
		this.salary = ""+Double.parseDouble(salary)+(12/100)*(Double.parseDouble(salary));
		TelNumber = telNumber;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", userRole=" + userRole + ", address=" + address
				+ ", city=" + city + ", salary=" + salary + ", TelNumber=" + TelNumber + "]";
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public Long getTelNumber() {
		return TelNumber;
	}
	public void setTelNumber(Long telNumber) {
		TelNumber = telNumber;
	}


}
