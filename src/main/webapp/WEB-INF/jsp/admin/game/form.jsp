<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../tag.jsp" %>
<c:set var="title" scope="request" value="Form game"/>
<jsp:include flush="true" page="../base_admin.jsp"/>

<div class="container">
    <h1>Create Game</h1>
    <f:form modelAttribute="gameDto" method="post" action="${action}" cssClass="p-5">
        <div class="mb-3 row">
            <f:label path="countries" class="col-sm-2 col-form-label">Country</f:label>
            <div class="col-sm-10">
                <input class="form-control" data-multiple-select-input="country"/>
                <f:select path="countries"
                          multiple="multiple"
                          items="${countries}"
                          cssClass="form-select"
                          itemLabel="name"
                          data-multiple-select="country"
                >
                </f:select>
            </div>
        </div>
        <f:button class="btn btn-secondary" type="reset">Reset</f:button>
        <f:button class="btn btn-primary">Submit</f:button>
    </f:form>
</div>

<%@ include file="../footer_admin.jsp" %>
