<?php
    $con = mysqli_connect('localhost','root','','phone');
    if($_SERVER['REQUEST_METHOD']=='POST'){
        $phone = $_POST['num'];
        $sql = "SELECT * FROM `verify` where `phone`='$phone'";
        $sq=mysqli_query($con,$sql);
        
        if(mysqli_num_rows($sq)==1){
            echo "Present";
        }
        else{
            echo "Not Present";
        }
    
        mysqli_close($con);
    } else {
        echo "Error";
    }
?>