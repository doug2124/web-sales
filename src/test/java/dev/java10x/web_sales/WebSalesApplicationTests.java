package dev.java10x.web_sales;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import static org.junit.jupiter.api.Assertions.*;

import dev.java10x.web_sales.enumerates.OrderStatus;
import dev.java10x.web_sales.models.OrderItemModel;
import dev.java10x.web_sales.models.OrderModel;
import dev.java10x.web_sales.models.ProductModel;
import dev.java10x.web_sales.repositories.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import dev.java10x.web_sales.services.*;
import java.util.*;
@SpringBootTest
class WebSalesApplicationTests {

	@MockBean
	private OrderRepository orderRepository;
	@MockBean
	private ProductRepository productRepository;
	@Autowired
	private OrderServices orderService;
	@Test
	void testcreateOrder() {
		ProductModel p = new ProductModel();
		p.setId(1L);
		p.setPrice(100.0);

		OrderItemModel item= new OrderItemModel();
		ProductModel product= new ProductModel();
		product.setId(1L);
		item.setProduct(p);
		item.setQuantity(3);

		OrderModel inputOrder= new OrderModel();
		inputOrder.setItems(List.of(item));

		Mockito.when(productRepository.findById(1L))
		.thenReturn(Optional.of(p));
		Mockito.when(orderRepository.save(Mockito.any(OrderModel.class)))
		.thenAnswer(invocation->invocation.getArgument(0));

		OrderModel result = orderService.create(inputOrder);

		Assertions.assertEquals(300.0, result.getTotalPrice());
		Assertions.assertEquals(OrderStatus.PENDING, result.getStatus());
		Assertions.assertEquals(3, result.getItems().get(0).getQuantity());
		Assertions.assertEquals(100.0, result.getItems().get(0).getPrice());
	}

}
