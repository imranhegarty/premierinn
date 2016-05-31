<jsp:directive.include file="/libs/foundation/global.jsp" />
<cq:includeClientLib categories="core,multifield" />

<c:if test="${empty fn:trim(properties.multifieldlist)}">
    <div id="multilist">
        <h1>please configure...</h1>
    </div>
</c:if>
<c:if test="${not empty fn:trim(properties.multifieldlist)}">
    <div>
        <c:forEach var="items" items="${properties.multifieldlist}">
            <c:set var="listItem" value="${fn:split(items,'|')}" />
            <c:set var="title" value="${fn:trim(listItem[0])}" />
            <c:set var="richTextArea" value="${fn:trim(listItem[1])}" />
            <c:set var="image" value="${fn:trim(listItem[2])}" />
            <div id="elements">
                <div style="padding-left:7px;margin-top:5px">
                    <div id="name">
                       </b>${title}
                    </div>
                    <div id="image">
                        ${richTextArea}
                    </div>
                    <div id="image" >
                        <img src="${image}"/>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</c:if>

