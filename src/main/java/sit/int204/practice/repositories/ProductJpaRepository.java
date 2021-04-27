package sit.int204.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.practice.models.Products;

public interface ProductJpaRepository extends JpaRepository<Products,String> {


}
