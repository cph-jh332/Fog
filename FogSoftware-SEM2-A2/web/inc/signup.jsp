<h1>Signup</h1>
<form action="FrontController" method="post">

    <div class="form-group"><input type="email" name="email" class="form-control" placeholder="Skriv din e-mail..." required/></div>

    <div class="form-group"><input type="text" name="firstName" class="form-control" placeholder="Skriv dit fornavn..." required/></div>

    <div class="form-group"><input type="text" name="lastName" class="form-control" placeholder="Skriv dit efternavn..." required/></div>

    <div class="form-group"><input type="tel" name="phone" class="form-control" placeholder="Skriv dit telefonnummer..." pattern=".{8,8}" required/></div>

    <div class="form-group"><input type="text" name="streetName" class="form-control" placeholder="Skriv dit vejnavn..." required/></div>

    <div class="form-group"><input type="text" name="city" class="form-control" placeholder="Skriv din by..." required/></div>

    <div class="form-group"><input type="number" name="zipCode" class="form-control" placeholder="Skriv dit postnr..." pattern=".{4,4}" required/></div>

    <div class="form-group"><input type="password" name="password" class="form-control" placeholder="Skriv dit password..." required/></div>
    
    <div class="form-group text-right"><button type="submit" name="action" value="signup" class="btn btn-primary">Opret bruger</button></div>
    
    
</form>
