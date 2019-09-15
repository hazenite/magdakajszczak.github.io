<%--
  Created by IntelliJ IDEA.
  User: mastanczak
  Date: 19.05.2019
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <!-- Required meta tags -->
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

      <!-- Bootstrap CSS -->
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

      <title>Spotify</title>
  </head>
  <body>
  <div class="container">

  <h1>Spotify:</h1>
      <hr>
  <h3>Dodaj piosenke:</h3>

  <form action="DodajPiosenke" method="POST">
      <div class="form-group">
          <label for="nazwa">Nazwa:</label>
          <input type="text" id="nazwa" class="form-control" name="NazwaPiosenki" placeholder="nazwa" required>
      </div>
      <div class="form-group">
          <label for="autor">Autor:</label>
          <input type="text" id="autor" name="NazwaAutora" class="form-control" placeholder="autor" required>
      </div>
      <button type="submit" class="btn btn-primary">Dodaj piosenke!</button>
  </form>
  </div>
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>
