package example;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NewProduct2 extends NewProduct {
	private int productClass;

	public NewProduct2() {
	}

	public NewProduct2(int productClass) {
		this.productClass = productClass;
	}

	@XmlAttribute
	public int getProductClass() {
		return productClass;
	}

	public void setProductClass(int productClass) {
		this.productClass = productClass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productClass;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewProduct2 other = (NewProduct2) obj;
		if (productClass != other.productClass)
			return false;
		return true;
	}
}
