import { useState } from "react";
import Navbar from "./components/Navbar";
import Hero from "./components/Hero";
import About from "./components/About";
import Services from "./components/Services";
import Contact from "./components/Contact";
import Footer from "./components/Footer";
import MandatoryLabel from "./components/Mandatory";
import { validateMandatoryFields } from "./components/Mandatory";


function Login() {

  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = () => {
    const isValid = validateMandatoryFields();

    if (!isValid) {
      alert("Please fill all mandatory fields");
      return;
    }

      alert("Login Successful");
      setIsLoggedIn(true);
  };

  return (
    <div>
      {!isLoggedIn ? (
        // LOGIN SCREEN
        <div className="login-container">
      <h2>Login</h2>
      
      {/* <label htmlFor="Username_ip">Username</label> */}
      <div>
      <MandatoryLabel htmlFor="Username_ip" mandatory={true}>Username</MandatoryLabel>
      <input
        id="Username_ip"
        type="text"
        placeholder="Username"
        value={username}
        data-mandatory="true"
        onChange={(e) => setUsername(e.target.value)}
      />
      </div>
      
      <div>
      {/* <label htmlFor="Password_ip">Password</label> */}
      <MandatoryLabel htmlFor="Password_ip" mandatory={true}>Password</MandatoryLabel>
      <input
        id="Password_ip"
        type="password"
        placeholder="Password"
        data-mandatory="true"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />
      </div>

      <button onClick={handleLogin}>Login</button>

      {/* Show error message */}
      {/* {error && <p style={{ color: "red" }}>{error}</p>} */}
    </div>
      ) : (
        // AFTER LOGIN → LOAD OTHER PAGES
        <>
          <Navbar />
          <Hero />
          <About />
          <Services />
          <Contact />
          <Footer />
        </>
      )}
    </div>
  );

}

export default Login;