<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.models.Student" %>
<%@ page import="org.example.db.DBManagerStudent" %>
<%@ page import="org.example.models.University" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lab3</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
</head>
<body>
<tbody>
<section class="vh-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row justify-content-center align-items-center h-100">
            <div class="col-12 col-lg-9 col-xl-7">
                <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Registration Form</h3>

                        <form action="/StudentServlet" method="post">
                            <div class="row">
                                <div class="col-md-6 mb-4">

                                    <div class="form-outline">
                                        <input type="text" name="fname" id="fName" class="form-control form-control-lg" />
                                        <label class="form-label" for="fName">First Name</label>
                                    </div>

                                </div>
                                <div class="col-md-6 mb-4">

                                    <div class="form-outline">
                                        <input type="text" name="lname" id="lName" class="form-control form-control-lg" />
                                        <label class="form-label" for="lName">Last Name</label>
                                    </div>

                                </div>
                            </div>

                            <div class="row">
                                <div class="col-12">

                                    <select class="select form-control-lg" name="university">
                                        <option value="1" disabled>Choose option</option>
                                        <%
                                            ArrayList<University> universities = DBManagerStudent.getAllUniversity();
                                            if(universities!=null){
                                                for (University u : universities){
                                        %>
                                        <option name="university"><%= u.getUni_name()%> </option>
                                        <%
                                                }
                                            }
                                        %>
                                    </select>
                                    <label class="form-label select-label">University</label>
                                    <a href="univer.jsp">Choose own</a>
                                </div>
                                <div class="col-13">
                                    <select class="select form-control-lg" name="age">
                                        <option value="1" disabled>Choose option</option>
                                        <option>16</option>
                                        <option>17</option>
                                        <option>18</option>
                                        <option>19</option>
                                        <option>20</option>
                                        <option>21</option>

                                    </select>
                                    <label class="form-label select-label">Age</label>

                                </div>
                            </div>

                            <div class="mt-4 pt-2">
                                <input class="btn btn-primary btn-lg" type="submit" value="Submit" />
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</tbody>
<tbody>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">NAME</th>
        <th scope="col">SURNAME</th>
        <th scope="col">AGE</th>
        <th scope="col">UNIVERSITY</th>
    </tr>
        </thead>
            <tbody>
    <%
        ArrayList<Student> students = DBManagerStudent.getAllStudents();
        if(students!=null){
            for (Student i: students) {
    %>
    <tr>
        <th scope="row"> <%= i.getId()%></th>
        <td>
            <%= i.getFname()%>
        </td>
        <td>
            <%= i.getLname()%>
        </td>
        <td>
            <%= i.getAge()%>
        </td>
        <td>
            <%= i.getUniversity()%>
        </td>
    </tr>
    <%
                }
        }
    %>
        </tbody>
    </table>
</tbody>

</body>
</html>
