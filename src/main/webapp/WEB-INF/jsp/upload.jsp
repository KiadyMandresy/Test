<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Upload One File:</h3>
      
<!-- MyUploadForm -->
<form method="POST" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data">
    <input type="file" name="file" /><br/><br/>
    <input type="submit" value="Submit" />
</form>
