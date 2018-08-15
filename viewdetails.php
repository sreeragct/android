 <?php

    $con = mysqli_connect('localhost','root','','phone');

    if($_SERVER['REQUEST_METHOD']=='GET'){
        $result = array();
        $sql = "SELECT * FROM `verify`";
        $sq=mysqli_query($con,$sql);
        while($arr=mysqli_fetch_array($sq)){
            $id=$arr['id'];
            $name=$arr['Name'];
            $age=$arr['age'];
            $gender=$arr['gender'];
            $address=$arr['address'];
            $phone=$arr['phone'];
            $email=$arr['email'];
            $branch=$arr['branch'];
            array_push($result,array("id"=>$id,"name"=>$name,"age"=>$age,"gender"=>$gender,"address"=>$address,"phone"=>$phone,"email"=>$email,"branch"=>$branch));  
            }
        
    echo json_encode(array('result'=>$result));

    mysqli_close($con);
    } else {
    echo "error";
    }
?>