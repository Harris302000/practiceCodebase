
import Intropage from './Components/Intropage'
import Loginpage from './Components/Loginpage'
import Signinpage from './Components/Signinpage'
import Welcomepage from './Components/Welcomepage'
import {BrowserRouter as Router, Routes ,Route} from 'react-router-dom'

const RouterDets = () => {

    return <>
    <Router>
          <Routes>
            <Route path="/" element={<Welcomepage />} />
            <Route path="/Loginpage" element={<Loginpage />} />
            <Route path="/Signinpage" element={<Signinpage />} />
            <Route path="/Intropage/:username" element={<Intropage />} />
          </Routes>
        </Router>
    </>
}

export default RouterDets;