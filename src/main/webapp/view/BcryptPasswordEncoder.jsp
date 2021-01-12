<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Bcrypt-Generator.com is a online tool to check Bcrypt hashes. You can also use it to generate new Bcrypt hashes for your other applications that require a Bcrypt encrypted string or password">
<link rel="icon" href="/favicon.ico">
<title>Bcrypt-Generator.com - Online Bcrypt Hash Generator &amp; Checker</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<link rel="canonical" href="https://bcrypt-generator.com">



<script data-ad-client="ca-pub-3314141934572275" async src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js" type="cebbb2b774063de105e90170-text/javascript"></script>
<style>
        #decrypt-hash {
            font-size: 0.8em;
            height: 3em;
        }

        @media  only screen and (max-width: 768px) {
            .alert {
                font-size: 0.8em;
            }
        }
        @media  only screen and (max-width: 570px) {
            .alert {
                font-size: 0.7em;
            }
        }
        @media  only screen and (max-width: 500px) {
            .alert {
                font-size: 0.6em;
            }
        }
        @media  only screen and (max-width: 430px) {
            .alert {
                font-size: 0.5em;
            }
        }

        #btn-copy {
          margin-left: 1rem;
          font-size: 0.7em;
          padding: 0.5em;
        }
    </style>
</head>
<body>
<header>
<div class="navbar navbar-dark bg-dark box-shadow">
<div class="container">
<a href="/" class="navbar-brand d-flex align-items-center">
<strong>Bcrypt-Generator.com <small class="d-none d-md-inline">- Online Bcrypt Hash Generator &amp; Checker</small></strong>
</a>
</div>
</div>
</header>
<main role="main">
<section class="text-center">
<div style="margin-top: 1em;" class="container">

<c:if test="${userclickedHash == true }">

<div class="row">
<div id="response" role="alert" class="col-md alert alert-success">
   ${encodedPassword}&nbsp  &nbsp <button class="btn btn-primary" onclick="copytext()">Copy</button>
</div>
</div>

</c:if>

<div class="row">
<div class="col-md">
<h1>Encrypt</h1>
<strong>Encrypt some text. The result shown will be a Bcrypt encrypted hash.</strong>
<br>
<br>
<form method="POST" action="/BcryptingPassowrd">
<div class="input-group mb-3">
<input name="string" type="text" class="form-control" placeholder="String to encrypt" aria-label="String to encrypt">
<div class="input-group-append">
<button class="btn btn-outline-primary" name="action" value="encrypt" type="submit">Hash!</button>
</div>
</div>
<div class="input-group mb-3">
<input name="rounds" value="12" type="number" min="4" max="18" class="form-control" aria-describedby="basic-addon2">
<div class="input-group-append">
<span class="input-group-text" id="basic-addon2">Rounds</span>
</div>
</div>
</form>
</div>
<div class="col-md">
 <h1>Decrypt</h1>
<strong>Test your Bcrypt hash against some plaintext, to see if they match.</strong>
<br>
<br>
<form method="POST" action="/">
<div class="input-group mb-3">
<input id="decrypt-hash" name="hash" type="text" class="form-control" placeholder="Hash to check">
</div>
<div class="input-group mb-3">
<input name="string" type="text" class="form-control" placeholder="String to check against" aria-label="String to check against">
<div class="input-group-append">
<button class="btn btn-outline-primary" name="action" value="decrypt" type="submit">Check!</button>
</div>
</div>
</form>
</div>
</div>
</div>
</section>
</main>

<script>

function copytext()
{
	var textid=document.getElementById("response");
	   textid.select();
	
	  textid.setSelectionRange(0, 99999)
	  document.execCommand("copy");
	

	alert("your clicke"+textid)
	
	}
</script>

<script src="https://cdn.jsdelivr.net/npm/clipboard@2.0.6/dist/clipboard.min.js" type="cebbb2b774063de105e90170-text/javascript"></script>

<script src="https://ajax.cloudflare.com/cdn-cgi/scripts/7089c43e/cloudflare-static/rocket-loader.min.js" data-cf-settings="cebbb2b774063de105e90170-|49" defer=""></script></body>
</html>
