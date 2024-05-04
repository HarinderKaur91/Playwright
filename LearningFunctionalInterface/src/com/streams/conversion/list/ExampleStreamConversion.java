package com.streams.conversion.list;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleStreamConversion {

	public static void main(String[] args) {

		List<Product> myList = ExampleData.getProducts();

		// Function<Product, Category>function = p->p.getCategory();

		List<Category> list = myList.stream().filter(p -> p.getCategory() == Category.FOOD).map(p -> p.getCategory())
				.collect(Collectors.toList());
		
		list.forEach(s->System.out.println(s));
	
		List<String> namesList = List.of("Harinder","Navjot","Kuldeep");
		Stream<Object> secondNameList= namesList.stream().filter(s->s.contains("a")).map(s->s);
		secondNameList.forEach(s->System.out.println(s));
	}

}
