 <?php
    
    $con = mysqli_connect('localhost','root','','phone');
    
    
     if($_SERVER['REQUEST_METHOD']=='GET'){
        $result = array();
        
        $sql = "SELECT * FROM `attendance`";
        $sq=mysqli_query($con,$sql);
        while($arr=mysqli_fetch_array($sq)){
            $id=$arr['id'];
            $phone=$arr['phone'];
            $date=$arr['date'];
            $an=$arr['an'];
            $fn=$arr['fn'];
            array_push($result,array("id"=>$id,"date"=>$date,"an"=>$an,"fn"=>$fn));  
            }
        
    echo json_encode(array('result'=>$result));

    mysqli_close($con);
    } else {
    echo "error";
    }
?>