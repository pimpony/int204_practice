package sit.int204.practice.models;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Products {
  @Id
  private String productCode;
  private String productName;
  private String productLine;
  private String productScale;
  private String productVendor;
  private String productDescription;
  private long quantityInStock;
  private double buyPrice;
  private double msrp;


  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }


  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }


  public String getProductLine() {
    return productLine;
  }

  public void setProductLine(String productLine) {
    this.productLine = productLine;
  }


  public String getProductScale() {
    return productScale;
  }

  public void setProductScale(String productScale) {
    this.productScale = productScale;
  }


  public String getProductVendor() {
    return productVendor;
  }

  public void setProductVendor(String productVendor) {
    this.productVendor = productVendor;
  }


  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }


  public long getQuantityInStock() {
    return quantityInStock;
  }

  public void setQuantityInStock(long quantityInStock) {
    this.quantityInStock = quantityInStock;
  }


  public double getBuyPrice() {
    return buyPrice;
  }

  public void setBuyPrice(double buyPrice) {
    this.buyPrice = buyPrice;
  }


  public double getMsrp() {
    return msrp;
  }

  public void setMsrp(double msrp) {
    this.msrp = msrp;
  }

}
