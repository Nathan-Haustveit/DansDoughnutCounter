package com.total_sacle.doughnuts.models;

public class Type {
    private long id;
    private long productId;
    private String type;

    public Type(long id, long product_id, String type){
        this.id = id;
        this.productId = product_id;
        this.type = type;
    }

    public Type(long productId, String type){
        this.productId = productId;
        this.type = type;
    }

    public Type() {}

    public long getId() {
        return id;
    }

    public long getProductId() {
        return productId;
    }

    public String getType() {
        return type;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public void setType(String type) {
        this.type = type;
    }
}
