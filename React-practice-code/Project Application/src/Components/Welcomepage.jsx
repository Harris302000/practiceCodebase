import React from "react";
import { Link } from "react-router-dom";
import Loginpage from "./Loginpage";

const Welcomepage = () => {
  return (
    <div id="WelcomePageMainDiv">
      <h1>Welcomepage</h1>
      <div id="WelcomePageButtonDiv">
        <Link to="/Loginpage">Login</Link>
        <Link to="/Signinpage">signin</Link>
      </div>
    </div>
  );
};

export default Welcomepage;
