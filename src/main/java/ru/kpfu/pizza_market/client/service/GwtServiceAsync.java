package ru.kpfu.pizza_market.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import ru.kpfu.pizza_market.model.Category;

import java.util.List;

public interface GwtServiceAsync {

    void getAllCategories(AsyncCallback<List<Category>> async);

}
