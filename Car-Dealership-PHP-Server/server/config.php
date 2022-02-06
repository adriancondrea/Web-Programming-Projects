<?php

$SERVER = 'localhost';
$USERNAME = 'root';
$PASSWORD = '';
$DATABASE = 'DealershipDB';

$CONNECTION = new mysqli($SERVER, $USERNAME, $PASSWORD, $DATABASE);

if($CONNECTION->connect_error) {
    die("Connection failed: " . $CONNECTION->connect_error);
}