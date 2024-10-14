package com.yourapp.repository;

import com.yourapp.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    List<Stock> findBySymbol(String symbol);
}
