<?php
    $name = $_POST["name"];
    $address = $_POST["address"];
    $zip = $_POST["zip"];
    $payment_method = $_POST["payment_method"];

    $web_book_count = $_POST["web_book_count"];
    if($web_book_count == "") $web_book_count = 0;
    $mathematics_count = $_POST["mathematics_count"];
    if($mathematics_count == "") $mathematics_count = 0;
    $principle_count = $_POST["principle_count"];
    if($principle_count == "") $principle_count = 0;
    $theory_count = $_POST["theory_count"];
    if($theory_count == "") $theory_count = 0;

    $web_cost = 5.0 * $web_book_count;
    $math_cost = 6.2 * $mathematics_count;
    $principle_cost = 10.0 * $principle_count;
    $theory_cost = 7.8 * $theory_count;

    $count = $web_book_count + $mathematics_count + $principle_count + $theory_count;
    $total_cost = $web_cost + $math_cost + $principle_cost + $theory_cost;

    $message1 = "$name has bought $count books.";
    $message2 = "$name paid $total_cost.";
    $message3 = "$name paid by $payment_method.";
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to book seller</title>
</head>
<body>
    <p><strong>customer name: <?php print $name; ?></strong></p>
    <p><strong>customer address: <?php print $address; ?> </strong></p>
    <p><strong>customer zip: <?php print $zip; ?> </strong></p>
    <table border="1" padding="lpx">
        <tr>
            <th>book</th>
            <th>publisher</th>
            <th>price</th>
            <th>total cost</th>
        </tr>
        <tr>
            <td>Web technology</td>
            <td>Springer press</td>
            <td>$5.0</td>
            <td><?php print $web_cost; ?></td>
        </tr>
        <tr>
            <td>mathematics</td>
            <td>ACM press</td>
            <td>$6.2</td>
            <td><?php print $math_cost; ?></td>
        </tr>
        <tr>
            <td>principle of OS</td>
            <td>Science press</td>
            <td>$10</td>
            <td><?php print $principle_cost; ?></td>
        </tr>
        <tr>
            <td>Theory of matrix</td>
            <td>High education press</td>
            <td>$7.8</td>
            <td><?php print $theory_cost; ?></td>
        </tr>
    </table>
    <p> <?php print $message1; ?> </p>
    <p> <?php print $message2; ?> </p>
    <p> <?php print $message3; ?> </p>

</body>
</html>