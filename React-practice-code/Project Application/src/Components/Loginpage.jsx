import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { Button } from "react-bootstrap";
import Swal from "sweetalert2";
import { TextField, Grid } from "@mui/material";
import Card from "react-bootstrap/Card";

const Loginpage = () => {
  let [username, SetUsername] = useState("");
  let [password, SetPassword] = useState("");
  let navigate = useNavigate("");

  // useEffect(() => {console.log("Getting printed on every rended");
  // })

  useEffect(() => {
    console.log("Getting printed on First rended");
  }, []);

  useEffect(() => {
    console.log("Getting printed on Username Change");
  }, [username]);

  let handleLogin = () => {
    if (username === "" || password === "") {
      Swal.fire({
        title: "Username and Password is mandatory",
        icon: "warning",
        draggable: true,
      });
      return;
    }

    Swal.fire({
      title: "Logged in successfully",
      icon: "success",
      draggable: true,
    });
    navigate(`/Intropage/${username}`);
  };

  let loginCard = {display : "flex", flexDirection:'column' ,width : '30%',border : '1px solid black',padding : '30px', gap : '20px'}

  return (
    
      <div style={{display:'flex',justifyContent:'center',alignItems : 'center',height: '90vh'}}>

        <form style={loginCard}>
          <TextField
            name="username"
            label="Username"
            variant="outlined"
            value={username}
            onChange={(e) => SetUsername(e.target.value)}
            fullWidth
          />

          <TextField
            name="password"
            label="Password"
            type="password"
            variant="outlined"
            value={password}
            onChange={(e) => SetPassword(e.target.value)}
            fullWidth
          />

          <Button variant="primary" onClick={handleLogin}>
            Login
          </Button>
          <h4>Create new account</h4>
          <Button as={Link} to="/Signinpage" variant="primary">
            Signin
          </Button>
        </form>
      </div>
  );
};

export default Loginpage;
