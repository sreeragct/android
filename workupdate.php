<?php
    $con = mysqli_connect('localhost','root','','phone');
    if($_SERVER['REQUEST_METHOD']=='POST'){
        $num = $_POST['num'];
        $date = $_POST['date'];
        $text = $_POST['text'];
        $sql = "INSERT INTO `workupdate`(`phone`, `date`, `review`) VALUES ('$num','$date','$text')";
        $sq=mysqli_query($con,$sql);
       
        
       echo "Inserted";
        
    
        mysqli_close($con);
    } else {
        echo "Error";
    }
?>