package com.bestbuy.api.constants;

public class EndPoints {
    /**
     * This is Endpoints of product api
     */
    public static final String GET_ALL_PRODUCTS = "/products";
    public static final String GET_SINGLE_PRODUCTS = "/products/{id}";
    public static final String UPDATE_PRODUCTS_BY_ID = "/products/{id}";
    public static final String DELETE_PRODUCTS_BY_ID = "/products/{id}";

    /**
     * This is Endpoints of categories api
     */
    public static final String GET_ALL_CATEGORIES = "/categories";
    public static final String GET_SINGLE_CATEGORIES = "/categories/{id}";
    public static final String UPDATE_CATEGORIES_BY_ID = "/categories/{id}";
    public static final String DELETE_CATEGORIES_BY_ID = "/categories/{id}";

    /**
     * This is Endpoints of services api
     */
    public static final String GET_ALL_SERVICES = "/services";
    public static final String GET_SINGLE_SERVICES = "/{id}";
    public static final String UPDATE_SERVICES_BY_ID = "/{id}";
    public static final String DELETE_SERVICES_BY_ID = "/{id}";

    /**
     * This is Endpoints of stores api
     */
    public static final String GET_ALL_STORES = "/stores";
    public static final String GET_SINGLE_STORES = "/stores/{id}";
    public static final String UPDATE_STORES_BY_ID = "/stores/{id}";
    public static final String DELETE_STORES_BY_ID = "/stores/{id}";

}
