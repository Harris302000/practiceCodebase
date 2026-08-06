
import './App.css'
import Intropage from './Components/Intropage'
import Loginpage from './Components/Loginpage'
import Signinpage from './Components/Signinpage'
import Welcomepage from './Components/Welcomepage'
import {BrowserRouter as Router, Routes ,Route, Link} from 'react-router-dom'

function App() {

  return (
    <>
      <div>
        <Router>
          <Routes>
            <Route path="/" element={<Welcomepage />} />
            <Route path="/Loginpage" element={<Loginpage />} />
            <Route path="/Signinpage" element={<Signinpage />} />
            <Route path="/Intropage/:username" element={<Intropage />} />
          </Routes>
        </Router>
      </div>
    </>
  );
}

export default App
