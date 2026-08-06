import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

const Loginpage = () => {

    let [username, SetUsername ] = useState("")
    let [password, SetPassword ] = useState("")
    let navigate = useNavigate("");


    let handleLogin = () => {
        if(username === '' || password === ''){
            alert('Username and Password is mandatory')
            return;
        }

        navigate(`/Intropage/${username}`)

    }


  return (
    <div>
      <div>
        <h1>Loginpage</h1>
        <input type="text" placeholder="Enter Username" value={username} onChange={(e) => SetUsername(e.target.value)} />
        <input type="password" placeholder="Enter Password" value={password} onChange={(e) => SetPassword(e.target.value)} />
        <button onClick={handleLogin}>Login</button>
      </div>

      <div>
        <h4>Create new account</h4>
        <Link to='/Signinpage' >Signin</Link>
      </div>
    </div>
  );
};

export default Loginpage;
