package com.project.ecommerce;


public class Constants {
    public static final String REQUEST_MAPPING= "/api/v1";
    public static final String UPDATE_CART_QUANTITY = "/cart/update";
    public static final String DELETE_CART_ITEM_BY_ID = "/cart/{id}";
    public static final String ADD_ITEMS_TO_CART = "/cart";
    public static final String GET_CART_BY_USERID = "/cart/{id}";
    public static final String DELETE_ALL_CART_ITEMS = "/cart/delete/{id}";  // Order
    public static final String GET_ORDER_BY_CUSTOMER_ID = "/orders";
    public static final String PLACE_NEW_ORDER = "/orders";
    public static final String RETURN_ORDER = "/orders";
    public static final String SHOW_ALL_WAREHOUSE = "/allwarehouse";
    public static final String GET_ALL_PRODUCT = "/products";
    public static final String GET_ONE_PRODUCT = "/product/{id}";
    public static final String ADD_PRODUCT = "/product/{warehouseId}";
    public static final String UPDATE_PRODUCT = "/product/{id}";
    public static final String DELETE_PRODUCT = "/product/{id}";
    public static final String ADD_NEW_SHIPMENT = "/addnewshipment";
    public static final String GET_PRODUCT_NAME = "/product/products/{name}";
    public static final String GET_ALL_CATOGERYES = "/allcategories";
    public static final String GET_CATOGERY_NAME = "/category/{name}";
    public static final String ADD_NEW_WAREHOUSE = "/addnewwarehouse";
    public static final String GET_TOTAL_STOCK_OF_WAREHOUSE_BY_ID = "/getquantity/{wareHouseId}";
    public static final String GET_ALL_PRODUCTS_IN_WAREHOUSE = "/getproducts/{warehouseId}";
    public static final String DELETE_WAREHOUSE_BY_ID = "/deletewarehouse/{wareHouseId}";
    public static final String ADD_STOCK_OF_PRODUCT = "/addstock/{productid}/{stock}";
    public static final String UPDATE_PRODUCT_AFTER_ORDER = "/updatewarehouse";
    public static final String UPDATE_PROFIT_OF_WAREHOUSES_AFTER_ORDER = "/updateprofit";
    public static final String FIND_WAREHOUSE_FROM_PRODUCT = "/findwarehousefromproduct/{id}";
    public static final String UPDATE_AVAILABLE_STOCK_FROM_WAREHOUSE_STOCK = "/updateavailablequantity";
    public static final String GET_PROFIT_SELL_OF_WAREHOUSE = "/getprofit/{warehouseId}";
    public static final String GET_ALL_SHIPMENT = "/getallshipment";
    public static final String SET_SHIPMENT_TO_ORDER = "/addshipmenttoorder";
    public static final String GET_OVERALL_PROFIT_OF_WAREHOUSE = "/account/{warehouseId}";
    public static final String SIGN_UP_BY_CUSTOMER = "/signup";
    public static final String SIGN_IN_BY_CUSTOMER = "/signin";
    public static final String GET_CUSTOMER_BY_EmailID = "/customer/{emailId}";
    public static final String GET_ALL_CUSTOMER = "/customer";
    public static final String UPDATE_CUSTOMER_DETAILS = "customerDetails";
    public static final String GET_ADDRESS_BY_CUSTOMERID = "/address/{customerId}";
    public static final String WAREHOUSE_WITH_MAXIMUM_PROFIT= "/warehousewithmaximumprofit";

}

