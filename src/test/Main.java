package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import example.Category;
import example.NewProduct1;
import example.NewProduct2;
import example.Product;

public class Main {
	public static void main(String[] args) throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(Category.class, NewProduct1.class, NewProduct2.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		Unmarshaller unmarshaller = context.createUnmarshaller();

		ByteArrayOutputStream out;
		
		Category c = new Category();
		c.setName("My category");
		c.setProducts(Arrays.<Product> asList(new NewProduct1("1"), new NewProduct2()));

		out = new ByteArrayOutputStream();
		marshaller.marshal(c, out);
		System.out.println("-- serialized c ----");
		System.out.println(out.toString());

		Category c2 = (Category) unmarshaller.unmarshal(new ByteArrayInputStream(out.toByteArray()));

		out = new ByteArrayOutputStream();
		marshaller.marshal(c2, out);
		System.out.println("-- serialized c2 ----");
		System.out.println(out.toString());

		System.out.println("-- check equals ----");
		System.out.println("c.equals(c2) = " + c.equals(c2));
	}
}
