package coffee_management;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import coffee_management.dao.SaleMapper;
import coffee_management.dao.SaleMapperImpl;
import coffee_management.dto.Product;
import coffee_management.dto.Sale;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaleMapperTest extends AbstractTest {
	private SaleMapper dao = SaleMapperImpl.getInstance();
	
	@Test
	public void test01SelectSaleByAll() throws SQLException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");		
		List<Sale> list = dao.selectSaleByAll();		
		for(Sale s : list) {
			System.out.println(s);
		}
		Assert.assertNotNull(list);
	}	
	@Test
	public void test03SelectSaleRankTrue() throws SQLException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");		
		List<Sale> list = dao.selectSaleRank(true);			
		for(Sale s : list) {
			System.out.println(s);
		}
		Assert.assertNotNull(list);
	}
	@Test
	public void test04SelectSaleRankFalse() throws SQLException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Sale> list = dao.selectSaleRank(false);		
		for(Sale s : list) {
			System.out.println(s);
		}
		Assert.assertNotNull(list);
	}
}
