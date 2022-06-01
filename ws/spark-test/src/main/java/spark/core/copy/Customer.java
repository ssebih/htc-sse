package spark.core.copy;

import java.io.Serializable;

public class Customer implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
//	Education level : Graduate Degree a un chiffre d'affaires : 284358.7000000002
//	Education level : High School Degree a un chiffre d'affaires : 1614680.6999999923
//	Education level : Partial College a un chiffre d'affaires : 506574.38000000064
//	Education level : Bachelors Degree a un chiffre d'affaires : 1394302.7699999944
//	Education level : Partial High School a un chiffre d'affaires : 1650653.7099999934
	private Integer customerId;
	private Long customerTime;
    private String  lName ;
    private String fName;
    private String mi;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String city;
    private String stateProvince;
    private int  postalCode;
    private  String country;
    private int customerRegionId;
    private String phone1;
    private String phone2;
    private String  birthdate;
    private String maritalStatus;
    private  String  yearlyIncome;
    private String  gender;
    private int totalChildren;
    private int  numChildrenAtHome;
    private String education;
    private String dateAccountPpened;
    private String  memberCard;
    private String occupation;
    private boolean  houseOwner;
    private int numCarsOwned;
    private String fullName;

	

	public static Customer parse(String csvLine) {
		Customer cu = new Customer();
		String[] column = csvLine.split(";");
		cu.setCustomerId(Integer.parseInt(column[0]));
		cu.setEducation(column[22]);

		return cu;

	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Customer [graduate=" + education + ", customerRegionId=" + customerId + "]";
	}

}
