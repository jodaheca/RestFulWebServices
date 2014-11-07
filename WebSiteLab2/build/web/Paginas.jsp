<%-- 
    Document   : Paginas
    Created on : 4/11/2014, 09:03:14 PM
    Author     : Joaquin David
--%>

<%@page import="DTO.FeedObjects"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.List"%>

<!--pagina html que muestra las paginas que estan registradas en la DB-->

<!DOCTYPE html>
<%     
    List paginas=(List) request.getAttribute("paginas");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Paginas</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div class="container">
                        <h1 class="text-center login-title"> Paginas Registradas</h1>
                                <div class="account-wall">
                        <br><br>
                     <% 
                            if(paginas==null){
                                %>
                                <div class="col-sm-6 col-md-4 col-md-offset-4">      
                                 <p class="bg-info">Ocurrió un error al recuperar las Paginas, intente Luego </p>
                                 </div>
                            <%
                            } else  if(paginas.size()==0){
                                %>
                                 <div class="col-sm-6 col-md-4 col-md-offset-4">    
                                     <p class="bg-info">No existen Paginas registradas </p>
                                 </div>
                        <%
                            }else{
                        %>   
                    <table class="table table-bordered">
                        <thead>
                            <tr> 
                                <th>Title</th> 
                                <th>Description</th> 
                                <th>Url</th>
                            </tr>
                        </thead> 
                        <tbody>
                            <%
                              for(int i=0;i<paginas.size();i++){
                                FeedObjects nueva=(FeedObjects) paginas.get(i);
                                String title=nueva.getTitle();
                                String description=nueva.getDescription();
                                String url=nueva.getUrl();

                            %>
                             <tr class="active">
                                <td><%=title%></td> 
                                <td><%=description%></td> 
                                <td><%=url%></td> 
                            </tr>

                            <%    
                            }  
                            %> 
                        </tbody>
                    </table>
                        <%
                            }
                        %>
                </div>
            </div>
    </body>
</html>
