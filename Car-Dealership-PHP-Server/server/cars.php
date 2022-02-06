<?php

include_once 'config.php';
include_once 'utils.php';

addHeaders();
$query = 'select * from Car';
$statement = $CONNECTION->prepare($query);
$statement->execute();
$statement->bind_result($id, $brandId, $model, $productionYear, $enginePower, $fuel, $color, $price);

$filter = $_GET["filter"];

while ($statement->fetch()) {
    if ($filter != 0 && $brandId != $filter) {
        continue;
    }
    echo $id . ',' . $brandId . ',' . $model . ',' . $productionYear . ',' . $enginePower . ',' . $fuel . ',' . $color . ',' . $price . ';';
}

$statement->close();