<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#include "main-template.ftl"/>
<#macro m_body>

<div class="ui celled ordered list">
    <#if orders??>
        <#list orders as order>

        </#list>
    </#if>
    <div class="item">Cats</div>
    <div class="item">Horses</div>
    <div class="item">Dogs
        <div class="list">
            <div class="item">Labradoodles</div>
            <div class="item">Shiba Inu</div>
            <div class="item">Mastiff</div>
        </div>
    </div>
</div>

</#macro>
<@main title="Cart" customStyles=["/css/orders.css"]/>