<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Credentials: true");
header("Access-Control-Allow-Methods: POST, GET, OPTIONS");
header("Access-Control-Allow-Headers: Content-Type, Authorization, X-Requested-With");


$connection = mysqli_connect("localhost","root","","covoiturage");



if(isset($_GET["depart"]) && isset($_GET["arrivee"])&& isset($_GET["date"])&& isset($_GET["prix"])) {
	if( !empty($_GET["depart"]) && !empty($_GET["arrivee"]) && !empty($_GET["date"])&& !empty($_GET["prix"]) ){
		$depart=$_GET["depart"];
        $arrivee=$_GET["arrivee"];
        $date=$_GET["date"];
        $prix=$_GET["prix"];
       
    }
   

}



 $query="SELECT * FROM `annonce`,`utilisateur`WHERE `annonce`.`id_utilisateur`=`utilisateur`.`id_utilisateur`AND `lieu_depart`='$depart' AND `lieu_arrivee`='$arrivee'AND `prix`<='$prix' AND `date_trajet`>'$date' ORDER BY `annonce`.`date_trajet` ASC "; 




 $result = $connection->query($query);



  $outp = "";
    while($rs = $result->fetch_array(MYSQLI_ASSOC)) {
        if ($outp != "") {$outp .= ",";}
            $outp .= '{"idU":"'.$rs["id_utilisateur"].'",';
            $outp .= '"idTrajet":"'.$rs["id_annonce"].'",';
            $outp .= '"nomConducteur":"'.$rs["nom"].'",';
            $outp .= '"prenomConducteur":"'.$rs["prenom"].'",';
            $outp .= '"depart":"'.$rs["lieu_depart"].'",';
            $outp .= '"arrivee":"'.$rs["lieu_arrivee"].'",';
            $outp .= '"prix":"'.$rs["prix"].'",';
            $outp .= '"date":"'.$rs["date_trajet"].'"}';
  		

    }
    $outp ='{"records":['.$outp.']}';
    $connection->close();  


   echo($outp); 




?>