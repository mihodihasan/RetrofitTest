<?php
$user_phone = $_GET['user_phone'];
$sql = "UPDATE `user` SET `user_verification_status`=1 WHERE `user_phone`='" . $user_id . "';";
include 'connect.php';
if (mysqli_query($con, $sql)) {
} else {
    echo "Error Encountered!";
}

?>
