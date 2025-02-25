package com.adu.api.controller;

import com.adu.api.model.LayoutEntry;
import com.adu.api.service.LayoutEntryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/layoutentry")
@RequiredArgsConstructor
@Tag(name = "layoutentry Management", description = "APIs for managing layoutentry")
public class LayoutEntryController {

    private final LayoutEntryService layoutentryService;

    @GetMapping
    @Operation(summary = "Get all layoutentry")
    public Flux<LayoutEntry> getAllLayoutEntry() {
        return layoutentryService.getAllLayoutEntry();
    }

    @GetMapping("/{layoutentry_id}")
    @Operation(summary = "Get layoutentry by ID")
    public Mono<LayoutEntry> getLayoutEntryById(@PathVariable Long layoutentry_id) {
        return layoutentryService.getLayoutEntryById(layoutentry_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new layoutentry")
    public Mono<LayoutEntry> createLayoutEntry(@RequestBody LayoutEntry layoutentry) {
        return layoutentryService.createLayoutEntry(layoutentry);
    }

    @PutMapping("/{layoutentry_id}")
    @Operation(summary = "Update an existing layoutentry")
    public Mono<LayoutEntry> updateLayoutEntry(@PathVariable Long layoutentry_id, @RequestBody LayoutEntry layoutentry) {
        return layoutentryService.updateLayoutEntry(layoutentry_id, layoutentry);
    }

    @DeleteMapping("/{layoutentry_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a layoutentry")
    public Mono<Void> deleteLayoutEntry(@PathVariable Long layoutentry_id) {
        return layoutentryService.deleteLayoutEntry(layoutentry_id);
    }
}
