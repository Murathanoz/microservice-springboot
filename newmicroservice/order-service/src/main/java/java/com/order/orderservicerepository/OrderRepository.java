package java.com.order.orderservicerepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.com.order.orderservice.model.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
