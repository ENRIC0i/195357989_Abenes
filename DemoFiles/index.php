<!DOCTYPE html>
<html>
<head>
    <title>Simple Calculator</title>
</head>
<body>
    <h2>Simple Calculator</h2>
    <form action="calculate.php" method="POST">
        <label for="num1">Number 1:</label>
        <input type="number" name="num1" required><br><br>
        
        <label for="num2">Number 2:</label>
        <input type="number" name="num2" required><br><br>
        
        <label for="operation">Operation:</label>
        <select name="operation" required>
            <option value="add">Addition (+)</option>
            <option value="subtract">Subtraction (-)</option>
            <option value="multiply">Multiplication (*)</option>
            <option value="divide">Division (/)</option>
            <option value="modulo">Modulo (%)</option>
        </select><br><br>
        
        <input type="submit" value="Calculate">
    </form>
</body>
</html>

