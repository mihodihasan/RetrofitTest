<?php

$host = "localhost";
$user = "root";
$pass = "";
$db_name = "bajimaat";

$con = mysqli_connect($host, $user, $pass, $db_name);
if ($con) {
//    echo "connected";
} else {
    echo 'connected';
}
?>
