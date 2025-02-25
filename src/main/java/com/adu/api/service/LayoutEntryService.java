package com.adu.api.service;

import com.adu.api.model.LayoutEntry;
import com.adu.api.repository.LayoutEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LayoutEntryService {

    private final LayoutEntryRepository layoutentryRepository;

    public Flux<LayoutEntry> getAllLayoutEntry() {
        return layoutentryRepository.findAll();
    }

    public Mono<LayoutEntry> getLayoutEntryById(Long layoutentry_id) {
        return layoutentryRepository.findById(layoutentry_id);
    }

    public Mono<LayoutEntry> createLayoutEntry(LayoutEntry layoutentry) {
        return layoutentryRepository.save(layoutentry);
    }

    public Mono<LayoutEntry> updateLayoutEntry(Long layoutentry_id, LayoutEntry layoutentry) {
        return layoutentryRepository.findById(layoutentry_id)
                .flatMap(existingLayoutEntry -> {
                    existingLayoutEntry.setDescription(layoutentry.getDescription());
                    existingLayoutEntry.setExt_description(layoutentry.getExt_description());
                  
                    existingLayoutEntry.setPrice(layoutentry.getPrice());

                    existingLayoutEntry.setUpdated_at(LocalDateTime.now());
                
                    return layoutentryRepository.save(existingLayoutEntry);
                });
    }

    public Mono<Void> deleteLayoutEntry(Long layoutentry_id) {
        return layoutentryRepository.deleteById(layoutentry_id);
    }
}
