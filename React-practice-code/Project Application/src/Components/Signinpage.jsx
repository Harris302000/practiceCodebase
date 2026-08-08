import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import Button from "react-bootstrap/Button";

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

  return (
    <div>
      <div>
        <h1>Signinpage</h1>
        <input
          type="text"
          placeholder="Enter Username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />
        <input type="date" placeholder="Choose DOB" />
        <input type="email" placeholder="Enter Email ID" />
        <Button onClick={handleSignin} variant="primary">
          Signin
        </Button>
      </div>

      <div>
        <h4>Already Having Account?</h4>

        <Button as={Link} to="/Loginpage" variant="primary">
          Login
        </Button>
      </div>
    </div>
  );
};

export default Signinpage;
