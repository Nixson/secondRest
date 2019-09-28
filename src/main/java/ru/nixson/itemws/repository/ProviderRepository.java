package ru.nixson.itemws.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.nixson.itemws.domain.Provider;

import java.util.List;

@Repository
public interface ProviderRepository extends PagingAndSortingRepository<Provider, Long> {
    List<Provider> findByName(String name);
}
