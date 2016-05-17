package ru.kpfu.pizza_market.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import ru.kpfu.pizza_market.model.Category;

import java.util.List;

/**
 * Created by Anvar on 11.05.16.
 */

@RemoteServiceRelativePath("springGwtServices/gwtService")
public interface GwtService extends RemoteService {

    List<Category> getAllCategories();

}
