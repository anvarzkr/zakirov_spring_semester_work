<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#include "main-template.ftl"/>
<#macro m_body>

<div class="breadcrumb_block">
    <ul class="breadcrumb">
        <li><a href="/">Home</a></li>
        <li><a href="/products">Products</a></li>
        <li class="active">${category.name}</li>
    </ul>
</div>

<#if products?has_content>
    <div class="products row">
        <#list products as product>
            <#include "product-template.ftl"/>
        </#list>
    </div>
</#if>

</#macro>
<@main title="Products" customStyles=["/css/products.css"] customScripts=["https://cdn.jsdelivr.net/semantic-ui/2.1.8/components/tab.min.js", "/js/products.js"]/>