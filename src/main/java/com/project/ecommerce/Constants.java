package com.project.ecommerce;


public class Constants {

    public static final String SHOW_ALL_WAREHOUSE="/allwarehouse";

    public static final String GET_ALL_PRODUCT="/products";
    public static final String GET_ONE_PRODUCT="/product/{id}";
    public static final String ADD_PRODUCT="/product/";
    public static final String UPDATE_PRODUCT="/product/{id}";

    public static final String DELETE_PRODUCT="/product/{id}";



    public static final String GET_PRODUCT_NAME="/product/products/productss/{name}";

    public static final String GET_ALL_CATOGERYES="/allcategories";
    public static final String GET_CATOGERY_NAME="/category/{name}";

    public static final String ADD_NEW_WAREHOUSE="/addnewwarehouse";
    public static final String GET_TOTAL_STOCK_OF_WAREHOUSE_BY_ID="/getquantity/{wareHouseId}";

    public static final String GET_ALL_PRODUCTS_IN_WAREHOUSE="/getproducts/{warehouseId}";
    public static final String DELETE_WAREHOUSE_BY_ID= "/deletewarehouse/{wareHouseId}";
    public static final String ADD_STOCK_OF_PRODUCT="/addstock/{productid}/{stock}";
    public static final String UPDATE_PRODUCT_AFTER_ORDER="/updatewarehouse";
    public static final String UPDATE_PROFIT_OF_WAREHOUSES_AFTER_ORDER="/updateprofit";
    public static final String FIND_WAREHOUSE_FROM_PRODUCT="/findwarehousefromproduct/{id}";
    public static final String UPDATE_AVAILABLE_STOCK_FROM_WAREHOUSE_STOCK="/updateavailablequantity";

    public static final String GET_PROFIT_SELL_OF_WAREHOUSE="/getprofit/{warehouseId}";
}
