<?php

include_once 'config.php';
include_once 'utils.php';

addHeaders();

$body = getBody();

//isset - variable exists and != null
if (!isset($body->brandId) || !isset($body->model) || !isset($body->productionYear)
    || !isset($body->enginePower) || !isset($body->fuel) || !isset($body->color) || !isset($body->price)) {
    http_response_code(400);
    die();
}

$query = "INSERT INTO Car (id, brandId, model, productionYear, enginePower, fuel, color, price)
VALUES (NULL, '$body->brandId', '$body->model', '$body->productionYear', '$body->enginePower', '$body->fuel', '$body->color',
        '$body->price')";
$statement = $CONNECTION->prepare($query);
$statement->execute();

$statement->close();