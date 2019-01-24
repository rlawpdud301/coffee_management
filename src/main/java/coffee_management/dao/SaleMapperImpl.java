package coffee_management.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import coffee_management.dto.Product;
import coffee_management.dto.Sale;
import coffee_management.dto.SaleDetail;
import coffee_management.jdbc.MyBatisSqlSessionFactory;

public class SaleMapperImpl implements SaleMapper {
	private static final String namespace = "coffee_management.dao.SaleMapper";
	
	private static final SaleMapper instance = new SaleMapperImpl();
	
	public static SaleMapper getInstance() {
		return instance;
	}
	
	public SaleMapperImpl() {}


	@Override
	public List<Sale> selectSaleByAll() throws SQLException {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".selectSaleByAll");
		}
	}

	@Override
	public int insertSale(Sale sale) throws SQLException {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.insert(namespace + ".insertSale", sale);
			sqlSession.commit();
			
			return res;
		}
	}

	@Override
	public List<Sale> selectSaleRank(boolean isSale) throws SQLException {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".selectSaleRank", isSale);
		}
	}

	@Override
	public Sale getSale(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		int no = rs.getInt("no");
		Product code = new Product(rs.getString("code"));
		int price = rs.getInt("price");
		int saleCnt = rs.getInt("saleCnt");
		int marginRate = rs.getInt("marginRate");
		
		return new Sale(no, code, price, saleCnt, marginRate);
	}

	@Override
	public Sale getSaleDetail(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		int no = rs.getInt("no");
		Product product = new Product(rs.getString("code"), rs.getString("name"));
		int price = rs.getInt("price");
		int saleCnt = rs.getInt("saleCnt");
		int marginRate = rs.getInt("marginRate");
		
		int supplyTax = rs.getInt("supplyTax");
		int addTax = rs.getInt("addTax");
		int salePrice = rs.getInt("salePrice");
		int marginPrice = rs.getInt("marginPrice");
		int rank = rs.getInt("rank");
		
		SaleDetail detail = new SaleDetail(supplyTax, addTax, salePrice, marginPrice, rank);
		Sale sale = new Sale(no, product, price, saleCnt, marginRate, detail);
		
		return sale;
	}
	
}
