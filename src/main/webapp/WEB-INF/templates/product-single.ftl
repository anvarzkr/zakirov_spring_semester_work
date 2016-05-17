<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "main-template.ftl"/>
<#macro m_body>

<div class="breadcrumb_block">
    <ul class="breadcrumb">
        <li><a href="/">Home</a></li>
        <li><a href="/products">Products</a></li>
        <li><a href="/categories/${product.category.id}">${product.category.name}</a></li>
        <li class="active">${product.name}</li>
    </ul>
</div>

<div class="product-single row">
    <div class="col-sm-6 col-md-4">
        <img src="/pizza_image/${product.id}" class="product-item-image img-responsive" alt="" />
    </div>
    <div class="col-sm-6 col-md-8">
        <h1>${product.name}</h1>
        <div class="properties">
            <strong>Category: </strong>
            <a href="/categories/${product.category.id}">${product.category.name}</a>
            <br>
            <strong>Price: </strong>
            ${product.price} ₽
            <br>
            <strong>Weight: </strong>
            ${product.weight} g.
            <br>
            <strong>Diameter size: </strong>
            ${product.diameterSize} sm.
            <br>
        </div>
        <div class="row">
            <div class="col-sm-12 col-md-8 cart-area">
                <div class="col-sm-12 price red">
                    ${product.price} ₽
                </div>
                <div class="col-sm-12 add-to-cart">
                    <form action="/cart/add/${product.id}" method="post">
                        <div class="ui action big input">
                            <input type="number" class="add-to-cart-amount" name="quantity" value="1" placeholder="Amount">
                            <button class="ui green big button">
                                <i class="fa fa-shopping-cart"></i>
                                <span class="cart-button-text">Add to Cart</span>
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="ui pointing secondary menu">
    <a class="item active" data-tab="1">Description</a>
    <a class="item" data-tab="2">Reviews(${reviews_count})</a>
</div>

<div class="ui tab segment active" data-tab="1">
    <#if product.description?has_content>
        <div class="product-description">
            ${product.description}
        </div>
    <#else>
        There's no description for this product.
    </#if>
</div>

<div class="ui tab segment col-md-8" data-tab="2">
    <div class="review-wrapper">
        <#if auth??>
            <@form.form action="/review/add/${product.id}" id="review-add-form" modelAttribute="reviewForm">
                <div class="ui form">
                    <div class="field">
                        <label for="">Rating:</label>
                        <div class="ui star huge rating" id="form-rating" data-max-rating="5"></div>
                        <@form.input path="rating" type="hidden" />
                    </div>
                    <div class="field">
                        <label for="">Review text:</label>
                        <@form.textarea path="text" placeholder="Review text..."/>
                    </div>
                    <button type="submit" class="ui blue labeled submit icon big button">
                        <i class="icon edit"></i> Add Review
                    </button>
                </div>
            </@form.form>
        <#else>
            <div class="ui warning message">
                <div class="header">
                    Please,
                    <a href="/sign_in"> Sign In </a>
                    to review this product.
                </div>
            </div>

        </#if>
    </div>
    <#if reviews?has_content>
        <div class="reviews row">
            <#list reviews as review>
                <#include "product-review-item.ftl"/>
            </#list>
        </div>
    <#else>
        <div class="message">

        </div>
        <div class="ui info message">
            <div class="header">
                There's no reiews yet. Be the first!
            </div>
        </div>
    </#if>
</div>

</#macro>
<@main title="${product.name}" customStyles=["/css/products.css"] customScripts=["https://cdn.jsdelivr.net/semantic-ui/2.1.8/components/tab.min.js", "/js/products.js"]/>