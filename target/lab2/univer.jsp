<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>

    <title>Choose own</title>
</head>
<body>
<div class="">
    <form action="/UniverServlet" method="post">
        <label for="inputUniversity" class="form-label">University:</label>
        <div class="submission-field" style="width: 120px; height: 80px;">
        <input type="text" id="inputUniversity" name="university" class="form-control" aria-describedby="passwordHelpBlock">
        </div>
            <div id="passwordHelpBlock" class="form-text">
            Enter your University name in short, example: IITU (International Information Technology University).
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

</body>
</html>
