<?php
    $con = mysqli_connect('localhost','root','','phone');
    if($_SERVER['REQUEST_METHOD']=='POST'){
        $id = $_POST['id'];
        $name = $_POST['name'];
        $age = $_POST['age'];
        $gender = $_POST['gender'];
        $address = $_POST['address'];
        $phone = $_POST['phone'];
        $email = $_POST['email'];
        $branch = $_POST['branch'];
        $sql = "UPDATE `verify` SET `Name`='$name',`age`='$age',`gender`='$gender',`address`='$address',`phone`='$phone',`email`='$email',`branch`='$branch' WHERE `id`='$id'";
        $sq=mysqli_query($con,$sql);
       
        
      if($sql){
          echo "Inserted";
      }
        
    
        mysqli_close($con);
    } else {
        echo "Error";
    }
?>