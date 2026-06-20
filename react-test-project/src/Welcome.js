import { useNavigate } from "react-router-dom";
import LoginPage from "./LoginPage";
function Welcome(){

    const navigate = useNavigate();

    return (
     <div>
            <h2>Welcome To The Collection Of Jersey</h2>

            <button onClick={() => navigate("/login")}>
                Log In
            </button>

            <button>
                Sign In
            </button>
        </div>
    );


}

export default Welcome;