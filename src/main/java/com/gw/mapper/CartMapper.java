package com.gw.mapper;

import com.gw.pojo.Cart;
import com.gw.pojo.Goods;
import com.gw.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface CartMapper {
    List<Cart> selectAll();
    Cart selectById(int id);
    int add(@Param("usersid")int usersid,@Param("goodsid")int goodsid,@Param("price")double price,@Param("quantity")int quantity,@Param("goodsname") String goodsname);

    List<Cart> selectByCondition(@Param("usersid")int usersid,@Param("status")int status);
    Cart selectByUG(@Param("usersid")int usersid,@Param("goodsid")int goodsid);
    void updateUG(@Param("usersid")int usersid,@Param("goodsid")int goodsid,@Param("price")double price,@Param("quantity")int quantity,@Param("goodsname") String goodsname);
    void update(@Param("id")int id, @Param("quantity")int quantity);
    void del(@Param("id")int id);
    void purchase(Cart cart);
    List<Cart> showhistory();
    List<Cart> showuserhistory(@Param("usersid") int usersid);
    List<Cart> showgoodshistory();
}
