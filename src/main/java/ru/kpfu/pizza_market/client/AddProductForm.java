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

    static final ListBox list = new ListBox();

    public FormPanel getAddProductForm() {

        callback = new AsyncCallback<List<Category>>() {

            @Override
            public void onFailure(Throwable caught) {
                Window.alert(caught.getMessage());
            }

            @Override
            public void onSuccess(List<Category> categories) {
                for (Category category : categories) {
                    list.addItem(category.getName(), String.valueOf(category.getId()));
                }
            }
        };

        goodServiceAsyncService.getAllCategories(callback);
        VerticalPanel panel = new VerticalPanel();
        final FormPanel form = new FormPanel();
        form.setAction("/admin/add_product");
//        form.setEncoding(FormPanel.ENCODING_MULTIPART);
        form.setMethod(FormPanel.METHOD_POST);

        System.out.println(GWT.getModuleBaseURL());

        final Label status = new Label("");
        panel.add(status);

        Label itemNameLabel = new Label("Product name:");
        final TextBox nameForm = new TextBox();
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
        list.setName("category_id");
        panel.add(categoryProductLabel);
        panel.add(list);

        Label weightProductLabel = new Label("Weight:");
        final TextBox weightProductForm = new TextBox();
        weightProductForm.setName("weight");
        weightProductForm.getElement().setAttribute("type", "number");
        weightProductForm.getElement().setAttribute("min", "0");
        panel.add(weightProductLabel);
        panel.add(weightProductForm);

        Label diameterSizeProductLabel = new Label("Diameter Size:");
        final TextBox diameterSizeProductForm = new TextBox();
        diameterSizeProductForm.setName("diameter_size");
        diameterSizeProductForm.getElement().setAttribute("type", "number");
        diameterSizeProductForm.getElement().setAttribute("min", "0");
        panel.add(diameterSizeProductLabel);
        panel.add(diameterSizeProductForm);

        Label fileUploadLabel = new Label("Выберете картинку:");
        final FileUpload fileUpload = new FileUpload();
        fileUpload.setName("img");
        fileUpload.getElement().setAttribute("accept",".png, .jpg, .jpeg");
        panel.add(fileUploadLabel);
        panel.add(fileUpload);

        Button uploadButton = new Button("Add");
        panel.add(uploadButton);

        uploadButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (nameForm.getValue().length() == 0
                        || descriptionForm.getValue().length() == 0
                        || priceProductForm.getValue().length() == 0
                        || weightProductForm.getValue().length() == 0
                        || diameterSizeProductForm.getValue().length() == 0) {
                    status.setText("Please, fill out all fields!");
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
