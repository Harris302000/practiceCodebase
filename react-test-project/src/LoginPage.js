import { useState } from "react";
import HomePage from "./components/HomePage";
import MandatoryLabel from "./components/Mandatory";
import { validateMandatoryFields } from "./components/Mandatory";
import { showMessage } from "./components/Message";
import "./customcss.css";


function Login() {

  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = async () => {
    const isValid = validateMandatoryFields();

    try {
      if (!isValid) {
        //alert("Please fill all mandatory fields");
        showMessage("Please fill all mandatory fields");
        return;
      }

      const response = await fetch(
            "http://localhost:8080/user/verifylogin",
            {
                method: "GET",
                headers: {
                    username: username,
                    "X-Password": password
                }
            }
        );

      const data = await response.json();

      console.log(data);

      if (response.ok) {
        // alert("Login Successful");
        showMessage(data.response);
        setIsLoggedIn(true);
      } else {
        showMessage(data.response);
      }
    } catch (error) {
      console.error(error);
      showMessage("Unable to connect to server");
    }
  };

  return (
    <div>
      {!isLoggedIn ? (
        // LOGIN SCREEN WITH BACKGROUND + CENTER CARD
        <div className="login-container">
          <div className="login-card">
            <h2>Login</h2>

            <div>
              <MandatoryLabel htmlFor="Username_ip" mandatory={true}>
                Username
              </MandatoryLabel>
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
              <MandatoryLabel htmlFor="Password_ip" mandatory={true}>
                Password
              </MandatoryLabel>
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
          </div>
        </div>
      ) : (
        <HomePage />
      )}
    </div>
  );

}

export default Login;