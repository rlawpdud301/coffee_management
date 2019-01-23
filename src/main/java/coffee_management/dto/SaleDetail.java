package coffee_management.dto;

public class SaleDetail {
	private int supplyTax;		//공급가액
	private int addTax;			//부가세액
	private int salePrice;		//판매금액
	private int marginPrice;	//마진액
	
	public SaleDetail() {
		// TODO Auto-generated constructor stub
	}

	public SaleDetail(int supplyTax, int addTax, int salePrice, int marginPrice) {
		this.supplyTax = supplyTax;
		this.addTax = addTax;
		this.salePrice = salePrice;
		this.marginPrice = marginPrice;
	}

	public int getSupplyTax() {
		return supplyTax;
	}

	public void setSupplyTax(int supplyTax) {
		this.supplyTax = supplyTax;
	}

	public int getAddTax() {
		return addTax;
	}

	public void setAddTax(int addTax) {
		this.addTax = addTax;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	public int getMarginPrice() {
		return marginPrice;
	}

	public void setMarginPrice(int marginPrice) {
		this.marginPrice = marginPrice;
	}

	@Override
	public String toString() {
		return String.format("SaleDetail [supplyTax=%s, addTax=%s, salePrice=%s, marginPrice=%s]", supplyTax, addTax,
				salePrice, marginPrice);
	}
	
	
}
