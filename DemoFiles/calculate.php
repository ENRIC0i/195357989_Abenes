<?php
$num1 = $_POST['num1'];
$num2 = $_POST['num2'];
$operation = $_POST['operation'];
$result = 0;

switch ($operation) {
    case 'add':
        $result = $num1 + $num2;
        break;
    case 'subtract':
        $result = $num1 - $num2;
        break;
    case 'multiply':
        $result = $num1 * $num2;
        break;
    case 'divide':
        if ($num2 != 0) {
            $result = $num1 / $num2;
        } else {
            echo "Error: Division by zero";
        }
        break;
    case 'modulo':
        if ($num2 != 0) {
            $result = $num1 % $num2;
        } else {
            echo "Error: Modulo by zero";
        }
        break;
    default:
        echo "Invalid operation";
        break;
}

echo "Result: " . $result;
?>

