import React, { useReducer, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import Button from "react-bootstrap/Button";
import { TextField, Grid } from "@mui/material";
import Swal from "sweetalert2";
import Axios from "axios";

const Signinpage = () => {
  let [username, setUsername] = useState("");
  let [dob, setDOB] = useState("");
  let [email, setEmail] = useState("");
  let [mobileno, setMobileno] = useState("");
  let [password, setPassword] = useState("");
  let navigate = useNavigate();

  let handleSignin = async () => {
    if (
      username === "" ||
      dob === "" ||
      email === "" ||
      mobileno === "" ||
      password === ""
    ) {
      // alert("Username is mandatory");
      Swal.fire({
        position: "center",
        icon: "info",
        title: "Kindly fill all the data",
        showConfirmButton: false,
        timer: 1500,
        padding: "50px",
        width: "500px",
      });
      return;
    }

    let data = {
      username: username,
      password: password,
      dob: dob,
      mobileno: mobileno,
      emailid: email,
    };
    console.log(JSON.stringify(data));

    try {
      let response = await Axios.post(
        "http://localhost:8081/user/createuser",
        data,
        {
          headers: {
            "Content-Type": "application/json",
            "Accept-Type": "application/json",
          },
        },
      );

      console.log(response.data);

      let icon;

      if (response.data.statusCode == 200) {
        icon = "success";
      } else {
        icon = "info";
      }

      Swal.fire({
        title: response.data.response,
        icon: icon,
        draggable: true,
      });

      if (response.data.statusCode == 200) {
       // navigate(`/Intropage/${username}`);
        navigate(`/Loginpage`);
      }

    } catch (error) {
      console.log(error.response);

      Swal.fire({
        title: error.response.data,
        icon: "error",
        draggable: true,
      });
    }

    
  };

  let signinCard = {
    display: "flex",
    flexDirection: "column",
    width: "27%",
    border: "2px solid black",
    padding: "30px",
    gap: "20px",
    backgroundColor: "White",
  };

  return (
    <div
      style={{
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        // height: "90vh",
        marginTop: "40px",
      }}
    >
      <form style={signinCard}>
        <h4 style={{ textAlign: "Center" }}>Signin</h4>

        <TextField
          name="username"
          label="Username"
          variant="outlined"
          value={username}
          placeholder="Enter User Name"
          onChange={(e) => setUsername(e.target.value)}
          fullWidth
        />

        <TextField
          name="DOB"
          // label="Date Of Birth"
          variant="outlined"
          value={dob}
          onChange={(e) => setDOB(e.target.value)}
          type="date"
          fullWidth
        />

        <TextField
          name="emailID"
          label="Email ID"
          variant="outlined"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          placeholder="Enter Email ID"
          type="email"
          fullWidth
        />

        <TextField
          name="mobilenumber"
          label="Mob No"
          variant="outlined"
          value={mobileno}
          onChange={(e) => setMobileno(e.target.value)}
          placeholder="Enter Mobile No"
          type="tel"
          fullWidth
        />

        <TextField
          name="password"
          label="Password"
          variant="outlined"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          placeholder="Enter Password"
          type="password"
          fullWidth
        />

        <Button onClick={handleSignin} variant="primary">
          Signin
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
            <b>
              Already Having Account?{" "}
              <Link to="/Loginpage">Click here to login</Link>
            </b>
          </label>
        </footer>
      </form>
    </div>
  );
};

export default Signinpage;
