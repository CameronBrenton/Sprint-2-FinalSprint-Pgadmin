const express = require('express');
const session = require('express-session');
const app = express()
const path = require('path');
const bcrypt = require('bcrypt');
const db = require("./query")

const Pool = require('pg').Pool;
const pool = new Pool({
    user: 'postgres',
    host: 'localhost',
    database: 'sprint2',
    password: 'password',
    port: 5432
});

app.use(session({secret: "password"}));
app.use(express.json());
app.use(express.urlencoded({
    extended: false
}));

app.get('/roles', db.get_role)
app.get('/routes', db.get_route)
app.get('/routes/:role', db.get_route_and_role)


app.get("/", function(req, res){
   if(req.session.count === undefined){
        req.session.count = 0;
    }

    const count = req.session.count;
    req.session.count = req.session.count + 1
    res.send(`you've visited ${count} times before!`)
});

app.get("/login", function(req, res){
    res.sendFile(path.join(__dirname, 'login.html'));
});

app.post("/login", async function(req, res){
    const email = req.body.email;
    const password = req.body.password;
	let results = await pool.query("SELECT * FROM users WHERE email =$1", [email]);
	console.log(email, password)
    if(results.rows === 0){
        res.send("Oh no! no account found.");
    }else if(results.rows > 1){
		console.warn("there are two accounts with the same email!");
		res.send('Try using another account')
		//I would send an error message to the user here as well via res.send
    }else{
		const passwordMatched = await bcrypt.compare(password, results.rows[0].password)
        if(passwordMatched){
            req.session.loggedIn = true;
            res.send("Congrats! you've logged in");
        }else{
            res.send("invailid password please try again");
        }
    }
});

app.listen(3000, function(){
    console.log("listening at http://localhost:3000")
});

// AUTHENTICATION //
app.get('/signup', function(req, res){
    res.sendFile(path.join(__dirname, 'signup.html'));
});

app.post("/signup",  async function(req, res){
    let email = req.body.email;
    let password = req.body.password;
    let encrypted_password = await bcrypt.hash(password, 10);
    let results = await pool.query('SELECT * FROM users where email = $1', [email]);
    if(results.rows.length > 0){
        res.send("error! there is already an account with this email");
    }else {
		let role_id = 3
        let insert_result = await pool.query('INSERT INTO users (email, password, role_id) VALUES ($1, $2, $3)', [email, encrypted_password, role_id]);
        res.send("Created account!");
	}
});

app.get("/secret", async function (req, res) {
    if (req.session.loggedIn === true) {
        res.send("Wow! You are allow to be here continue your work")
    } else {
        res.send("Ooop! You are not logged in!")
	}
});

app.get('/logout', function(req, res){
	req.session.destroy();
	res.send("You have logged out!");
});


app.post("/logout", async function (req, res) {
	if (req.session.loggedIn === true) {
		req.session.destroy();
	}
	req.send('You are now logged out! ');
});


