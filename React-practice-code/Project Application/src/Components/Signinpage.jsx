import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import Button from "react-bootstrap/Button";
import { TextField, Grid } from "@mui/material";

const Signinpage = () => {
  let [username, setUsername] = useState("");
  let navigate = useNavigate("");

  let handleSignin = () => {
    if (username === "") {
      alert("Username is mandatory");
      return;
    }

    navigate(`/Intropage/${username}`);
  };

  let signinCard = {
    display: "flex",
    flexDirection: "column",
    width: "30%",
    border: "2px solid black",
    padding: "30px",
    gap: "20px",
  };

  return (
    <div
      style={{
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        height: "90vh",
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
          onChange={(e) => SetUsername(e.target.value)}
          fullWidth
        />

        <TextField
          name="DOB"
          label="Date Of Birth"
          variant="outlined"
          // value={username}
          // onChange={(e) => SetUsername(e.target.value)}
          type="date"
          fullWidth
        />

        <TextField
          name="emailID"
          label="Email ID"
          variant="outlined"
          // value={username}
          // onChange={(e) => SetUsername(e.target.value)}
          placeholder="Enter Email ID"
          type="email"
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
