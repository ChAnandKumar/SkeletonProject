package com.anand.skeletonproject.data.db;

import com.anand.skeletonproject.data.db.item_model.Item;
import com.anand.skeletonproject.data.db.item_model.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by anand.chandaliya on 04-05-2017.
 */

public interface DbHelper {

    /** User */
    Observable<Boolean> insertUser(User user);

    Observable<Boolean> isUserEmpty();

    Observable<User> getUserData();



    /** Item */
    Observable<List<Item>> getAllItems();

    Observable<Boolean> insertItem(Item item);

    Observable<Boolean> isItemEmpty();

    Observable<Item> getItemData();

    Observable<Boolean> saveItemList(List<Item> items);

    Observable<Boolean> updateFav(String itemId,boolean isFav);

    Observable<Boolean> updateCartItem(String itemId,boolean isInCart);


}
