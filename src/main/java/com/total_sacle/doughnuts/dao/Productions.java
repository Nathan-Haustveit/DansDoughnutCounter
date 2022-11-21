package com.total_sacle.doughnuts.dao;

import com.total_sacle.doughnuts.models.Product;

import java.util.List;

public interface Productions {
    List<Product> all();

    List<Product> filterByUsername(Long id);

    Long insert(Product info);

    void update(Product info);

    void delete(long id);
}
