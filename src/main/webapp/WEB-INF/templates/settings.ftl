<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>

<#include "main-template.ftl"/>
<#macro m_body>

<div class="col-sm-12 col-md-6 col-lg-6">
    <div class="well">
        <@form.form action="/settings" id="form_settings" method="post" modelAttribute="userForm" class="form-horizontal">
            <fieldset>
                <legend>Settings</legend>

                <#if changed??>
                    <div class="ui positive message">
                        <div class="header">
                            Settings have been changed!
                        </div>
                    </div>
                </#if>

                <div class="form-group">
                    <label for="email" class="col-lg-3 col-md-3 control-label">Email</label>
                    <div class="col-lg-9 col-md-9">
                        <@form.input path="email" type="email" placeholder="Email" class="form-control" disabled=true/>
                        <@form.errors path="email" element="div" class="input-has-error"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="password" class="col-lg-3 col-md-3 control-label">Password</label>
                    <div class="col-lg-9 col-md-9">
                        <@form.input path="password" type="password" placeholder="Password"  class="form-control"/>
                        <@form.errors path="password" element="div" class="input-has-error"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="password_retype" class="col-lg-3 col-md-3 control-label">Re-Password</label>
                    <div class="col-lg-9 col-md-9">
                        <input id="password_retype" type="password" placeholder="Password re-type"  class="form-control" />
                        <div id="password_retype_error" class="input-has-error">
                            Re-typed Password is wrong!
                        </div>
                    </div>
                </div>

                <hr>

                <div class="form-group">
                    <label for="firstName" class="col-lg-3 col-md-3 control-label">First Name</label>
                    <div class="col-lg-9 col-md-9">
                        <@form.input path="firstName" type="text" placeholder="First name" class="form-control" required="required"/>
                        <@form.errors path="firstName" element="div" class="input-has-error"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="lastName" class="col-lg-3 col-md-3 control-label">Last Name</label>
                    <div class="col-lg-9 col-md-9">
                        <@form.input path="lastName" type="text" placeholder="Last name" class="form-control" required="required"/>
                        <@form.errors path="lastName" element="div" class="input-has-error"/>
                    </div>
                </div>

                <br>

                <button type="submit" class="btn btn-success">
                    Update
                </button>
            </fieldset>
        </@form.form>
    </div>
</div>

<div class="col-sm-12 col-md-6 col-lg-6">
    <div class="well">
        <form action="/shipping_info/add" id="form_shipping_info_add" method="post">
            <fieldset>
                <legend>Shipping Info</legend>

                <div class="form-group">
                    <label for="address-input">Full Shipping Address</label>
                    <input type="text" name="address" id="address-input" placeholder="Full address" class="form-control"/>
                </div>

                <button type="submit" class="ui button green">
                    Add
                </button>
            </fieldset>
        </form>
        <br>
        <#if shipping_info_list?has_content>
            <form action="/shipping_info/remove" id="form_shipping_info_remove" method="post">
                <div class="form-group">
                    <select name="shipping_info_id" class="form-control">
                        <#list shipping_info_list as shipping_info>
                            <option value="${shipping_info.id}">${shipping_info.address}</option>
                        </#list>
                    </select>
                </div>
                <button type="submit" class="ui button red">
                    Remove
                </button>
            </form>
        </#if>
    </div>
</div>

</#macro>
<@main title="Settings" customScripts=["/js/settings.js"]/>