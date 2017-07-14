<?php
$user_name = $_POST['user_name'];
$user_email = $_POST['user_email'];
$user_phone = $_POST['user_phone'];
$user_verification_status = $_POST['user_verification_status'];
$user_promo_code = $_POST['user_promo_code'];
$user_reward_points = $_POST['user_reward_points'];
$user_promo_code_apply_status = $_POST['user_promo_code_apply_status'];
$sql = "INSERT INTO `user`(`user_name`, `user_email`, `user_phone`, `user_verification_status`, `user_promo_code`, `user_reward_points`, `user_promo_code_apply_status`) VALUES ('" . $user_name . "','" . $user_email . "','" . $user_phone . "','" . $user_verification_status . "','" . $user_promo_code . "','" . $user_reward_points . "','" . $user_promo_code_apply_status . "');";
include 'connect.php';
if (mysqli_query($con, $sql)) {
} else {
    echo "Error Encountered!";
}
?>
