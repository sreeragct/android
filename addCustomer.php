<?php

    $con = mysqli_connect('localhost','root','','phone');

    if($_SERVER['REQUEST_METHOD']=='POST') {
        $phone = $_POST['phone'];
        
        
        $query = "SELECT * from `verify` where `phone`='$phone'";
        
        mysqli_query($con,$query);
        
        echo "Present";
        
        mysqli_close($con);
    } else {
        echo "Phone number not present!";
    }
?>