<?php

include_once 'config.php';
include_once 'utils.php';

addHeaders();

$body = getBody();

//isset - variable exists and != null
if (!isset($body->carId) || !isset($body->brandId) || !isset($body->model) || !isset($body->productionYear)
    || !isset($body->enginePower) || !isset($body->fuel) || !isset($body->color) || !isset($body->price)) {
    http_response_code(400);
    die();
}

$query = "UPDATE Car SET brandId = '$body->brandId', model = '$body->model', productionYear = '$body->productionYear',
enginePower = '$body->enginePower', fuel = '$body->fuel', color = '$body->color', price = '$body->price' WHERE Car.id = '$body->carId'";

$statement = $CONNECTION->prepare($query);
$statement->execute();

$statement->close();