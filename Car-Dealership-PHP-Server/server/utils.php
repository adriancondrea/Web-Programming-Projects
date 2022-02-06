<?php

include_once 'config.php';

function addHeaders()
{
    header("Access-Control-Allow-Origin: *");
    header("Access-Control-Allow-Methods: GET,POST,PUT,DELETE,PATCH,OPTIONS");
    header("Access-Control-Allow-Headers: Access-Control-Allow-Origin,Access-Control-Allow-Headers,Token,Content-Type,X-Auth-Token");
}

function getBody()
{
    return json_decode(file_get_contents("php://input"));
}
