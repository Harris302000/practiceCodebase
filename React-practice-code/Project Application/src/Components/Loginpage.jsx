import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import {Button} from 'react-bootstrap'

const Loginpage = () => {

    let [username, SetUsername ] = useState("")
    let [password, SetPassword ] = useState("")
    let navigate = useNavigate("");


    // useEffect(() => {console.log("Getting printed on every rended");
    // })

    useEffect(() => {console.log("Getting printed on First rended");
    }, [])

    useEffect(() => {console.log("Getting printed on Username Change");
    }, [username])

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
        <Button variant="primary" onClick={handleLogin}>Login</Button>
      </div>

      <div>
        <h4>Create new account</h4>
        <Button as={Link} to="/Signinpage" variant="primary">Signin</Button>
      </div>
      
    </div>
  );
};

export default Loginpage;
