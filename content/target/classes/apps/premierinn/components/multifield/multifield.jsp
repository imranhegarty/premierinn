
<jsp:directive.include file="/libs/foundation/global.jsp" />
<cq:includeClientLib categories="multifield" />

<c:if test="${empty fn:trim(properties.multifieldlist)}">
    <div id="multilist" style="border: 1px solid grey; background-color: #FFF0F0; width: 600px; height: auto;padding:7px">
        please configure...
    </div>
</c:if>
<c:if test="${not empty fn:trim(properties.multifieldlist)}">
    <div
        style="border: 1px solid grey; background-color: #F5FBFF; width: 600px; height: auto">
        <c:forEach var="items" items="${properties.multifieldlist}">
            <c:set var="listItem" value="${fn:split(items,'|')}" />
            <c:set var="title" value="${fn:trim(listItem[0])}" />
            <c:set var="richTextArea" value="${fn:trim(listItem[1])}" />
            <c:set var="image" value="${fn:trim(listItem[2])}" />
            <div id="elements" style="border: 1px solid grey; padding: 7px;margin-top:10px">
                <div style="padding-left:7px;margin-top:5px">
                    <div id="name">
                       </b>${title}
                    </div>
                    <div id="image">
                        ${richTextArea}
                    </div>
                    <div id="image" >
                        <img src="${image}" style="margin-left: 250px;border: 4px solid #FFCCCC;" align="centre" height="100" width="100"
                             title="Image" alt="image" />
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</c:if>

