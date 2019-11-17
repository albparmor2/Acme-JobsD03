a<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

   
<acme:form>
<jstl:if test="${command != 'create'}">
    <acme:form-textbox code="provider.requesta.form.label.ticker" path="ticker" readonly="true"/>
	<acme:form-textbox code="provider.requesta.form.label.title" path="title" readonly="true"/>
	<acme:form-moment code="provider.requesta.form.label.moment" path="moment" readonly="true"/>
	<acme:form-textarea code="provider.requesta.form.label.description" path="description" readonly="true"/>
	<acme:form-moment code="provider.requesta.form.label.deadline" path="deadline" readonly="true"/>
	<acme:form-money code="provider.requesta.form.label.reward" path="reward" readonly="true"/>
</jstl:if>

<jstl:if test="${command == 'create'}">
	<acme:form-textbox code="provider.requesta.form.label.ticker" path="ticker"/>
	<acme:form-textbox code="provider.requesta.form.label.title" path="title"/>
	<acme:form-url code="provider.requesta.form.label.description" path="description"/>
	<acme:form-moment code="provider.requesta.form.label.deadline" path="deadline"/>
	<acme:form-money code="provider.requesta.form.label.reward" path="reward"/>
	<acme:form-checkbox code="provider.requesta.form.label.confirmRequesta" path="confirmRequesta"/>
	
	<acme:form-submit
	 code="provider.requesta.form.button.create"
	 action="/provider/requesta/create"/>
	 </jstl:if>
	
	<acme:form-return code="provider.requesta.form.button.return"/>
</acme:form>