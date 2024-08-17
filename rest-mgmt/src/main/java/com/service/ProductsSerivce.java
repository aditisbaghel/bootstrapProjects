package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;

import com.model.ProductPojo;
import com.mysql.cj.Query;

@Service
public class ProductsSerivce {
	@Autowired
	JdbcTemplate j;

	public List<ProductPojo> getAllProducts() {
		List<Map<String, Object>> list = j.queryForList("SELECT * FROM products");
		List<ProductPojo> f = new ArrayList<ProductPojo>();
		for (int i = 0; i < list.size(); i++) {
			f.add(new ProductPojo((Integer) list.get(i).get("ID"), (Integer) list.get(i).get("STOCK"),
					(String) list.get(i).get("NAME"), (String) list.get(i).get("GENRE"),
					(String) list.get(i).get("PRICE")));
			System.out.println(f.get(i));
		}
		return f;
	}

	public ProductPojo getProductById(String id) {
		List<Map<String, Object>> list = j.queryForList("SELECT * FROM products where ID = " + id);
		int i = 0;
		return new ProductPojo((Integer) list.get(i).get("ID"), (Integer) list.get(i).get("STOCK"),
				(String) list.get(i).get("NAME"), (String) list.get(i).get("GENRE"), (String) list.get(i).get("PRICE"));
	}

	public String upsertProduct(ProductPojo p) {
		String INSERT_QUERY = "INSERT INTO `mydb`.`products` (`NAME`, `GENRE`, `PRICE`, `STOCK`) VALUES (?, ?, ?, ?);";
		String UPDATE_QUERY = "UPDATE `mydb`.`products` SET `NAME`= ?, `GENRE`= ? , `PRICE`= ? , `STOCK`= ?  WHERE `ID`= ? ;";
		if (p.getID() != null) {
			int res = j.update(UPDATE_QUERY, p.getNAME(), p.getGENRE(), p.getPRICE(), p.getSTOCK(), p.getID());
			return res == 1 ? "success" : "error";
		}
		int res = j.update(INSERT_QUERY, p.getNAME(),  p.getGENRE(),p.getPRICE(), p.getSTOCK());
		return res == 1 ? "success" : "error";

	}

	public String deleteProduct(ProductPojo p) {
		String DELETE_QUERY = "DELETE FROM `mydb`.`products` WHERE `ID`= ? ;";
		int res = j.update(DELETE_QUERY, p.getID());
		return res == 1 ? "success" : "error";

	}
}
