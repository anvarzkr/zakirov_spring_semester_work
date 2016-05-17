<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#include "main-template.ftl"/>
<#macro m_body>

<div class="ui items">
    <#if cart_items?has_content>
        <div class="products">
            <#list cart_items as cart_item>
                <#include "cart-item-template.ftl"/>
                <hr>
            </#list>
        </div>

        <div class="col-sm-12 text-right">
            <form action="/cart/order" id="form_shipping_info_remove" method="post">
                <#if shipping_info_list?has_content>

                    <div class="form-group">
                        <select name="shipping_info_id" class="form-control">
                            <#list shipping_info_list as shipping_info>
                                <option value="${shipping_info.id}">${shipping_info.address}</option>
                            </#list>
                        </select>
                    </div>

                </#if>

                <div class="ui left labeled big button" tabindex="0">
                    <a class="ui basic label overall-sum">
                        ${overall_sum} ₽
                    </a>
                    <button type="submit" class="ui right labeled icon big button teal">
                        <i class="right arrow icon"></i>
                        Checkout
                    </button>
                </div>
            </form>
        </div>
    <#else>
        <div class="ui warning message">
            <div class="header">There're no products in your cart yet!</div>
            <ul class="list">
                <li>Go to <a href="/products"> products page </a> and buy something!</li>
            </ul>
        </div>
    </#if>
</div>

</#macro>
<@main title="Cart" customStyles=["/css/cart.css"] customScripts=["/js/cart.js"]/>