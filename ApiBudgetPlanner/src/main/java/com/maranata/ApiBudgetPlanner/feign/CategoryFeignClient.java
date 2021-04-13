package com.maranata.ApiBudgetPlanner.feign;

import com.maranata.budgetplanner.entity.Category;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.Optional;

@FeignClient(value = "api-categories", url = "http://localhost:8084/v1/categories/")
public interface CategoryFeignClient {

    @GetMapping
    @Headers("Content-Type: application/json")
    ResponseEntity<Collection<Category>> categoryList();

    @GetMapping("/{id}")
    Optional<Category> findById(@PathVariable Long id);

}
