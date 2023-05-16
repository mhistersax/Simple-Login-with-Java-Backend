<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <style>
        * {
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }

        body {
            background: rgb(50, 113, 244);
            background: linear-gradient(90deg, rgba(50, 113, 244, 1) 10%, rgba(175, 30, 194, 1) 66%);
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .container {
            margin-top: 50px;
            display: flex;
            justify-content: center;
            background: rgba(255, 255, 255, 0.2);
            box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);
            -webkit-backdrop-filter: blur(4.5px);
            backdrop-filter: blur(4.5px);
            border-radius: 10px;
            border: 1px solid rgba(255, 255, 255, 0.18);
            width: 30%;
            height: 55vh;
        }

        .container input {
            display: block;
            margin: 20px;
            outline: none;
            width: 200px;
            height: 30px;
            outline: none;
            background: rgba(255, 255, 255, 0.2);
            border: 1px solid black;
            border-radius: 5px;
        }

        .container input::placeholder {
            color: white;
            font-family: 'Courier New', Courier, monospace;
            padding-left: 5px;
        }

        #spec {
            width: 70px;
        }
    </style>
    <div class="container">
        <form action="regist" autocomplete="off">
            <input type="text" name="fname" placeholder="Input Your First Name">
            <input type="text" name="lname" placeholder="Input Your Last Name">
            <input type="email" name="email" placeholder="Please Enter your mail" required>
            <input type="text" name="city" placeholder="Input Your City">
            <input type="text" name="country" placeholder="Input Your Country">
            <input type="text" name="gender" placeholder="Input Your Gender">
            <input type="submit" value="submit" id="spec">
        </form>
    </div>
</body>
</html>