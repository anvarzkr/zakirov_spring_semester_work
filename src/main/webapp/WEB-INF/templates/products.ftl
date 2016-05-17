<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#include "main-template.ftl"/>
<#macro m_body>

<div class="breadcrumb_block">
    <ul class="breadcrumb">
        <li><a href="/">Home</a></li>
        <li class="active"><a href="/products">Products</a></li>
    </ul>
</div>

<div class="ui pointing secondary menu">
    <a class="item active" data-tab="1">All</a>
    <a class="item" data-tab="2">Bestsellers</a>
    <a class="item" data-tab="3">Latest</a>
</div>

<div class="row">

    <div class="col-sm-12">
        <div class="ui tab segment active" data-tab="1">

            <div class="ui text menu sorter">
                <div class="header item">Sort By</div>

                <a class="item ${filter?contains('price_up')?then('active', '')}" href="/products?filter=price_up">
                    Price Up
                </a>
                <a class="item ${filter?contains('price_down')?then('active', '')}" href="/products?filter=price_down">
                    Price Down
                </a>
                <a class="item ${filter?contains('name_up')?then('active', '')}" href="/products?filter=name_up">
                    Name Up
                </a>
                <a class="item ${filter?contains('name_down')?then('active', '')}" href="/products?filter=name_down">
                    Name Down
                </a>
            </div>

            <#if products?has_content>
                <div class="products row">
                    <#list products as product>
                        <#include "product-template.ftl"/>
                    </#list>
                </div>
            </#if>
        </div>

        <div class="ui tab segment" data-tab="2">
            <#if productsBestsellers?has_content>
                <div class="products row">
                    <#list productsBestsellers as product>
                        <#include "product-template.ftl"/>
                    </#list>
                </div>
            </#if>
        </div>

        <div class="ui tab segment" data-tab="3">
            <#if productsLatest?has_content>
                <div class="products row">
                    <#list productsLatest as product>
                        <#include "product-template.ftl"/>
                    </#list>
                </div>
            </#if>
        </div>

    </div>

</div>


</#macro>
<@main title="Products" customStyles=["/css/products.css"] customScripts=["https://cdn.jsdelivr.net/semantic-ui/2.1.8/components/tab.min.js", "/js/products.js"]/>