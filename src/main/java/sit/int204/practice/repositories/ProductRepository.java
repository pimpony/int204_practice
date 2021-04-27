package sit.int204.practice.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.practice.models.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByProdPriceBetween(Double lower,Double upper);

}