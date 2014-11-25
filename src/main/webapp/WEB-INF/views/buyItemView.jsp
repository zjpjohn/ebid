<%-- 
    Document   : buyItemView
    Created on : Nov 20, 2014, 10:24:29 AM
    Author     : Kawin
--%>

<%-- 
    Document   : viewItemView
    Created on : Nov 19, 2014, 9:15:51 PM
    Author     : Kawin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false" %>



<style type="text/css">
    .scrollable-menu {
        height: auto;
        max-height: 200px;
        overflow-x: hidden;
    }

    .centercontents {
        text-align: center !important;
    }

</style>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">

        <div class="container">
            <h4>หน้ายืนยันการซื้อสินค้า</h4>

            <h3>${item.title}</h3>
            <h3>ประเภท</h3> <h3>${item.category}</h3>
            <div class = "row">
                <div class="col-sm-4 col-md-4">
                    <div class="thumbnail">
                        <c:if test = "${fn:length(listPhotos)>0}"> 
                            <div class="item active">
                                <img src="${listPhotos[0].photoURL}" alt="..." class="carousel-img">
                            </div>
                        </c:if>
                    </div>
                </div>

                <div class="col-sm-8 col-md-8">	
                    <div class="caption">
                        <div class="panel-body">
                            <dl class="dl-horizontal">
                                <dt>จำนวนชิ้นที่ซื้อ</dt>
                                <dd>${invoice.quantity}</dd>
                            </dl>
                            <dl class="dl-horizontal">
                                <dt>ราคาต่อชิ้น</dt>
                                <dd>${item.price}</dd>
                            </dl>          
                        </div>
                    </div>
                </div>
            </div>
            <hr>
            <!--confirm buy waiting for invoice-->           
            <div class="centercontents"><h3>รวมเป็นเงิน ${invoice.total} บาท (ยังไม่รวมค่าจัดส่ง)</h3></div>
            
            <div class = "row centercontents">
            
            <c:url var="addAction" value="/buyItem/${item.itemID}/confirmBuy" ></c:url>
            <form:form action="${addAction}" modelAttribute="buyForm" method="POST" name="buyForm">
                <form:hidden path="quantity" />
                <input type="submit" class="btn btn-default" value="ยืนยันการซื้อ"/>
            </form:form>
                <a type="button" class="btn btn-default" href="${pageContext.request.contextPath}/viewItem/${item.itemID}">ยกเลิก</a>
            
         </div>
                
        </div>
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>

    </tiles:putAttribute>
</tiles:insertDefinition>

