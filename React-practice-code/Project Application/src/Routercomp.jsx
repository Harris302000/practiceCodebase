
import Intropage from './Components/Intropage'
import Loginpage from './Components/Loginpage'
import Signinpage from './Components/Signinpage'
import Welcomepage from './Components/Welcomepage'
import {BrowserRouter as Router, Routes ,Route} from 'react-router-dom'
import NavBarComp from "./Components/NavBarComp";
import Errorpage from './Components/Errorpage'
import Productpage from './Components/Productpage'
import NewProduct from './Components/NewProduct'

const RouterDets = () => {

    return <>
    <Router>
      <NavBarComp />
          <Routes>
            <Route path='*' element={<Errorpage />} />
            <Route path="/" element={<Welcomepage />} />
            <Route path="/Loginpage" element={<Loginpage />} />
            <Route path="/Signinpage" element={<Signinpage />} />
            <Route path="/Intropage/:username" element={<Intropage />} />
            <Route path='/Productpage' element={<Productpage />} />
            <Route path='/NewProduct' element= {<NewProduct />} />
          </Routes>
        </Router>
    </>
}

export default RouterDets;