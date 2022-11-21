package com.total_sacle.doughnuts.models;

public class Product {
    private long id;
    private long employeeId;
    private long typeId;
    private int amount;
    private String productionDate;

    public Product(long id, long employee_id, long type_id, int amount, String production_date) {
        this.id = id;
        this.employeeId = employee_id;
        this.typeId = type_id;
        this.amount = amount;
        this.productionDate = production_date;
    }

    public Product(long employee_id, long type_id, int amount, String production_date) {
        this.employeeId = employee_id;
        this.typeId = type_id;
        this.amount = amount;
        this.productionDate = production_date;
    }

    public Product(long type_id, int amount, String production_date) {
        this.typeId = type_id;
        this.amount = amount;
        this.productionDate = production_date;
    }

    public Product(long type_id, int amount, String production_date, long id) {
        this.typeId = type_id;
        this.amount = amount;
        this.productionDate = production_date;
        this.id = id;
    }

    public Product() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }
}


