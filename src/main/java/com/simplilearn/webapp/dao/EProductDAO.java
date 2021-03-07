package com.simplilearn.webapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.simplilearn.webapp.entity.EProduct;

public class EProductDAO {

	// jdbc data operations
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	// list all product
	
	public List<EProduct> getProducts(){
		return template.query("select * from eproduct", new RowMapper<EProduct>() {
			public EProduct mapRow(ResultSet res, int row) throws SQLException {
				//map fields
				EProduct  product = new EProduct();
				product.setId(res.getInt(1));
				product.setName(res.getString(2));
				product.setPrice(res.getBigDecimal(3));
				product.setDateAdded(res.getDate(4));
				return product;
			}
		});
	}
	
	// add product
	public int addProduct(EProduct product) {
		String query = "insert into eproduct values ('"+product.getId() +"','"+product.getName() +
				"','"+product.getPrice()+ "','"+product.getDateAdded()+"')";
		return template.update(query);
	}
	
	
	//delete product
	
	// update product
	
	
}
