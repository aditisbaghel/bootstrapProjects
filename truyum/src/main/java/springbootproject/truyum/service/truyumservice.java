package springbootproject.truyum.service;

public class truyumservice {

package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public interface CartDao {

	public void addCartItem(long userId, long menuItemId);

	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException;

	public void removeCartItem(long userId, long menuItemId);

}


-------------------
package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {

	private static HashMap<Long, Cart> userCarts;

	public CartDaoCollectionImpl() {
		super();
		if (userCarts == null) {
			userCarts = new HashMap<Long, Cart>();
		}
	}

	@Override
	public void addCartItem(long userId, long menuItemId) {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
		if (userCarts.containsKey(userId)) {
			Cart cart = userCarts.get(userId);
			List<MenuItem> menuItemsList = cart.getMenuItemList();
			menuItemsList.add(menuItem);
		} else {
			Cart cart = new Cart();
			List<MenuItem> menuItemList = new ArrayList<MenuItem>();
			menuItemList.add(menuItem);
			cart.setMenuItemList(menuItemList);
			userCarts.put(userId, cart);

		}
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {

		Cart cart = userCarts.get(userId);
		ListIterator<MenuItem> iterator = cart.getMenuItemList().listIterator();
		while (iterator.hasNext()) {
			if (iterator.next().getId() == menuItemId) {
				iterator.remove();
			}
		}

	}

	// There is an issue in class diagram it is mentioned List<MenuItem> as
	// return type
	// But in description it is mentioned as Cart type
	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		Cart cart = userCarts.get(userId);
		List<MenuItem> menuItemsList = cart.getMenuItemList();
		if (menuItemsList.isEmpty()) {
			throw new CartEmptyException();
		}
		double total = 0;
		for (MenuItem menuItem : menuItemsList) {
			total += menuItem.getPrice();
		}
		cart.setTotal(total);
		return cart.getMenuItemList();
	}

}
-------------------
package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void main(String args[]) {
		System.out.println("ADD CART");
		testAddCartItem();
		System.out.println("REMOVE CART");
		testRemoveCartItem();

	}

	public static void testAddCartItem() {

		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1, 2);
		List<MenuItem> menuItemList;
		try {
			menuItemList = cartDao.getAllCartItems(1);
		} catch (CartEmptyException e) {
			e.printStackTrace();
			return;
		}
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}
	}

	public static void testGetAllCartItems() {

		CartDao cartDao = new CartDaoCollectionImpl();
		List<MenuItem> menuItemList;
		try {
			menuItemList = cartDao.getAllCartItems(1);
		} catch (CartEmptyException e) {
			e.printStackTrace();
			return;
		}
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}
	}

	public static void testRemoveCartItem() {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.removeCartItem(1, 2);
		List<MenuItem> menuItemList;
		try {
			menuItemList = cartDao.getAllCartItems(1);
		} catch (CartEmptyException e) {
			System.out.println("CART IS EMPTY");
		}
	}

}
--------------------------
package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

	@Override
	public void addCartItem(long userId, long menuItemId) {
		Connection con = ConnectionHandler.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement("insert into cart(ct_us_id, ct_pr_id) values(?, ?)");
			statement.setInt(1, (int) userId);
			statement.setInt(2, (int) menuItemId);
			statement.executeUpdate();
			System.out.println("Item inserted into Cart Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		Connection con = ConnectionHandler.getConnection();
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		Cart cart = new Cart(menuItemList, 0);
		try {
			PreparedStatement statement = con.prepareStatement(
					"select menu_item.me_id, menu_item.me_name, menu_item.Me_price, menu_item.me_active, menu_item.me_date_of_launch, menu_item.me_category, menu_item.me_free_delivery from menu_item inner join cart on menu_item.me_id = cart.ct_pr_id where cart.ct_us_id = ?");
			statement.setInt(1, (int)userId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				MenuItem menuItem = new MenuItem(resultSet.getInt("me_id"), resultSet.getString("me_name"),
						resultSet.getFloat("me_price"), resultSet.getString("me_active").equals("Yes") ? true : false,
						resultSet.getDate("me_date_of_launch"), resultSet.getString("me_category"),
						resultSet.getString("me_free_delivery").equals("Yes") ? true : false);
				menuItemList.add(menuItem);
			}
			cart.setMenuItemList(menuItemList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(menuItemList.isEmpty()) {
			throw new CartEmptyException();
		}
		try {
			PreparedStatement statement = con.prepareStatement(
					"select sum(menu_item.me_price) from menu_item inner join cart on menu_item.me_id = cart.ct_pr_id where cart.ct_us_id = ?");
			statement.setInt(1, (int)userId);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				cart.setTotal(resultSet.getDouble(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuItemList;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		Connection con = ConnectionHandler.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement("delete from cart where ct_us_id = ? and ct_pr_id = ?");
			statement.setInt(1, (int)userId);
			statement.setInt(2, (int)menuItemId);
			statement.executeUpdate();
			System.out.println("Item Removed Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		//cartDaoSqlImpl.addCartItem(1, 1);
//		try {
//			System.out.println(cartDaoSqlImpl.getAllCartItems(1));
//		} catch (CartEmptyException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		cartDaoSqlImpl.removeCartItem(1, 1);
	}

}
---------------
package com.cognizant.truyum.dao;

public class CartEmptyException extends Exception {

	public CartEmptyException() {

	}

}
--------------------------
package com.cognizant.truyum.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {

	public static Connection getConnection() {
		Properties p;
		FileInputStream fis;
		Connection con = null;
		try {
			fis = new FileInputStream("src\\connection.properties");
			p = new Properties();
			p.load(fis);
			Class.forName(p.getProperty("driver"));
			con = DriverManager.getConnection(p.getProperty("connection-url"), p.getProperty("user"),
					p.getProperty("password"));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			System.out.println("Unable to Connect");
			return null;
		}
		System.out.println("Connection Successfull");
		return con;
	}
	
//	public static void main(String args[]) {
//		System.out.println(getConnection());
//	}
}
--------------------------
package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao {

	public List<MenuItem> getMenuItemListAdmin();

	public List<MenuItem> getMenuItemListCustomer();

	public void modifyMenuItem(MenuItem menuItem);

	public MenuItem getMenuItem(long menuItemId);
}
--------------------------
package com.cognizant.truyum.dao;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static List<MenuItem> menuItemList;

	public MenuItemDaoCollectionImpl() {
		super();
		if (menuItemList == null) {
			menuItemList = new ArrayList<MenuItem>();

			MenuItem menuItem = new MenuItem(1, "Sandwich", 99, true, DateUtil.convertToDate("15/03/17"), "Main Course",
					true);
			menuItemList.add(menuItem);

			menuItem = new MenuItem(2, "Burger", 129, true, DateUtil.convertToDate("23/12/17"), "Main Course", false);
			menuItemList.add(menuItem);

			menuItem = new MenuItem(3, "Pizza", 149, true, DateUtil.convertToDate("21/08/18"), "Main Course", false);
			menuItemList.add(menuItem);

			menuItem = new MenuItem(4, "French Fries", 57, false, DateUtil.convertToDate("02/07/17"), "Starters", true);
			menuItemList.add(menuItem);

			menuItem = new MenuItem(5, "Choclate Brownie", 32, true, DateUtil.convertToDate("02/11/22"), "Dessert",
					true);
			menuItemList.add(menuItem);
		}
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		ArrayList<MenuItem> menuItemsListCustomer = new ArrayList<MenuItem>();
		Date date = new Date();
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yy");
		date = DateUtil.convertToDate(sdfDate.format(date));

		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getDateOfLaunch().compareTo(date) < 0 && menuItem.isActive()) {
				menuItemsListCustomer.add(menuItem);
			}
		}
		return menuItemsListCustomer;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		for (MenuItem menuItemLocal : menuItemList) {
			if (menuItemLocal.getId() == menuItem.getId()) {
				menuItemLocal.setName(menuItem.getName());
				menuItemLocal.setPrice(menuItem.getPrice());
				menuItemLocal.setDateOfLaunch(menuItem.getDateOfLaunch());
				menuItemLocal.setCategory(menuItem.getCategory());
				menuItemLocal.setActive(menuItem.isActive());
				menuItemLocal.setFreeDelivery(menuItem.isFreeDelivery());
				return;
			}
		}
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		for (MenuItem menuItemLocal : menuItemList) {
			if (menuItemLocal.getId() == menuItemId) {
				return menuItemLocal;
			}
		}
		return null;
	}

}
----------------------------
package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public static void main(String args[]) {
		System.out.println("MENU ITEM ADMIN");
		testGetMenuItemListAdmin();
		System.out.println("MENU ITEM CUSTOMER");
		testGetMenuItemListCustomer();
		System.out.println("MENU ITEM AFTER MODIFICATION");
		testModifyMenuItem();
	}

	public static void testGetMenuItemListAdmin() {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}

	}

	public static void testGetMenuItemListCustomer() {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}
	}

	public static void testModifyMenuItem() {
		MenuItem menuItem = new MenuItem(3, "Panner Kulcha", 150, true, DateUtil.convertToDate("10/10/17"), "Main Course", true);
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		menuItemDao.modifyMenuItem(menuItem);
		System.out.println(menuItemDao.getMenuItem(3));
	}

	public static void testGetMenuItem() {

	}

}
--------------------------------

package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImpl implements MenuItemDao {

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		Connection con = ConnectionHandler.getConnection();
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		try {
			PreparedStatement statement = con.prepareStatement("select * from menu_item");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				MenuItem menuItem = new MenuItem(resultSet.getInt("me_id"), resultSet.getString("me_name"),
						resultSet.getFloat("me_price"), resultSet.getString("me_active").equals("Yes") ? true : false,
						resultSet.getDate("me_date_of_launch"), resultSet.getString("me_category"),
						resultSet.getString("me_free_delivery").equals("Yes") ? true : false);
				menuItemList.add(menuItem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		Connection con = ConnectionHandler.getConnection();
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		try {
			PreparedStatement statement = con
					.prepareStatement("select * from menu_item where me_active = ? and me_date_of_launch <= ?");
			statement.setString(1, "Yes");
			Date date = new Date();
			SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-mm-dd");
			statement.setString(2, sdfDate.format(date));
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				MenuItem menuItem = new MenuItem(resultSet.getInt("me_id"), resultSet.getString("me_name"),
						resultSet.getFloat("me_price"), resultSet.getString("me_active").equals("Yes") ? true : false,
						resultSet.getDate("me_date_of_launch"), resultSet.getString("me_category"),
						resultSet.getString("me_free_delivery").equals("Yes") ? true : false);
				menuItemList.add(menuItem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuItemList;
	}

	// There is miss understanding here in interface the name of this function
	// is mentioned as modify...
	// But in class & description it is mentioned as edit...
	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		Connection con = ConnectionHandler.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(
					"update menu_item set me_name = ?, me_price = ?, me_active = ?, me_date_of_launch = ?, me_category = ?, me_free_delivery = ? where me_id = ?");
			statement.setString(1, menuItem.getName());
			statement.setFloat(2, menuItem.getPrice());
			statement.setString(3, menuItem.isActive() == true ? "Yes" : "No");
			statement.setDate(4, new java.sql.Date(menuItem.getDateOfLaunch().getTime()));
			statement.setString(5, menuItem.getCategory());
			statement.setString(6, menuItem.isFreeDelivery() == true ? "Yes" : "No");
			statement.setInt(7, (int)menuItem.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		Connection con = ConnectionHandler.getConnection();
		MenuItem menuItem = null;
		try {
			PreparedStatement statement = con.prepareStatement("select * from menu_item where me_id = ?");
			statement.setInt(1, (int) menuItemId);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				menuItem = new MenuItem(resultSet.getInt("me_id"), resultSet.getString("me_name"),
						resultSet.getFloat("me_price"), resultSet.getString("me_active").equals("Yes") ? true : false,
						resultSet.getDate("me_date_of_launch"), resultSet.getString("me_category"),
						resultSet.getString("me_free_delivery").equals("Yes") ? true : false);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuItem;
	}

	public static void main(String args[]) {
		MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();
		System.out.println("MENU ITEM LIST");
		//System.out.println(menuItemDaoSqlImpl.getMenuItem(1));
//		MenuItem menuItem = new MenuItem(3, "Panner Kulcha", 200, true, DateUtil.convertToDate("05/05/19"),
//				"Main Course", true);
//		menuItemDaoSqlImpl.modifyMenuItem(menuItem);
//		for (MenuItem menuItemLocal : menuItemDaoSqlImpl.getMenuItemListCustomer()) {
//			System.out.println(menuItemLocal);
//		}
		
	}
}
--------------------------------dao Override


model
package com.cognizant.truyum.model;

import java.util.List;

public class Cart {

	private List<MenuItem> menuItemList;
	private double total;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(List<MenuItem> menuItemList, double total) {
		super();
		this.menuItemList = menuItemList;
		this.total = total;
	}

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cart [menuItemList=" + menuItemList + ", total=" + total + "]";
	}

}
/-----------------------------
package com.cognizant.truyum.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MenuItem {

	private long id;
	private String name;
	private float price;
	private boolean active;
	private Date dateOfLaunch;
	private String category;
	private boolean freeDelivery;

	public MenuItem() {
		super();
	}

	public MenuItem(long id, String name, float price, boolean active, Date dateOfLaunch, String category,
			boolean freeDelivery) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.category = category;
		this.freeDelivery = freeDelivery;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isFreeDelivery() {
		return freeDelivery;
	}

	public void setFreeDelivery(boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}

	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		return "MenuItem [id=" + id + ", name=" + name + ", price=" + price + ", active=" + active + ", dateOfLaunch="
				+ formatter.format(dateOfLaunch) + ", category=" + category + ", freeDelivery=" + freeDelivery + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
---------
model Override


----------------------------------

util
package com.cognizant.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date convertToDate(String date) {
		try {
			return new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}




}
