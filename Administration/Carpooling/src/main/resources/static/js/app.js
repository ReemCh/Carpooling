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
   
});

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
	//$scope.id=idUtilisateur;
	$scope.showMe = false;
	 $scope.showMe2=false;
	/* $scope.utilisateur={
			 "idUtilisateur":idUtilisateur,
			 "nom":nom,
			 "prenom":prenom,
			 "cin":cin
	 }*/
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
	    	 console.log(idUtilisateur);
	    	 $http.get("http://localhost:8080/utilisateurs/"+idUtilisateur).success(function(data){
	    		 $scope.user=data;

	 			$scope.getAnnonces(idUtilisateur);
	 			$scope.getReservations(idUtilisateur);
	    		 $scope.showMe=true;
	    		 $scope.showMe2=false;
	    		
	    		 
	    		 
	    	 });
	    	 $scope.goToPageAnnonce=function(p){
		    	 $scope.pageCourante=p;
		    	$scope.getAnnonces(IdUtilisateur);}
	    	 
	    	 
	    	 $scope.goToPageReservation=function(p){
		    	 $scope.pageCourante=p;
		    	$scope.getReservations(idUtilisateur);}
			
			$scope.getAnnonces=function(idUtilisateur){
				 $http.get("http://localhost:8080/annonces?id="+idUtilisateur+"&page="+$scope.pageCouranteAnnonce+"&size="+$scope.pageSize)
		 			.success(function(data) {
		 				$scope.annonces = data;
		 				$scope.pagesAnnonces=new Array(data.totalPages);
		 			
		 			});
			};
			
			$scope.getReservations=function(idUtilisateur){
				 $http.get("http://localhost:8080/reservations?id="+idUtilisateur+"&page="+$scope.pageCouranteReservation+"&size="+$scope.pageSize)
		 			.success(function(data) {
		 				$scope.reservations = data;
		 				$scope.pagesReservations=new Array(data.totalPages);
		 			
		 			});
			};
			


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
	     
	     
	     $scope.updateData=function(idUtilisateur,nom,prenom,cin){
	    	 $scope.showMe2=true;
	    	 
	    	 $scope.idUtilisateur=idUtilisateur;
	    	 $scope.nom=nom;
	    	 $scope.prenom=prenom;
	    	 $scope.cin=cin;
             $scope.utilisateur={
            		 'idUtilisateur':$scope.idUtilisateur,
            		 'nom':$scope.nom,
             		'prenom':$scope.prenom,
             		'cin':$scope.cin,
             }
             
           //  console.log($scope.utilisateur)
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



	     
	     
	       
	     
	
	     
