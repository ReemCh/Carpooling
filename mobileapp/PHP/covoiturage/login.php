<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Credentials: true");
header("Access-Control-Allow-Methods: POST, GET, OPTIONS");
header("Access-Control-Allow-Headers: Content-Type, Authorization, X-Requested-With");


$connection = mysqli_connect("localhost","root","","covoiturage");

if(isset($_GET["username"]) && isset($_GET["password"]) ){
	if( !empty($_GET["username"])  && !empty($_GET["password"])  ){
		$username=$_GET["username"];
		$password=$_GET["password"];
	}

}

 /* $data =json_decode(file_get_contents("php://input"));
$username = mysqli_real_escape_string($connection,$data->username);
$password = mysqli_real_escape_string($connection,$data->password);

echo "$username";
echo "$password"; */

$query = "SELECT * FROM `utilisateur` WHERE `username`= '$username' AND `upassword`='$password'";

$result = $connection->query($query);
$outp = "";
		if( $rs=$result->fetch_array()) {
			if ($outp != "") {$outp .= ",";}
			
			$outp .= '{"idU":"'  . $rs["id_utilisateur"] . '",';
			$outp .= '"nom":"'   . $rs["nom"]        . '",';
			$outp .= '"prenom":"'   . $rs["prenom"]        . '",';
			$outp .= '"password":"'. $rs["upassword"]     . '"}'; 
		}
		$outp ='{"records":'.$outp.'}';
		$connection->close();

		echo($outp); 

?>