<?php

header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Credentials: true");
header("Access-Control-Allow-Methods: POST, GET, OPTIONS");
header("Access-Control-Allow-Headers: Content-Type, Authorization, X-Requested-With");

$connection = mysqli_connect("localhost","root","","covoiturage");

if ($connection->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

 
$data =json_decode(file_get_contents("php://input"));



     $depart = mysqli_real_escape_string($connection,$data->lieudepart);
     $arrivee = mysqli_real_escape_string($connection,$data->lieuarrivee);
     $datetrajet = mysqli_real_escape_string($connection,$data->datetrajet);
     $prix = mysqli_real_escape_string($connection,$data->prix);
     $idUtilisateur = mysqli_real_escape_string($connection,$data->idUtilisateur);
       
  
     $query = " INSERT INTO `annonce`( `date_trajet`, `lieu_arrivee`, `lieu_depart`, `prix`, `id_utilisateur`)
      VALUES('$datetrajet','$arrivee','$depart','$prix','$idUtilisateur')";
 
     

 
if(mysqli_query($connection,$query)){
    echo "Add successfully\n";
 }else{
    die('Could not edit data');
 }
    
 

?>