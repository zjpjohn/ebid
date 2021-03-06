<%-- 
    Document   : searchResultView
    Created on : Nov 17, 2014, 9:35:04 PM
    Author     : mtmmoei
--%>

<%@page import="com.se.ebid.controller.CountryList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<style type="text/css">

    .thumbnail a img {
        /*        max-height: 250px;*/
        margin: 0 auto;
        width: 100%
    }

    .center {
        float: none;
        margin-left: auto;
        margin-right: auto;
    }

    .centercontents {
        text-align: center !important;
    }

</style>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <div class="container">
            <h3>
                <c:choose>

                    <c:when test="${fn:length(listItems)>0}"> 
                        ผลการค้นหาคำว่า ${keyword} จาก ${category}

                    </c:when>
                    <c:otherwise>
                        ไม่พบสินค้า
                    </c:otherwise>
                </c:choose>
            </h3>
            <hr>
            <c:forEach items="${listItems}" var = "item" varStatus="status">
                <div class = "row">
                    <div class="col-sm-4 col-md-4">
                        <div class="thumbnail">
                            <a href="viewItem/${item.itemID}"><img src="${listPhotos[status.index].photoURL}" alt=""></a>
                        </div>
                    </div>
                    <div class="col-sm-8 col-md-8">	
                        <div class="caption">	
                            <a href="viewItem/${item.itemID}"><h3>${item.title}</h3></a>
                             <c:choose>
                                        <c:when test = "${item.sellingType=='BUY'}">
                                            <h4>${item.price} บาท</h4><h4><span class="label label-success">ซื้อทันที</span></h4>
                                        </c:when>


                                        <c:when test="${currentDate > item.endTime}"> 
                                            <h4>หมดเวลาประมูล</h4>
                                            <h4><span class="label label-warning">ประมูล</span></h4>
                                        </c:when>

                                        <c:otherwise>
                                            <h4>ราคาปัจจุบัน ${item.price} บาท</h4><h4><span class="label label-warning">ประมูล</span></h4>
                                        </c:otherwise>
                                    </c:choose>
                          
                        </div>
                    </div>
                </div>
                <hr>
            </c:forEach>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>
