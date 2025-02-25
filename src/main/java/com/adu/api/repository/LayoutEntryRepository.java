package com.adu.api.repository;

import com.adu.api.model.LayoutEntry;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LayoutEntryRepository extends ReactiveCrudRepository<LayoutEntry, Long> {

    Flux<LayoutEntry> findByDescription(String description);    
}
