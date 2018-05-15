<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Credentials: true");
header("Access-Control-Allow-Methods: POST, GET, OPTIONS");
header("Access-Control-Allow-Headers: Content-Type, Authorization, X-Requested-With");


$connection = mysqli_connect("localhost","root","","covoiturage");

if(isset($_GET["id"])) {
	if( !empty($_GET["id"])){
		$id=$_GET["id"];
    
    }
}





$query="SELECT * FROM `annonce`,`utilisateur` WHERE `id_annonce`='$id' AND `annonce`.`id_utilisateur`=`utilisateur`.`id_utilisateur`";

$result = $connection->query($query);
$outp = "";
    while($rs = $result->fetch_array(MYSQLI_ASSOC)) {
        if ($outp != "") {$outp .= ",";}
            $outp .= '{"dateNaissance":"'.$rs["date_de_naissance"].'",';
            $outp .= '"email":"'.$rs["email"].'",';
            $outp .= '"nomConducteur":"'.$rs["nom"].'",';
            $outp .= '"prenomConducteur":"'.$rs["prenom"].'",';
            $outp .= '"avis":"'.$rs["avis"].'",';
            $outp .= '"fumeur":"'.$rs["fumeur"].'",';
            $outp .= '"gender":"'.$rs["gender"].'",';
            $outp .= '"telephone":"'.$rs["telephone"].'"}';
  		

    }
    $outp ='{"annonces":['.$outp.']}';
    $connection->close();  


   echo($outp); 

?>