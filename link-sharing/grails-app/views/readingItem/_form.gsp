<%@ page import="com.ig.jan13.linksharing.ReadingItem" %>



<div class="fieldcontain ${hasErrors(bean: readingItemInstance, field: 'isFavourite', 'error')} ">
	<label for="isFavourite">
		<g:message code="readingItem.isFavourite.label" default="Is Favourite" />
		
	</label>
	<g:checkBox name="isFavourite" value="${readingItemInstance?.isFavourite}" />
</div>

<div class="fieldcontain ${hasErrors(bean: readingItemInstance, field: 'isRead', 'error')} ">
	<label for="isRead">
		<g:message code="readingItem.isRead.label" default="Is Read" />
		
	</label>
	<g:checkBox name="isRead" value="${readingItemInstance?.isRead}" />
</div>

<div class="fieldcontain ${hasErrors(bean: readingItemInstance, field: 'resource', 'error')} required">
	<label for="resource">
		<g:message code="readingItem.resource.label" default="Resource" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="resource" name="resource.id" from="${com.ig.jan13.linksharing.Resource.list()}" optionKey="id" required="" value="${readingItemInstance?.resource?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: readingItemInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="readingItem.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${com.ig.jan13.linksharing.User.list()}" optionKey="id" required="" value="${readingItemInstance?.user?.id}" class="many-to-one"/>
</div>

