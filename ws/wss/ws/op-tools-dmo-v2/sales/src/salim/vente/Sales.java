package salim.vente;

public class Sales {

	private String productName;
	private int price;
	private String customerName;
	public Sales(String productName, int price, String customerName ){
		this.customerName = customerName;
		this.price= price;
		this.productName = productName;
		
	}
	@Override
	public String toString() {
		return "Sales [productName=" + productName + ", price=" + price +"euros"+ ", customerName=" + customerName + "]";
	}
	
	
	
	
	
	
	
	}


