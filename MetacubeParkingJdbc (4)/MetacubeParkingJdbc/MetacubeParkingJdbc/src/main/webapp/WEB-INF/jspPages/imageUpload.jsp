
<%@ page contentType="text/html; charset = UTF-8" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<html>
   <head>
      <title>File Upload Example</title>
   </head>
   
   <body>
      <form:form modelAttribute = "image" action = "/fileUpload" enctype = "multipart/form-data" >
         Please select a file to upload : 
         <form:input type = "file" path = "image" ></form:input>
          <form:input path = "email" value = "${email}" hidden = "true"></form:input>
         <input type = "submit" value = "upload" />
      </form:form>
   </body>
</html>

<!--  <html>
<head>
      <title>Image Upload</title>
   </head>
   
   <body>
      <form:form modelAttribute = "image" action = "/fileUpload">
      <form:input path = "image"></form:input>
      <form:errors path = "image"></form:errors>
      <form:input path = "email" value = "${email}" hidden = "true"></form:input>
      
        <input type = "submit" value = "Upload">
      </form:form>
   </body>
</html>-->