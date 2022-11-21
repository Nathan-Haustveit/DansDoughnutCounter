package com.total_sacle.doughnuts.dao;

import com.total_sacle.doughnuts.models.Product;
import com.total_sacle.doughnuts.models.Type;

import java.util.List;

public interface Types {
    // list all types in the doughnut_type table
    List<Type> all();

    // find all doughnuts with a specific type
    List<Product> findByType(String type);
}
