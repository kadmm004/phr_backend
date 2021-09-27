package entity;

public class Drug {
	private  String drugid;  
    private  String drugname;  
    private  String vertinum;  
    private  String ingredient;
    private  String mainfunc; 
    private  String dosage; 
    private  String adverseaction; 
    private  String taboo; 
    private  String attention; 
    private  String standards; 
    private  String productor; 
    private  String category; 
    private  double price; 
    
    public Drug(String docid1, String docname1, String docsex1,String doctele1,
    		String docposition1, String docsection1, String docskilled1,
    		String docintro1,String hosid1,String standards1,String productor1,
    		String category1,double price1) {  
        this.drugid = docid1;  
        this.drugname = docname1;  
        this.vertinum = docsex1; 
        this.ingredient=doctele1;
        this.mainfunc = docposition1;  
        this.dosage = docsection1;  
        this.adverseaction = docskilled1; 
        this.taboo=docintro1;
        this.attention=hosid1;
        this.standards=standards1;
        this.productor=productor1;
        this.category=category1;
        this.price=price1;
    }  
    public Drug() {  
 
    }  
    
    public String getdrugid() {  
        return this.drugid ;
    }  
    public void setdrugid(String docid1) {  
    	drugid=docid1;
    }  

    public String getdrugname() {  
        return this.drugname ;
    }  
    public void setdrugname(String docname1) {  
    	drugname=docname1;
    }  
    
    public String getvertinum() {  
        return this.vertinum ;
    }  
    public void setvertinum(String docsex1) {  
    	vertinum=docsex1;
    }  
    public String getmainfunc() {  
        return this.mainfunc ;
    }  
    public void setmainfunc(String docposition1) {  
    	mainfunc=docposition1;
    }  
    public String getdosage() {  
        return this.dosage ;
    }  
    public void setdosage(String docsection1) {  
    	dosage=docsection1;
    }  
    public String getadverseaction() {  
        return this.adverseaction ;
    }  
    public void setadverseaction(String docskilled1) {  
    	adverseaction=docskilled1;
    }  
    public String gettaboo() {  
        return this.taboo ;
    }  
    public void settaboo(String docintro1) {  
    	taboo=docintro1;
    }  
    public String getingredient() {  
        return this.ingredient ;
    }  
    public void setingredient(String doctele1) {  
    	ingredient=doctele1;
    }  
    public String getstandards() {  
        return this.standards ;
    }  
    public void setstandards(String standards1) {  
    	standards=standards1;
    }  
    
    public String getproductor() {  
        return this.productor ;
    }  
    public void setproductor(String productor1) {  
    	productor=productor1;
    }  
    public String getattention() {  
        return this.attention ;
    }  
    public void setattention(String hosid1) {  
    	attention=hosid1;
    }  
    
    
    public String getcategory() {  
        return this.category ;
    }  
    public void setcategory(String category1) {  
    	category=category1;
    }  
    public double getprice() {  
        return this.price ;
    }  
    public void setprice(double price1) {  
    	price=price1;
    }  

}
