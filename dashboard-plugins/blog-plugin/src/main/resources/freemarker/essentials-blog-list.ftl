<#include "/WEB-INF/freemarker/include/imports.ftl">
<#-- @ftlvariable name="pageable" type="org.onehippo.cms7.essentials.components.paging.Pageable" -->
<#if pageable??>
    <#list pageable.items as item>
        <@hst.link var="link" hippobean=item />
    <article>
        <h3><a href="${link}">${item.title}</a></h3>
        <#if item.publicationDate?? && item.publicationDate.time??>
            <p><@fmt.formatDate value=item.publicationDate.time type="both" dateStyle="medium" timeStyle="short"/></p>
        </#if>
        <p>${item.introduction}</p>
    </article>
    </#list>
    <#if pageable.showPagination??>
        <#include "/WEB-INF/freemarker/include/pagination.ftl">
    </#if>
</#if>