# SpringMVCTutorial

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
<h2><p>I have implemented the following dependencies in the pom.xml file </p></h2>
<p>1.spring-boot-starter-web</p>
<p>2.spring-boot-starter-data-jpa</p>
<p>3.mysql-connector-java</p>
<p>4.spring-boot-starter-security</p>
<p>5.JsonWebToken</p>
<p>6.spring-boot-starter-tomcat</p>
<p>7.jackson-core</p>
<p>8.jackson-dataformat-xml</p>
<p>9.spring-boot-starter-test</p>
<p>10.modelmapper</p>

<h2><p>Project contains Restful api as follows:- </p></h2>
<h3>1. Sign Up Api </h3>
<b>Request : - </b>

<p> post url :- localhost:8080/mobile-app-ws/users <p>
<p> headers :- 1.Content-Type : application/json
2.Accept : application/json</p>
<p>Body :- 
<pre><code>
{
	"firstName":"Rahul",
	"lastName":"Developer",
	"email": "rahul.rawat.er@gmail.com",
	"password":"password",
	"addresses":[
		{
			"city":"new delhi",
			"country":"india",
			"streetName":"L-92 Saket",
			"postalCode":"110017",
			"type":"home"
		},
		{
			"city":"Gurgaon",
			"country":"india",
			"streetName":"697 Udyog vihar phase-5",
			"postalCode":"220012",
			"type":"office"
		}
	]
}
</code></pre>
</p>




  </body>
</html>

<b>Response : - </b>
<pre><code>
{
    "userId": "rEYiibm6LuOgY51XAoLIPBYgInZsiY",
    "firstName": "Rahul",
    "lastName": "Developer",
    "email": "rahul.rawat.er@gmail.com",
    "addresses": [
        {
            "addressId": "LpeUNmExQf697U2qulnqOA6CVhJbb5",
            "city": "new delhi",
            "country": "india",
            "streetName": "L-92 Saket",
            "postalCode": "110017",
            "type": "home"
        },
        {
            "addressId": "T2l4IalpjI3imKxQYP562RuFrW2j1v",
            "city": "Gurgaon",
            "country": "india",
            "streetName": "697 Udyog vihar phase-5",
            "postalCode": "220012",
            "type": "office"
        }
    ]
}
</code></pre>













<h3>2. Login Api </h3>
<b>Request : - </b>

<p> post url :- localhost:8080/mobile-app-ws/users/login <p>
<p> headers :- 1.Content-Type : application/json
2.Accept : application/json</p>
<p>Body :- 
<pre><code>
{
 
	"email": "rahul.rawat.er@gmail.com",
	"password":"password"
}
</code></pre>
</p>




  </body>
</html>

<b>Response : - </b>
<p>in header you will get Authorization token and UserId such as
<pre><code>
Authorization →Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyYWh1bC5yYXdhdC5lckBnbWFpbC5jb20iLCJleHAiOjE1Njg4MjU1MDZ9.gyfre0idjQscKqd8zctUteAlODh1VuJQl3v3FzQNt_4TS1CDLy6Ic94NRgOE0Cpi8mH7PAxha6cSwUtRIdX5Yw
UserID →rEYiibm6LuOgY51XAoLIPBYgInZsiY

</code></pre>







<h3>3. User Data Api </h3>
<b>Request : - </b>

<p> Get url :- localhost:8080/mobile-app-ws/users/rEYiibm6LuOgY51XAoLIPBYgInZsiY <p>
<p> headers :- 1.Authorization : Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyYWh1bC5yYXdhdC5lckBnbWFpbC5jb20iLCJleHAiOjE1Njg4MjU1MDZ9.gyfre0idjQscKqd8zctUteAlODh1VuJQl3v3FzQNt_4TS1CDLy6Ic94NRgOE0Cpi8mH7PAxha6cSwUtRIdX5Yw ( Authorization token which you gt from login api)
2.Content-Type : application/json
3.Accept : application/json</p>
  
<b>Response : - </b>
<pre><code>
{
    "userId": "rEYiibm6LuOgY51XAoLIPBYgInZsiY",
    "firstName": "Rahul",
    "lastName": "Developer",
    "email": "rahul.rawat.er@gmail.com",
    "addresses": [
        {
            "addressId": "LpeUNmExQf697U2qulnqOA6CVhJbb5",
            "city": "new delhi",
            "country": "india",
            "streetName": "L-92 Saket",
            "postalCode": "110017",
            "type": "home"
        },
        {
            "addressId": "T2l4IalpjI3imKxQYP562RuFrW2j1v",
            "city": "Gurgaon",
            "country": "india",
            "streetName": "697 Udyog vihar phase-5",
            "postalCode": "220012",
            "type": "office"
        }
    ]
}
</code></pre>









<h3>4. Update User Details Api </h3>
<b>Request : - </b>

<p> put url :- localhost:8080/mobile-app-ws/users/login <p>
<p> headers :- 1.Content-Type : application/json
2.Accept : application/json
3.Authorization : Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyYWh1bC5yYXdhdC5lckBnbWFpbC5jb20iLCJleHAiOjE1Njg4MjU1MDZ9.gyfre0idjQscKqd8zctUteAlODh1VuJQl3v3FzQNt_4TS1CDLy6Ic94NRgOE0Cpi8mH7PAxha6cSwUtRIdX5Yw ( Authorization token which you gt from login api)</p>
<p>Body :- 
<pre><code>
{
 
 	"firstName":"rahul",
	"lastName":"hello"
}
</code></pre>
</p>




  </body>
</html>

<b>Response : - </b>
<p>Here our code will only update first name and the last name for more you can easily change inside the code
<pre><code>
{
    "userId": "rEYiibm6LuOgY51XAoLIPBYgInZsiY",
    "firstName": "rahul",
    "lastName": "hello",
    "email": "rahul.rawat.er@gmail.com",
    "addresses": [
        {
            "addressId": "LpeUNmExQf697U2qulnqOA6CVhJbb5",
            "city": "new delhi",
            "country": "india",
            "streetName": "L-92 Saket",
            "postalCode": "110017",
            "type": "home"
        },
        {
            "addressId": "T2l4IalpjI3imKxQYP562RuFrW2j1v",
            "city": "Gurgaon",
            "country": "india",
            "streetName": "697 Udyog vihar phase-5",
            "postalCode": "220012",
            "type": "office"
        }
    ]
}
</code></pre>




<h3>5. Get list of all users with pagination </h3>
<b>Request : - </b>

<p> Get url :- localhost:8080/mobile-app-ws/users?page=0&limit=8<p>
<p> headers :- 1.Content-Type : application/json
2.Accept : application/json
3.Authorization : Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyYWh1bC5yYXdhdC5lckBnbWFpbC5jb20iLCJleHAiOjE1Njg4MjU1MDZ9.gyfre0idjQscKqd8zctUteAlODh1VuJQl3v3FzQNt_4TS1CDLy6Ic94NRgOE0Cpi8mH7PAxha6cSwUtRIdX5Yw ( Authorization token which you gt from login api)</p>

<b>Response : - </b>
<pre><code>
{
    "operationName": "Delete",
    "operationResult": "Success"
}
</code></pre>


<h3>6. Update User Details Api </h3>
<b>Request : - </b>

<p> put url :- localhost:8080/mobile-app-ws/users/login <p>
<p> headers :- 1.Content-Type : application/json
2.Accept : application/json
3.Authorization : Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyYWh1bC5yYXdhdC5lckBnbWFpbC5jb20iLCJleHAiOjE1Njg4MjU1MDZ9.gyfre0idjQscKqd8zctUteAlODh1VuJQl3v3FzQNt_4TS1CDLy6Ic94NRgOE0Cpi8mH7PAxha6cSwUtRIdX5Yw ( Authorization token which you gt from login api)</p>
  
<b>Response : - </b>
<pre><code>
[
    {
        "userId": "THHKpsoyTkmJUmIwqsVdiM8xE8TUjL",
        "firstName": "rahul",
        "lastName": "androiddev",
        "email": "rahulrocksmgps@gmail.com",
        "addresses": [
            {
                "addressId": "K5w52lgv4ogUmbzv0WQQYoZPa87vW9",
                "city": "Gurgaon",
                "country": "india",
                "streetName": "697 Udyog vihar phase-5",
                "postalCode": "220012",
                "type": "office"
            },
            {
                "addressId": "2Cbs8EibDgfZQdghrPaw7N3rMoEURm",
                "city": "new delhi",
                "country": "india",
                "streetName": "147/15 sec-1 pushp vihar",
                "postalCode": "110017",
                "type": "home"
            }
        ]
    },
    {
        "userId": "TJAOFv0vTRKEqAsn4Az5PiADBMHSP5",
        "firstName": "Rahul",
        "lastName": "Developer",
        "email": "rahul.rawat.er@gmail.com",
        "addresses": [
            {
                "addressId": "xiMOoUK1w4fzX0SIlemq6yLsmNQVFB",
                "city": "Gurgaon",
                "country": "india",
                "streetName": "697 Udyog vihar phase-5",
                "postalCode": "220012",
                "type": "office"
            },
            {
                "addressId": "TISQo46rYQOnZTMSPpi2eoR5IX0e8F",
                "city": "new delhi",
                "country": "india",
                "streetName": "L-92 Saket",
                "postalCode": "110017",
                "type": "home"
            }
        ]
    }
]
</code></pre>


<h3>7. Get list of partiular user addresses Api </h3>
<b>Request : - </b>

<p> get url :- localhost:8080/mobile-app-ws/users/rEYiibm6LuOgY51XAoLIPBYgInZsiY/addresses <p>
<p> headers :- 1.Content-Type : application/json
2.Accept : application/json
3.Authorization : Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyYWh1bC5yYXdhdC5lckBnbWFpbC5jb20iLCJleHAiOjE1Njg4MjU1MDZ9.gyfre0idjQscKqd8zctUteAlODh1VuJQl3v3FzQNt_4TS1CDLy6Ic94NRgOE0Cpi8mH7PAxha6cSwUtRIdX5Yw ( Authorization token which you gt from login api)</p>
  
<b>Response : - </b>
<pre><code>
[
    {
        "addressId": "xiMOoUK1w4fzX0SIlemq6yLsmNQVFB",
        "city": "Gurgaon",
        "country": "india",
        "streetName": "697 Udyog vihar phase-5",
        "postalCode": "220012",
        "type": "office"
    },
    {
        "addressId": "TISQo46rYQOnZTMSPpi2eoR5IX0e8F",
        "city": "new delhi",
        "country": "india",
        "streetName": "L-92 Saket",
        "postalCode": "110017",
        "type": "home"
    }
]

</code></pre>





<h3>8. Get particlar Address detail from partiular addresses id Api </h3>
<b>Request : - </b>

<p> get url :- localhost:8080/mobile-app-ws/users/TJAOFv0vTRKEqAsn4Az5PiADBMHSP5/addresses/xiMOoUK1w4fzX0SIlemq6yLsmNQVFB <p>
<p> headers :- 1.Content-Type : application/json
2.Accept : application/json
3.Authorization : Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyYWh1bC5yYXdhdC5lckBnbWFpbC5jb20iLCJleHAiOjE1Njg4MjU1MDZ9.gyfre0idjQscKqd8zctUteAlODh1VuJQl3v3FzQNt_4TS1CDLy6Ic94NRgOE0Cpi8mH7PAxha6cSwUtRIdX5Yw ( Authorization token which you gt from login api)</p>
  
<b>Response : - </b>
<pre><code>
{
    "addressId": "xiMOoUK1w4fzX0SIlemq6yLsmNQVFB",
    "city": "Gurgaon",
    "country": "india",
    "streetName": "697 Udyog vihar phase-5",
    "postalCode": "220012",
    "type": "office"
}

</code></pre>
