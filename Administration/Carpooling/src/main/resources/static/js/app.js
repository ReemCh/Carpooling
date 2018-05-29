var app=angular.module("MyApp", ["ngRoute"])

app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "Acceuil.html"
    })
    .when("/acceuil", {
        templateUrl : "Acceuil.html"
    })
    .when("/users", {
        templateUrl : "listeUsers.html",
        controller: "UtilisateursControlleur"
    })
    .when("/stat", {
        templateUrl : "Statistiques.html",
        controller: "statControlleur"
    })
   
});



app.controller("statControlleur", function($scope,$http) {
	//$scope.ttAnnonces=[];
	$scope.pageCourantetA=0;
	$scope.pageSize=6;
	$http.get("http://localhost:8080/statistiques").success(function(data) {
		$scope.stat = data;
		console.log($scope.stat);

	});
	
	$scope.show1=true;
	$scope.show3=true;
	
	$scope.getttRes=function(){
		$http.get("http://localhost/covoiturage/geResAdmin.php").success(function(data){
			$scope.ttRes=data;
			console.log($scope.ttRes)
		})
	}
	$scope.getttRes();
	
	$scope.gettAnnonces=function(){
	$http.get("http://localhost:8080/tousAnnonces?page="+$scope.pageCourantetA+"&size="+$scope.pageSize)
	.success(function(data){
		$scope.ttAnnonces=data;
		$scope.pages=new Array(data.totalPages);
		
	})}
	$scope.gettAnnonces();
	
	$scope.goToPagettA=function(p){
   	 $scope.pageCourantetA=p;
   	$scope.gettAnnonces();}
	
	$scope.chercher=function(dateDebut,dateFin){
		console.log(dateDebut)
		
		$http.get("http://localhost:8080/rechAnnonces?debut="+dateDebut+"&fin="+dateFin)
		.success(function(data){
			$scope.ann=data;
			//console.log($scope.ann);
			$scope.show1=false;
			$scope.show2=true;
		})
	}
	
	$scope.chercherR=function(dateDebut,dateFin){
		console.log(dateDebut)
		
		$http.get("http://localhost/covoiturage/rechReservation.php?debut="+dateDebut+"&fin="+dateFin)
		.success(function(data){
			$scope.ttRes1=data;
			console.log($scope.ttRes1);
			$scope.show3=false;
			$scope.show4=true;
		})
	}
	
	
	
})



app.controller("UtilisateursControlleur", function($scope,$http) {
	$scope.user=null;
	$scope.users=[];
	$scope.pageCouranteUser=0;
	$scope.pageCouranteAnnonce=0;
	$scope.pageCouranteReservation=0;
	$scope.pagesReservations=[]
	$scope.pagesAnnonces=[]
	$scope.pageSize=3;
	$scope.pagesUsers=[];
	console.log($scope.idU)
	
	
	
	
	$scope.showMe = false;
	 $scope.showMe2=false;
	 $scope.utilisateur=this;
	 
	 
	 
	
	 
		$scope.getUsers=function(){
		$http.get("http://localhost:8080/utilisateurs?page="+$scope.pageCouranteUser+"&size="+$scope.pageSize)
		.success(function(data) {
			$scope.users = data;
			$scope.pagesUsers=new Array(data.totalPages);

		});
		};
		
		$scope.getUsers();  
		
		$scope.goToPage=function(p){
	    	 $scope.pageCouranteUser=p;
	    	$scope.getUsers();}		
		
		
	     
	     $scope.getUser=function(idUtilisateur){
	    	 
	    	 $scope.imgU='http://localhost/covoiturage/images/users/'+idUtilisateur+'.png';
	    	 
	    	console.log(idUtilisateur);
	    	sessionStorage.setItem('idUtilisateur', idUtilisateur);
	    	 $http.get("http://localhost:8080/utilisateurs/"+idUtilisateur).success(function(data){
	    		 $scope.user=data;

	 			$scope.getAnnonces(idUtilisateur);
	 			$scope.getReservations(idUtilisateur);
	 			$scope.getVoitures(idUtilisateur);
	 			
	 			//$scope.imgV='http://localhost/covoiturage/images/cars/'+$scope.idVoiture+'.png'
	 			
	    		 $scope.showMe=true;
	    		 $scope.showMe2=false;

		    	
	    		 
	    		
	    		 
	    		 
	    	 });
	    	 
	    	 
	    	 
	    	$scope.idUt=parseInt(sessionStorage.getItem('idUtilisateur'));
	    	console.log($scope.idUt)
	    	
	    	$scope.getVoitures=function(idUtilisateur){
	   		 $http.get("http://localhost:8080/voitures?id="+idUtilisateur)
	   		 .success(function(data){
	   			 $scope.voitures=data;
	   			 console.log($scope.voitures)
	   		 })
	   		 
	   	 }
	    	 
			
			$scope.getAnnonces=function(idUtilisateur){
				 $http.get("http://localhost:8080/annonces?id="+idUtilisateur+"&page="+$scope.pageCouranteAnnonce+"&size="+$scope.pageSize)
		 			.success(function(data) {
		 				$scope.annonces = data;
		 				$scope.pagesAnnonces=new Array(data.totalPages);
		 			
		 			});
			};
			
			$scope.goToPageAnnonce=function(p){
	    		 
		    	 $scope.pageCouranteAnnonce=p;
		    	$scope.getAnnonces($scope.idUt);}
			
			$scope.getReservations=function(idUtilisateur){
				 $http.get("http://localhost:8080/annoncesRes?id="+idUtilisateur+"&page="+$scope.pageCouranteReservation+"&size="+$scope.pageSize)
		 			.success(function(data) {
		 				$scope.reservations = data;
		 				$scope.pagesReservations=new Array(data.totalPages);
		 				console.log($scope.reservations[1].lieuDepart)
		 			
		 			});
			};
			$scope.goToPageReservation=function(p){
				console.log(idUtilisateur)
		    	 $scope.pageCourante=p;
		    	$scope.getReservations(idUtilisateur);}
			


	     };
	     
	     $scope.deleteUser=function(idUtilisateur){
	    	if(confirm("Vous etes Sur?!!")){
	     $http.delete("http://localhost:8080/utilisateurs/"+idUtilisateur)
	     .success(
	         function(data){
	           // success callback
	        	 $scope.getUsers(); 
	        	 alert("utilisateur supprime avec succes !")
	         }, 
	         
	      ).error(function(err){console.log("not done");})
	    	}else return false;		 
	     
	    	 
	     };
	     
	     
	     $scope.updateData=function(idUtilisateur,nom,prenom,cin,telephone,avis,email){
	    	 $scope.showMe2=true;
	    	 
	    	 $scope.idUtilisateur=idUtilisateur;
	    	 $scope.nom=nom;
	    	 $scope.prenom=prenom;
	    	 $scope.cin=cin;
	    	 $scope.telephone=telephone;
	    	 $scope.avis=avis;
             $scope.utilisateur={
            		 'idUtilisateur':$scope.idUtilisateur,
            		 'nom':$scope.nom,
             		'prenom':$scope.prenom,
             		'cin':$scope.cin,
             		'avis':avis,
             		'telephone':telephone,
             		'email':email
             }
             
           // console.log($scope.utilisateur)
	     };
	     
	     
	     
	     
	     $scope.saveUser=function(idUtilisateur,utilisateur){
	    	 console.log(utilisateur)
	    	 console.log("d5alna fel fonction")
	         $http.put("http://localhost:8080/utilisateurs/"+$scope.idUtilisateur,$scope.utilisateur)
	          .success(function(){

	             alert("successfully updated");
	             $scope.getUsers();
	             $scope.showMe2=false;

	           });
	       };
});



	     
	     
	       
	     
	
	     
