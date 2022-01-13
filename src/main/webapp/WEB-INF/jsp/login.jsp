<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>CodePen - Login/Registration Form Transition</title>
  <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'><link rel="stylesheet" href="style.css">

</head>
<body>
<!-- partial:index.partial.html -->
<p class="tip"></p>
<div style="margin-top: 190px" class="cont">
  <div style="margin-top: 50px" class="form sign-in">
    <h2>Bienvenue,</h2>
    <label>
      <span>Votre nom ( ou mail )</span>
      <input type="text" name="mail"/>
    </label>
    <label>
      <span>Mot de passe</span>
      <input type="password" name="mdp" />
    </label>
    <button type="submit" class="submit">Se connecter</button>
    
  </div>
  <div class="sub-cont">
    <div class="img">
      <div class="img__text m--up">
        <h2>Admin</h2>
        <p>Signalement</p>
      </div>
      <div class="img__text m--in">
        <h2>One of us?</h2>
        <p>If you already has an account, just sign in. We've missed you!</p>
      </div>
     
        <span class="m--in">Sign In</span>
      </div>
    </div>
    <div class="form sign-up">
      <h2>Time to feel like home,</h2>
      <label>
        <span>Votre nom ( ou mail )</span>
        <input type="text" name="mail"/>
      </label>
      <label>
        <span>Mot de passe</span>
        <input type="password" name="mdp" />
      </label>
      <button type="submit" class="submit">Se connecter</button>
      
    </div>
  </div>
</div>

<!-- partial -->
  <script  src="script.js"></script>

</body>
</html>
