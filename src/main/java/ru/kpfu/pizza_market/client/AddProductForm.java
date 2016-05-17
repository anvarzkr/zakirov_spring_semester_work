package ru.kpfu.pizza_market.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import ru.kpfu.pizza_market.client.service.GwtService;
import ru.kpfu.pizza_market.client.service.GwtServiceAsync;
import ru.kpfu.pizza_market.model.Category;

import java.util.List;

/**
 * Created by Anvar on 11.05.16.
 */
public class AddProductForm {
    private GwtServiceAsync goodServiceAsyncService = GWT.create(GwtService.class);

    private AsyncCallback<List<Category>> callback;

    public FormPanel getAddProductForm() {

        final ListBox list = new ListBox();

        callback = new AsyncCallback<List<Category>>() {

            @Override
            public void onFailure(Throwable caught) {
                Window.alert(caught.getMessage());
            }

            @Override
            public void onSuccess(List<Category> categories) {
//                for (int i = 0; i < list.getItemCount(); i++) {
//                    list.removeItem(i);
//                }
                for (Category category : categories) {
                    list.addItem(category.getName(), String.valueOf(category.getId()));
                }
            }
        };

//        goodServiceAsyncService.getAllCategories(callback);
        VerticalPanel panel = new VerticalPanel();
        final FormPanel form = new FormPanel();
        form.setAction("/admin/add_item");
//        form.setEncoding(FormPanel.ENCODING_MULTIPART);
        form.setMethod(FormPanel.METHOD_POST);

        final Label status = new Label("");
        panel.add(status);

        Label itemNameLabel = new Label("Item name:");
        final TextBox nameForm;
        nameForm = new TextBox();
        nameForm.getElement().setAttribute("type", "text");
        nameForm.setName("name");
        panel.add(itemNameLabel);
        panel.add(nameForm);

        Label productDescriptionLabel = new Label("Description:");
        final TextBox descriptionForm = new TextBox();
        descriptionForm.getElement().setAttribute("type", "text");
        descriptionForm.setName("description");
        panel.add(productDescriptionLabel);
        panel.add(descriptionForm);

        Label priceProductLabel = new Label("Price:");
        final TextBox priceProductForm = new TextBox();
        priceProductForm.setName("price");
        priceProductForm.getElement().setAttribute("type", "number");
        priceProductForm.getElement().setAttribute("min", "0");
        panel.add(priceProductLabel);
        panel.add(priceProductForm);

        Label categoryProductLabel = new Label("Category name:");
        list.setVisibleItemCount(0);
        list.setName("category");
        panel.add(categoryProductLabel);
        panel.add(list);

        Label countItemLabel = new Label("Count:");
        final TextBox countItemForm = new TextBox();
        countItemForm.setName("count");
        countItemForm.getElement().setAttribute("type", "number");
        countItemForm.getElement().setAttribute("min", "1");
        panel.add(countItemLabel);
        panel.add(countItemForm);

        Button uploadButton = new Button("Add");
        panel.add(uploadButton);

        uploadButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String itemName = nameForm.getValue();
                if (itemName.length() == 0) {
                    status.setText("Заполните все поля!");
                    status.getElement().setClassName("error");
                } else {
                    form.submit();
                }
            }
        });

        form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
            @Override
            public void onSubmitComplete(FormPanel.SubmitCompleteEvent event) {
                status.setText("Success, item was added!");
                status.getElement().setClassName("success");
                countItemForm.setValue("");
                descriptionForm.setValue("");
                nameForm.setValue("");
            }
        });
        panel.setSpacing(10);

        form.add(panel);
        return form;
    }

    public void refresCategories() {
        goodServiceAsyncService.getAllCategories(callback);
    }
}
