public class Clothing extends Product{
	private String size;
	
	public Clothing(int id,String name,double price,int quantity,String size){
		super(id,name,price,quantity);
		this.size=size;
		
	}
	
	public String getSize(){
		return size;
	}
	
	public void setSize(String size){
		this.size=size;
	}
	
	@Override
	public String displayInfo(){
		return super.displayInfo()+"\n\tSize : "+size;
	}

}