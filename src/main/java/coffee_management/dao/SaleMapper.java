package coffee_management.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import coffee_management.dto.Sale;

public interface SaleMapper {
	List<Sale> selectSaleByAll() throws SQLException;
	
	int insertSale(Sale sale) throws SQLException;
	
	List<Sale> selectSaleRank(boolean isSale) throws SQLException;
	
	Sale getSale(ResultSet rs) throws SQLException;
	
	Sale getSaleDetail(ResultSet rs) throws SQLException;
}
