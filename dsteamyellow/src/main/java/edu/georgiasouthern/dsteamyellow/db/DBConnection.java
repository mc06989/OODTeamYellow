package edu.georgiasouthern.dsteamyellow.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.spring.DaoFactory;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import edu.georgiasouthern.dsteamyellow.db.TableDefinitions.*;

public class DBConnection {
	
	private static volatile DBConnection sdbconnection;
	public static volatile Dao<OrderView, Integer> orderViewDao;
	public static volatile Dao<Employee, Integer> employeeDao;
	public static volatile Dao<OrderDetailsView, Integer> orderDetailViewDao;
	public static volatile Dao<EmployeeView, Integer> employeeViewDao;
	public static volatile Dao<Product, Integer> productDao;
	public static volatile Dao<Order, Integer> orderDao;
	public static volatile Dao<OrderDetail, Integer> orderDetailDao;
	public static volatile Dao<Shipper, Integer> shipperDao;
	public static volatile Dao<Region, Integer> regionDao;
	public static volatile Dao<Customer, Integer> customerDao;
	ConnectionSource connectionSource;
	private String urlString;
	public static DBConnection getInstance() {
		if (sdbconnection == null) {
			sdbconnection = new DBConnection();
		}
		
		return sdbconnection;
	}
	
	public static DBConnection getInstance(String urlString) {
		if (sdbconnection == null) {
			sdbconnection = new DBConnection();
			sdbconnection.urlString=urlString;
		}
		
		return sdbconnection;
	}
	
	private DBConnection() {
		String databaseUrl = "jdbc:sqlserver://dbyellowteam.database.windows.net:1433;database=dbyellowteam;user=dbyellow@dbyellowteam;password=Dbyell0wteam;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		databaseUrl = "jdbc:sqlserver://localhost:1433;database=Northwind;user=admin;password=password;encrypt=true;trustServerCertificate=true;loginTimeout=5;";
		databaseUrl = "jdbc:sqlserver://localhost:1433;database=ProjectNorthwind;user=admin;password=password;encrypt=true;trustServerCertificate=true;loginTimeout=5;";
		
		if ( urlString!=null) {
				if (!urlString.isEmpty()) {
				databaseUrl = urlString.toString();}
		}
		
		try {
			String driverName = "org.gjt.mm.sqlserver.Driver";
			//Class.forName(driverName);
			String serverName = "localhost";
			String mydatabase = "Northwind";
			String url = "jdbc:sqlserver://"+serverName+";database="+mydatabase;
			
			String username = "mjc3bb@gmail.com";
			String password = "Retrac_13";
			
			//Connection connection = DriverManager.getConnection(url, username, password);
			connectionSource = new JdbcConnectionSource(databaseUrl);
			new DaoFactory();
			orderDetailDao = DaoFactory.createDao(connectionSource, OrderDetail.class);
			
			orderViewDao = DaoFactory.createDao(connectionSource, OrderView.class);
			orderDetailViewDao = DaoFactory.createDao(connectionSource, OrderDetailsView.class);
			employeeViewDao = DaoFactory.createDao(connectionSource, EmployeeView.class);
			employeeDao = DaoFactory.createDao(connectionSource, Employee.class);
			shipperDao = DaoFactory.createDao(connectionSource, Shipper.class);
			productDao = DaoFactory.createDao(connectionSource, Product.class);
			orderDao = DaoFactory.createDao(connectionSource, Order.class);
			regionDao = DaoFactory.createDao(connectionSource, Region.class);
			customerDao = DaoFactory.createDao(connectionSource, Customer.class);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void closeConnection() {
		try {
			connectionSource.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Object[][] getOrderViewList(){
		List<OrderView> orders=null;
		List<Object[]> a = new ArrayList<Object[]>();
		List<Order> orderList = null;
		try {
			//QueryBuilder<OrderView, Integer> q = orderViewDao.queryBuilder();
			//orders = orderViewDao.query(q.prepare());
			orderList = orderDao.queryForAll();
			
			for (Order o : orderList) {
				ArrayList<Object> b = new ArrayList<Object>();
				b.add(o.getOrderID());
				b.add(o.getShipName());
				b.add(o.getRequiredDate());
				a.add(b.toArray());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Object[][] d = new Object[a.size()][];
		
		for(int i =0;i<a.size();i++) {
			d[i]=a.get(i);
		}
		return  (Object[][]) d;
	}

	public OrderDetailsView getOrderDetailsView(int oid) {
		QueryBuilder<OrderDetailsView, Integer> q = orderDetailViewDao.queryBuilder();
		
		List<OrderDetailsView> odv = null;
		try {
			q.where().eq("OrderID", oid);
			odv= orderDetailViewDao.query(q.prepare());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return odv.get(0);
	}
	
	public Order getOrder(int oid) {
		Order order = null;
		try {
			order = orderDao.queryForId(oid);
			employeeDao.refresh(order.getEmployeeID());
			return order;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}
	
	public List<OrderDetail> getOrderDetails(int oid){
		List<OrderDetail> orderDetails = null;
		try {
			orderDetails = orderDetailDao.query(orderDetailDao.queryBuilder().where().eq("OrderID", oid).prepare());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderDetails;
	}
	
	public Object[][] getEmployeeViewList(){
		List<EmployeeView> orders=null;
		List<Object[]> a = new ArrayList<Object[]>();
		try {
			QueryBuilder<EmployeeView, Integer> q = employeeViewDao.queryBuilder();
			orders = employeeViewDao.query(q.prepare());
			
			for (EmployeeView o : orders) {
				ArrayList<Object> b = new ArrayList<Object>();
				b.add(o.getEmployeeID());
				b.add(o.getEmployeeName());
				b.add(o.getTitle());
				b.add(o.getFullAddress());
				b.add(o.getHomePhone());
				b.add(o.getReportsTo());
				b.add(o.getReportsToID());
				
				a.add(b.toArray());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Object[][] d = new Object[a.size()][];
		
		for(int i =0;i<a.size();i++) {
			d[i]=a.get(i);
		}
		return  (Object[][]) d;
	}
	
	public Employee getEmployeeDetails(int eid) {
		Employee e = null;
		try {
			e= employeeDao.queryForId(eid);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return e;
	}
	
	
	public List<Product> getProductsOnOrder(int oid){
		List<Product> products= new ArrayList<Product>();
		List<OrderDetail> details;
		try {
			details = orderDetailDao.query(orderDetailDao.queryBuilder().where().eq("OrderID", oid).prepare());
		
			for (OrderDetail det : details) {
				products.add(productDao.queryForId(det.getProductID()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return products;
	}

	public Object[][] getProductsOnOrderTable(int oid) {
		List<Product> products= new ArrayList<Product>();
		List<Object[]> a = new ArrayList<Object[]>();
		try {
			
			List<OrderDetail> details = orderDetailDao.query(orderDetailDao.queryBuilder().where().eq("OrderID", oid).prepare());


			for (OrderDetail det : details) {
				products.add(productDao.queryForId(det.getProductID()));
			}
			
			
			for (Product o : products) {
				ArrayList<Object> b = new ArrayList<Object>();
				b.add(o.getProductID());
				b.add(o.getProductName());
				b.add(o.getSupplierID());
				b.add(o.getCategoryID());
				b.add(o.getQuantityPerUnit());
				b.add(o.getUnitPrice());
				b.add(o.getUnitsInStock());
				b.add(o.getUnitsOnOrder());
				b.add(o.getReorderLevel());
				
				a.add(b.toArray());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Object[][] d = new Object[a.size()][];
		
		for(int i =0;i<a.size();i++) {
			d[i]=a.get(i);
		}
		return  (Object[][]) d;
	}
	
	public List<Product> getProducts(){
		List<Product> products = null;
		
		try {
			products = productDao.queryForAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	}
	
	public List<Employee> getEmployees(){
		List<Employee> products = null;
		
		try {
			products = employeeDao.queryForAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	}
	
	public List<Shipper> getShippers(){
		List<Shipper> products = null;
		
		try {
			products = shipperDao.queryForAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	}
	
	public List<Region> getRegions(){
		List<Region> products = null;
		
		try {
			products = regionDao.queryForAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	}

	public void updateOrCreateOrder(Order o) {
		try {
			List<Order> orders = orderDao.queryForAll();
			o.setOrderID(orders.get(orders.size()-1).getOrderID()+1);
			orderDao.create(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Customer> getCustomers() {
		List<Customer> products = null;
		
		try {
			products = customerDao.queryForAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	}

	public void updateOrCreateOrder(OrderDetail od) {
		try {
//			List<Order> orders = orderDao.queryForAll();
//			o.setOrderID(orders.get(orders.size()-1).getOrderID()+1);
			orderDetailDao.create(od);
		} catch (Exception e) {
			
		}
	}
}
