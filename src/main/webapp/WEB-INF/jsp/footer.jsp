<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:useBean id="date" class="java.util.Date" />
<fmt:formatDate value="${date}" pattern="yyyy" var="currentYear" />

<footer class="bg-dark">
    <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Livraria Online <c:out value="${currentYear}" /></p></div>
</footer>