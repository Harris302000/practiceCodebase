import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

const Signinpage = () => {

    let[username , setUsername] = useState("")
    let navigate = useNavigate("")

    let handleSignin = () => {

        if(username === '') {
            alert('Username is mandatory')
            return;
        }

        
        navigate(`/Intropage/${username}`)

    }


  return (
    <div>
      <div>
        <h1>Signinpage</h1>
        <input type="text" placeholder="Enter Username" value={username} onChange={(e) => setUsername(e.target.value)}/>
        <input type="date" placeholder="Choose DOB" />
        <input type="email" placeholder="Enter Email ID" />
        <button onClick={handleSignin}>Signin</button>
      </div>

      <div>
        <h4>Already Having Account?</h4>
        <Link to="/Loginpage">Login</Link>
      </div>
    </div>
  );
};

export default Signinpage;
