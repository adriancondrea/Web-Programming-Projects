<?php
include_once 'config.php';
include_once 'utils.php';

addHeaders();

$body = getBody();

if (! isset($body->carId)){
    http_response_code(400);
    die();
}
$query = "DELETE FROM Car WHERE Car.id = '$body->carId'";
$statement = $CONNECTION->prepare($query);
$statement->execute();

$statement->close();