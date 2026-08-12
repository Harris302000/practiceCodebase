import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { Button } from "react-bootstrap";
import Swal from "sweetalert2";
import { TextField, Grid } from "@mui/material";
import Card from "react-bootstrap/Card";
import Axios from 'axios'
import {FourSquare} from 'react-loading-indicators'

const Loginpage = () => {
  let [username, SetUsername] = useState("");
  let [password, SetPassword] = useState("");
  let [isLoading, setIsLoading] = useState(false)
  let navigate = useNavigate("");

  // useEffect(() => {console.log("Getting printed on every rended");
  // })

  useEffect(() => {
    console.log("Getting printed on First rended");
  }, []);

  useEffect(() => {
    console.log("Getting printed on Username Change");
  }, [username]);

  let handleLogin =  async () => {

    if (username === "" || password === "") {
      Swal.fire({
        title: "Username and Password is mandatory",
        icon: "warning",
        draggable: true,
      });
      return;
    }

    setIsLoading(true)

    try{

      const response = await Axios.get("http://localhost:8081/user/verifylogin", {
      headers: {
        "username": username,
        "X-Password": password
      }
    });

    console.log(response.data);
    
    if(response.data.statusCode == 200){
      Swal.fire({
      title: response.data.response,
      icon: "success",
      draggable: true,
    });
      navigate(`/Intropage/${username}`);
    } else {

      Swal.fire({
      title: response.data.response,
      icon: "error",
      draggable: true,
    });

    }
       
    } catch( error){
      Swal.fire({
      title: error.message,
      icon: "error",
      draggable: true,
    });

    // navigate(`/Intropage/${username}`);
    
    } finally{
      setIsLoading(false)
    }

    
  };

  let loginCard = {display : "flex", flexDirection:'column' ,width : '27%',border : '2px solid black',padding : '30px', gap : '20px', backgroundColor : 'White'}

  return (
    <>
      {isLoading && (
        <div className="loader-overlay"
          // style={{
          //   display: "flex",
          //   justifyContent: "center",
          //   alignItems: "center",
          //   height: "100vh",
          // }}
        >
          <FourSquare
            color="#32cd32"
            size="large"
            text="Loading..."
            textColor=""
            style={{ display: "flex", justifyContent: "center" }}
          />
        </div>
      )}

      <div
        style={{
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
          height: "90vh",
        }}
      >
        <form style={loginCard}>
          <h4 style={{ textAlign: "Center" }}>Login</h4>
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

          <footer
            style={{
              width: "100%",
              display: "flex",
              justifyContent: "space-evenly",
              alignItems: "center",
            }}
          >
            <label>
              {" "}
              <b>
                Dont have account?{" "}
                <Link to="/Signinpage">Create new account</Link>
              </b>
            </label>
          </footer>
        </form>
      </div>
    </>
  );
};

export default Loginpage;
