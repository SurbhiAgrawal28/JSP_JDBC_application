<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
            <title>Student Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> Student Management App </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Student</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${user != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${user == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${user != null}">
                                    Edit Student Details
                                </c:if>
                                <c:if test="${user == null}">
                                    Add New Student
                                </c:if>
                            </h2>
                        </caption>

                        
						<fieldset class="form-group">
                            <label>Student ID</label> <input type="number" value="<c:out value='${user.studentID}' />" class="form-control" name="sId" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Student Name</label> <input type="text" value="<c:out value='${user.studentName}' />" class="form-control" name="sName" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Student Specialization</label> <input type="text" value="<c:out value='${user.specialization}' />" class="form-control" name="spec">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Student Dept</label> <input type="text" value="<c:out value='${user.dept}' />" class="form-control" name="dept" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Student Semester</label> <input type="number" value="<c:out value='${user.semester}' />" class="form-control" name="semester">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Dob</label> <input type="date" value="<c:out value='${user.dob}' />" class="form-control" name="dob">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>CGPA</label> <input type=number step =0.01 value="<c:out value='${user.cgpa}' />" class="form-control" name="cgpa">
                        </fieldset>
                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>
</html>