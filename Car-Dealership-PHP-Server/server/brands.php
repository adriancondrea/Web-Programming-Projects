<?php

include_once 'config.php';

$query = 'select brandId, name from Brand';

$statement = $CONNECTION->prepare($query);
$statement->execute();
$statement->bind_result($brandId, $name);

while($statement->fetch()) {
    echo $brandId.','.$name.';';
}

$statement->close();