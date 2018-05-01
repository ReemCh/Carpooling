angular.module('starter.controllers', [])

.controller('detailTrajetCtrl',function($scope,$http,$filter,$ionicPopup,$ionicModal,$timeout,$state,$ionicHistory){


})


 .controller('listeTrajetsCtrl',function($scope,$http,$filter,$ionicPopup,$ionicModal,$timeout,$state,$ionicHistory){
  $scope.trajets = angular.fromJson( localStorage.getItem( 'trajets' ) );
  console.log($scope.trajets);
}) 

.controller('TrajetsCtrl', function($scope,$http,$filter,$ionicPopup,$ionicModal,$timeout,$state,$ionicHistory,$location) {
  $scope.nomU=sessionStorage.getItem('loggedin_usernom');
  $scope.prenomU=sessionStorage.getItem('loggedin_userprenom');
  

  $scope.AfficherTrajet=function(date,heure,depart,arrivee,prix,choix){

    $ionicPopup.confirm({
      title: '',
      template: 'Afficher la liste des Trajet?'

    }).then(function(res){
        if(res){
          $scope.newdate=$filter('date')(date,"yyyy-MM-dd")
          $scope.newtime=$filter('date')(heure,'HH:mm:sss')
          $scope.newdatetime=$scope.newdate+"T"+$scope.newtime+"Z"
            var recherche='depart='+depart+'&arrivee='+arrivee+'&date='+$scope.newdate+'&prix='+prix;

            $http.get('http://localhost/covoiturage/listeTrajets.php?'+recherche).success(function(data){
              $scope.trajets = data;
              localStorage.setItem( 'trajets', angular.toJson( $scope.trajets ) );

              
              $state.go('listeTrajets',{},{location:"replace",reload:true});


              

            })

        



        }else{


        }

    })


  }
  


  $scope.AjoutTrajet=function(date,heure,depart,arrivee,prix,choix){
    // Don't forget to inject the $ionicPopup service to your controller!
    // To fully enable IntelliSense for the $ionicPopup service, add the following line to the JSDoc header of your controller:
    // @param {ionic.popup.IonicPopupService} $ionicPopup – The $ionicPopup service
    
      $ionicPopup.confirm({
        title: '',
        template: 'Ajouter Trajet?'
      }).then(function(res) {
        if (res) {
          $scope.idUtilisateur=sessionStorage.getItem('loggedin_id')
    
    $scope.newdate=$filter('date')(date,"yyyy-MM-dd")
    $scope.newtime=$filter('date')(heure,'HH:mm:sss')
    $scope.newdatetime=$scope.newdate+"T"+$scope.newtime+"Z"
          $http.post(
            "http://localhost/covoiturage/insert.php",{
                    "lieudepart":depart,
                    "lieuarrivee":arrivee,
                    "datetrajet":$scope.newdatetime,
                    "prix":prix,
                    "idUtilisateur": $scope.idUtilisateur
            }
            ).success(function (data) {
              $ionicPopup.alert({
                title:'',
                template:'Trajet crée !'
              })
                depart=null;
                arrivee=null;
                heure=null;
                date=null;
                $scope.newdatetime=null;
                prix=null;
            }).error(function(error){console.log("erreur")
            
          });
          console.log('Popup was closed with OK');
        } else {
          console.log('Popup was closed with Cancel');
        }
      });
    
    
    
    /* console.log(depart)
    console.log(arrivee) 
    console.log($scope.newdatetime)
    console.log(prix)
    
     */
       
 }

})

.controller('loginCtrl',function($scope,$ionicModal,$timeout,$ionicPopup,$http,$state,$ionicHistory){
  $scope.login=function(username,password){
    
    if(username && password){
      var user_data='username=' +username+'&password='+password;
      $http.get(
        "http://localhost/covoiturage/login.php?"+user_data
                
        ).success(function(response){

          $scope.user=response.records;
          sessionStorage.setItem('loggedin_status',true);
          sessionStorage.setItem('loggedin_id',$scope.user.idU);
          sessionStorage.setItem('loggedin_usernom',$scope.user.nom);
          sessionStorage.setItem('loggedin_userprenom',$scope.user.prenom);
          

          

          $ionicHistory.nextViewOptions({
            disableAnimate:true,
            disableBack:true
          })

          $ionicPopup.alert({
            title:'',
            template:'Verifié '
          })

          $state.go('tab.dash',{},{location:"replace",reload:true});
      })
      .error(function(){

        $ionicPopup.alert({
          title:'erreur',
          template:'erreur'
        })
      });

    }else{
      $ionicPopup.alert({
        title:'Erreur',
        template:'saisir les deux champs svp !'
      })
    }

}
 

})

.controller('ChatsCtrl', function($scope, Chats) {
  // With the new view caching in Ionic, Controllers are only called
  // when they are recreated or on app start, instead of every page change.
  // To listen for when this page is active (for example, to refresh data),
  // listen for the $ionicView.enter event:
  //
  //$scope.$on('$ionicView.enter', function(e) {
  //});

  $scope.chats = Chats.all();
  $scope.remove = function(chat) {
    Chats.remove(chat);
  };
})

.controller('ChatDetailCtrl', function($scope, $stateParams, Chats) {
  $scope.chat = Chats.get($stateParams.chatId);
})

.controller('AccountCtrl', function($scope) {
  $scope.settings = {
    enableFriends: true
  };
});
