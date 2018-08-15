 <?php

    $con = mysqli_connect('localhost','root','','phone');

    if($_SERVER['REQUEST_METHOD']=='GET'){
        $result = array();
        $sql = "SELECT * FROM `news`";
        $sq=mysqli_query($con,$sql);
        while($arr=mysqli_fetch_array($sq)){
            $title=$arr['title'];
            $content=$arr['content'];
            array_push($result,array("title"=>$title,"content"=>$content));  
            }
        
    echo json_encode(array('result'=>$result));

    mysqli_close($con);
    } else {
    echo "error";
    }
?>