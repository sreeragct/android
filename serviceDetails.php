 <?php

    $con = mysqli_connect('localhost','root','','android');

    if($_SERVER['REQUEST_METHOD']=='GET'){
        $result = array();
        $sql = "SELECT * FROM `customer`";
        $sq=mysqli_query($con,$sql);
        while($arr=mysqli_fetch_array($sq)){
            $name=$arr['name'];
            $dob=$arr['dob'];
            $email=$arr['email'];
            array_push($result,array("name"=>$name,"dob"=>$dob,"email"=>$email));  
            }
        
    echo json_encode(array('result'=>$result));

    mysqli_close($con);
    } else {
    echo "error";
    }
?>