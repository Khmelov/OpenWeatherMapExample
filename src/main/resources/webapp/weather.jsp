<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Weather: ${city}</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>

</head>
<body>

<div class="container">
    <div class="header clearfix">
        <nav>
            <ul class="nav nav-pills float-right">
                <li class="nav-item">
                    <a class="nav-link active" href=".">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
                </li>
            </ul>
        </nav>
        <h3 class="text-muted">Weather in ${city}</h3>
    </div>

    <div class="jumbotron">
        <p>
            <a class="btn btn-lg btn-success" href="get?city=Minsk" role="button">Minsk</a>
            <a class="btn btn-lg btn-success" href="get?city=Gomel" role="button">Gomel</a>
            <a class="btn btn-lg btn-success" href="get?city=Kiev" role="button">Kiev</a>
            <a class="btn btn-lg btn-success" href="get?city=Moscow" role="button">Moscow</a>
            <a class="btn btn-lg btn-success" href="get?city=London" role="button">London</a>
            <a class="btn btn-lg btn-success" href="get?city=Donetsk" role="button">Donetsk</a>
            <a class="btn btn-lg btn-success" href="get?city=Barselona" role="button">Barselona</a>
            <a class="btn btn-lg btn-success" href="get?city=Sankt-Peterburg" role="button">Sankt-Peterburg</a>
        </p>
        <h2 class="display-4">Now the temperature is ${value}</h2>
        <div data-component-maps="" style="min-height:500px;min-width:500px;position:relative">

            <iframe frameborder="0"
                    src="https://maps.google.com/maps?&amp;q=${city}&amp;z=10&amp;t=q&amp;output=embed" width="100"
                    height="100"
                    style="width:100%;height:100%;position:absolute;left:0px;">
            </iframe>
        </div>

        <p class="lead">Weather details for ${city}</p>
    </div>

    <div class="row marketing">


    </div>

    <footer class="footer">
        <p>IT Academy 2020</p>
    </footer>

</div> <!-- /container -->


</body>
</html>