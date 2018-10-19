package edu.georgiasouthern.dsteamyellow.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Date;
public class NorthwindTableDefinitions {
	
	@DatabaseTable(tableName="categories")
	static class Category{
		@DatabaseField(id=true)
		private int CategoryID;
		@DatabaseField(canBeNull=false)
		private String CategoryName;
		@DatabaseField(canBeNull=true)
		private String Description;
		
		public Category() {
			
		}
		
		public int getCategoryID() {
			return CategoryID;
		}
		public void setCategoryID(int categoryID) {
			CategoryID = categoryID;
		}
		public String getCategoryName() {
			return CategoryName;
		}
		public void setCategoryName(String categoryName) {
			CategoryName = categoryName;
		}
		public String getDescription() {
			return Description;
		}
		public void setDescription(String description) {
			Description = description;
		}
		
	}
	
	@DatabaseTable(tableName="OrderView")
	public static class OrderView{
		@DatabaseField(canBeNull=false)
		private int OrderID;
		@DatabaseField(canBeNull=true)
		private String contactName;
		@DatabaseField(canBeNull=true)
		private Date RequiredDate;
		@DatabaseField(canBeNull=false)
		private String CompanyName;
		
		public int getOrderID() {
			return OrderID;
		}

		public void setOrderID(int orderID) {
			OrderID = orderID;
		}

		public String getContactName() {
			return contactName;
		}

		public void setContactName(String contactName) {
			this.contactName = contactName;
		}

		public Date getRequiredDate() {
			return RequiredDate;
		}

		public void setRequiredDate(Date requiredDate) {
			RequiredDate = requiredDate;
		}

		public String getCompanyName() {
			return CompanyName;
		}

		public void setCompanyName(String companyName) {
			CompanyName = companyName;
		}

		public OrderView() {
			
		}
	}
	
	@DatabaseTable(tableName="OrderDetailsView")
	public static class OrderDetailsView{
		
		@DatabaseField(canBeNull=false)
		public int OrderID;
		@DatabaseField(canBeNull=true)
		public String ShipAddress;
		@DatabaseField(canBeNull=true)
		public String ShipPostal;
		@DatabaseField(canBeNull=false)
		public String CustomerID;
		@DatabaseField(canBeNull=true)
		public String ContactName;
		@DatabaseField(canBeNull=true)
		public float TotalPrice;
		
		public int getOrderID() {
			return OrderID;
		}

		public void setOrderID(int orderID) {
			OrderID = orderID;
		}

		public String getShipAddress() {
			return ShipAddress;
		}

		public void setShipAddress(String shipAddress) {
			ShipAddress = shipAddress;
		}

		public String getShipPostal() {
			return ShipPostal;
		}

		public void setShipPostal(String shipPostal) {
			ShipPostal = shipPostal;
		}

		public String getCustomerID() {
			return CustomerID;
		}

		public void setCustomerID(String customerID) {
			CustomerID = customerID;
		}

		public String getContactName() {
			return ContactName;
		}

		public void setContactName(String contactName) {
			ContactName = contactName;
		}

		public float getTotalPrice() {
			return TotalPrice;
		}

		public void setTotalPrice(float totalPrice) {
			TotalPrice = totalPrice;
		}

		public OrderDetailsView() {
			
		}
	}
	
//	@DatabaseTable(tableName="Employees")
//	public class Employee{
//		@DatabaseField(id=true,canBeNull=false)
//		private int EmployeeID;
//		@DatabaseField(canBeNull=false)
//		private String LastName;
//		@DatabaseField(canBeNull=false)
//		private String FirstName;
//		@DatabaseField(canBeNull=false)
//		private String Title;
//		@DatabaseField(canBeNull=true)
//		private String TitleOfCourtesy;
//		@DatabaseField(canBeNull=true)
//		private Date BirthDate;
//		@DatabaseField(canBeNull=true)
//		private Date HireDate;
//		@DatabaseField(canBeNull=true)
//		private String Address;
//		@DatabaseField(canBeNull=true)
//		private String City;
//		@DatabaseField(canBeNull=true)
//		private String Region;
//		public int getEmployeeID() {
//			return EmployeeID;
//		}
//
//		public void setEmployeeID(int employeeID) {
//			EmployeeID = employeeID;
//		}
//
//		public String getLastName() {
//			return LastName;
//		}
//
//		public void setLastName(String lastName) {
//			LastName = lastName;
//		}
//
//		public String getFirstName() {
//			return FirstName;
//		}
//
//		public void setFirstName(String firstName) {
//			FirstName = firstName;
//		}
//
//		public String getTitle() {
//			return Title;
//		}
//
//		public void setTitle(String title) {
//			Title = title;
//		}
//
//		public String getTitleOfCourtesy() {
//			return TitleOfCourtesy;
//		}
//
//		public void setTitleOfCourtesy(String titleOfCourtesy) {
//			TitleOfCourtesy = titleOfCourtesy;
//		}
//
//		public Date getBirthDate() {
//			return BirthDate;
//		}
//
//		public void setBirthDate(Date birthDate) {
//			BirthDate = birthDate;
//		}
//
//		public Date getHireDate() {
//			return HireDate;
//		}
//
//		public void setHireDate(Date hireDate) {
//			HireDate = hireDate;
//		}
//
//		public String getAddress() {
//			return Address;
//		}
//
//		public void setAddress(String address) {
//			Address = address;
//		}
//
//		public String getCity() {
//			return City;
//		}
//
//		public void setCity(String city) {
//			City = city;
//		}
//
//		public String getRegion() {
//			return Region;
//		}
//
//		public void setRegion(String region) {
//			Region = region;
//		}
//
//		public String getPostalCode() {
//			return PostalCode;
//		}
//
//		public void setPostalCode(String postalCode) {
//			PostalCode = postalCode;
//		}
//
//		public String getCountry() {
//			return Country;
//		}
//
//		public void setCountry(String country) {
//			Country = country;
//		}
//
//		public String getHomePhone() {
//			return HomePhone;
//		}
//
//		public void setHomePhone(String homePhone) {
//			HomePhone = homePhone;
//		}
//
//		public String getExtension() {
//			return Extension;
//		}
//
//		public void setExtension(String extension) {
//			Extension = extension;
//		}
//
//		public int getReportsTo() {
//			return ReportsTo;
//		}
//
//		public void setReportsTo(int reportsTo) {
//			ReportsTo = reportsTo;
//		}
//
//		public String getPhotopath() {
//			return Photopath;
//		}
//
//		public void setPhotopath(String photopath) {
//			Photopath = photopath;
//		}
//
//		@DatabaseField(canBeNull=true)
//		private String PostalCode;
//		@DatabaseField(canBeNull=true)
//		private String Country;
//		@DatabaseField(canBeNull=true)
//		private String HomePhone;
//		@DatabaseField(canBeNull=true)
//		private String Extension;
//		@DatabaseField(canBeNull=true)
//		private int ReportsTo;
//		@DatabaseField(canBeNull=true)
//		private String Photopath;
//		
//		public Employee() {
//			
//		}
//	}
	
	@DatabaseTable(tableName="EmployeeView")
	public static class EmployeeView {
		@DatabaseField(canBeNull=false)
		private int EmployeeID;
		@DatabaseField(canBeNull=false)
		private String EmployeeName;
		@DatabaseField(canBeNull=true)
		private String Title;
		@DatabaseField(canBeNull=false)
		private String FullAddress;
		@DatabaseField(canBeNull=true)
		public String HomePhone;
		@DatabaseField(canBeNull=false)
		public String ReportsTo;
		@DatabaseField(canBeNull=true)
		public int ReportsToID;
		
		public int getEmployeeID() {
			return EmployeeID;
		}

		public void setEmployeeID(int employeeID) {
			EmployeeID = employeeID;
		}

		public String getEmployeeName() {
			return EmployeeName;
		}

		public void setEmployeeName(String employeeName) {
			EmployeeName = employeeName;
		}

		public String getTitle() {
			return Title;
		}

		public void setTitle(String title) {
			Title = title;
		}

		public String getFullAddress() {
			return FullAddress;
		}

		public void setFullAddress(String fullAddress) {
			FullAddress = fullAddress;
		}

		public String getHomePhone() {
			return HomePhone;
		}

		public void setHomePhone(String homePhone) {
			HomePhone = homePhone;
		}

		public String getReportsTo() {
			return ReportsTo;
		}

		public void setReportsTo(String reportsTo) {
			ReportsTo = reportsTo;
		}

		public int getReportsToID() {
			return ReportsToID;
		}

		public void setReportsToID(int reportsToID) {
			ReportsToID = reportsToID;
		}
		
		public EmployeeView() {
			
		}
	}
}
