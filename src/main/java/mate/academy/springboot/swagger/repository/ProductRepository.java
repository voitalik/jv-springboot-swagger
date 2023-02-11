package mate.academy.springboot.swagger.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import mate.academy.springboot.swagger.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductByPriceIsBetween(BigDecimal from, BigDecimal to, Pageable pageable);

    @Query("SELECT MAX(p.price) FROM Product p")
    Optional<BigDecimal> findMaxPrice();
}