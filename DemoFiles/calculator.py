import mysql.connector

def calculate(num1, num2, operation):
    result = 0

    if operation == 'add':
        result = num1 + num2
    elif operation == 'subtract':
        result = num1 - num2
    elif operation == 'multiply':
        result = num1 * num2
    elif operation == 'divide':
        if num2 != 0:
            result = num1 / num2
        else:
            return "Error: Division by zero"
    elif operation == 'modulo':
        if num2 != 0:
            result = num1 % num2
        else:
            return "Error: Modulo by zero"
    else:
        return "Invalid operation"

    return result

num1 = 15
num2 = 5
operations = ['add', 'subtract', 'multiply', 'divide', 'modulo']

for operation in operations:
    result = calculate(num1, num2, operation)
    print(f"{operation.capitalize()}: {result}")

def store_in_database(operation, num1, num2, result):
    conn = mysql.connector.connect(
        host="localhost",
        user="root",
        password="",
        database="calculator"
    )
    cursor = conn.cursor()

    sql = "INSERT INTO calculations (operation, num1, num2, result) VALUES (%s, %s, %s, %s)"
    val = (operation, num1, num2, result)
    cursor.execute(sql, val)

    conn.commit()
    print(cursor.rowcount, "record inserted.")

    cursor.close()
    conn.close()

for operation in operations:
    result = calculate(num1, num2, operation)
    store_in_database(operation, num1, num2, result)

