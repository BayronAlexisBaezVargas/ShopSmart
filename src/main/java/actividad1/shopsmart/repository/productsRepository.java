package actividad1.shopsmart.repository;

import actividad1.shopsmart.model.products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface productsRepository extends JpaRepository<products, Long>{

}
