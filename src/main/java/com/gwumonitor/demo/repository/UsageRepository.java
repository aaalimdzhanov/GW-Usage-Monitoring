package com.gwumonitor.demo.repository;
import com.gwumonitor.demo.model.Usage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsageRepository extends JpaRepository<Usage, Long> {
    List<Usage> findByCustomerIdAndResourceId(long customerId, long resId);
    List<Usage> findByCustomerId(long customerId);
}
